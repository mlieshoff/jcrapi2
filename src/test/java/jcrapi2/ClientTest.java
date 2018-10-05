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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import jcrapi2.request.GetClansRequest;

/**
 * @author Michael Lieshoff
 */
class ClientTest {

  private CrawlerFactory crawlerFactory;

  private Crawler crawler;

  @BeforeEach
  void setUp() throws Exception {
    crawlerFactory = mock(CrawlerFactory.class);
    crawler = mock(Crawler.class);
    when(crawlerFactory.createCrawler()).thenReturn(crawler);
  }

  @Test
  void construct_whenWithNullUrl_shouldThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Client(null, "abc", crawlerFactory));
  }

  @Test
  void construct_whenWithEmptyUrl_shouldThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Client("", "abc", crawlerFactory));
  }

  @Test
  void construct_whenWithNullCrawlerFactory_shouldThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Client("abc", "abc", null));
  }

  @Test
  void getClans_whenWithNullRequest_shouldThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> createClient().getClans(null));
  }

  @Test
  void getClans_whenWithRequest_shouldGetResponse() throws Exception {
    GetClansRequest getClansRequest = GetClansRequest.builder().name("abbas").build();
    when(crawler.get("lala/clans", createHeaders(), getClansRequest.getQueryParameters())).thenReturn("{}");
    assertNotNull(createClient().getClans(getClansRequest));
  }

  private static Map<String, String> createHeaders() {
    return ImmutableMap.<String, String>builder().put(AUTHORIZATION, "Bearer abc").build();
  }

  private Client createClient() {
    return new Client("lala/", "abc", crawlerFactory);
  }

}