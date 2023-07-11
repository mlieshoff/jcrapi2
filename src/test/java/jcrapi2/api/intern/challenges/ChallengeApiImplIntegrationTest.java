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
package jcrapi2.api.intern.challenges;

import static wiremock.org.apache.commons.lang3.StringUtils.EMPTY;

import jcrapi2.IntegrationTestBase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChallengeApiImplIntegrationTest extends IntegrationTestBase {

    private ChallengeApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(ChallengeApi.class);
    }

    @Test
    void findAll() throws Exception {
        jcrapi2.api.intern.challenges.ChallengesRequest.ChallengesRequestBuilder builder =
                jcrapi2.api.intern.challenges.ChallengesRequest.builder();
        jcrapi2.api.intern.challenges.ChallengesRequest request =
                builder.storeRawResponse(true).build();
        prepare("/challenges", EMPTY, "src/test/resources/challenge-findAll.json", request);
        jcrapi2.api.intern.challenges.ChallengesResponse expected =
                toJson(jcrapi2.api.intern.challenges.ChallengesResponse.class, getExpected());

        run(expected, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findAll_whenWithException() {
        jcrapi2.api.intern.challenges.ChallengesRequest.ChallengesRequestBuilder builder =
                jcrapi2.api.intern.challenges.ChallengesRequest.builder();
        jcrapi2.api.intern.challenges.ChallengesRequest request =
                builder.storeRawResponse(true).build();

        prepareWithErrorAndRun(
                "/challenges", EMPTY, request, () -> unitUnderTest.findAll(request).get());
    }
}
