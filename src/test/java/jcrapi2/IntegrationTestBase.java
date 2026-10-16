/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jcrapi2;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.common.ContentTypes.AUTHORIZATION;

import static jcrapi2.essentials.common.Utils.isNotBlank;

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.hc.core5.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import jcrapi2.essentials.common.IResponse;
import jcrapi2.essentials.common.PaginationRequest;
import jcrapi2.essentials.common.PaginationResponse;
import jcrapi2.essentials.common.Request;
import jcrapi2.essentials.connector.ConnectorException;
import jcrapi2.essentials.connector.StandardConnector;

import lombok.Getter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public abstract class IntegrationTestBase {

    private static final Gson GSON =
            new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final String EMPTY = "";

    private static WireMockServer wireMockServer;

    @Getter private String expected;

    private JCrApi jCrApi;

    @BeforeAll
    public static void beforeAll() {
        WireMockConfiguration wireMockConfiguration = new WireMockConfiguration().dynamicPort();
        wireMockServer = new WireMockServer(wireMockConfiguration);
        wireMockServer.start();
    }

    @AfterAll
    public static void afterAll() {
        wireMockServer.stop();
    }

    private static JCrApi createJCrApi() {
        return new JCrApi(
                "http://localhost:" + wireMockServer.port(), "myApiKey", new StandardConnector());
    }

    protected static <T> T fromJson(Class<T> clazz, String s) {
        return GSON.fromJson(s, clazz);
    }

    protected String body(String filename) throws IOException {
        List<String> lines = readLines(new File(filename), StandardCharsets.UTF_8);
        expected = lines.stream().map(String::trim).collect(Collectors.joining());
        return expected;
    }

    @BeforeEach
    public void beforeEach() {
        configureFor("localhost", wireMockServer.port());
        jCrApi = createJCrApi();
    }

    @AfterEach
    public void afterEach() {
        wireMockServer.resetAll();
        jCrApi = createJCrApi();
    }

    protected void prepare(String url, String queryPart, String filename, Request request)
            throws Exception {
        stubFor(
                get(urlEqualTo(createUrl(url, queryPart, request)))
                        .withHeader(AUTHORIZATION, equalTo("Bearer myApiKey"))
                        .willReturn(aResponse().withBody(body(filename)).withStatus(SC_OK)));
    }

    private String createUrl(String url, String queryPart, Request request) {
        String createdUrl = url;
        if (request instanceof PaginationRequest) {
            createdUrl = url + "?limit=100&after=aaa&before=zzz";
            if (isNotBlank(queryPart)) {
                return createdUrl + '&' + queryPart;
            }
        } else if (isNotBlank(queryPart)) {
            createdUrl += '?' + queryPart;
        }
        return createdUrl;
    }

    protected void assertResponse(
            IResponse expectedResponse, ResultTestRunner<? extends IResponse> resultTestRunner)
            throws Exception {
        IResponse actual = resultTestRunner.execute();
        assertThat(actual).isEqualTo(expectedResponse);
        assertThat(actual.getRawResponse()).isNotNull();
        assertThat(actual.getRawResponse().getResponseHeaders()).isNotEmpty();
        assertThat(actual.getRawResponse().getRaw()).isEqualTo(expected);
        assertThat(actual.toString()).isNotEmpty();
        assertGeneratedPayload(actual);
        assertPayloadPreserved(JsonParser.parseString(expected), GSON.toJsonTree(actual), "$");
    }

    private void assertGeneratedPayload(IResponse response) {
        if (response instanceof PaginationResponse<?> page) {
            page.getItems().forEach(this::assertGeneratedModel);
        } else if (response instanceof Collection<?> items) {
            items.forEach(this::assertGeneratedModel);
        } else {
            assertGeneratedModel(response);
        }
    }

    private void assertGeneratedModel(Object value) {
        Class<?> type = value.getClass();
        while (type != null && !type.getPackageName().equals("jcrapi2.api.generated.model")) {
            type = type.getSuperclass();
        }
        assertThat(type).as("Generated model for %s", value.getClass().getName()).isNotNull();
    }

    // Comparing two instances of the same response type cannot detect dropped JSON fields.
    private void assertPayloadPreserved(JsonElement expected, JsonElement actual, String path) {
        if (expected.isJsonNull()) {
            return;
        }
        assertThat(actual).as("Response data at %s", path).isNotNull();
        if (expected.isJsonObject()) {
            assertThat(actual.isJsonObject()).as("Object at %s", path).isTrue();
            for (var entry : expected.getAsJsonObject().entrySet()) {
                assertPayloadPreserved(
                        entry.getValue(),
                        actual.getAsJsonObject().get(entry.getKey()),
                        path + "." + entry.getKey());
            }
        } else if (expected.isJsonArray()) {
            assertThat(actual.isJsonArray()).as("Array at %s", path).isTrue();
            assertThat(actual.getAsJsonArray()).as(path).hasSize(expected.getAsJsonArray().size());
            for (int i = 0; i < expected.getAsJsonArray().size(); i++) {
                assertPayloadPreserved(
                        expected.getAsJsonArray().get(i),
                        actual.getAsJsonArray().get(i),
                        path + "[" + i + "]");
            }
        } else {
            assertThat(actual).as(path).isEqualTo(expected);
        }
    }

    protected void assertRequestFails(
            String url, String queryPart, Request request, TestRunner testRunner) {
        prepareWithError(url, queryPart, request);
        assertConnectorFailure(testRunner, SC_BAD_REQUEST, "body");
    }

    protected void assertNotFoundResponse(
            String url, String queryPart, String filename, Request request, TestRunner testRunner)
            throws IOException {
        String errorBody = body(filename);
        stubFor(
                get(urlEqualTo(createUrl(url, queryPart, request)))
                        .withHeader(AUTHORIZATION, equalTo("Bearer myApiKey"))
                        .willReturn(aResponse().withBody(errorBody).withStatus(SC_NOT_FOUND)));
        assertConnectorFailure(testRunner, SC_NOT_FOUND, errorBody);
    }

    private void assertConnectorFailure(TestRunner testRunner, int status, String errorBody) {
        assertThatThrownBy(testRunner::execute)
                .isInstanceOf(ExecutionException.class)
                .hasMessage(ConnectorException.class.getName() + ": " + status + ": " + errorBody)
                .hasCauseInstanceOf(ConnectorException.class);
    }

    private void prepareWithError(String url, String queryPart, Request request) {
        stubFor(
                get(urlEqualTo(createUrl(url, queryPart, request)))
                        .withHeader(AUTHORIZATION, equalTo("Bearer myApiKey"))
                        .willReturn(aResponse().withBody("body").withStatus(SC_BAD_REQUEST)));
    }

    protected JCrApi getJCrApi() {
        return jCrApi;
    }

    @FunctionalInterface
    public interface TestRunner {
        void execute() throws Exception;
    }

    @FunctionalInterface
    public interface ResultTestRunner<T extends IResponse> {
        T execute() throws Exception;
    }
}
