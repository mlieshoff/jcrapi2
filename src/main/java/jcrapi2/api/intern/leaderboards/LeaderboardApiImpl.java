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
package jcrapi2.api.intern.leaderboards;

import jcrapi2.api.intern.leaderboards.info.LeaderboardRequest;
import jcrapi2.api.intern.leaderboards.info.LeaderboardResponse;

import supercell.api.wrapper.essentials.api.ApiContext;
import supercell.api.wrapper.essentials.api.BaseApi;

import java.util.concurrent.Future;

class LeaderboardApiImpl extends BaseApi implements LeaderboardApi {

    LeaderboardApiImpl(ApiContext apiContext) {
        super(apiContext);
    }

    @Override
    public Future<LeaderboardsResponse> findAll(LeaderboardsRequest leaderboardsRequest) {
        return get("/leaderboards", leaderboardsRequest, LeaderboardsResponse.class);
    }

    public Future<LeaderboardResponse> findById(LeaderboardRequest leaderboardRequest) {
        return get("/leaderboard/{leaderboardId}", leaderboardRequest, LeaderboardResponse.class);
    }
}
