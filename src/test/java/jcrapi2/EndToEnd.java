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
package jcrapi2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jcrapi2.request.GetClanMembersRequest;
import jcrapi2.request.GetClanRequest;
import jcrapi2.request.GetClanWarLogRequest;
import jcrapi2.request.GetClansRequest;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClanWarLogResponse;
import jcrapi2.response.GetClansResponse;

/**
 * @author Michael Lieshoff
 */
class EndToEnd {

  private static final String API_KEY = System.getProperty("api.key");

  private Api api;

  @BeforeEach
  void setUp() throws Exception {
    api = new Api("https://api.clashroyale.com/v1/", API_KEY);
  }

  @Test
  void getClans_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClansResponse getClansResponse = api.getClans(GetClansRequest.builder().name("puzzle").build());
    assertAll(
        () -> assertNotNull(getClansResponse, "getClansResponse"),
        () -> assertNull(getClansResponse.getMessage(), "message"),
        () -> assertNull(getClansResponse.getReason(), "reason")
    );
  }

  @Test
  void getClan_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClanResponse getClanResponse = api.getClan(GetClanRequest.builder("#RP88QQG").build());
    assertAll(
        () -> assertNotNull(getClanResponse, "getClanResponse"),
        () -> assertNull(getClanResponse.getMessage(), "message"),
        () -> assertNull(getClanResponse.getReason(), "reason")
    );
  }

  @Test
  void getClanMembers_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClanMembersResponse
        getClanMembersResponse =
        api.getClanMembers(GetClanMembersRequest.builder("#RP88QQG").build());
    assertAll(
        () -> assertNotNull(getClanMembersResponse, "getClanMembersResponse"),
        () -> assertNull(getClanMembersResponse.getMessage(), "message"),
        () -> assertNull(getClanMembersResponse.getReason(), "reason")
    );
  }

  @Test
  void getClanWarLog_whenWithValidParameters_thenGetResponse() throws Exception {
    GetClanWarLogResponse
        getClanWarLogResponse =
        api.getClanWarLog(GetClanWarLogRequest.builder("#RP88QQG").build());
    assertAll(
        () -> assertNotNull(getClanWarLogResponse, "getClanWarLogResponse"),
        () -> assertNull(getClanWarLogResponse.getMessage(), "message"),
        () -> assertNull(getClanWarLogResponse.getReason(), "reason")
    );
  }

}
