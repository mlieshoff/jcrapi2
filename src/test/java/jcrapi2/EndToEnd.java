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

import static org.junit.jupiter.api.Assertions.assertEquals;

import static wiremock.org.apache.commons.lang3.StringUtils.EMPTY;

import static java.lang.System.getProperty;
import static java.lang.System.getenv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jcrapi2.api.intern.cards.CardApi;
import jcrapi2.api.intern.cards.CardsRequest;
import jcrapi2.api.intern.cards.CardsResponse;
import jcrapi2.api.intern.challenges.ChallengeApi;
import jcrapi2.api.intern.challenges.ChallengesRequest;
import jcrapi2.api.intern.challenges.ChallengesResponse;
import jcrapi2.api.intern.clans.ClanApi;
import jcrapi2.api.intern.clans.ClansRequest;
import jcrapi2.api.intern.clans.ClansResponse;
import jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest;
import jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceResponse;
import jcrapi2.api.intern.clans.info.ClanRequest;
import jcrapi2.api.intern.clans.info.ClanResponse;
import jcrapi2.api.intern.clans.members.ClanMembersRequest;
import jcrapi2.api.intern.clans.members.ClanMembersResponse;
import jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest;
import jcrapi2.api.intern.clans.riverracelog.RiverRaceLogResponse;
import jcrapi2.api.intern.globaltournaments.GlobalTournamentApi;
import jcrapi2.api.intern.globaltournaments.GlobalTournamentsRequest;
import jcrapi2.api.intern.globaltournaments.GlobalTournamentsResponse;
import jcrapi2.api.intern.locations.LocationApi;
import jcrapi2.api.intern.locations.LocationsRequest;
import jcrapi2.api.intern.locations.LocationsResponse;
import jcrapi2.api.intern.locations.info.LocationRequest;
import jcrapi2.api.intern.locations.info.LocationResponse;
import jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest;
import jcrapi2.api.intern.locations.rankings.clan.ClanRankingsResponse;
import jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest;
import jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsResponse;
import jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest;
import jcrapi2.api.intern.locations.rankings.player.PlayerRankingsResponse;
import jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest;
import jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsResponse;
import jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest;
import jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonResponse;
import jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest;
import jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsResponse;
import jcrapi2.api.intern.players.PlayerApi;
import jcrapi2.api.intern.players.battlelog.BattleLogRequest;
import jcrapi2.api.intern.players.battlelog.BattleLogResponse;
import jcrapi2.api.intern.players.info.PlayerRequest;
import jcrapi2.api.intern.players.info.PlayerResponse;
import jcrapi2.api.intern.players.upcomingchests.UpcomingChestsRequest;
import jcrapi2.api.intern.players.upcomingchests.UpcomingChestsResponse;
import jcrapi2.api.intern.tournaments.TournamentApi;
import jcrapi2.api.intern.tournaments.TournamentsRequest;
import jcrapi2.api.intern.tournaments.TournamentsResponse;
import jcrapi2.api.intern.tournaments.info.TournamentRequest;
import jcrapi2.api.intern.tournaments.info.TournamentResponse;
import jcrapi2.connector.StandardConnector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonPatch;
import javax.json.JsonValue;

public class EndToEnd {

    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    private static final String CLAN_TAG = "#RP88QQG";
    private static final String PLAYER_TAG = "#2PGGCJJL";
    private static final String TOURNAMENT_NAME = "de";
    private static final String TOURNAMENT_TAG = "#U2QQQL2";
    private static final String SEASON_ID = "2022-04";

    private static final long LOCATION_ID = 57000256L;

    private ClanApi clanApi;

    private PlayerApi playerApi;

    private CardApi cardApi;

    private TournamentApi tournamentApi;

    private LocationApi locationApi;

    private ChallengeApi challengeApi;

    private GlobalTournamentApi globalTournamentApi;

    @BeforeEach
    void setUp() {
        JCrApi jCrApi =
                new JCrApi(
                        "https://proxy.royaleapi.dev/v1",
                        getProperty("apiKey", getenv("API_KEY")),
                        new StandardConnector());
        clanApi = jCrApi.getApi(ClanApi.class);
        playerApi = jCrApi.getApi(PlayerApi.class);
        cardApi = jCrApi.getApi(CardApi.class);
        tournamentApi = jCrApi.getApi(TournamentApi.class);
        locationApi = jCrApi.getApi(LocationApi.class);
        challengeApi = jCrApi.getApi(ChallengeApi.class);
        globalTournamentApi = jCrApi.getApi(GlobalTournamentApi.class);
    }

