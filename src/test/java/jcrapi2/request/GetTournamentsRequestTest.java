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

import static jcrapi2.request.GetClansRequest.QUERY_PARAM_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GetTournamentsRequestTest extends PageableRequestTestBase<GetTournamentsRequest> {

  private static final String NAME = "name";

  @Test
  void build_whenWithName_thenSetValue() throws Exception {
    assertEquals(NAME, GetTournamentsRequest.builder().name(NAME).build().getName());
  }

  @Test
  void getQueryParameters_whenWithName_thenHaveParameter() throws Exception {
    assertEquals(NAME, GetTournamentsRequest.builder().name(NAME).build().getQueryParameters().get(QUERY_PARAM_NAME));
  }

  @Override
  Object getBuilder() {
    return GetClansRequest.builder().minScore(1);
  }

}