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
package jcrapi2.api.intern.locations.rankings.player;

import java.util.Map;
import jcrapi2.common.PaginationRequest;
import lombok.Builder;

public class PlayerRankingsRequest extends PaginationRequest {

  private final long locationId;

  @Builder
  private PlayerRankingsRequest(int limit, String after, String before, boolean storeRawResponse, long locationId) {
    super(limit, after, before, storeRawResponse);
    this.locationId = locationId;
  }

  public static PlayerRankingsRequestBuilder builder(long locationId) {
    return new PlayerRankingsRequestBuilder().locationId(locationId);
  }

  @Override
  public Map<String, Object> getRestParameters() {
    Map<String, Object> map = super.getRestParameters();
    map.put("locationId", locationId);
    return map;
  }

  @Override
  public Map<String, Object> getQueryParameters() {
    Map<String, Object> map = super.getQueryParameters();
    return map;
  }

}