    private static void assertDiff(String expected, String actual) {
        JsonValue source = Json.createReader(new StringReader(actual)).readValue();
        JsonValue target = Json.createReader(new StringReader(expected)).readValue();
        JsonPatch diff;
        try {
            diff = Json.createDiff(source.asJsonObject(), target.asJsonObject());
        } catch (ClassCastException e) {
            diff = Json.createDiff(source.asJsonArray(), target.asJsonArray());
        }
        StringBuilder diffOutput = new StringBuilder();
        diff.toJsonArray().forEach(entry -> diffOutput.append(entry).append('\n'));
        assertEquals(EMPTY, diffOutput.toString());
    }

    @Test
    void clans_findAll() throws Exception {
        ClansResponse clansResponse =
                clanApi.findAll(
                                ClansRequest.builder()
                                        .name("puz")
                                        .locationId(57000120)
                                        .minMembers(5)
                                        .maxMembers(20)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(clansResponse);
        String expected = clansResponse.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void clans_findByTag() throws Exception {
        ClanResponse response =
                clanApi.findByTag(ClanRequest.builder(CLAN_TAG).storeRawResponse(true).build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void clans_getRiverRaceLog() throws Exception {
        RiverRaceLogResponse response =
                clanApi.getRiverRaceLog(
                                RiverRaceLogRequest.builder(CLAN_TAG)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void clans_getMembers() throws Exception {
        ClanMembersResponse response =
                clanApi.getMembers(
                                ClanMembersRequest.builder(CLAN_TAG).storeRawResponse(true).build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void clans_getCurrentRiverRaceLog() throws Exception {
        CurrentRiverRaceResponse response =
                clanApi.getCurrentRiverRace(
                                CurrentRiverRaceRequest.builder(CLAN_TAG)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void players_findByTag() throws Exception {
        PlayerResponse response =
                playerApi
                        .findByTag(PlayerRequest.builder(PLAYER_TAG).storeRawResponse(true).build())
                        .get();
        String actual =
                GSON.toJson(response)
                        .replace(",\"starLevel\":0", "")
                        .replace(",\"target\":0", "")
                        .replace(",\"bestTrophies\":0", "");
        String expected =
                response.getRawResponse()
                        .getRaw()
                        .replace(",\"completionInfo\":null", "")
                        .replace(",\"rank\":null", "");

        assertDiff(expected, actual);
    }

    @Test
    void players_getUpcomingChests() throws Exception {
        UpcomingChestsResponse response =
                playerApi
                        .getUpcomingChests(
                                UpcomingChestsRequest.builder(PLAYER_TAG)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void players_getBattleLog() throws Exception {
        BattleLogResponse response =
                playerApi
                        .getBattleLog(
                                BattleLogRequest.builder(PLAYER_TAG).storeRawResponse(true).build())
                        .get();

        String actual =
                GSON.toJson(response)
                        .replace(",\"startingTrophies\":0", "")
                        .replace(",\"crowns\":0", "")
                        .replace(",\"trophyChange\":0", "")
                        .replace(",\"kingTowerHitPoints\":0", "")
                        .replace(",\"boatBattleWon\":false", "")
                        .replace(",\"newTowersDestroyed\":0", "")
                        .replace(",\"prevTowersDestroyed\":0", "")
                        .replace(",\"prevTowersDestroyedprevTowersDestroyed\":0", "")
                        .replace(",\"remainingTowers\":0", "")
                        .replace(",\"starLevel\":0", "")
                        .replace(",\"elixirLeaked\":0.0,", ",")
                        .replace(",\"challengeId\":0", "")
                        .replace(",\"challengeWinCountBefore\":0", "")
                        .replace(",\"globalRank\":null", "");
        String expected =
                response.getRawResponse()
                        .getRaw()
                        .replace(",\"crowns\":0", "")
                        .replace(",\"boatBattleWon\":false", "")
                        .replace(",\"remainingTowers\":0", "")
                        .replace(",\"prevTowersDestroyed\":0", "")
                        .replace(",\"newTowersDestroyed\":0", "")
                        .replace(",\"kingTowerHitPoints\":0", "")
                        .replace(",\"princessTowersHitPoints\":null", "")
                        .replace(",\"elixirLeaked\":0.0,", ",")
                        .replace("\"name\":null,", "")
                        .replace(",\"challengeWinCountBefore\":0", "")
                        .replace(",\"maxEvolutionLevel\":null", "")
                        .replace(",\"globalRank\":null", "");

        assertDiff(expected, actual);
    }

    @Test
    void cards_findAll() throws Exception {
        CardsResponse response =
                cardApi.findAll(CardsRequest.builder().storeRawResponse(true).build()).get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void tournaments_findAll() throws Exception {
        TournamentsResponse response =
                tournamentApi
                        .findAll(
                                TournamentsRequest.builder()
                                        .name(TOURNAMENT_NAME)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void tournaments_findByTag() throws Exception {
        TournamentResponse response =
                tournamentApi
                        .findByTag(
                                TournamentRequest.builder(TOURNAMENT_TAG)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void locations_findAll() throws Exception {
        LocationsResponse response =
                locationApi
                        .findAll(LocationsRequest.builder().storeRawResponse(true).build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void locations_findById() throws Exception {
        LocationResponse response =
                locationApi
                        .findById(
                                LocationRequest.builder(LOCATION_ID).storeRawResponse(true).build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void locations_getClanRankings() throws Exception {
        ClanRankingsResponse response =
                locationApi
                        .getClanRankings(
                                ClanRankingsRequest.builder(LOCATION_ID)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void locations_getPlayerRankings() throws Exception {
        PlayerRankingsResponse response =
                locationApi
                        .getPlayerRankings(
                                PlayerRankingsRequest.builder(LOCATION_ID)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void locations_getClanWarRankings() throws Exception {
        ClanWarRankingsResponse response =
                locationApi
                        .getClanWarRankings(
                                ClanWarRankingsRequest.builder(LOCATION_ID)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void locations_getTopPlayerLeagueSeasons() throws Exception {
        TopPlayerLeagueSeasonsResponse response =
                locationApi
                        .getTopPlayerLeagueSeasons(
                                TopPlayerLeagueSeasonsRequest.builder()
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void locations_getTopPlayerLeagueSeason() throws Exception {
        TopPlayerLeagueSeasonResponse response =
                locationApi
                        .getTopPlayerLeagueSeason(
                                TopPlayerLeagueSeasonRequest.builder(SEASON_ID)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void locations_getTopPlayerLeagueSeasonRankings() throws Exception {
        TopPlayerLeagueSeasonRankingsResponse response =
                locationApi
                        .getTopPlayerLeagueSeasonRankings(
                                TopPlayerLeagueSeasonRankingsRequest.builder(SEASON_ID)
                                        .storeRawResponse(true)
                                        .build())
                        .get();
        String actual = GSON.toJson(response);
        String expected = response.getRawResponse().getRaw();

        assertDiff(expected, actual);
    }

    @Test
    void challenges_findAll() throws Exception {
        ChallengesResponse response =
                challengeApi
                        .findAll(ChallengesRequest.builder().storeRawResponse(true).build())
                        .get();
        String actual =
                GSON.toJson(response)
                        .replace(",\"amount\":0", "")
                        .replace(",{\"amount\":0}", "")
                        .replace(",{\"type\":null}", "")
                        .replace(",\"type\":null", "");
        String expected =
                response.getRawResponse()
                        .getRaw()
                        .replace(",{\"type\":null}", "")
                        .replace("\"name\":null,", "");

        assertDiff(expected, actual);
    }

    @Test
    void globalTournaments_findAll() throws Exception {
        GlobalTournamentsResponse response =
                globalTournamentApi
                        .findAll(GlobalTournamentsRequest.builder().storeRawResponse(true).build())
                        .get();
        String actual = GSON.toJson(response).replace(",\"amount\":0", "");
        String expected =
                response.getRawResponse()
                        .getRaw()
                        .replace(",\"type\":null", "")
                        .replace("\"name\":null,", "");

        assertDiff(expected, actual);
    }
}
