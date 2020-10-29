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

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.apache.http.HttpHeaders.AUTHORIZATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jcrapi2.request.BlankRequest;
import jcrapi2.request.GetClanCurrentWarRequest;
import jcrapi2.request.GetClanMembersRequest;
import jcrapi2.request.GetClanRequest;
import jcrapi2.request.GetClanRiverRaceLogRequest;
import jcrapi2.request.GetClanWarLogRequest;
import jcrapi2.request.GetClansRequest;
import jcrapi2.request.GetCurrentClanRiverRaceRequest;
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
import jcrapi2.response.Callback;
import jcrapi2.response.GetTournamentResponse;
import jcrapi2.response.RawResponse;

/**
 * @author Michael Lieshoff
 */
class ClientTest {

  private static final String API_KEY = "apiKey";
  private static final String CLAN_TAG = "clanTag";
  private static final String LOCATION_ID = "locationId";
  private static final String NAME = "name";
  private static final String PLAYER_TAG = "playerTag";
  private static final String URL = "url";

  private CrawlerFactory crawlerFactory;

  private Crawler crawler;

  @BeforeEach
  void setUp() throws Exception {
    crawlerFactory = mock(CrawlerFactory.class);
    crawler = mock(Crawler.class);
    when(crawlerFactory.createCrawler()).thenReturn(crawler);
  }

