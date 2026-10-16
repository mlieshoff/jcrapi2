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

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.hc.core5.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import static supercell.api.wrapper.essentials.common.Utils.isNotBlank;

import static java.util.Collections.emptyMap;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import lombok.Getter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import supercell.api.wrapper.essentials.common.IResponse;
import supercell.api.wrapper.essentials.common.PaginationRequest;
import supercell.api.wrapper.essentials.common.PaginationResponse;
import supercell.api.wrapper.essentials.common.Request;
import supercell.api.wrapper.essentials.connector.StandardConnector;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
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

    private static JCrApi createJCrApi() {
        return new JCrApi(
                "http://localhost:" + wireMockServer.port(), "myApiKey", new StandardConnector());
    }

    protected static <T> T toJson(Class<T> clazz, String s) {
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

    protected void run(
            IResponse expectedResponse, ResultTestRunner<? extends IResponse> resultTestRunner)
            throws Exception {
        IResponse actual = resultTestRunner.execute();
        assertEquals(expectedResponse, actual);
        assertNotNull(actual.getRawResponse());
        assertNotEquals(emptyMap(), actual.getRawResponse().getResponseHeaders());
        assertEquals(expected, actual.getRawResponse().getRaw());
        assertNotEquals(EMPTY, actual.toString());
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
        assertNotNull(type, () -> "Expected a generated model: " + value.getClass().getName());
    }

    // Comparing two instances of the same response type cannot detect dropped JSON fields.
    private void assertPayloadPreserved(JsonElement expected, JsonElement actual, String path) {
        if (expected.isJsonNull()) {
            return;
        }
        assertNotNull(actual, () -> "Missing response data at " + path);
        if (expected.isJsonObject()) {
            assertTrue(actual.isJsonObject(), () -> "Expected an object at " + path);
            for (var entry : expected.getAsJsonObject().entrySet()) {
                assertPayloadPreserved(entry.getValue(), actual.getAsJsonObject().get(entry.getKey()),
                        path + "." + entry.getKey());
            }
        } else if (expected.isJsonArray()) {
            assertTrue(actual.isJsonArray(), () -> "Expected an array at " + path);
            assertEquals(expected.getAsJsonArray().size(), actual.getAsJsonArray().size(), path);
            for (int i = 0; i < expected.getAsJsonArray().size(); i++) {
                assertPayloadPreserved(expected.getAsJsonArray().get(i),
                        actual.getAsJsonArray().get(i), path + "[" + i + "]");
            }
        } else {
            assertEquals(expected, actual, path);
        }
    }

    protected void prepareWithErrorAndRun(
            String url, String queryPart, Request request, TestRunner testRunner) {
        prepareWithError(url, queryPart, request);
        try {
            testRunner.execute();
            fail();
        } catch (Exception e) {
            assertEquals(
                    "supercell.api.wrapper.essentials.connector.ConnectorException: 400",
                    e.getMessage());
        }
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
