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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jcrapi2.IntegrationTestBase;

public class LocationApiImplIntegrationTest extends IntegrationTestBase {

  private LocationApi unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = getJCrApi().getApi(LocationApi.class);
  }

  @Test
  void findAll() throws Exception {
    jcrapi2.api.intern.locations.LocationsRequest.LocationsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.LocationsRequest.builder();
    jcrapi2.api.intern.locations.LocationsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/locations", "", "src/test/resources/location-findAll.json", request);
    jcrapi2.api.intern.locations.LocationsResponse
        expected =
        toJson(jcrapi2.api.intern.locations.LocationsResponse.class, getExpected());

    run(expected, () -> unitUnderTest.findAll(request).get());
  }

  @Test
  void findAll_whenWithException() {
    jcrapi2.api.intern.locations.LocationsRequest.LocationsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.LocationsRequest.builder();
    jcrapi2.api.intern.locations.LocationsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/locations", "", request, () -> unitUnderTest.findAll(request).get());
  }

  @Test
  void findById() throws Exception {
    long locationId = 4711L;
    jcrapi2.api.intern.locations.info.LocationRequest.LocationRequestBuilder
        builder =
        jcrapi2.api.intern.locations.info.LocationRequest.builder(locationId);
    jcrapi2.api.intern.locations.info.LocationRequest request = builder

        .storeRawResponse(true)
        .build();
    prepare("/locations/{locationId}".replace("{locationId}", String.valueOf(locationId)), "",
        "src/test/resources/location-findById.json", request);
    jcrapi2.api.intern.locations.info.LocationResponse
        expected =
        toJson(jcrapi2.api.intern.locations.info.LocationResponse.class, getExpected());

    run(expected, () -> unitUnderTest.findById(request).get());
  }

  @Test
  void findById_whenWithException() {
    long locationId = 4711L;
    jcrapi2.api.intern.locations.info.LocationRequest.LocationRequestBuilder
        builder =
        jcrapi2.api.intern.locations.info.LocationRequest.builder(locationId);
    jcrapi2.api.intern.locations.info.LocationRequest request = builder

        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/locations/{locationId}".replace("{locationId}", String.valueOf(locationId)), "", request,
        () -> unitUnderTest.findById(request).get());
  }

  @Test
  void getClanRankings() throws Exception {
    long locationId = 4711L;
    jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest.ClanRankingsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest.builder(locationId);
    jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/locations/{locationId}/rankings/clans".replace("{locationId}", String.valueOf(locationId)), "",
        "src/test/resources/location-getClanRankings.json", request);
    jcrapi2.api.intern.locations.rankings.clan.ClanRankingsResponse
        expected =
        toJson(jcrapi2.api.intern.locations.rankings.clan.ClanRankingsResponse.class, getExpected());

    run(expected, () -> unitUnderTest.getClanRankings(request).get());
  }

  @Test
  void getClanRankings_whenWithException() {
    long locationId = 4711L;
    jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest.ClanRankingsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest.builder(locationId);
    jcrapi2.api.intern.locations.rankings.clan.ClanRankingsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/locations/{locationId}/rankings/clans".replace("{locationId}", String.valueOf(locationId)),
        "", request, () -> unitUnderTest.getClanRankings(request).get());
  }

  @Test
  void getPlayerRankings() throws Exception {
    long locationId = 4711L;
    jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest.PlayerRankingsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest.builder(locationId);
    jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/locations/{locationId}/rankings/players".replace("{locationId}", String.valueOf(locationId)), "",
        "src/test/resources/location-getPlayerRankings.json", request);
    jcrapi2.api.intern.locations.rankings.player.PlayerRankingsResponse
        expected =
        toJson(jcrapi2.api.intern.locations.rankings.player.PlayerRankingsResponse.class, getExpected());

    run(expected, () -> unitUnderTest.getPlayerRankings(request).get());
  }

  @Test
  void getPlayerRankings_whenWithException() {
    long locationId = 4711L;
    jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest.PlayerRankingsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest.builder(locationId);
    jcrapi2.api.intern.locations.rankings.player.PlayerRankingsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun(
        "/locations/{locationId}/rankings/players".replace("{locationId}", String.valueOf(locationId)), "", request,
        () -> unitUnderTest.getPlayerRankings(request).get());
  }

  @Test
  void getClanWarRankings() throws Exception {
    long locationId = 4711L;
    jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest.ClanWarRankingsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest.builder(locationId);
    jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/locations/{locationId}/rankings/clanwars".replace("{locationId}", String.valueOf(locationId)), "",
        "src/test/resources/location-getClanWarRankings.json", request);
    jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsResponse
        expected =
        toJson(jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsResponse.class, getExpected());

    run(expected, () -> unitUnderTest.getClanWarRankings(request).get());
  }

  @Test
  void getClanWarRankings_whenWithException() {
    long locationId = 4711L;
    jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest.ClanWarRankingsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest.builder(locationId);
    jcrapi2.api.intern.locations.rankings.clanwar.ClanWarRankingsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun(
        "/locations/{locationId}/rankings/clanwars".replace("{locationId}", String.valueOf(locationId)), "", request,
        () -> unitUnderTest.getClanWarRankings(request).get());
  }

  @Test
  void getTopPlayerLeagueSeasons() throws Exception {
    jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest.TopPlayerLeagueSeasonsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest.builder();
    jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/locations/global/seasons", "", "src/test/resources/location-getTopPlayerLeagueSeasons.json", request);
    jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsResponse
        expected =
        toJson(jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsResponse.class, getExpected());

    run(expected, () -> unitUnderTest.getTopPlayerLeagueSeasons(request).get());
  }

  @Test
  void getTopPlayerLeagueSeasons_whenWithException() {
    jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest.TopPlayerLeagueSeasonsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest.builder();
    jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/locations/global/seasons", "", request,
        () -> unitUnderTest.getTopPlayerLeagueSeasons(request).get());
  }

  @Test
  void getTopPlayerLeagueSeason() throws Exception {
    String seasonId = "seasonId";
    jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest.TopPlayerLeagueSeasonRequestBuilder
        builder =
        jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest.builder(seasonId);
    jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest request = builder

        .storeRawResponse(true)
        .build();
    prepare("/locations/global/seasons/{seasonId}".replace("{seasonId}", String.valueOf(seasonId)), "",
        "src/test/resources/location-getTopPlayerLeagueSeason.json", request);
    jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonResponse
        expected =
        toJson(jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonResponse.class, getExpected());

    run(expected, () -> unitUnderTest.getTopPlayerLeagueSeason(request).get());
  }

  @Test
  void getTopPlayerLeagueSeason_whenWithException() {
    String seasonId = "seasonId";
    jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest.TopPlayerLeagueSeasonRequestBuilder
        builder =
        jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest.builder(seasonId);
    jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest request = builder

        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/locations/global/seasons/{seasonId}".replace("{seasonId}", String.valueOf(seasonId)), "",
        request, () -> unitUnderTest.getTopPlayerLeagueSeason(request).get());
  }

  @Test
  void getTopPlayerLeagueSeasonRankings() throws Exception {
    String seasonId = "seasonId";
    jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest.TopPlayerLeagueSeasonRankingsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest.builder(seasonId);
    jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/locations/global/seasons/{seasonId}/rankings/players".replace("{seasonId}", String.valueOf(seasonId)), "",
        "src/test/resources/location-getTopPlayerLeagueSeasonRankings.json", request);
    jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsResponse
        expected =
        toJson(jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsResponse.class,
            getExpected());

    run(expected, () -> unitUnderTest.getTopPlayerLeagueSeasonRankings(request).get());
  }

  @Test
  void getTopPlayerLeagueSeasonRankings_whenWithException() {
    String seasonId = "seasonId";
    jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest.TopPlayerLeagueSeasonRankingsRequestBuilder
        builder =
        jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest.builder(seasonId);
    jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun(
        "/locations/global/seasons/{seasonId}/rankings/players".replace("{seasonId}", String.valueOf(seasonId)), "",
        request, () -> unitUnderTest.getTopPlayerLeagueSeasonRankings(request).get());
  }

}