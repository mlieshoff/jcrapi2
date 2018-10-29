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

import static java.util.Collections.singletonList;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableMap;

import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import jcrapi2.response.RawResponse;

/**
 * @author Michael Lieshoff
 */
class CrawlerTest {

  private HttpClientFactory httpClientFactory;

  private HttpClient httpClient;

  @BeforeEach
  void setUp() throws Exception {
    httpClientFactory = Mockito.mock(HttpClientFactory.class);
    httpClient = Mockito.mock(HttpClient.class);
    when(httpClientFactory.create()).thenReturn(httpClient);
  }

  @Test
  void construct_whenWithNullUrl_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Crawler(httpClientFactory).get(null, createHeaders(), null));
  }

  private static Map<String, String> createHeaders() {
    return ImmutableMap.<String, String>builder().put("name", "value").build();
  }

  @Test
  void construct_whenWithEmptyUrl_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Crawler(httpClientFactory).get("", createHeaders(), null));
  }

  @Test
  void construct_whenWithNullHeaders_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Crawler(httpClientFactory).get("abc", null, null));
  }

  @Test
  void construct_whenWithEmptyHeaders_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class,
        () -> new Crawler(httpClientFactory).get("abc", new HashMap<>(), null));
  }

  @Test
  void get_whenWithValidParameters_thenGet() throws Exception {
    String expectedResult = "break-out-prison";
    when(httpClientFactory.create()).thenReturn(httpClient);
    HttpResponse
        httpResponse =
        new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("http", 100, 1), SC_OK, ""));
    httpResponse.setEntity(new StringEntity(expectedResult));
    when(httpClient.execute(anyObject())).thenReturn(httpResponse);
    assertEquals(expectedResult, new Crawler(httpClientFactory).get("the-url", createHeaders()));
  }

  @Test
  void get_whenWithException_thenGetMessage() throws Exception {
    String expectedResult = "break-out-prison";
    when(httpClientFactory.create()).thenReturn(httpClient);
    HttpResponse
        httpResponse =
        new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("http", 100, 1), SC_NOT_FOUND, ""));
    httpResponse.setEntity(new StringEntity(expectedResult));
    when(httpClient.execute(anyObject())).thenReturn(httpResponse);
    try {
      new Crawler(httpClientFactory).get("the-url", createHeaders(), null);
    } catch (IOException e) {
      assertEquals("crapi: " + SC_NOT_FOUND, e.getMessage());
    }
  }

  @Test
  void get_whenWithQueryParameters_thenEncode() throws IOException {
    String expectedResult = "break-out-prison";
    when(httpClientFactory.create()).thenReturn(httpClient);
    HttpResponse
        httpResponse =
        new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("http", 100, 1), SC_OK, ""));
    httpResponse.setEntity(new StringEntity(expectedResult));
    when(httpClient.execute(argThat(getEncodingParameterMatcher()))).thenReturn(httpResponse);
    assertEquals(expectedResult, new Crawler(httpClientFactory).get("the-url", createHeaders(),
        ImmutableMap.<String, String>builder().put("param", "a+b").put("key", "abc").build()));
  }

  private static ArgumentMatcher<HttpUriRequest> getEncodingParameterMatcher() {
    return new ArgumentMatcher<HttpUriRequest>() {
      @Override
      public boolean matches(Object o) {
        if (o instanceof HttpUriRequest) {
          HttpUriRequest httpUriRequest = (HttpUriRequest) o;
          return "param=a%2Bb&key=abc".equals(httpUriRequest.getURI().getRawQuery());
        }
        return false;
      }
    };
  }

  @Test
  void get_whenWithRestParameters_thenEncode() throws IOException {
    String expectedResult = "break-out-prison";
    when(httpClientFactory.create()).thenReturn(httpClient);
    HttpResponse
        httpResponse =
        new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("http", 100, 1), SC_OK, ""));
    httpResponse.setEntity(new StringEntity(expectedResult));
    when(httpClient.execute(argThat(getEncodingRestParameterMatcher()))).thenReturn(httpResponse);
    assertEquals(expectedResult,
        new Crawler(httpClientFactory).get("the-url/%s/end", createHeaders(), null, singletonList("a+b")));
  }

  private static ArgumentMatcher<HttpUriRequest> getEncodingRestParameterMatcher() {
    return new ArgumentMatcher<HttpUriRequest>() {
      @Override
      public boolean matches(Object o) {
        if (o instanceof HttpUriRequest) {
          HttpUriRequest httpUriRequest = (HttpUriRequest) o;
          return "the-url/a%2Bb/end".equals(httpUriRequest.getURI().getRawPath());
        }
        return false;
      }
    };
  }

  @Test
  void get_whenWithRestParametersWithEncodingProblem_thenThrowException() throws IOException {
    when(httpClientFactory.create()).thenReturn(httpClient);
    HttpResponse
        httpResponse =
        new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("http", 100, 1), SC_OK, ""));
    when(httpClient.execute(argThat(getEncodingRestParameterMatcher()))).thenReturn(httpResponse);
    Crawler defectCrawler = new Crawler(httpClientFactory) {
      @Override
      String encode(String s) throws UnsupportedEncodingException {
        throw new UnsupportedEncodingException("test");
      }
    };
    assertThrows(IllegalStateException.class,
        () -> defectCrawler.get("the-url/%s/end", createHeaders(), null, singletonList("a+b")));
  }

  @Test
  public void getLastRawResponse_whenCalled_shouldReturnLastRawResponse() throws IOException {
    String expectedResult = "break-out-prison";
    when(httpClientFactory.create()).thenReturn(httpClient);
    HttpResponse
        httpResponse =
        new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("http", 100, 1), 200, ""));
    httpResponse.setEntity(new StringEntity(expectedResult));
    httpResponse.addHeader("hello", "world");
    when(httpClient.execute(argThat(getEncodingParameterMatcher()))).thenReturn(httpResponse);
    RawResponse rawResponse = new RawResponse();
    rawResponse.setRaw(expectedResult);
    rawResponse.getResponseHeaders().put("hello", "world");
    assertEquals(expectedResult, new Crawler(httpClientFactory).get("the-url", createHeaders(),
        ImmutableMap.<String, String>builder().put("param", "a+b").put("key", "abc").build()));
    assertEquals(rawResponse, new Crawler(httpClientFactory).getLastRawResponse());
  }

}