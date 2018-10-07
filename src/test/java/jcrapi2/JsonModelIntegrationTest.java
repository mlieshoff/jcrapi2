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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.gson.Gson;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import jcrapi2.response.GetClanCurrentWarResponse;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClanWarLogResponse;
import jcrapi2.response.GetClansResponse;

class JsonModelIntegrationTest {

  private static final Gson GSON = new Gson();

  @Test
  void fromJson_whenForGetClans_thenResolve() throws Exception {
    String json = FileUtils.readFileToString(new File("src/test/resources/clans.json"));
    GetClansResponse object = GSON.fromJson(json, GetClansResponse.class);
    assertNotNull(object);
    object.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void fromJson_whenForGetClan_thenResolve() throws Exception {
    String json = FileUtils.readFileToString(new File("src/test/resources/clan.json"));
    GetClanResponse object = GSON.fromJson(json, GetClanResponse.class);
    assertNotNull(object);
  }

  @Test
  void fromJson_whenForGetClanMembers_thenResolve() throws Exception {
    String json = FileUtils.readFileToString(new File("src/test/resources/clanMembers.json"));
    GetClanMembersResponse object = GSON.fromJson(json, GetClanMembersResponse.class);
    assertNotNull(object);
    object.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void fromJson_whenForGetClanWarLog_thenResolve() throws Exception {
    String json = FileUtils.readFileToString(new File("src/test/resources/clanWarLog.json"));
    GetClanWarLogResponse object = GSON.fromJson(json, GetClanWarLogResponse.class);
    assertNotNull(object);
    object.getItems().forEach(Assertions::assertNotNull);
  }

  @Test
  void fromJson_whenForGetClanCurentWar_thenResolve() throws Exception {
    String json = FileUtils.readFileToString(new File("src/test/resources/clanCurrentWar.json"));
    GetClanCurrentWarResponse object = GSON.fromJson(json, GetClanCurrentWarResponse.class);
    assertNotNull(object);
  }

}
