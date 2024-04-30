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
package jcrapi2.api.intern.tournaments;

import jcrapi2.IntegrationTestBase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TournamentApiImplIntegrationTest extends IntegrationTestBase {

    private TournamentApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(TournamentApi.class);
    }

    @Test
    void findAll() throws Exception {
        String name = "name";
        jcrapi2.api.intern.tournaments.TournamentsRequest.TournamentsRequestBuilder builder =
                jcrapi2.api.intern.tournaments.TournamentsRequest.builder();
        jcrapi2.api.intern.tournaments.TournamentsRequest request =
                builder.name(name)
                        .limit(100)
                        .before("zzz")
                        .after("aaa")
                        .storeRawResponse(true)
                        .build();
        prepare(
                "/tournaments",
                "name=" + name,
                "src/test/resources/tournament-findAll.json",
                request);
        jcrapi2.api.intern.tournaments.TournamentsResponse expected =
                toJson(jcrapi2.api.intern.tournaments.TournamentsResponse.class, getExpected());

        run(expected, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findAll_whenWithException() {
        String name = "name";
        jcrapi2.api.intern.tournaments.TournamentsRequest.TournamentsRequestBuilder builder =
                jcrapi2.api.intern.tournaments.TournamentsRequest.builder();
        jcrapi2.api.intern.tournaments.TournamentsRequest request =
                builder.name(name)
                        .limit(100)
                        .before("zzz")
                        .after("aaa")
                        .storeRawResponse(true)
                        .build();

        prepareWithErrorAndRun(
                "/tournaments",
                "name=" + name,
                request,
                () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findByTag() throws Exception {
        String tournamentTag = "tournamentTag";
        jcrapi2.api.intern.tournaments.info.TournamentRequest.TournamentRequestBuilder builder =
                jcrapi2.api.intern.tournaments.info.TournamentRequest.builder(tournamentTag);
        jcrapi2.api.intern.tournaments.info.TournamentRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/tournaments/{tournamentTag}".replace("{tournamentTag}", tournamentTag),
                EMPTY,
                "src/test/resources/tournament-findByTag.json",
                request);
        jcrapi2.api.intern.tournaments.info.TournamentResponse expected =
                toJson(jcrapi2.api.intern.tournaments.info.TournamentResponse.class, getExpected());

        run(expected, () -> unitUnderTest.findByTag(request).get());
    }

    @Test
    void findByTag_whenWithException() {
        String tournamentTag = "tournamentTag";
        jcrapi2.api.intern.tournaments.info.TournamentRequest.TournamentRequestBuilder builder =
                jcrapi2.api.intern.tournaments.info.TournamentRequest.builder(tournamentTag);
        jcrapi2.api.intern.tournaments.info.TournamentRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/tournaments/{tournamentTag}".replace("{tournamentTag}", tournamentTag),
                EMPTY,
                request,
                () -> unitUnderTest.findByTag(request).get());
    }
}
