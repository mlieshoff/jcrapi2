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

import jcrapi2.IntegrationTestBase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClanApiImplIntegrationTest extends IntegrationTestBase {

    private ClanApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(ClanApi.class);
    }

    @Test
    void findAll_whenApiReturnsSuccess_thenReturnGeneratedResponse() throws Exception {
        String name = "name";
        Integer locationId = 815;
        Integer minMembers = 815;
        Integer maxMembers = 815;
        jcrapi2.api.intern.clans.ClansRequest.ClansRequestBuilder builder =
                jcrapi2.api.intern.clans.ClansRequest.builder();
        jcrapi2.api.intern.clans.ClansRequest request =
                builder.name(name)
                        .locationId(locationId)
                        .minMembers(minMembers)
                        .maxMembers(maxMembers)
                        .limit(100)
                        .before("zzz")
                        .after("aaa")
                        .storeRawResponse(true)
                        .build();
        prepare(
                "/clans",
                "name="
                        + name
                        + "&locationId="
                        + locationId
                        + "&minMembers="
                        + minMembers
                        + "&maxMembers="
                        + maxMembers,
                "src/test/resources/clan-findAll.json",
                request);
        jcrapi2.api.intern.clans.ClansResponse expected =
                fromJson(jcrapi2.api.intern.clans.ClansResponse.class, getExpected());

        assertResponse(expected, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findAll_whenApiReturnsError_thenThrowConnectorException() {
        String name = "name";
        Integer locationId = 815;
        Integer minMembers = 815;
        Integer maxMembers = 815;
        jcrapi2.api.intern.clans.ClansRequest.ClansRequestBuilder builder =
                jcrapi2.api.intern.clans.ClansRequest.builder();
        jcrapi2.api.intern.clans.ClansRequest request =
                builder.name(name)
                        .locationId(locationId)
                        .minMembers(minMembers)
                        .maxMembers(maxMembers)
                        .limit(100)
                        .before("zzz")
                        .after("aaa")
                        .storeRawResponse(true)
                        .build();

        assertRequestFails(
                "/clans",
                "name="
                        + name
                        + "&locationId="
                        + locationId
                        + "&minMembers="
                        + minMembers
                        + "&maxMembers="
                        + maxMembers,
                request,
                () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findByTag_whenApiReturnsSuccess_thenReturnGeneratedResponse() throws Exception {
        String clanTag = "clanTag";
        jcrapi2.api.intern.clans.info.ClanRequest.ClanRequestBuilder builder =
                jcrapi2.api.intern.clans.info.ClanRequest.builder(clanTag);
        jcrapi2.api.intern.clans.info.ClanRequest request = builder.storeRawResponse(true).build();

        prepare(
                "/clans/{clanTag}".replace("{clanTag}", clanTag),
                EMPTY,
                "src/test/resources/clan-findByTag.json",
                request);
        jcrapi2.api.intern.clans.info.ClanResponse expected =
                fromJson(jcrapi2.api.intern.clans.info.ClanResponse.class, getExpected());

        assertResponse(expected, () -> unitUnderTest.findByTag(request).get());
    }

    @Test
    void findByTag_whenApiReturnsError_thenThrowConnectorException() {
        String clanTag = "clanTag";
        jcrapi2.api.intern.clans.info.ClanRequest.ClanRequestBuilder builder =
                jcrapi2.api.intern.clans.info.ClanRequest.builder(clanTag);
        jcrapi2.api.intern.clans.info.ClanRequest request = builder.storeRawResponse(true).build();

        assertRequestFails(
                "/clans/{clanTag}".replace("{clanTag}", clanTag),
                EMPTY,
                request,
                () -> unitUnderTest.findByTag(request).get());
    }

    @Test
    void getRiverRaceLog_whenApiReturnsSuccess_thenReturnGeneratedResponse() throws Exception {
        String clanTag = "clanTag";
        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest.RiverRaceLogRequestBuilder
                builder =
                        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest.builder(clanTag);
        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/clans/{clanTag}/riverracelog".replace("{clanTag}", clanTag),
                EMPTY,
                "src/test/resources/clan-getRiverRaceLog.json",
                request);
        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogResponse expected =
                fromJson(
                        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogResponse.class,
                        getExpected());

        assertResponse(expected, () -> unitUnderTest.getRiverRaceLog(request).get());
    }

    @Test
    void getRiverRaceLog_whenApiReturnsError_thenThrowConnectorException() {
        String clanTag = "clanTag";
        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest.RiverRaceLogRequestBuilder
                builder =
                        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest.builder(clanTag);
        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        assertRequestFails(
                "/clans/{clanTag}/riverracelog".replace("{clanTag}", clanTag),
                EMPTY,
                request,
                () -> unitUnderTest.getRiverRaceLog(request).get());
    }

    @Test
    void getMembers_whenApiReturnsSuccess_thenReturnGeneratedResponse() throws Exception {
        String clanTag = "clanTag";
        jcrapi2.api.intern.clans.members.ClanMembersRequest.ClanMembersRequestBuilder builder =
                jcrapi2.api.intern.clans.members.ClanMembersRequest.builder(clanTag);
        jcrapi2.api.intern.clans.members.ClanMembersRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();
        prepare(
                "/clans/{clanTag}/members".replace("{clanTag}", clanTag),
                EMPTY,
                "src/test/resources/clan-getMembers.json",
                request);
        jcrapi2.api.intern.clans.members.ClanMembersResponse expected =
                fromJson(jcrapi2.api.intern.clans.members.ClanMembersResponse.class, getExpected());

        assertResponse(expected, () -> unitUnderTest.getMembers(request).get());
    }

    @Test
    void getMembers_whenApiReturnsError_thenThrowConnectorException() {
        String clanTag = "clanTag";
        jcrapi2.api.intern.clans.members.ClanMembersRequest.ClanMembersRequestBuilder builder =
                jcrapi2.api.intern.clans.members.ClanMembersRequest.builder(clanTag);
        jcrapi2.api.intern.clans.members.ClanMembersRequest request =
                builder.limit(100).before("zzz").after("aaa").storeRawResponse(true).build();

        assertRequestFails(
                "/clans/{clanTag}/members".replace("{clanTag}", clanTag),
                EMPTY,
                request,
                () -> unitUnderTest.getMembers(request).get());
    }

    @Test
    void getCurrentRiverRace_whenApiReturnsSuccess_thenReturnGeneratedResponse() throws Exception {
        String clanTag = "clanTag";
        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest
                        .CurrentRiverRaceRequestBuilder
                builder =
                        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest.builder(
                                clanTag);
        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest request =
                builder.storeRawResponse(true).build();
        prepare(
                "/clans/{clanTag}/currentriverrace".replace("{clanTag}", clanTag),
                EMPTY,
                "src/test/resources/clan-getCurrentRiverRace.json",
                request);
        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceResponse expected =
                fromJson(
                        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceResponse.class,
                        getExpected());

        assertResponse(expected, () -> unitUnderTest.getCurrentRiverRace(request).get());
    }

    @Test
    void getCurrentRiverRace_whenApiReturnsError_thenThrowConnectorException() {
        String clanTag = "clanTag";
        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest
                        .CurrentRiverRaceRequestBuilder
                builder =
                        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest.builder(
                                clanTag);
        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest request =
                builder.storeRawResponse(true).build();

        assertRequestFails(
                "/clans/{clanTag}/currentriverrace".replace("{clanTag}", clanTag),
                EMPTY,
                request,
                () -> unitUnderTest.getCurrentRiverRace(request).get());
    }
}
