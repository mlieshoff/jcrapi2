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

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jcrapi2.request.GetClansRequest;
import jcrapi2.response.GetClansResponse;

/**
 * @author Michael Lieshoff
 */
class ApiTest {

  private Client client;

  private Api api;

  private CrawlerException crawlerException;

  @BeforeEach
  void setUp() throws Exception {
    ClientFactory clientFactory = mock(ClientFactory.class);
    client = mock(Client.class);
    when(clientFactory.createClient("lala", "abc")).thenReturn(client);
    api = new Api("lala", "abc", clientFactory);
    crawlerException = mock(CrawlerException.class);
    when(crawlerException.getStatusCode()).thenReturn(SC_NOT_FOUND);
  }

  @Test
  void construct_whenWithNullUrl_shouldThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Api(null, "abc"));
  }

  @Test
  void construct_whenWithEmptyUrl_shouldThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Api("", "abc"));
  }

  @Test
  void construct_whenWithNullApiKey_shouldThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Api("url", null));
  }

  @Test
  void construct_whenWithEmptyApiKey_shouldThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Api("url", ""));
  }

  @Test
  void getClans_whenWithNullRequest_shouldThrowsException() throws Exception {
    assertThrows(NullPointerException.class, () -> api.getClans(null));
  }

  @Test
  void getClans_whenWithRequest_shouldReturnResult() throws Exception {
    GetClansRequest getClansRequest = GetClansRequest.builder().name("name").build();
    GetClansResponse getClansResponse = new GetClansResponse();
    when(client.getClans(getClansRequest)).thenReturn(getClansResponse);
    assertEquals(getClansResponse, api.getClans(getClansRequest));
  }

  @Test
  void getClans_whenWithException_shouldThrowApiException() throws Exception {
    GetClansRequest getClansRequest = GetClansRequest.builder().name("name").build();
    when(client.getClans(getClansRequest)).thenThrow(crawlerException);
    try {
      api.getClans(getClansRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

}
