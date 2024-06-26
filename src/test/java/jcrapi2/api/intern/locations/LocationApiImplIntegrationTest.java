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
package jcrapi2.api.intern.locations;

import jcrapi2.IntegrationTestBase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationApiImplIntegrationTest extends IntegrationTestBase {

    private LocationApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(LocationApi.class);
    }

    @Test
    void findAll() throws Exception {
        jcrapi2.api.intern.locations.LocationsRequest.LocationsRequestBuilder builder =
                jcrapi2.api.intern.locations.LocationsRequest.builder();
        jcrapi2.api.intern.locations.LocationsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare("/locations", EMPTY, "src/test/resources/location-findAll.json", request);

        jcrapi2.api.intern.locations.LocationsResponse expected =
                toJson(jcrapi2.api.intern.locations.LocationsResponse.class, getExpected());

        run(expected, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findAll_whenWithException() {
        jcrapi2.api.intern.locations.LocationsRequest.LocationsRequestBuilder builder =
                jcrapi2.api.intern.locations.LocationsRequest.builder();
        jcrapi2.api.intern.locations.LocationsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/locations", EMPTY, request, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findById() throws Exception {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.info.LocationRequest.LocationRequestBuilder builder =
                jcrapi2.api.intern.locations.info.LocationRequest.builder(locationId);
        jcrapi2.api.intern.locations.info.LocationRequest request =
                builder.storeRawResponse(true).build();
        prepare(
                "/locations/{locationId}".replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                "src/test/resources/location-findById.json",
                request);
        jcrapi2.api.intern.locations.info.LocationResponse expected =
                toJson(jcrapi2.api.intern.locations.info.LocationResponse.class, getExpected());

        run(expected, () -> unitUnderTest.findById(request).get());
    }

    @Test
    void findById_whenWithException() {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.info.LocationRequest.LocationRequestBuilder builder =
                jcrapi2.api.intern.locations.info.LocationRequest.builder(locationId);
        jcrapi2.api.intern.locations.info.LocationRequest request =
                builder.storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/locations/{locationId}".replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                request,
                () -> unitUnderTest.findById(request).get());
    }

    @Test
    void getClanRankings() throws Exception {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest.ClanRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest.builder(
                                locationId);
        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/locations/{locationId}/rankings/clans"
                        .replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                "src/test/resources/location-getClanRankings.json",
                request);
        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsResponse expected =
                toJson(
                        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsResponse.class,
                        getExpected());

        run(expected, () -> unitUnderTest.getClanRankings(request).get());
    }

    @Test
    void getClanRankings_whenWithException() {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest.ClanRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest.builder(
                                locationId);
        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/locations/{locationId}/rankings/clans"
                        .replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                request,
                () -> unitUnderTest.getClanRankings(request).get());
    }

    @Test
    void getPlayerRankings() throws Exception {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest
                        .PlayerRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest.builder(
                                locationId);
        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/locations/{locationId}/rankings/players"
                        .replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                "src/test/resources/location-getPlayerRankings.json",
                request);
        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsResponse expected =
                toJson(
                        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsResponse.class,
                        getExpected());

        run(expected, () -> unitUnderTest.getPlayerRankings(request).get());
    }

    @Test
    void getPlayerRankings_whenWithException() {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest
                        .PlayerRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest.builder(
                                locationId);
        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/locations/{locationId}/rankings/players"
                        .replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                request,
                () -> unitUnderTest.getPlayerRankings(request).get());
    }

    @Test
    void getClanWarRankings() throws Exception {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest
                        .ClanWarRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest
                                .builder(locationId);
        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/locations/{locationId}/rankings/clanwars"
                        .replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                "src/test/resources/location-getClanWarRankings.json",
                request);
        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsResponse expected =
                toJson(
                        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsResponse.class,
                        getExpected());

        run(expected, () -> unitUnderTest.getClanWarRankings(request).get());
    }

    @Test
    void getClanWarRankings_whenWithException() {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest
                        .ClanWarRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest
                                .builder(locationId);
        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/locations/{locationId}/rankings/clanwars"
                        .replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                request,
                () -> unitUnderTest.getClanWarRankings(request).get());
    }

    @Test
    void getTopPlayerLeagueSeasons() throws Exception {
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest
                        .TopPlayerLeagueSeasonsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest
                                .builder();
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/locations/global/seasons",
                EMPTY,
                "src/test/resources/location-getTopPlayerLeagueSeasons.json",
                request);
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsResponse expected =
                toJson(
                        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsResponse
                                .class,
                        getExpected());

        run(expected, () -> unitUnderTest.getTopPlayerLeagueSeasons(request).get());
    }

    @Test
    void getTopPlayerLeagueSeasons_whenWithException() {
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest
                        .TopPlayerLeagueSeasonsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest
                                .builder();
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/locations/global/seasons",
                EMPTY,
                request,
                () -> unitUnderTest.getTopPlayerLeagueSeasons(request).get());
    }

    @Test
    void getTopPlayerLeagueSeason() throws Exception {
        String seasonId = "seasonId";
        jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest
                        .TopPlayerLeagueSeasonRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.info
                                .TopPlayerLeagueSeasonRequest.builder(seasonId);
        jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest request =
                builder.storeRawResponse(true).build();
        prepare(
                "/locations/global/seasons/{seasonId}".replace("{seasonId}", seasonId),
                EMPTY,
                "src/test/resources/location-getTopPlayerLeagueSeason.json",
                request);
        jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonResponse expected =
                toJson(
                        jcrapi2.api.intern.locations.seasons.global.info
                                .TopPlayerLeagueSeasonResponse.class,
                        getExpected());

        run(expected, () -> unitUnderTest.getTopPlayerLeagueSeason(request).get());
    }

    @Test
    void getTopPlayerLeagueSeason_whenWithException() {
        String seasonId = "seasonId";
        jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest
                        .TopPlayerLeagueSeasonRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.info
                                .TopPlayerLeagueSeasonRequest.builder(seasonId);
        jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest request =
                builder.storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/locations/global/seasons/{seasonId}".replace("{seasonId}", seasonId),
                EMPTY,
                request,
                () -> unitUnderTest.getTopPlayerLeagueSeason(request).get());
    }

    @Test
    void getTopPlayerLeagueSeasonRankings() throws Exception {
        String seasonId = "seasonId";
        jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest
                        .TopPlayerLeagueSeasonRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.rankings
                                .TopPlayerLeagueSeasonRankingsRequest.builder(seasonId);
        jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest
                request =
                        builder.limit(100)
                                .before("zzz")
                                .after("aaa")
                                .storeRawResponse(true)
                                .build();
        prepare(
                "/locations/global/seasons/{seasonId}/rankings/players"
                        .replace("{seasonId}", seasonId),
                EMPTY,
                "src/test/resources/location-getTopPlayerLeagueSeasonRankings.json",
                request);
        jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsResponse
                expected =
                        toJson(
                                jcrapi2.api.intern.locations.seasons.global.rankings
                                        .TopPlayerLeagueSeasonRankingsResponse.class,
                                getExpected());

        run(expected, () -> unitUnderTest.getTopPlayerLeagueSeasonRankings(request).get());
    }

    @Test
    void getTopPlayerLeagueSeasonRankings_whenWithException() {
        String seasonId = "seasonId";
        jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest
                        .TopPlayerLeagueSeasonRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.rankings
                                .TopPlayerLeagueSeasonRankingsRequest.builder(seasonId);
        jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest
                request =
                        builder.limit(100)
                                .before("zzz")
                                .after("aaa")
                                .storeRawResponse(true)
                                .build();

        prepareWithErrorAndRun(
                "/locations/global/seasons/{seasonId}/rankings/players"
                        .replace("{seasonId}", seasonId),
                EMPTY,
                request,
                () -> unitUnderTest.getTopPlayerLeagueSeasonRankings(request).get());
    }

    @Test
    void getTopPlayerPathOfLegendSeasonRankings() throws Exception {
        String seasonId = "seasonId";
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                        .TopPlayerPathOfLegendSeasonRankingsRequest
                        .TopPlayerPathOfLegendSeasonRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                                .TopPlayerPathOfLegendSeasonRankingsRequest.builder(seasonId);
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                        .TopPlayerPathOfLegendSeasonRankingsRequest
                request =
                        builder.limit(100)
                                .before("zzz")
                                .after("aaa")
                                .storeRawResponse(true)
                                .build();
        prepare(
                "/locations/global/pathoflegend/{seasonId}/rankings/players"
                        .replace("{seasonId}", seasonId),
                EMPTY,
                "src/test/resources/location-getTopPlayerPathOfLegendSeasonRankings.json",
                request);
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                        .TopPlayerPathOfLegendSeasonRankingsResponse
                expected =
                        toJson(
                                jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                                        .TopPlayerPathOfLegendSeasonRankingsResponse.class,
                                getExpected());

        run(expected, () -> unitUnderTest.getTopPlayerPathOfLegendSeasonRankings(request).get());
    }

    @Test
    void getTopPlayerPathOfLegendSeasonRankings_whenWithException() {
        String seasonId = "seasonId";
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                        .TopPlayerPathOfLegendSeasonRankingsRequest
                        .TopPlayerPathOfLegendSeasonRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                                .TopPlayerPathOfLegendSeasonRankingsRequest.builder(seasonId);
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                        .TopPlayerPathOfLegendSeasonRankingsRequest
                request =
                        builder.limit(100)
                                .before("zzz")
                                .after("aaa")
                                .storeRawResponse(true)
                                .build();

        prepareWithErrorAndRun(
                "/locations/global/pathoflegend/{seasonId}/rankings/players"
                        .replace("{seasonId}", seasonId),
                EMPTY,
                request,
                () -> unitUnderTest.getTopPlayerPathOfLegendSeasonRankings(request).get());
    }

    @Test
    void getTopPlayerPathOfLegendRankings() throws Exception {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player
                        .TopPlayerPathOfLegendRankingsRequest
                        .TopPlayerPathOfLegendRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player
                                .TopPlayerPathOfLegendRankingsRequest.builder(locationId);
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player
                        .TopPlayerPathOfLegendRankingsRequest
                request =
                        builder.limit(100)
                                .before("zzz")
                                .after("aaa")
                                .storeRawResponse(true)
                                .build();
        prepare(
                "/locations/{locationId}/pathoflegend/players"
                        .replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                "src/test/resources/location-getTopPlayerPathOfLegendRankings.json",
                request);
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player
                        .TopPlayerPathOfLegendRankingsResponse
                expected =
                        toJson(
                                jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend
                                        .player.TopPlayerPathOfLegendRankingsResponse.class,
                                getExpected());

        run(expected, () -> unitUnderTest.getTopPlayerPathOfLegendRankings(request).get());
    }

    @Test
    void getTopPlayerPathOfLegendRankings_whenWithException() {
        long locationId = 4711L;
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player
                        .TopPlayerPathOfLegendRankingsRequest
                        .TopPlayerPathOfLegendRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player
                                .TopPlayerPathOfLegendRankingsRequest.builder(locationId);
        jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player
                        .TopPlayerPathOfLegendRankingsRequest
                request =
                        builder.limit(100)
                                .before("zzz")
                                .after("aaa")
                                .storeRawResponse(true)
                                .build();

        prepareWithErrorAndRun(
                "/locations/{locationId}/pathoflegend/players"
                        .replace("{locationId}", String.valueOf(locationId)),
                EMPTY,
                request,
                () -> unitUnderTest.getTopPlayerPathOfLegendRankings(request).get());
    }

    @Test
    void getTopPlayerTournamentRankings() throws Exception {
        String tournamentTag = "tournamentTag";
        jcrapi2.api.intern.locations.seasons.global.rankings.tournament
                        .TopPlayerTournamentRankingsRequest
                        .TopPlayerTournamentRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.rankings.tournament
                                .TopPlayerTournamentRankingsRequest.builder(tournamentTag);
        jcrapi2.api.intern.locations.seasons.global.rankings.tournament
                        .TopPlayerTournamentRankingsRequest
                request =
                        builder.limit(100)
                                .before("zzz")
                                .after("aaa")
                                .storeRawResponse(true)
                                .build();
        prepare(
                "/locations/global/rankings/tournaments/{tournamentTag}"
                        .replace("{tournamentTag}", tournamentTag),
                EMPTY,
                "src/test/resources/location-getTopPlayerTournamentRankings.json",
                request);
        jcrapi2.api.intern.locations.seasons.global.rankings.tournament
                        .TopPlayerTournamentRankingsResponse
                expected =
                        toJson(
                                jcrapi2.api.intern.locations.seasons.global.rankings.tournament
                                        .TopPlayerTournamentRankingsResponse.class,
                                getExpected());

        run(expected, () -> unitUnderTest.getTopPlayerTournamentRankings(request).get());
    }

    @Test
    void getTopPlayerTournamentRankings_whenWithException() {
        String tournamentTag = "tournamentTag";
        jcrapi2.api.intern.locations.seasons.global.rankings.tournament
                        .TopPlayerTournamentRankingsRequest
                        .TopPlayerTournamentRankingsRequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.rankings.tournament
                                .TopPlayerTournamentRankingsRequest.builder(tournamentTag);
        jcrapi2.api.intern.locations.seasons.global.rankings.tournament
                        .TopPlayerTournamentRankingsRequest
                request =
                        builder.limit(100)
                                .before("zzz")
                                .after("aaa")
                                .storeRawResponse(true)
                                .build();

        prepareWithErrorAndRun(
                "/locations/global/rankings/tournaments/{tournamentTag}"
                        .replace("{tournamentTag}", tournamentTag),
                EMPTY,
                request,
                () -> unitUnderTest.getTopPlayerTournamentRankings(request).get());
    }

    @Test
    void getTopPlayerLeagueSeasonsV2() throws Exception {
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Request
                        .TopPlayerLeagueSeasonsV2RequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Request
                                .builder();
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Request request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/locations/global/seasonsV2",
                EMPTY,
                "src/test/resources/location-getTopPlayerLeagueSeasonsV2.json",
                request);
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Response expected =
                toJson(
                        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Response
                                .class,
                        getExpected());

        run(expected, () -> unitUnderTest.getTopPlayerLeagueSeasonsV2(request).get());
    }

    @Test
    void getTopPlayerLeagueSeasonsV2_whenWithException() {
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Request
                        .TopPlayerLeagueSeasonsV2RequestBuilder
                builder =
                        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Request
                                .builder();
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Request request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/locations/global/seasonsV2",
                EMPTY,
                request,
                () -> unitUnderTest.getTopPlayerLeagueSeasonsV2(request).get());
    }
}
