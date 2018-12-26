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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jcrapi2.request.GetClanCurrentWarRequest;
import jcrapi2.request.GetClanMembersRequest;
import jcrapi2.request.GetClanRequest;
import jcrapi2.request.GetClanWarLogRequest;
import jcrapi2.request.GetClansRequest;
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
class IntegrationTest {

  private static final int PORT = 50000;

  private static JettyServer jettyServer;

  private static final String CONTEXT = "test";
  private static final String APP = "jcrapi2";
  private static final String URL = String.format("http://localhost:50000/%s/%s/", CONTEXT, APP);
  static final String API_KEY = "itsasecret";

  @BeforeAll
  static void beforeClass() throws Exception {
    jettyServer = new JettyServer(PORT, '/' + CONTEXT);
    jettyServer.addServlet('/' + APP + "/clans/*", new TestClansServlet());
    jettyServer.addServlet('/' + APP + "/players/*", new TestPlayersServlet());
    jettyServer.addServlet('/' + APP + "/tournaments/*", new TestTournamentsServlet());
    jettyServer.addServlet('/' + APP + "/cards/*", new TestCardsServlet());
    jettyServer.addServlet('/' + APP + "/locations/*", new TestLocationsServlet());
    jettyServer.start();
  }

  @AfterAll
  static void afterClass() throws Exception {
    jettyServer.stop();
  }

  @Test
  void getClans_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetClans(API_KEY);
  }

  private static void doGetClans(String apiKey) {
    GetClansResponse actual = new Api(URL, apiKey).getClans(GetClansRequest.builder().name("name").build());
    assertNotNull(actual);
    actual.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void getClans_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetClans("lala2"));
  }

  @Test
  void getClan_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetClan(API_KEY);
  }

  private static void doGetClan(String apiKey) {
    GetClanResponse actual = new Api(URL, apiKey).getClan(GetClanRequest.builder("clanTag").build());
    assertNotNull(actual);
  }

  @Test
  void getClan_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetClan("lala2"));
  }

  @Test
  void getClanMembers_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetClanMembers(API_KEY);
  }

  private static void doGetClanMembers(String apiKey) {
    GetClanMembersResponse
        actual =
        new Api(URL, apiKey).getClanMembers(GetClanMembersRequest.builder("clanTag").build());
    assertNotNull(actual);
    actual.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void getClanMembers_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetClanMembers("lala2"));
  }

  @Test
  void getClanWarLog_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetClanWarLog(API_KEY);
  }

  private static void doGetClanWarLog(String apiKey) {
    GetClanWarLogResponse actual = new Api(URL, apiKey).getClanWarLog(GetClanWarLogRequest.builder("clanTag").build());
    assertNotNull(actual);
    actual.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void getClanWarLog_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetClanWarLog("lala2"));
  }

  @Test
  void getClanCurrentWar_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetClanCurrentWar(API_KEY);
  }

  private static void doGetClanCurrentWar(String apiKey) {
    GetClanCurrentWarResponse
        actual =
        new Api(URL, apiKey).getClanCurrentWar(GetClanCurrentWarRequest.builder("clanTag").build());
    assertNotNull(actual);
  }

  @Test
  void getClanCurrentWar_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetClanCurrentWar("lala2"));
  }

  @Test
  void getPlayer_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetPlayer(API_KEY);
  }

  private static void doGetPlayer(String apiKey) {
    GetPlayerResponse actual = new Api(URL, apiKey).getPlayer(GetPlayerRequest.builder("playerTag").build());
    assertNotNull(actual);
  }

  @Test
  void getPlayer_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetPlayer("lala2"));
  }

  @Test
  void getPlayerUpcomingChests_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetPlayerUpcomingChests(API_KEY);
  }

  private static void doGetPlayerUpcomingChests(String apiKey) {
    GetPlayerUpcomingChestsResponse
        actual =
        new Api(URL, apiKey).getPlayerUpcomingChests(GetPlayerUpcomingChestsRequest.builder("playerTag").build());
    assertNotNull(actual);
    actual.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void getPlayerUpcomingChests_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetPlayerUpcomingChests("lala2"));
  }

  @Test
  void getPlayerBattleLog_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetPlayerBattleLog(API_KEY);
  }

  private static void doGetPlayerBattleLog(String apiKey) {
    GetPlayerBattleLogResponse
        actual =
        new Api(URL, apiKey).getPlayerBattleLog(GetPlayerBattleLogRequest.builder("playerTag").build());
    assertNotNull(actual);
  }

  @Test
  void getPlayerBattleLog_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetPlayerBattleLog("lala2"));
  }

  @Test
  void getTournaments_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetTournaments(API_KEY);
  }

  private static void doGetTournaments(String apiKey) {
    GetTournamentsResponse
        actual =
        new Api(URL, apiKey).getTournaments(GetTournamentsRequest.builder().name("name").build());
    assertNotNull(actual);
    actual.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void getTournaments_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetTournaments("lala2"));
  }

  @Test
  void getTournament_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetTournament(API_KEY);
  }

  private static void doGetTournament(String apiKey) {
    GetTournamentResponse
        actual =
        new Api(URL, apiKey).getTournament(GetTournamentRequest.builder("tournamentTag").build());
    assertNotNull(actual);
    actual.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void getTournament_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetTournament("lala2"));
  }

  @Test
  void getCards_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetCards(API_KEY);
  }

  private static void doGetCards(String apiKey) {
    GetCardsResponse actual = new Api(URL, apiKey).getCards();
    assertNotNull(actual);
    actual.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void getCards_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetCards("lala2"));
  }

  @Test
  void getLocations_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetLocations(API_KEY);
  }

  private static void doGetLocations(String apiKey) {
    GetLocationsResponse actual = new Api(URL, apiKey).getLocations(GetLocationsRequest.builder().build());
    assertNotNull(actual);
    actual.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void getLocations_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetLocations("lala2"));
  }

  @Test
  void getLocation_whenWithValidParameters_thenReturnResponse() throws Exception {
    doGetLocation(API_KEY);
  }

  private static void doGetLocation(String apiKey) {
    GetLocationResponse actual = new Api(URL, apiKey).getLocation(GetLocationRequest.builder("de").build());
    assertNotNull(actual);
  }

  @Test
  void getLocation_whenWithWrongUrl_thenThrow() throws Exception {
    assertThrows(ApiException.class, () -> doGetLocation("lala2"));
  }

}
