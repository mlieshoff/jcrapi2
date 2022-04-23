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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.util.concurrent.MoreExecutors.listeningDecorator;
import static java.lang.Thread.NORM_PRIORITY;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static jcrapi2.Preconditions.checkNotBlank;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.gson.Gson;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.io.IOException;
import java.util.Map;
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
import jcrapi2.request.Request;
import jcrapi2.response.GetCardsResponse;
import jcrapi2.response.GetClanCurrentWarResponse;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClanRiverRaceLogResponse;
import jcrapi2.response.GetClanWarLogResponse;
import jcrapi2.response.GetClansResponse;
import jcrapi2.response.GetCurrentClanRiverRaceResponse;
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
import jcrapi2.response.IResponse;
import jcrapi2.response.RawResponse;

/**
 * @author Michael Lieshoff
 */
public class Client {

  private static final ListeningExecutorService EXECUTOR_SERVICE = listeningDecorator(
      newFixedThreadPool(8, new BasicThreadFactory.Builder()
          .daemon(true)
          .namingPattern("jcrapi2.async")
          .priority(NORM_PRIORITY)
          .build())
  );

  private final String url;
  private final String apiKey;

  private final CrawlerFactory crawlerFactory;

  Client(String url, String apiKey, CrawlerFactory crawlerFactory) {
    checkNotBlank(url, "url");
    checkNotNull(crawlerFactory);
    this.url = url;
    this.apiKey = apiKey;
    this.crawlerFactory = crawlerFactory;
  }

  GetClansResponse getClans(GetClansRequest getClansRequest) throws IOException {
    return singleObjectFromJson("getClansRequest", "clans", getClansRequest, GetClansResponse.class);
  }

  private <T extends IResponse> T singleObjectFromJson(String nameOfRequest, String part, Request request,
                                                       Class<T> responseClass) throws IOException {
    checkNotNull(request, nameOfRequest);
    if (request.getCallback() == null) {
      return toJson(part, request, responseClass);
    } else {
      EXECUTOR_SERVICE.submit(() -> {
        try {
          request.getCallback().onResponse(toJson(part, request, responseClass));
        } catch (Exception e) {
          request.getCallback().onException(e);
        }
      });
      return null;
    }
  }

  private <T extends IResponse> T toJson(String part, Request request, Class<T> responseClass) throws IOException {
    String json = get(createUrl(part), request);
    return new Gson().fromJson(json, responseClass);
  }

  private String createUrl(String part) {
    return url + part;
  }

  private String get(String url, Request request) throws IOException {
    return createCrawler()
        .get(url, createAuthHeader(apiKey), request.getQueryParameters(), request.getRestParameters());
  }

  private Crawler createCrawler() {
    return crawlerFactory.createCrawler();
  }

  private static Map<String, String> createAuthHeader(String apiKey) {
    String headerValue = "Bearer " + apiKey;
    return ImmutableMap.<String, String>builder().put(AUTHORIZATION, headerValue).build();
  }

  GetClanResponse getClan(GetClanRequest getClanRequest) throws IOException {
    return singleObjectFromJson("getClanRequest", "clans/%s", getClanRequest,
        GetClanResponse.class);
  }

  GetClanMembersResponse getClanMembers(GetClanMembersRequest getClanMembersRequest) throws IOException {
    return singleObjectFromJson("getClanMembersRequest", "clans/%s/members", getClanMembersRequest,
        GetClanMembersResponse.class);
  }

  GetClanWarLogResponse getClanWarLog(GetClanWarLogRequest getClanWarLogRequest) throws IOException {
    return singleObjectFromJson("getClanWarLogRequest", "clans/%s/warlog", getClanWarLogRequest,
        GetClanWarLogResponse.class);
  }

  GetClanCurrentWarResponse getClanCurrentWar(GetClanCurrentWarRequest getClanCurrentWarRequest) throws IOException {
    return singleObjectFromJson("getClanCurrentWarRequest", "clans/%s/currentwar", getClanCurrentWarRequest,
        GetClanCurrentWarResponse.class);
  }

