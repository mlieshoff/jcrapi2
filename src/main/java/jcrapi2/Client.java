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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import jcrapi2.request.GetClanCurrentWarRequest;
import jcrapi2.request.GetClanMembersRequest;
import jcrapi2.request.GetClanRequest;
import jcrapi2.request.GetClanWarLogRequest;
import jcrapi2.request.GetClansRequest;
import jcrapi2.request.GetPlayerBattleLogRequest;
import jcrapi2.request.GetPlayerRequest;
import jcrapi2.request.GetPlayerUpcomingChestsRequest;
import jcrapi2.request.GetTournamentsRequest;
import jcrapi2.request.Request;
import jcrapi2.response.GetClanCurrentWarResponse;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClanWarLogResponse;
import jcrapi2.response.GetClansResponse;
import jcrapi2.response.GetPlayerBattleLogResponse;
import jcrapi2.response.GetPlayerResponse;
import jcrapi2.response.GetPlayerUpcomingChestsResponse;
import jcrapi2.response.GetTournamentsResponse;
import jcrapi2.response.IResponse;

/**
 * @author Michael Lieshoff
 */
public class Client {

  private final String url;
  private final String apiKey;

  private final CrawlerFactory crawlerFactory;

  Client(String url, String apiKey, CrawlerFactory crawlerFactory) {
    checkString(url);
    checkNotNull(crawlerFactory);
    this.url = url;
    this.apiKey = apiKey;
    this.crawlerFactory = crawlerFactory;
  }

  private static void checkString(String url) {
    checkNotNull(url);
    checkArgument(!url.isEmpty(), url);
  }

  GetClansResponse getClans(GetClansRequest getClansRequest) throws IOException {
    return singleObjectFromJson("getClansRequest", "clans", getClansRequest, GetClansResponse.class);
  }

  private <T extends IResponse> T singleObjectFromJson(String nameOfRequest, String part, Request request,
                                                       Class<T> responseClass) throws IOException {
    checkNotNull(request, nameOfRequest);
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

}
