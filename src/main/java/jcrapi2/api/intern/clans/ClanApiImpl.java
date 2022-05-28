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
package jcrapi2.api.intern.clans;

import java.util.concurrent.Future;
import jcrapi2.api.ApiContext;
import jcrapi2.api.BaseApi;

import jcrapi2.api.intern.clans.info.ClanResponse;
import jcrapi2.api.intern.clans.info.ClanRequest;
import jcrapi2.api.intern.clans.riverracelog.RiverRaceLogResponse;
import jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest;
import jcrapi2.api.intern.clans.members.ClanMembersResponse;
import jcrapi2.api.intern.clans.members.ClanMembersRequest;
import jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceResponse;
import jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest;

class ClanApiImpl extends BaseApi implements ClanApi {

  ClanApiImpl(ApiContext apiContext) {
    super(apiContext);
  }

  @Override
  public Future<ClansResponse> findAll(ClansRequest clansRequest) {
    return get("/clans", clansRequest, ClansResponse.class);
  }

  public Future<ClanResponse> findByTag(ClanRequest clanRequest) {
    return get("/clans/{clanTag}", clanRequest, ClanResponse.class);
  }

  public Future<RiverRaceLogResponse> getRiverRaceLog(RiverRaceLogRequest riverRaceLogRequest) {
    return get("/clans/{clanTag}/riverracelog", riverRaceLogRequest, RiverRaceLogResponse.class);
  }

  public Future<ClanMembersResponse> getMembers(ClanMembersRequest clanMembersRequest) {
    return get("/clans/{clanTag}/members", clanMembersRequest, ClanMembersResponse.class);
  }

  public Future<CurrentRiverRaceResponse> getCurrentRiverRace(CurrentRiverRaceRequest currentRiverRaceRequest) {
    return get("/clans/{clanTag}/currentriverrace", currentRiverRaceRequest, CurrentRiverRaceResponse.class);
  }

}