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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jcrapi2.request.GetClanCurrentWarRequest;
import jcrapi2.request.GetClanMembersRequest;
import jcrapi2.request.GetClanRequest;
import jcrapi2.request.GetClanWarLogRequest;
import jcrapi2.request.GetClansRequest;
import jcrapi2.request.GetLocationClanRankingsRequest;
import jcrapi2.request.GetLocationClanWarRankingsRequest;
import jcrapi2.request.GetLocationPlayerRankingsRequest;
import jcrapi2.request.GetLocationRequest;
import jcrapi2.request.GetLocationsRequest;
import jcrapi2.request.GetPlayerBattleLogRequest;
import jcrapi2.request.GetPlayerRequest;
import jcrapi2.request.GetPlayerUpcomingChestsRequest;
import jcrapi2.request.GetTournamentRequest;
import jcrapi2.request.GetTournamentsRequest;
import jcrapi2.response.GetCardsResponse;
import jcrapi2.response.GetClanCurrentWarResponse;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClanWarLogResponse;
import jcrapi2.response.GetClansResponse;
import jcrapi2.response.GetLocationClanRankingsResponse;
import jcrapi2.response.GetLocationClanWarRankingsResponse;
import jcrapi2.response.GetLocationPlayerRankingsResponse;
import jcrapi2.response.GetLocationResponse;
import jcrapi2.response.GetLocationsResponse;
import jcrapi2.response.GetPlayerBattleLogResponse;
import jcrapi2.response.GetPlayerResponse;
import jcrapi2.response.GetPlayerUpcomingChestsResponse;
import jcrapi2.response.GetTournamentResponse;
import jcrapi2.response.GetTournamentsResponse;

/**
 * @author Michael Lieshoff
 */
class EndToEnd {

  private static final String API_KEY = System.getProperty("api.key");

  private Api api;

  @BeforeEach
  void setUp() throws Exception {
    api = new Api("https://api.clashroyale.com/v1/", API_KEY);
  }

