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
package jcrapi2.request;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GetClanWarLogRequestTest extends PageableRequestTestBase<GetClanWarLogRequest> {

  private static final String CLAN_TAG = "clanTag";

  @Test
  void build_whenWithNullClanTag_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> GetClanWarLogRequest.builder(null).build());
  }

  @Test
  void build_whenWithEmptyClanTag_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> GetClanWarLogRequest.builder("").build());
  }

  @Test
  void build_whenWithClanTag_thenSetValue() throws Exception {
    assertEquals(CLAN_TAG, GetClanWarLogRequest.builder(CLAN_TAG).build().getClanTag());
  }

  @Test
  void build_whenWithClanTag_thenHaveRestParameter() throws Exception {
    assertEquals(singletonList(CLAN_TAG), GetClanWarLogRequest.builder(CLAN_TAG).build().getRestParameters());
  }

  @Override
  Object getBuilder() {
    return GetClanWarLogRequest.builder(CLAN_TAG);
  }

}