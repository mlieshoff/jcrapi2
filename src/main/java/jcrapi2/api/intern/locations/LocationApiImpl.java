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
import jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Request;
import jcrapi2.api.intern.locations.seasons.global.TopPlayerLeagueSeasonsV2Response;
import jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonRequest;
import jcrapi2.api.intern.locations.seasons.global.info.TopPlayerLeagueSeasonResponse;
import jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsRequest;
import jcrapi2.api.intern.locations.seasons.global.rankings.TopPlayerLeagueSeasonRankingsResponse;
import jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.TopPlayerPathOfLegendSeasonRankingsRequest;
import jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.TopPlayerPathOfLegendSeasonRankingsResponse;
import jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player.TopPlayerPathOfLegendRankingsRequest;
import jcrapi2.api.intern.locations.seasons.global.rankings.pathoflegend.player.TopPlayerPathOfLegendRankingsResponse;
import jcrapi2.api.intern.locations.seasons.global.rankings.tournament.TopPlayerTournamentRankingsRequest;
import jcrapi2.api.intern.locations.seasons.global.rankings.tournament.TopPlayerTournamentRankingsResponse;

import supercell.api.wrapper.essentials.api.ApiContext;
import supercell.api.wrapper.essentials.api.BaseApi;

import java.util.concurrent.Future;

class LocationApiImpl extends BaseApi implements LocationApi {

    LocationApiImpl(ApiContext apiContext) {
        super(apiContext);
    }

    @Override
    public Future<LocationsResponse> findAll(LocationsRequest locationsRequest) {
        return get("/locations", locationsRequest, LocationsResponse.class);
    }

    public Future<LocationResponse> findById(LocationRequest locationRequest) {
        return get("/locations/{locationId}", locationRequest, LocationResponse.class);
    }

    public Future<ClanRankingsResponse> getClanRankings(ClanRankingsRequest clanRankingsRequest) {
        return get(
                "/locations/{locationId}/rankings/clans",
                clanRankingsRequest,
                ClanRankingsResponse.class);
    }

    public Future<PlayerRankingsResponse> getPlayerRankings(
            PlayerRankingsRequest playerRankingsRequest) {
        return get(
                "/locations/{locationId}/rankings/players",
                playerRankingsRequest,
                PlayerRankingsResponse.class);
    }

    public Future<ClanWarRankingsResponse> getClanWarRankings(
            ClanWarRankingsRequest clanWarRankingsRequest) {
        return get(
                "/locations/{locationId}/rankings/clanwars",
                clanWarRankingsRequest,
                ClanWarRankingsResponse.class);
    }

    public Future<TopPlayerLeagueSeasonsResponse> getTopPlayerLeagueSeasons(
            TopPlayerLeagueSeasonsRequest topPlayerLeagueSeasonsRequest) {
        return get(
                "/locations/global/seasons",
                topPlayerLeagueSeasonsRequest,
                TopPlayerLeagueSeasonsResponse.class);
    }

    public Future<TopPlayerLeagueSeasonResponse> getTopPlayerLeagueSeason(
            TopPlayerLeagueSeasonRequest topPlayerLeagueSeasonRequest) {
        return get(
                "/locations/global/seasons/{seasonId}",
                topPlayerLeagueSeasonRequest,
                TopPlayerLeagueSeasonResponse.class);
    }

    public Future<TopPlayerLeagueSeasonRankingsResponse> getTopPlayerLeagueSeasonRankings(
            TopPlayerLeagueSeasonRankingsRequest topPlayerLeagueSeasonRankingsRequest) {
        return get(
                "/locations/global/seasons/{seasonId}/rankings/players",
                topPlayerLeagueSeasonRankingsRequest,
                TopPlayerLeagueSeasonRankingsResponse.class);
    }

    public Future<TopPlayerPathOfLegendSeasonRankingsResponse>
            getTopPlayerPathOfLegendSeasonRankings(
                    TopPlayerPathOfLegendSeasonRankingsRequest
                            topPlayerPathOfLegendSeasonRankingsRequest) {
        return get(
                "/locations/global/pathoflegend/{seasonId}/rankings/players",
                topPlayerPathOfLegendSeasonRankingsRequest,
                TopPlayerPathOfLegendSeasonRankingsResponse.class);
    }

    public Future<TopPlayerPathOfLegendRankingsResponse> getTopPlayerPathOfLegendRankings(
            TopPlayerPathOfLegendRankingsRequest topPlayerPathOfLegendRankingsRequest) {
        return get(
                "/locations/{locationId}/pathoflegend/players",
                topPlayerPathOfLegendRankingsRequest,
                TopPlayerPathOfLegendRankingsResponse.class);
    }

    public Future<TopPlayerTournamentRankingsResponse> getTopPlayerTournamentRankings(
            TopPlayerTournamentRankingsRequest topPlayerTournamentRankingsRequest) {
        return get(
                "/locations/global/rankings/tournaments/{tournamentTag}",
                topPlayerTournamentRankingsRequest,
                TopPlayerTournamentRankingsResponse.class);
    }

    public Future<TopPlayerLeagueSeasonsV2Response> getTopPlayerLeagueSeasonsV2(
            TopPlayerLeagueSeasonsV2Request topPlayerLeagueSeasonsV2Request) {
        return get(
                "/locations/global/seasonsV2",
                topPlayerLeagueSeasonsV2Request,
                TopPlayerLeagueSeasonsV2Response.class);
    }
}
