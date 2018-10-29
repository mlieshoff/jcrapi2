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

import jcrapi2.request.GetClanCurrentWarRequest;
import jcrapi2.request.GetClanMembersRequest;
import jcrapi2.request.GetClanRequest;
import jcrapi2.request.GetClanWarLogRequest;
import jcrapi2.request.GetClansRequest;
import jcrapi2.request.GetPlayerBattleLogRequest;
import jcrapi2.request.GetPlayerRequest;
import jcrapi2.request.GetPlayerUpcomingChestsRequest;
import jcrapi2.request.GetTournamentRequest;
import jcrapi2.request.GetTournamentsRequest;
import jcrapi2.response.GetClanCurrentWarResponse;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClanWarLogResponse;
import jcrapi2.response.GetClansResponse;
import jcrapi2.response.GetPlayerResponse;
import jcrapi2.response.GetPlayerUpcomingChestsResponse;

/**
 * @author Michael Lieshoff
 */
class ApiTest {

  private static final String API_KEY = "apiKey";
  private static final String CLAN_TAG = "clanTag";
  private static final String NAME = "name";
  private static final String PLAYER_TAG = "playerTag";
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

  @Test
  void getClanWarLog_whenWithNullRequest_thenThrowsException() throws Exception {
    assertThrows(NullPointerException.class, () -> api.getClanWarLog(null));
  }

  @Test
  void getClanWarLog_whenWithRequest_thenReturnResult() throws Exception {
    GetClanWarLogRequest getClanWarLogRequest = GetClanWarLogRequest.builder(CLAN_TAG).build();
    GetClanWarLogResponse getClanWarLogResponse = new GetClanWarLogResponse();
    when(client.getClanWarLog(getClanWarLogRequest)).thenReturn(getClanWarLogResponse);
    assertEquals(getClanWarLogResponse, api.getClanWarLog(getClanWarLogRequest));
  }

  @Test
  void getClanWarLog_whenWithException_thenThrowApiException() throws Exception {
    GetClanWarLogRequest getClanWarLogRequest = GetClanWarLogRequest.builder(CLAN_TAG).build();
    when(client.getClanWarLog(getClanWarLogRequest)).thenThrow(crawlerException);
    try {
      api.getClanWarLog(getClanWarLogRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

  @Test
  void getClanCurrentWar_whenWithNullRequest_thenThrowsException() throws Exception {
    assertThrows(NullPointerException.class, () -> api.getClanCurrentWar(null));
  }

  @Test
  void getClanCurrentWar_whenWithRequest_thenReturnResult() throws Exception {
    GetClanCurrentWarRequest getClanCurrentWarRequest = GetClanCurrentWarRequest.builder(CLAN_TAG).build();
    GetClanCurrentWarResponse getClanCurrentWarResponse = new GetClanCurrentWarResponse();
    when(client.getClanCurrentWar(getClanCurrentWarRequest)).thenReturn(getClanCurrentWarResponse);
    assertEquals(getClanCurrentWarResponse, api.getClanCurrentWar(getClanCurrentWarRequest));
  }

  @Test
  void getClanCurrentWar_whenWithException_thenThrowApiException() throws Exception {
    GetClanCurrentWarRequest getClanCurrentWarRequest = GetClanCurrentWarRequest.builder(CLAN_TAG).build();
    when(client.getClanCurrentWar(getClanCurrentWarRequest)).thenThrow(crawlerException);
    try {
      api.getClanCurrentWar(getClanCurrentWarRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

  @Test
  void getPlayer_whenWithNullRequest_thenThrowsException() throws Exception {
    assertThrows(NullPointerException.class, () -> api.getPlayer(null));
  }

  @Test
  void getPlayer_whenWithRequest_thenReturnResult() throws Exception {
    GetPlayerRequest getPlayerRequest = GetPlayerRequest.builder(PLAYER_TAG).build();
    GetPlayerResponse getPlayerResponse = new GetPlayerResponse();
    when(client.getPlayer(getPlayerRequest)).thenReturn(getPlayerResponse);
    assertEquals(getPlayerResponse, api.getPlayer(getPlayerRequest));
  }

  @Test
  void getPlayer_whenWithException_thenThrowApiException() throws Exception {
    GetPlayerRequest getPlayerRequest = GetPlayerRequest.builder(PLAYER_TAG).build();
    when(client.getPlayer(getPlayerRequest)).thenThrow(crawlerException);
    try {
      api.getPlayer(getPlayerRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

  @Test
  void getPlayerUpcomingChests_whenWithNullRequest_thenThrowsException() throws Exception {
    assertThrows(NullPointerException.class, () -> api.getPlayerUpcomingChests(null));
  }

  @Test
  void getPlayerUpcomingChests_whenWithRequest_thenReturnResult() throws Exception {
    GetPlayerUpcomingChestsRequest
        getPlayerUpcomingChestsRequest =
        GetPlayerUpcomingChestsRequest.builder(PLAYER_TAG).build();
    GetPlayerUpcomingChestsResponse getPlayerUpcomingChestsResponse = new GetPlayerUpcomingChestsResponse();
    when(client.getPlayerUpcomingChests(getPlayerUpcomingChestsRequest)).thenReturn(getPlayerUpcomingChestsResponse);
    assertEquals(getPlayerUpcomingChestsResponse, api.getPlayerUpcomingChests(getPlayerUpcomingChestsRequest));
  }

  @Test
  void getPlayerUpcomingChests_whenWithException_thenThrowApiException() throws Exception {
    GetPlayerUpcomingChestsRequest
        getPlayerUpcomingChestsRequest =
        GetPlayerUpcomingChestsRequest.builder(PLAYER_TAG).build();
    when(client.getPlayerUpcomingChests(getPlayerUpcomingChestsRequest)).thenThrow(crawlerException);
    try {
      api.getPlayerUpcomingChests(getPlayerUpcomingChestsRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

  @Test
  void getPlayerBattleLog_whenWithException_thenThrowApiException() throws Exception {
    GetPlayerBattleLogRequest
        getPlayerBattleLogRequest =
        GetPlayerBattleLogRequest.builder(PLAYER_TAG).build();
    when(client.getPlayerBattleLog(getPlayerBattleLogRequest)).thenThrow(crawlerException);
    try {
      api.getPlayerBattleLog(getPlayerBattleLogRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

  @Test
  void getTournaments_whenWithException_thenThrowApiException() throws Exception {
    GetTournamentsRequest getTournamentsRequest = GetTournamentsRequest.builder().build();
    when(client.getTournaments(getTournamentsRequest)).thenThrow(crawlerException);
    try {
      api.getTournaments(getTournamentsRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

  @Test
  void getTournament_whenWithException_thenThrowApiException() throws Exception {
    GetTournamentRequest getTournamentRequest = GetTournamentRequest.builder("tournamentTag").build();
    when(client.getTournament(getTournamentRequest)).thenThrow(crawlerException);
    try {
      api.getTournament(getTournamentRequest);
      fail();
    } catch (ApiException e) {
      assertEquals(SC_NOT_FOUND, e.getCode());
    }
  }

}
