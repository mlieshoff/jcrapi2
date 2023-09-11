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
package jcrapi2.api.intern.locations.seasons.global.info;

import jcrapi2.common.Request;

import lombok.Builder;

import java.util.Map;

public class TopPlayerLeagueSeasonRequest extends Request {

    private final String seasonId;

    @Builder
    private TopPlayerLeagueSeasonRequest(boolean storeRawResponse, String seasonId) {
        super(storeRawResponse);
        this.seasonId = seasonId;
    }

    public static TopPlayerLeagueSeasonRequestBuilder builder(String seasonId) {
        return new TopPlayerLeagueSeasonRequestBuilder().seasonId(seasonId);
    }

    @Override
    public Map<String, Object> getRestParameters() {
        Map<String, Object> map = super.getRestParameters();
        map.put("seasonId", seasonId);
        return map;
    }
}
