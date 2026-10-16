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

import jcrapi2.IntegrationTestBase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeaderboardApiImplIntegrationTest extends IntegrationTestBase {

    private LeaderboardApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(LeaderboardApi.class);
    }

    @Test
    void findAll_whenApiReturnsSuccess_thenReturnGeneratedResponse() throws Exception {
        jcrapi2.api.intern.leaderboards.LeaderboardsRequest.LeaderboardsRequestBuilder builder =
                jcrapi2.api.intern.leaderboards.LeaderboardsRequest.builder();
        jcrapi2.api.intern.leaderboards.LeaderboardsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare("/leaderboards", EMPTY, "src/test/resources/leaderboard-findAll.json", request);

        jcrapi2.api.intern.leaderboards.LeaderboardsResponse expected =
                fromJson(jcrapi2.api.intern.leaderboards.LeaderboardsResponse.class, getExpected());

        assertResponse(expected, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findAll_whenApiReturnsError_thenThrowConnectorException() {
        jcrapi2.api.intern.leaderboards.LeaderboardsRequest.LeaderboardsRequestBuilder builder =
                jcrapi2.api.intern.leaderboards.LeaderboardsRequest.builder();
        jcrapi2.api.intern.leaderboards.LeaderboardsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        assertRequestFails(
                "/leaderboards", EMPTY, request, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findById_whenApiReturnsSuccess_thenReturnGeneratedResponse() throws Exception {
        long leaderboardId = 4711L;
        jcrapi2.api.intern.leaderboards.info.LeaderboardRequest.LeaderboardRequestBuilder builder =
                jcrapi2.api.intern.leaderboards.info.LeaderboardRequest.builder(leaderboardId);
        jcrapi2.api.intern.leaderboards.info.LeaderboardRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/leaderboard/{leaderboardId}"
                        .replace("{leaderboardId}", String.valueOf(leaderboardId)),
                EMPTY,
                "src/test/resources/leaderboard-findById.json",
                request);
        jcrapi2.api.intern.leaderboards.info.LeaderboardResponse expected =
                fromJson(
                        jcrapi2.api.intern.leaderboards.info.LeaderboardResponse.class,
                        getExpected());

        assertResponse(expected, () -> unitUnderTest.findById(request).get());
    }

    @Test
    void findById_whenApiReturnsError_thenThrowConnectorException() {
        long leaderboardId = 4711L;
        jcrapi2.api.intern.leaderboards.info.LeaderboardRequest.LeaderboardRequestBuilder builder =
                jcrapi2.api.intern.leaderboards.info.LeaderboardRequest.builder(leaderboardId);
        jcrapi2.api.intern.leaderboards.info.LeaderboardRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        assertRequestFails(
                "/leaderboard/{leaderboardId}"
                        .replace("{leaderboardId}", String.valueOf(leaderboardId)),
                EMPTY,
                request,
                () -> unitUnderTest.findById(request).get());
    }
}