  GetPlayerResponse getPlayer(GetPlayerRequest getPlayerRequest) throws IOException {
    return singleObjectFromJson("getPlayerRequest", "players/%s", getPlayerRequest, GetPlayerResponse.class);
  }

  GetPlayerUpcomingChestsResponse getPlayerUpcomingChests(GetPlayerUpcomingChestsRequest getPlayerUpcomingChestsRequest)
      throws IOException {
    return singleObjectFromJson("getPlayerUpcomingChestsRequest", "players/%s/upcomingchests",
        getPlayerUpcomingChestsRequest, GetPlayerUpcomingChestsResponse.class);
  }

  GetPlayerBattleLogResponse getPlayerBattleLog(GetPlayerBattleLogRequest getPlayerBattleLogRequest)
      throws IOException {
    return singleObjectFromJson("getPlayerBattleLogRequest", "players/%s/battlelog",
        getPlayerBattleLogRequest, GetPlayerBattleLogResponse.class);
  }

  GetTournamentsResponse getTournaments(GetTournamentsRequest getTournamentsRequest)
      throws IOException {
    return singleObjectFromJson("getTournamentsRequest", "tournaments", getTournamentsRequest,
        GetTournamentsResponse.class);
  }

  GetTournamentResponse getTournament(GetTournamentRequest getTournamentRequest)
      throws IOException {
    return singleObjectFromJson("getTournamentRequest", "tournaments/%s", getTournamentRequest,
        GetTournamentResponse.class);
  }

  RawResponse getLastRawResponse() {
    return createCrawler().getLastRawResponse();
  }

  GetCardsResponse getCards(BlankRequest<GetCardsResponse> blankRequest) throws IOException {
    return singleObjectFromJson("getCardsRequest", "cards", blankRequest, GetCardsResponse.class);
  }

  GetLocationsResponse getLocations(GetLocationsRequest getLocationsRequest) throws IOException {
    return singleObjectFromJson("getLocationsRequest", "locations", getLocationsRequest, GetLocationsResponse.class);
  }

  GetLocationResponse getLocation(GetLocationRequest getLocationRequest) throws IOException {
    return singleObjectFromJson("getLocationRequest", "locations/%s", getLocationRequest, GetLocationResponse.class);
  }

  GetLocationClanRankingsResponse getLocationClanRankings(GetLocationClanRankingsRequest getLocationClanRankingsRequest)
      throws IOException {
    return singleObjectFromJson("getLocationClanRankingsRequest", "locations/%s/rankings/clans",
        getLocationClanRankingsRequest, GetLocationClanRankingsResponse.class);
  }

  GetLocationPlayerRankingsResponse getLocationPlayerRankings(
      GetLocationPlayerRankingsRequest getLocationPlayerRankingsRequest)
      throws IOException {
    return singleObjectFromJson("getLocationPlayerRankingsRequest", "locations/%s/rankings/players",
        getLocationPlayerRankingsRequest, GetLocationPlayerRankingsResponse.class);
  }

  GetLocationClanWarRankingsResponse getLocationClanWarRankings(
      GetLocationClanWarRankingsRequest getLocationClanWarRankingsRequest)
      throws IOException {
    return singleObjectFromJson("getLocationClanWarRankingsRequest", "locations/%s/rankings/clanwars",
        getLocationClanWarRankingsRequest, GetLocationClanWarRankingsResponse.class);
  }

  GetClanRiverRaceLogResponse getClanRiverRaceLog(GetClanRiverRaceLogRequest getClanRiverRaceLogRequest)
      throws IOException {
    return singleObjectFromJson("getClanRiverRaceLogRequest", "clans/%s/riverracelog", getClanRiverRaceLogRequest,
        GetClanRiverRaceLogResponse.class);
  }

  GetCurrentClanRiverRaceResponse getCurrentClanRiverRace(GetCurrentClanRiverRaceRequest getCurrentClanRiverRaceRequest)
      throws IOException {
    return singleObjectFromJson("getCurrentClanRiverRaceRequest", "clans/%s/currentriverrace",
        getCurrentClanRiverRaceRequest, GetCurrentClanRiverRaceResponse.class);
  }

}
