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

class GetLocationClanWarRankingsRequestTest extends PageableRequestTestBase<GetLocationClanWarRankingsRequest> {

  private static final String LOCATION_ID = "locationId";

  @Test
  void build_whenWithNullNullLocationId_thenThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> GetLocationClanWarRankingsRequest.builder(null).build());
  }

  @Test
  void build_whenWithEmptyLocationId_thenThrowException() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> GetLocationClanWarRankingsRequest.builder("").build());
  }

  @Test
  void build_whenWithLocationId_thenSetValue() throws Exception {
    assertEquals(LOCATION_ID, GetLocationClanWarRankingsRequest.builder(LOCATION_ID).build().getLocationId());
  }

  @Test
  void build_whenWithLocationId_thenHaveRestParameter() throws Exception {
    assertEquals(singletonList(LOCATION_ID),
        GetLocationClanWarRankingsRequest.builder(LOCATION_ID).build().getRestParameters());
  }

  @Override
  Object getBuilder() {
    return GetLocationClanWarRankingsRequest.builder(LOCATION_ID);
  }

}