  @Test
  void construct_whenWithNullUrl_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Client(null, API_KEY, crawlerFactory));
  }

  @Test
  void construct_whenWithEmptyUrl_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Client("", API_KEY, crawlerFactory));
  }

  @Test
  void construct_whenWithNullCrawlerFactory_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new Client(URL, API_KEY, null));
  }

  @Test
  void getClans_whenWithNullRequest_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> createClient().getClans(null));
  }

  private Client createClient() {
    return new Client("lala/", API_KEY, crawlerFactory);
  }

  @Test
  void getClans_whenWithRequest_thenGetResponse() throws Exception {
    GetClansRequest getClansRequest = GetClansRequest.builder().name(NAME).build();
    when(crawler
        .get("lala/clans", createHeaders(), getClansRequest.getQueryParameters(), getClansRequest.getRestParameters()))
        .thenReturn("{}");
    assertNotNull(createClient().getClans(getClansRequest));
  }

  private static Map<String, String> createHeaders() {
    return ImmutableMap.<String, String>builder().put(AUTHORIZATION, "Bearer " + API_KEY).build();
  }

  @Test
  void getClan_whenWithRequest_thenGetResponse() throws Exception {
    GetClanRequest getClanRequest = GetClanRequest.builder(CLAN_TAG).build();
    when(crawler
        .get("lala/clans/%s", createHeaders(), getClanRequest.getQueryParameters(), getClanRequest.getRestParameters()))
        .thenReturn("{}");
    assertNotNull(createClient().getClan(getClanRequest));
  }

  @Test
  void getClanMembers_whenWithRequest_thenGetResponse() throws Exception {
    GetClanMembersRequest getClanMemberRequest = GetClanMembersRequest.builder(CLAN_TAG).build();
    when(crawler.get("lala/clans/%s/members", createHeaders(), getClanMemberRequest.getQueryParameters(),
        getClanMemberRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getClanMembers(getClanMemberRequest));
  }

  @Test
  void getClanWarLog_whenWithRequest_thenGetResponse() throws Exception {
    GetClanWarLogRequest getClanWarLogRequest = GetClanWarLogRequest.builder(CLAN_TAG).build();
    when(crawler.get("lala/clans/%s/warlog", createHeaders(), getClanWarLogRequest.getQueryParameters(),
        getClanWarLogRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getClanWarLog(getClanWarLogRequest));
  }

  @Test
  void getClanCurrentWar_whenWithRequest_thenGetResponse() throws Exception {
    GetClanCurrentWarRequest getClanCurrentWarRequest = GetClanCurrentWarRequest.builder(CLAN_TAG).build();
    when(crawler.get("lala/clans/%s/currentwar", createHeaders(), getClanCurrentWarRequest.getQueryParameters(),
        getClanCurrentWarRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getClanCurrentWar(getClanCurrentWarRequest));
  }

  @Test
  void getPlayer_whenWithRequest_thenGetResponse() throws Exception {
    GetPlayerRequest getPlayerRequest = GetPlayerRequest.builder(PLAYER_TAG).build();
    when(crawler
        .get("lala/players/%s", createHeaders(), getPlayerRequest.getQueryParameters(),
            getPlayerRequest.getRestParameters()))
        .thenReturn("{}");
    assertNotNull(createClient().getPlayer(getPlayerRequest));
  }

  @Test
  void getPlayerUpcomingChests_whenWithRequest_thenGetResponse() throws Exception {
    GetPlayerUpcomingChestsRequest
        getPlayerUpcomingChestsRequest =
        GetPlayerUpcomingChestsRequest.builder(PLAYER_TAG).build();
    when(crawler
        .get("lala/players/%s/upcomingchests", createHeaders(), getPlayerUpcomingChestsRequest.getQueryParameters(),
            getPlayerUpcomingChestsRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getPlayerUpcomingChests(getPlayerUpcomingChestsRequest));
  }

  @Test
  void getPlayerBattleLog_whenWithRequest_thenGetResponse() throws Exception {
    GetPlayerBattleLogRequest
        getPlayerBattleLogRequest =
        GetPlayerBattleLogRequest.builder(PLAYER_TAG).build();
    when(crawler
        .get("lala/players/%s/battlelog", createHeaders(), getPlayerBattleLogRequest.getQueryParameters(),
            getPlayerBattleLogRequest.getRestParameters())).thenReturn("[{}]");
    assertNotNull(createClient().getPlayerBattleLog(getPlayerBattleLogRequest));
  }

  @Test
  void getTournaments_whenWithRequest_thenGetResponse() throws Exception {
    GetTournamentsRequest getTournamentsRequest = GetTournamentsRequest.builder().build();
    when(crawler.get("lala/tournaments", createHeaders(), getTournamentsRequest.getQueryParameters(),
        getTournamentsRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getTournaments(getTournamentsRequest));
  }

  @Test
  void getTournament_whenWithRequest_thenGetResponse() throws Exception {
    GetTournamentRequest getTournamentRequest = GetTournamentRequest.builder("tournamentTag").build();
    when(crawler.get("lala/tournaments/%s", createHeaders(), getTournamentRequest.getQueryParameters(),
        getTournamentRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getTournament(getTournamentRequest));
  }

  @Test
  void getLastRawResponse_whenCalled_thenReturnLastRawResponse() throws Exception {
    RawResponse rawResponse = new RawResponse();
    when(crawler.getLastRawResponse()).thenReturn(rawResponse);
    assertEquals(rawResponse, createClient().getLastRawResponse());
  }

  @Test
  void getTournament_whenWithCallback_thenCallOnResponse() throws Exception {
    AtomicBoolean state = new AtomicBoolean(false);
    GetTournamentRequest
        getTournamentRequest =
        GetTournamentRequest.builder("tournamentTag").callback(new Callback<GetTournamentResponse>() {
          @Override
          public void onResponse(GetTournamentResponse getTournamentResponse) {
            assertNotNull(getTournamentResponse);
            state.set(true);
          }

          @Override
          public void onException(Exception exception) {
            fail();
          }
        }).build();
    when(crawler.get("lala/tournaments/%s", createHeaders(), getTournamentRequest.getQueryParameters(),
        getTournamentRequest.getRestParameters())).thenReturn("{}");
    createClient().getTournament(getTournamentRequest);
    waitUntil(state::get);
    assertTrue(state.get(), "callback not notified!");
  }

  private static void waitUntil(Action action) {
    long stop = System.currentTimeMillis() + 5000L;
    for (long ms = System.currentTimeMillis(); ms < stop; ms = System.currentTimeMillis()) {
      if (action.eval()) {
        break;
      }
    }
  }

  private interface Action {

    boolean eval();

  }

  @Test
  void getTournament_whenWithCallbackException_thenCallOnException() throws Exception {
    AtomicBoolean state = new AtomicBoolean(false);
    GetTournamentRequest
        getTournamentRequest =
        GetTournamentRequest.builder("tournamentTag").callback(new Callback<GetTournamentResponse>() {
          @Override
          public void onResponse(GetTournamentResponse getTournamentResponse) {
            fail();
          }

          @Override
          public void onException(Exception exception) {
            state.set(true);
          }
        }).build();
    when(crawler.get("lala/tournaments/%s", createHeaders(), getTournamentRequest.getQueryParameters(),
        getTournamentRequest.getRestParameters())).thenThrow(new IOException());
    createClient().getTournament(getTournamentRequest);
    waitUntil(state::get);
    assertTrue(state.get(), "callback not notified!");
  }

  @Test
  void getCards_whenCalled_thenGetResponse() throws Exception {
    when(crawler.get("lala/cards", createHeaders(), emptyMap(), emptyList())).thenReturn("{}");
    assertNotNull(createClient().getCards(new BlankRequest<>()));
  }

  @Test
  void getLocations_whenWithRequest_thenGetResponse() throws Exception {
    GetLocationsRequest getLocationsRequest = GetLocationsRequest.builder().build();
    when(crawler.get("lala/locations", createHeaders(), getLocationsRequest.getQueryParameters(),
        getLocationsRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getLocations(getLocationsRequest));
  }

  @Test
  void getLocation_whenWithRequest_thenGetResponse() throws Exception {
    GetLocationRequest getLocationRequest = GetLocationRequest.builder(LOCATION_ID).build();
    when(crawler.get("lala/locations/%s", createHeaders(), getLocationRequest.getQueryParameters(),
        getLocationRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getLocation(getLocationRequest));
  }

  @Test
  void getLocationClanRankings_whenWithRequest_thenGetResponse() throws Exception {
    GetLocationClanRankingsRequest
        getLocationClanRankingsRequest =
        GetLocationClanRankingsRequest.builder(LOCATION_ID).build();
    when(crawler
        .get("lala/locations/%s/rankings/clans", createHeaders(), getLocationClanRankingsRequest.getQueryParameters(),
            getLocationClanRankingsRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getLocationClanRankings(getLocationClanRankingsRequest));
  }

  @Test
  void getLocationPlayerRankings_whenWithRequest_thenGetResponse() throws Exception {
    GetLocationPlayerRankingsRequest
        getLocationPlayerRankingsRequest =
        GetLocationPlayerRankingsRequest.builder(LOCATION_ID).build();
    when(crawler
        .get("lala/locations/%s/rankings/players", createHeaders(),
            getLocationPlayerRankingsRequest.getQueryParameters(),
            getLocationPlayerRankingsRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getLocationPlayerRankings(getLocationPlayerRankingsRequest));
  }

  @Test
  void getLocationClanWarRankings_whenWithRequest_thenGetResponse() throws Exception {
    GetLocationClanWarRankingsRequest
        getLocationClanWarRankingsRequest =
        GetLocationClanWarRankingsRequest.builder(LOCATION_ID).build();
    when(crawler
        .get("lala/locations/%s/rankings/clanwars", createHeaders(),
            getLocationClanWarRankingsRequest.getQueryParameters(),
            getLocationClanWarRankingsRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getLocationClanWarRankings(getLocationClanWarRankingsRequest));
  }

  @Test
  void getClanRiverRaceLog_whenWithRequest_thenGetResponse() throws Exception {
    GetClanRiverRaceLogRequest
        getClanRiverRaceLogRequest =
        GetClanRiverRaceLogRequest.builder(CLAN_TAG).build();
    when(crawler
        .get("lala/clans/%s/riverracelog", createHeaders(),
            getClanRiverRaceLogRequest.getQueryParameters(),
            getClanRiverRaceLogRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getClanRiverRaceLog(getClanRiverRaceLogRequest));
  }

  @Test
  void getCurrentClanRiverRace_whenWithRequest_thenGetResponse() throws Exception {
    GetCurrentClanRiverRaceRequest
        getCurrentClanRiverRaceRequest =
        GetCurrentClanRiverRaceRequest.builder(CLAN_TAG).build();
    when(crawler
        .get("lala/clans/%s/currentriverrace", createHeaders(),
            getCurrentClanRiverRaceRequest.getQueryParameters(),
            getCurrentClanRiverRaceRequest.getRestParameters())).thenReturn("{}");
    assertNotNull(createClient().getCurrentClanRiverRace(getCurrentClanRiverRaceRequest));
  }

}