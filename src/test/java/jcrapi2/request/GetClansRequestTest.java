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

import static java.lang.String.valueOf;
import static jcrapi2.request.GetClansRequest.QUERY_PARAM_LOCATION_ID;
import static jcrapi2.request.GetClansRequest.QUERY_PARAM_MAX_MEMBERS;
import static jcrapi2.request.GetClansRequest.QUERY_PARAM_MIN_MEMBERS;
import static jcrapi2.request.GetClansRequest.QUERY_PARAM_MIN_SCORE;
import static jcrapi2.request.GetClansRequest.QUERY_PARAM_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GetClansRequestTest extends PageableRequestTestBase {

  private static final String LOCATION_ID = "locationId";
  private static final String NAME = "name";

  private static final int MAX_MEMBERS = 10;
  private static final int MIN_MEMBERS = 1;
  private static final int MIN_SCORE = 50;

  @Test
  void build_whenWithNameAndNameIsEmptyChars_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> GetClansRequest.builder().name("").build());
  }

  @Test
  void build_whenWithNameAndNameIsOneChar_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> GetClansRequest.builder().name("a").build());
  }

  @Test
  void build_whenWithNameAndNameIsTwoChars_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> GetClansRequest.builder().name("ab").build());
  }

  @Test
  void build_whenWithNoSearchCriteria_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> GetClansRequest.builder().build());
  }

  @Test
  void build_whenWithName_thenShouldConstruct() throws Exception {
    assertNotNull(GetClansRequest.builder().name(NAME).build());
  }

  @Test
  void build_whenWithLocationId_thenShouldConstruct() throws Exception {
    assertNotNull(GetClansRequest.builder().locationId(LOCATION_ID).build());
  }

  @Test
  void build_whenWithNameAndLocationId_thenShouldConstruct() throws Exception {
    assertNotNull(GetClansRequest.builder().name(NAME).locationId(LOCATION_ID).build());
  }

  @Test
  void build_whenWithMinMembers_thenShouldConstruct() throws Exception {
    assertNotNull(GetClansRequest.builder().minMembers(1).build());
  }

  @Test
  void build_whenWithMaxMembers_thenShouldConstruct() throws Exception {
    assertNotNull(GetClansRequest.builder().maxMembers(1).build());
  }

  @Test
  void build_whenWithMinScore_thenShouldConstruct() throws Exception {
    assertNotNull(GetClansRequest.builder().minScore(1).build());
  }

  @Test
  void getQueryParameters_whenWithName_shouldHaveParameter() throws Exception {
    assertEquals(NAME, GetClansRequest.builder().name(NAME).build().getQueryParameters().get(QUERY_PARAM_NAME));
  }

  @Test
  void getQueryParameters_whenWithLocationId_shouldHaveParameter() throws Exception {
    assertEquals(LOCATION_ID,
        GetClansRequest.builder().locationId(LOCATION_ID).build().getQueryParameters().get(QUERY_PARAM_LOCATION_ID));
  }

  @Test
  void getQueryParameters_whenWithMinMembers_shouldHaveParameter() throws Exception {
    assertEquals(valueOf(MIN_MEMBERS),
        GetClansRequest.builder().minMembers(MIN_MEMBERS).build().getQueryParameters().get(QUERY_PARAM_MIN_MEMBERS));
  }

  @Test
  void getQueryParameters_whenWithMaxMembers_shouldHaveParameter() throws Exception {
    assertEquals(valueOf(MAX_MEMBERS),
        GetClansRequest.builder().maxMembers(MAX_MEMBERS).build().getQueryParameters().get(QUERY_PARAM_MAX_MEMBERS));
  }

  @Test
  void getQueryParameters_whenWithMinScore_shouldHaveParameter() throws Exception {
    assertEquals(valueOf(MIN_SCORE),
        GetClansRequest.builder().minScore(MIN_SCORE).build().getQueryParameters().get(QUERY_PARAM_MIN_SCORE));
  }

  @Override
  Object getBuilder() {
    return GetClansRequest.builder().minScore(1);
  }

}