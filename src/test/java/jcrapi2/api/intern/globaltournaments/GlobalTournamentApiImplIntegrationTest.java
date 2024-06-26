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
package jcrapi2.api.intern.globaltournaments;

import jcrapi2.IntegrationTestBase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GlobalTournamentApiImplIntegrationTest extends IntegrationTestBase {

    private GlobalTournamentApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(GlobalTournamentApi.class);
    }

    @Test
    void findAll() throws Exception {
        jcrapi2.api.intern.globaltournaments.GlobalTournamentsRequest
                        .GlobalTournamentsRequestBuilder
                builder = jcrapi2.api.intern.globaltournaments.GlobalTournamentsRequest.builder();
        jcrapi2.api.intern.globaltournaments.GlobalTournamentsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/globaltournaments",
                EMPTY,
                "src/test/resources/globalTournament-findAll.json",
                request);
        jcrapi2.api.intern.globaltournaments.GlobalTournamentsResponse expected =
                toJson(
                        jcrapi2.api.intern.globaltournaments.GlobalTournamentsResponse.class,
                        getExpected());

        run(expected, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findAll_whenWithException() {
        jcrapi2.api.intern.globaltournaments.GlobalTournamentsRequest
                        .GlobalTournamentsRequestBuilder
                builder = jcrapi2.api.intern.globaltournaments.GlobalTournamentsRequest.builder();
        jcrapi2.api.intern.globaltournaments.GlobalTournamentsRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/globaltournaments", EMPTY, request, () -> unitUnderTest.findAll(request).get());
    }
}
