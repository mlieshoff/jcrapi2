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
package jcrapi2.api.intern.leaderboards.info;

import lombok.Builder;

import supercell.api.wrapper.essentials.common.PaginationRequest;

import java.util.Map;

public class LeaderboardRequest extends PaginationRequest {

    private final long leaderboardId;

    @Builder
    private LeaderboardRequest(
            int limit, String after, String before, boolean storeRawResponse, long leaderboardId) {
        super(limit, after, before, storeRawResponse);
        this.leaderboardId = leaderboardId;
    }

    public static LeaderboardRequestBuilder builder(long leaderboardId) {
        return new LeaderboardRequestBuilder().leaderboardId(leaderboardId);
    }

    @Override
    public Map<String, Object> getRestParameters() {
        Map<String, Object> map = super.getRestParameters();
        map.put("leaderboardId", leaderboardId);
        return map;
    }
}
