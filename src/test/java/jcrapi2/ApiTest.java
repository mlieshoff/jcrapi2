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

import jcrapi2.request.GetClanMembersRequest;
import jcrapi2.request.GetClanRequest;
import jcrapi2.request.GetClansRequest;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClansResponse;

/**
 * @author Michael Lieshoff
 */
class ApiTest {

  private static final String API_KEY = "apiKey";
  private static final String CLAN_TAG = "clanTag";
  private static final String NAME = "name";
  private static final String URL = "url";

  private Client client;

  private Api api;

  private CrawlerException crawlerException;

  @BeforeEach
  void setUp() throws Exception {
    ClientFactory clientFactory = mock(ClientFactory.class);
    client = mock(Client.class);
    when(clientFactory.createClient(URL, API_KEY)).thenReturn(client);
    api = new Api(URL, API_KEY, clientFactory);
    crawlerException = mock(CrawlerException.class);
    when(crawlerException.getStatusCode()).thenReturn(SC_NOT_FOUND);
  }

  @Test
  void construct_whenWithNullUrl_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Api(null, API_KEY));
  }

  @Test
  void construct_whenWithEmptyUrl_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Api("", API_KEY));
  }

  @Test
  void construct_whenWithNullApiKey_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Api(URL, null));
  }

  @Test
  void construct_whenWithEmptyApiKey_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Api(URL, ""));
  }

  @Test
  void getClans_whenWithNullRequest_thenThrowsException() throws Exception {
    assertThrows(NullPointerException.class, () -> api.getClans(null));
  }

  @Test
  void getClans_whenWithRequest_thenReturnResult() throws Exception {
    GetClansRequest getClansRequest = GetClansRequest.builder().name(NAME).build();
    GetClansResponse getClansResponse = new GetClansResponse();
    when(client.getClans(getClansRequest)).thenReturn(getClansResponse);
    assertEquals(getClansResponse, api.getClans(getClansRequest));
  }

  @Test
  void getClans_whenWithException_thenThrowApiException() throws Exception {
    GetClansRequest getClansRequest = GetClansRequest.builder().name(NAME).build();
    when(client.getClans(getClansRequest)).thenThrow(crawlerException);
    try {
      api.getClans(getClansRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

  @Test
  void getClan_whenWithNullRequest_thenThrowsException() throws Exception {
    assertThrows(NullPointerException.class, () -> api.getClan(null));
  }

  @Test
  void getClan_whenWithRequest_thenReturnResult() throws Exception {
    GetClanRequest getClanRequest = GetClanRequest.builder(CLAN_TAG).build();
    GetClanResponse getClanResponse = new GetClanResponse();
    when(client.getClan(getClanRequest)).thenReturn(getClanResponse);
    assertEquals(getClanResponse, api.getClan(getClanRequest));
  }

  @Test
  void getClan_whenWithException_thenThrowApiException() throws Exception {
    GetClanRequest getClanRequest = GetClanRequest.builder(CLAN_TAG).build();
    when(client.getClan(getClanRequest)).thenThrow(crawlerException);
    try {
      api.getClan(getClanRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

  @Test
  void getClanMembers_whenWithNullRequest_thenThrowsException() throws Exception {
    assertThrows(NullPointerException.class, () -> api.getClanMembers(null));
  }

  @Test
  void getClanMembers_whenWithRequest_thenReturnResult() throws Exception {
    GetClanMembersRequest getClanMembersRequest = GetClanMembersRequest.builder(CLAN_TAG).build();
    GetClanMembersResponse getClanMembersResponse = new GetClanMembersResponse();
    when(client.getClanMembers(getClanMembersRequest)).thenReturn(getClanMembersResponse);
    assertEquals(getClanMembersResponse, api.getClanMembers(getClanMembersRequest));
  }

  @Test
  void getClanMembers_whenWithException_thenThrowApiException() throws Exception {
    GetClanMembersRequest getClanMembersRequest = GetClanMembersRequest.builder(CLAN_TAG).build();
    when(client.getClanMembers(getClanMembersRequest)).thenThrow(crawlerException);
    try {
      api.getClanMembers(getClanMembersRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

}
