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
package jcrapi2.api.intern.players;

import static wiremock.org.apache.commons.lang3.StringUtils.EMPTY;

import jcrapi2.IntegrationTestBase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerApiImplIntegrationTest extends IntegrationTestBase {

    private PlayerApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(PlayerApi.class);
    }

    @Test
    void findByTag() throws Exception {
        String playerTag = "playerTag";
        jcrapi2.api.intern.players.info.PlayerRequest.PlayerRequestBuilder builder =
                jcrapi2.api.intern.players.info.PlayerRequest.builder(playerTag);
        jcrapi2.api.intern.players.info.PlayerRequest request =
                builder.storeRawResponse(true).build();
        prepare(
                "/players/{playerTag}".replace("{playerTag}", playerTag),
                EMPTY,
                "src/test/resources/player-findByTag.json",
                request);
        jcrapi2.api.intern.players.info.PlayerResponse expected =
                toJson(jcrapi2.api.intern.players.info.PlayerResponse.class, getExpected());

        run(expected, () -> unitUnderTest.findByTag(request).get());
    }

    @Test
    void findByTag_whenWithException() {
        String playerTag = "playerTag";
        jcrapi2.api.intern.players.info.PlayerRequest.PlayerRequestBuilder builder =
                jcrapi2.api.intern.players.info.PlayerRequest.builder(playerTag);
        jcrapi2.api.intern.players.info.PlayerRequest request =
                builder.storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/players/{playerTag}".replace("{playerTag}", playerTag),
                EMPTY,
                request,
                () -> unitUnderTest.findByTag(request).get());
    }

    @Test
    void getUpcomingChests() throws Exception {
        String playerTag = "playerTag";
        jcrapi2.api.intern.players.upcomingchests.UpcomingChestsRequest.UpcomingChestsRequestBuilder
                builder =
                        jcrapi2.api.intern.players.upcomingchests.UpcomingChestsRequest.builder(
                                playerTag);
        jcrapi2.api.intern.players.upcomingchests.UpcomingChestsRequest request =
                builder.storeRawResponse(true).build();
        prepare(
                "/players/{playerTag}/upcomingchests".replace("{playerTag}", playerTag),
                EMPTY,
                "src/test/resources/player-getUpcomingChests.json",
                request);
        jcrapi2.api.intern.players.upcomingchests.UpcomingChestsResponse expected =
                toJson(
                        jcrapi2.api.intern.players.upcomingchests.UpcomingChestsResponse.class,
                        getExpected());

        run(expected, () -> unitUnderTest.getUpcomingChests(request).get());
    }

    @Test
    void getUpcomingChests_whenWithException() {
        String playerTag = "playerTag";
        jcrapi2.api.intern.players.upcomingchests.UpcomingChestsRequest.UpcomingChestsRequestBuilder
                builder =
                        jcrapi2.api.intern.players.upcomingchests.UpcomingChestsRequest.builder(
                                playerTag);
        jcrapi2.api.intern.players.upcomingchests.UpcomingChestsRequest request =
                builder.storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/players/{playerTag}/upcomingchests".replace("{playerTag}", playerTag),
                EMPTY,
                request,
                () -> unitUnderTest.getUpcomingChests(request).get());
    }

    @Test
    void getBattleLog() throws Exception {
        String playerTag = "playerTag";
        jcrapi2.api.intern.players.battlelog.BattleLogRequest.BattleLogRequestBuilder builder =
                jcrapi2.api.intern.players.battlelog.BattleLogRequest.builder(playerTag);
        jcrapi2.api.intern.players.battlelog.BattleLogRequest request =
                builder.storeRawResponse(true).build();
        prepare(
                "/players/{playerTag}/battlelog".replace("{playerTag}", playerTag),
                EMPTY,
                "src/test/resources/player-getBattleLog.json",
                request);
        jcrapi2.api.intern.players.battlelog.BattleLogResponse expected =
                toJson(jcrapi2.api.intern.players.battlelog.BattleLogResponse.class, getExpected());

        run(expected, () -> unitUnderTest.getBattleLog(request).get());
    }

    @Test
    void getBattleLog_whenWithException() {
        String playerTag = "playerTag";
        jcrapi2.api.intern.players.battlelog.BattleLogRequest.BattleLogRequestBuilder builder =
                jcrapi2.api.intern.players.battlelog.BattleLogRequest.builder(playerTag);
        jcrapi2.api.intern.players.battlelog.BattleLogRequest request =
                builder.storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/players/{playerTag}/battlelog".replace("{playerTag}", playerTag),
                EMPTY,
                request,
                () -> unitUnderTest.getBattleLog(request).get());
    }
}
