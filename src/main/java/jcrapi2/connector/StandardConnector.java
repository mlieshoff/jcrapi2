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
package jcrapi2.connector;

import static jcrapi2.common.Utils.isNotEmpty;
import static jcrapi2.common.Utils.require;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jcrapi2.common.IResponse;
import jcrapi2.common.RawResponse;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Slf4j
public class StandardConnector implements Connector {

    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    @Override
    public <T extends IResponse> T get(RequestContext requestContext) throws ConnectorException {
        require("requestContext", requestContext);
        try {
            String url = requestContext.url();
            String replacedUrl =
                    appendToUrl(
                            url,
                            requestContext.request().getQueryParameters(),
                            requestContext.request().getRestParameters());
            String json = getInitialValue(replacedUrl);
            boolean makeRequest = json == null || json.isEmpty();
            HttpResponse<String> response = null;
            if (makeRequest) {
                HttpRequest request =
                        HttpRequest.newBuilder()
                                .uri(new URI(replacedUrl))
                                .header("Authorization", "Bearer " + requestContext.apiKey())
                                .GET()
                                .build();
                response =
                        HttpClient.newBuilder()
                                .build()
                                .send(request, HttpResponse.BodyHandlers.ofString());
                logResponse(response);
                if (response.statusCode() != 200) {
                    throw new ConnectorException(String.valueOf(response.statusCode()));
                }
                json = response.body();
                onJsonReceived(replacedUrl, json);
            }
            HttpResponse<String> checkedResponse = checkResponse(json, response);
            log.info("    response content: {}", json);
            T result = (T) GSON.fromJson(json, requestContext.responseClass());
            if (requestContext.request().isStoreRawResponse()) {
                setRawResponse(result, json, checkedResponse);
            }
            return result;
        } catch (InterruptedException | URISyntaxException | IOException e) {
            throw new ConnectorException(e);
        }
    }

    private String appendToUrl(
            String url, Map<String, Object> parameters, Map<String, Object> restParameters) {
        StringBuilder appendedUrl = new StringBuilder(url);
        List<String> queries = new ArrayList<>();
        if (isNotEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    queries.add(name + '=' + encode(String.valueOf(value)));
                }
            }
            if (!queries.isEmpty()) {
                appendedUrl.append('?');
                for (Iterator<String> iterator = queries.iterator(); iterator.hasNext(); ) {
                    appendedUrl.append(iterator.next());
                    if (iterator.hasNext()) {
                        appendedUrl.append('&');
                    }
                }
            }
        }
        String result = appendedUrl.toString();
        for (Map.Entry<String, Object> entry : restParameters.entrySet()) {
            String encodedValue = encode(String.valueOf(entry.getValue()));
            result = result.replace('{' + entry.getKey() + '}', encodedValue);
        }
        log.info("request to: {}", result);
        return result;
    }

    private static String encode(String s) {
        return URLEncoder.encode(s, UTF_8);
    }

    protected String getInitialValue(String url) throws IOException {
        return null;
    }

    private static void logResponse(HttpResponse<String> httpResponse) {
        if (log.isInfoEnabled()) {
            for (Map.Entry<String, List<String>> entry : httpResponse.headers().map().entrySet()) {
                String name = entry.getKey();
                List<String> values = entry.getValue();
                log.info("    response header: {}={}", name, String.join(",", values));
            }
            int code = httpResponse.statusCode();
            log.info("    status code: {}- {}", code, httpResponse.body());
        }
    }

    protected void onJsonReceived(String url, String json) throws IOException {
        // do nothing here
    }

    protected HttpResponse<String> checkResponse(String json, HttpResponse<String> response) {
        return response;
    }

    private <T extends IResponse> void setRawResponse(
            T result, String json, HttpResponse<String> response) {
        RawResponse rawResponse = new RawResponse();
        rawResponse.setRaw(json);
        HttpHeaders headers = response.headers();
        if (headers != null) {
            for (Map.Entry<String, List<String>> entry : headers.map().entrySet()) {
                String name = entry.getKey();
                List<String> values = entry.getValue();
                rawResponse
                        .getResponseHeaders()
                        .put(name.toLowerCase(Locale.ROOT), String.join(",", values));
            }
        }
        result.setRawResponse(rawResponse);
    }
}
