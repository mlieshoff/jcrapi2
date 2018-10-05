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

import static org.apache.http.HttpHeaders.AUTHORIZATION;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import jcrapi2.request.GetClansRequest;
import jcrapi2.request.Request;
import jcrapi2.response.GetClansResponse;

/**
 * @author Michael Lieshoff
 */
public class Client {

  private final String url;
  private final String apiKey;

  private final CrawlerFactory crawlerFactory;

  Client(String url, String apiKey, CrawlerFactory crawlerFactory) {
    checkString(url);
    Preconditions.checkNotNull(crawlerFactory);
    this.url = url;
    this.apiKey = apiKey;
    this.crawlerFactory = crawlerFactory;
  }

  private static void checkString(String url) {
    Preconditions.checkNotNull(url);
    Preconditions.checkArgument(!url.isEmpty(), url);
  }

  GetClansResponse getClans(GetClansRequest getClansRequest) throws IOException {
    Preconditions.checkNotNull(getClansRequest, "getClansRequest");
    String json = get(createUrl("clans"), getClansRequest);
    return new Gson().fromJson(json, GetClansResponse.class);
  }

  private String get(String url, Request request) throws IOException {
    return createCrawler()
        .get(url, createAuthHeader(apiKey), request == null ? null : request.getQueryParameters());
  }

  private static Map<String, String> createAuthHeader(String apiKey) {
    String headerValue = "Bearer " + apiKey;
    return ImmutableMap.<String, String>builder().put(AUTHORIZATION, headerValue).build();
  }

  private Crawler createCrawler() {
    return crawlerFactory.createCrawler();
  }

  private String createUrl(String part) {
    return url + part;
  }

}
