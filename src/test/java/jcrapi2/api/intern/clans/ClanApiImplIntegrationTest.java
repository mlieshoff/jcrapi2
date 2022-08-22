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

import static wiremock.org.apache.commons.lang3.StringUtils.EMPTY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jcrapi2.IntegrationTestBase;

public class ClanApiImplIntegrationTest extends IntegrationTestBase {

  private ClanApi unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = getJCrApi().getApi(ClanApi.class);
  }

  @Test
  void findAll() throws Exception {
    String name = "name";
    Integer locationId = 815;
    Integer minMembers = 815;
    Integer maxMembers = 815;
    jcrapi2.api.intern.clans.ClansRequest.ClansRequestBuilder builder = jcrapi2.api.intern.clans.ClansRequest.builder();
    jcrapi2.api.intern.clans.ClansRequest request = builder
        .name(name)
        .locationId(locationId)
        .minMembers(minMembers)
        .maxMembers(maxMembers)
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/clans",
        "name=" + name + "&locationId=" + locationId + "&minMembers=" + minMembers + "&maxMembers=" + maxMembers,
        "src/test/resources/clan-findAll.json", request);
    jcrapi2.api.intern.clans.ClansResponse
        expected =
        toJson(jcrapi2.api.intern.clans.ClansResponse.class, getExpected());

    run(expected, () -> unitUnderTest.findAll(request).get());
  }

  @Test
  void findAll_whenWithException() {
    String name = "name";
    Integer locationId = 815;
    Integer minMembers = 815;
    Integer maxMembers = 815;
    jcrapi2.api.intern.clans.ClansRequest.ClansRequestBuilder builder = jcrapi2.api.intern.clans.ClansRequest.builder();
    jcrapi2.api.intern.clans.ClansRequest request = builder
        .name(name)
        .locationId(locationId)
        .minMembers(minMembers)
        .maxMembers(maxMembers)
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/clans".replace("{name}", name)
            .replace("{locationId}", String.valueOf(locationId))
            .replace("{minMembers}", String.valueOf(minMembers))
            .replace("{maxMembers}", String.valueOf(maxMembers)),
        "name=" + name + "&locationId=" + locationId + "&minMembers=" + minMembers + "&maxMembers=" + maxMembers,
        request, () -> unitUnderTest.findAll(request).get());
  }

  @Test
  void findByTag() throws Exception {
    String clanTag = "clanTag";
    jcrapi2.api.intern.clans.info.ClanRequest.ClanRequestBuilder
        builder =
        jcrapi2.api.intern.clans.info.ClanRequest.builder(clanTag);
    jcrapi2.api.intern.clans.info.ClanRequest request = builder

        .storeRawResponse(true)
        .build();
    prepare("/clans/{clanTag}".replace("{clanTag}", clanTag), EMPTY, "src/test/resources/clan-findByTag.json", request);
    jcrapi2.api.intern.clans.info.ClanResponse
        expected =
        toJson(jcrapi2.api.intern.clans.info.ClanResponse.class, getExpected());

    run(expected, () -> unitUnderTest.findByTag(request).get());
  }

  @Test
  void findByTag_whenWithException() {
    String clanTag = "clanTag";
    jcrapi2.api.intern.clans.info.ClanRequest.ClanRequestBuilder
        builder =
        jcrapi2.api.intern.clans.info.ClanRequest.builder(clanTag);
    jcrapi2.api.intern.clans.info.ClanRequest request = builder

        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/clans/{clanTag}".replace("{clanTag}", clanTag), EMPTY, request,
        () -> unitUnderTest.findByTag(request).get());
  }

  @Test
  void getRiverRaceLog() throws Exception {
    String clanTag = "clanTag";
    jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest.RiverRaceLogRequestBuilder
        builder =
        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest.builder(clanTag);
    jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/clans/{clanTag}/riverracelog".replace("{clanTag}", clanTag), EMPTY,
        "src/test/resources/clan-getRiverRaceLog.json", request);
    jcrapi2.api.intern.clans.riverracelog.RiverRaceLogResponse
        expected =
        toJson(jcrapi2.api.intern.clans.riverracelog.RiverRaceLogResponse.class, getExpected());

    run(expected, () -> unitUnderTest.getRiverRaceLog(request).get());
  }

  @Test
  void getRiverRaceLog_whenWithException() {
    String clanTag = "clanTag";
    jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest.RiverRaceLogRequestBuilder
        builder =
        jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest.builder(clanTag);
    jcrapi2.api.intern.clans.riverracelog.RiverRaceLogRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/clans/{clanTag}/riverracelog".replace("{clanTag}", clanTag), EMPTY, request,
        () -> unitUnderTest.getRiverRaceLog(request).get());
  }

  @Test
  void getMembers() throws Exception {
    String clanTag = "clanTag";
    jcrapi2.api.intern.clans.members.ClanMembersRequest.ClanMembersRequestBuilder
        builder =
        jcrapi2.api.intern.clans.members.ClanMembersRequest.builder(clanTag);
    jcrapi2.api.intern.clans.members.ClanMembersRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();
    prepare("/clans/{clanTag}/members".replace("{clanTag}", clanTag), EMPTY, "src/test/resources/clan-getMembers.json",
        request);
    jcrapi2.api.intern.clans.members.ClanMembersResponse
        expected =
        toJson(jcrapi2.api.intern.clans.members.ClanMembersResponse.class, getExpected());

    run(expected, () -> unitUnderTest.getMembers(request).get());
  }

  @Test
  void getMembers_whenWithException() {
    String clanTag = "clanTag";
    jcrapi2.api.intern.clans.members.ClanMembersRequest.ClanMembersRequestBuilder
        builder =
        jcrapi2.api.intern.clans.members.ClanMembersRequest.builder(clanTag);
    jcrapi2.api.intern.clans.members.ClanMembersRequest request = builder
        .limit(100)
        .before("zzz")
        .after("aaa")
        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/clans/{clanTag}/members".replace("{clanTag}", clanTag), EMPTY, request,
        () -> unitUnderTest.getMembers(request).get());
  }

  @Test
  void getCurrentRiverRace() throws Exception {
    String clanTag = "clanTag";
    jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest.CurrentRiverRaceRequestBuilder
        builder =
        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest.builder(clanTag);
    jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest request = builder

        .storeRawResponse(true)
        .build();
    prepare("/clans/{clanTag}/currentriverrace".replace("{clanTag}", clanTag), EMPTY,
        "src/test/resources/clan-getCurrentRiverRace.json", request);
    jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceResponse
        expected =
        toJson(jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceResponse.class, getExpected());

    run(expected, () -> unitUnderTest.getCurrentRiverRace(request).get());
  }

  @Test
  void getCurrentRiverRace_whenWithException() {
    String clanTag = "clanTag";
    jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest.CurrentRiverRaceRequestBuilder
        builder =
        jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest.builder(clanTag);
    jcrapi2.api.intern.clans.currentriverrace.CurrentRiverRaceRequest request = builder

        .storeRawResponse(true)
        .build();

    prepareWithErrorAndRun("/clans/{clanTag}/currentriverrace".replace("{clanTag}", clanTag), EMPTY, request,
        () -> unitUnderTest.getCurrentRiverRace(request).get());
  }

}