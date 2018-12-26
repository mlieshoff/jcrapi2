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

import java.io.IOException;
import jcrapi2.request.BlankRequest;
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
import jcrapi2.response.RawResponse;

/**
 * @author Michael Lieshoff
 */
public class Api {

  private final ClientFactory clientFactory;

  private final String url;
  private final String apiKey;

  public Api(String url, String apiKey) {
    this(url, apiKey, new ClientFactory());
  }

  Api(String url, String apiKey, ClientFactory clientFactory) {
    checkString(url, "url");
    checkString(apiKey, "apiKey");
    this.url = url;
    this.apiKey = apiKey;
    this.clientFactory = clientFactory;
  }

  private static void checkString(String s, String key) {
    checkNotNull(s, key);
    checkArgument(!s.isEmpty(), key);
  }

  public GetClansResponse getClans(GetClansRequest getClansRequest) {
    checkNotNull(getClansRequest, "getClansRequest");
    try {
      return createClient().getClans(getClansRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  private Client createClient() {
    return clientFactory.createClient(url, apiKey);
  }

  public GetClanResponse getClan(GetClanRequest getClanRequest) {
    checkNotNull(getClanRequest, "getClanRequest");
    try {
      return createClient().getClan(getClanRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetClanMembersResponse getClanMembers(GetClanMembersRequest getClanMembersRequest) {
    checkNotNull(getClanMembersRequest, "getClanMembersRequest");
    try {
      return createClient().getClanMembers(getClanMembersRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetClanWarLogResponse getClanWarLog(GetClanWarLogRequest getClanWarLogRequest) {
    checkNotNull(getClanWarLogRequest, "getClanWarLogRequest");
    try {
      return createClient().getClanWarLog(getClanWarLogRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetClanCurrentWarResponse getClanCurrentWar(GetClanCurrentWarRequest getClanCurrentWarRequest) {
    checkNotNull(getClanCurrentWarRequest, "getClanCurrentWarRequest");
    try {
      return createClient().getClanCurrentWar(getClanCurrentWarRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetPlayerResponse getPlayer(GetPlayerRequest getPlayerRequest) {
    checkNotNull(getPlayerRequest, "getPlayerRequest");
    try {
      return createClient().getPlayer(getPlayerRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetPlayerUpcomingChestsResponse getPlayerUpcomingChests(
      GetPlayerUpcomingChestsRequest getPlayerUpcomingChestsRequest) {
    checkNotNull(getPlayerUpcomingChestsRequest, "getPlayerUpcomingChestsRequest");
    try {
      return createClient().getPlayerUpcomingChests(getPlayerUpcomingChestsRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetPlayerBattleLogResponse getPlayerBattleLog(GetPlayerBattleLogRequest getPlayerBattleLogRequest) {
    checkNotNull(getPlayerBattleLogRequest, "getPlayerBattleLogRequest");
    try {
      return createClient().getPlayerBattleLog(getPlayerBattleLogRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetTournamentsResponse getTournaments(GetTournamentsRequest getTournamentsRequest) {
    checkNotNull(getTournamentsRequest, "getTournamentsRequest");
    try {
      return createClient().getTournaments(getTournamentsRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetTournamentResponse getTournament(GetTournamentRequest getTournamentRequest) {
    checkNotNull(getTournamentRequest, "getTournamentRequest");
    try {
      return createClient().getTournament(getTournamentRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public RawResponse getLastRawResponse() {
    return createClient().getLastRawResponse();
  }

  public GetCardsResponse getCards() {
    try {
      return createClient().getCards(new BlankRequest<>());
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetLocationsResponse getLocations(GetLocationsRequest getLocationsRequest) {
    checkNotNull(getLocationsRequest, "getLocationsRequest");
    try {
      return createClient().getLocations(getLocationsRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetLocationResponse getLocation(GetLocationRequest getLocationRequest) {
    checkNotNull(getLocationRequest, "getLocationRequest");
    try {
      return createClient().getLocation(getLocationRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetLocationClanRankingsResponse getLocationClanRankings(
      GetLocationClanRankingsRequest getLocationClanRankingsRequest) {
    checkNotNull(getLocationClanRankingsRequest, "getLocationClanRankingsRequest");
    try {
      return createClient().getLocationClanRankings(getLocationClanRankingsRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetLocationPlayerRankingsResponse getLocationPlayerRankings(
      GetLocationPlayerRankingsRequest getLocationPlayerRankingsRequest) {
    checkNotNull(getLocationPlayerRankingsRequest, "getLocationPlayerRankingsRequest");
    try {
      return createClient().getLocationPlayerRankings(getLocationPlayerRankingsRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetLocationClanWarRankingsResponse getLocationClanWarRankings(
      GetLocationClanWarRankingsRequest getLocationClanWarRankingsRequest) {
    checkNotNull(getLocationClanWarRankingsRequest, "getLocationClanWarRankingsRequest");
    try {
      return createClient().getLocationClanWarRankings(getLocationClanWarRankingsRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

}