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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.collections.MapUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.http.HttpStatus.SC_OK;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Michael Lieshoff
 */
@Slf4j
class Crawler {

  private final HttpClientFactory httpClientFactory;

  Crawler(HttpClientFactory httpClientFactory) {
    this.httpClientFactory = httpClientFactory;
  }

  String get(String url, Map<String, String> headers) throws IOException {
    return get(url, headers, null);
  }

  String get(String url, Map<String, String> headers, Map<String, String> parameters) throws IOException {
    return get(url, headers, parameters, null);
  }

  String get(String url, Map<String, String> headers, Map<String, String> parameters, Collection<String> restUrlParts)
      throws IOException {
    checkNotNull(url);
    checkArgument(!url.isEmpty());
    checkNotNull(headers);
    checkArgument(!headers.isEmpty());
    String replacedUrl = appendToUrl(url, parameters, restUrlParts);
    HttpClient client = httpClientFactory.create();
    HttpGet request = createRequest(replacedUrl, headers);
    HttpResponse response = client.execute(request);
    logResponse(response);
    StatusLine statusLine = response.getStatusLine();
    if (statusLine.getStatusCode() != SC_OK) {
      throw new CrawlerException(statusLine);
    }
    StringBuilder content = new StringBuilder();
    try (BufferedReader rd = new BufferedReader(
        new InputStreamReader(response.getEntity().getContent(), Charset.forName("UTF-8")))) {
      String line;
      while ((line = rd.readLine()) != null) {
        content.append(line);
      }
    }
    log.info("    response content: {}", content);
    return content.toString();
  }

  private static void logResponse(HttpResponse httpResponse) {
    if (log.isInfoEnabled()) {
      for (Header header : httpResponse.getAllHeaders()) {
        log.info("    response header: {}={}", header.getName(), header.getValue());
      }
      StatusLine statusLine = httpResponse.getStatusLine();
      log.info("    status code: {}- {}", statusLine.getStatusCode(), statusLine.getReasonPhrase());
    }
  }

  private String appendToUrl(String url, Map<String, String> parameters, Collection<String> restUrlParts)
      throws UnsupportedEncodingException {
    StringBuilder appendedUrl = new StringBuilder(url);
    if (isNotEmpty(parameters)) {
      appendedUrl.append('?');
      for (Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator(); iterator.hasNext(); ) {
        Map.Entry<String, String> entry = iterator.next();
        String name = entry.getKey();
        String value = entry.getKey();
        appendedUrl.append(name);
        appendedUrl.append('=');
        if (isNotBlank(value)) {
          appendedUrl.append(encode(entry.getValue()));
        }
        if (iterator.hasNext()) {
          appendedUrl.append('&');
        }
      }
    }
    String result = appendedUrl.toString();
    if (CollectionUtils.isNotEmpty(restUrlParts)) {
      Object[] encodedParams = restUrlParts.stream().map(s -> {
        try {
          return encode(s);
        } catch (UnsupportedEncodingException e) {
          throw new IllegalStateException(e);
        }
      }).toArray();
      result = String.format(result, (Object[]) encodedParams);
    }
    log.info("request to: {}", result);
    return result;
  }

  String encode(String s) throws UnsupportedEncodingException {
    return URLEncoder.encode(s, "UTF-8");
  }

  private static HttpGet createRequest(String url, Map<String, String> headers) {
    HttpGet httpGet = new HttpGet(url);
    addHeaders(httpGet, headers);
    return httpGet;
  }

  private static void addHeaders(HttpMessage httpMessage, Map<String, String> headers) {
    headers.forEach((key, value) -> {
      log.info("    request header: {}={}", key, value);
      httpMessage.addHeader(key, value);
    });
  }

}