  @Test
  void getClans_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClansResponse getClansResponse = api.getClans(GetClansRequest.builder().name("puzzle").build());
    assertAll(
        () -> assertNotNull(getClansResponse, "getClansResponse"),
        () -> assertNull(getClansResponse.getMessage(), "message"),
        () -> assertNull(getClansResponse.getReason(), "reason")
    );
  }

  @Test
  void getClan_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClanResponse getClanResponse = api.getClan(GetClanRequest.builder("#RP88QQG").build());
    assertAll(
        () -> assertNotNull(getClanResponse, "getClanResponse"),
        () -> assertNull(getClanResponse.getMessage(), "message"),
        () -> assertNull(getClanResponse.getReason(), "reason")
    );
  }

  @Test
  void getClanMembers_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClanMembersResponse
        getClanMembersResponse =
        api.getClanMembers(GetClanMembersRequest.builder("#RP88QQG").build());
    assertAll(
        () -> assertNotNull(getClanMembersResponse, "getClanMembersResponse"),
        () -> assertNull(getClanMembersResponse.getMessage(), "message"),
        () -> assertNull(getClanMembersResponse.getReason(), "reason")
    );
  }

  @Test
  void getClanWarLog_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClanWarLogResponse
        getClanWarLogResponse =
        api.getClanWarLog(GetClanWarLogRequest.builder("#RP88QQG").build());
    assertAll(
        () -> assertNotNull(getClanWarLogResponse, "getClanWarLogResponse"),
        () -> assertNull(getClanWarLogResponse.getMessage(), "message"),
        () -> assertNull(getClanWarLogResponse.getReason(), "reason")
    );
  }

  @Test
  void getClanCurrentWar_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClanCurrentWarResponse
        getClanCurrentWarResponse =
        api.getClanCurrentWar(GetClanCurrentWarRequest.builder("#RP88QQG").build());
    assertAll(
        () -> assertNotNull(getClanCurrentWarResponse, "getClanCurrentWarResponse"),
        () -> assertNull(getClanCurrentWarResponse.getMessage(), "message"),
        () -> assertNull(getClanCurrentWarResponse.getReason(), "reason")
    );
  }

  @Test
  void getPlayer_whenWithValidParameters_thenGetResponse() throws Exception {
    GetPlayerResponse getPlayerResponse = api.getPlayer(GetPlayerRequest.builder("#L88P2282").build());
    assertAll(
        () -> assertNotNull(getPlayerResponse, "getPlayerResponse"),
        () -> assertNull(getPlayerResponse.getMessage(), "message"),
        () -> assertNull(getPlayerResponse.getReason(), "reason")
    );
    aaa,
  }

  @Test
  void getPlayerUpcomingChests_whenWithValidParameters_thenGetResponse() throws Exception {
    GetPlayerUpcomingChestsResponse
        getPlayerUpcomingChestsResponse =
        api.getPlayerUpcomingChests(GetPlayerUpcomingChestsRequest.builder("#L88P2282").build());
    assertAll(
        () -> assertNotNull(getPlayerUpcomingChestsResponse, "getPlayerUpcomingChestsResponse"),
        () -> assertNull(getPlayerUpcomingChestsResponse.getMessage(), "message"),
        () -> assertNull(getPlayerUpcomingChestsResponse.getReason(), "reason")
    );
  }

  @Test
  void getPlayerBattleLog_whenWithValidParameters_thenGetResponse() throws Exception {
    GetPlayerBattleLogResponse
        getPlayerBattleLogResponse =
        api.getPlayerBattleLog(GetPlayerBattleLogRequest.builder("#L88P2282").build());
    assertAll(
        () -> assertNotNull(getPlayerBattleLogResponse, "getPlayerBattleLogResponse"),
        () -> assertNull(getPlayerBattleLogResponse.getMessage(), "message"),
        () -> assertNull(getPlayerBattleLogResponse.getReason(), "reason")
    );
  }

  @Test
  void getTournaments_whenWithValidParameters_thenGetResponse() throws Exception {
    GetTournamentsResponse
        getTournamentsResponse =
        api.getTournaments(GetTournamentsRequest.builder().name("de").build());
    assertAll(
        () -> assertNotNull(getTournamentsResponse, "getTournamentsResponse"),
        () -> assertNull(getTournamentsResponse.getMessage(), "message"),
        () -> assertNull(getTournamentsResponse.getReason(), "reason")
    );
  }

  @Test
  void getTournament_whenWithValidParameters_thenGetResponse() throws Exception {
    GetTournamentResponse
        getTournamentResponse =
        api.getTournament(GetTournamentRequest.builder("#U2QQQL2").build());
    assertAll(
        () -> assertNotNull(getTournamentResponse, "getTournamentResponse"),
        () -> assertNull(getTournamentResponse.getMessage(), "message"),
        () -> assertNull(getTournamentResponse.getReason(), "reason")
    );
  }

  @Test
  void getCards_whenCalled_thenGetResponse() throws Exception {
    GetCardsResponse getCardsResponse = api.getCards();
    assertAll(
        () -> assertNotNull(getCardsResponse, "getCardsResponse"),
        () -> assertNull(getCardsResponse.getMessage(), "message"),
        () -> assertNull(getCardsResponse.getReason(), "reason")
    );
  }

  @Test
  void getLocations_whenWithValidParameters_thenGetResponse() throws Exception {
    GetLocationsResponse getLocationsResponse = api.getLocations(GetLocationsRequest.builder().build());
    assertAll(
        () -> assertNotNull(getLocationsResponse, "getLocationsResponse"),
        () -> assertNull(getLocationsResponse.getMessage(), "message"),
        () -> assertNull(getLocationsResponse.getReason(), "reason")
    );
  }

  @Test
  void getLocation_whenWithValidParameters_thenGetResponse() throws Exception {
    GetLocationResponse getLocationResponse = api.getLocation(GetLocationRequest.builder("57000094").build());
    assertAll(
        () -> assertNotNull(getLocationResponse, "getLocationResponse"),
        () -> assertNull(getLocationResponse.getMessage(), "message"),
        () -> assertNull(getLocationResponse.getReason(), "reason")
    );
  }

  @Test
  void getLocationClanRankings_whenWithValidParameters_thenGetResponse() throws Exception {
    GetLocationClanRankingsResponse
        getLocationClanRankingsResponse =
        api.getLocationClanRankings(GetLocationClanRankingsRequest.builder("57000094").build());
    assertAll(
        () -> assertNotNull(getLocationClanRankingsResponse, "getLocationClanRankingsResponse"),
        () -> assertNull(getLocationClanRankingsResponse.getMessage(), "message"),
        () -> assertNull(getLocationClanRankingsResponse.getReason(), "reason")
    );
  }

  @Test
  void getLocationPlayerRankings_whenWithValidParameters_thenGetResponse() throws Exception {
    GetLocationPlayerRankingsResponse
        getLocationPlayerRankingsResponse =
        api.getLocationPlayerRankings(GetLocationPlayerRankingsRequest.builder("57000094").build());
    assertAll(
        () -> assertNotNull(getLocationPlayerRankingsResponse, "getLocationPlayerRankingsResponse"),
        () -> assertNull(getLocationPlayerRankingsResponse.getMessage(), "message"),
        () -> assertNull(getLocationPlayerRankingsResponse.getReason(), "reason")
    );
  }

  @Test
  void getLocationClanWarRankings_whenWithValidParameters_thenGetResponse() throws Exception {
    GetLocationClanWarRankingsResponse
        getLocationClanWarRankingsResponse =
        api.getLocationClanWarRankings(GetLocationClanWarRankingsRequest.builder("57000094").build());
    assertAll(
        () -> assertNotNull(getLocationClanWarRankingsResponse, "getLocationClanWarRankingsResponse"),
        () -> assertNull(getLocationClanWarRankingsResponse.getMessage(), "message"),
        () -> assertNull(getLocationClanWarRankingsResponse.getReason(), "reason")
    );
  }

}
