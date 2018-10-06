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

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Michael Lieshoff
 */
@Getter
public class GetClansRequest extends PageableRequest {

  static final String QUERY_PARAM_NAME = "name";
  static final String QUERY_PARAM_LOCATION_ID = "locationId";
  static final String QUERY_PARAM_MIN_MEMBERS = "minMembers";
  static final String QUERY_PARAM_MAX_MEMBERS = "maxMembers";
  static final String QUERY_PARAM_MIN_SCORE = "minScore";

  private final String name;
  private final String locationId;

  private final int minMembers;
  private final int maxMembers;
  private final int minScore;

  @Builder
  private GetClansRequest(int limit, String after, String before, String name, String locationId, int minMembers,
                          int maxMembers, int minScore) {
    super(limit, after, before);
    if (name != null) {
      checkArgument(isNotEmpty(name));
      checkArgument(name.length() > 2);
    }
    this.name = name;
    this.locationId = locationId;
    this.minMembers = minMembers;
    this.maxMembers = maxMembers;
    this.minScore = minScore;
    checkAtLeastOneCriteriaIsSet();
  }

  private void checkAtLeastOneCriteriaIsSet() {
    if (isBlank(name) && isBlank(locationId) && minMembers == 0 && maxMembers == 0 && minScore == 0) {
      throw new IllegalArgumentException("at least one search criteria has to be set!");
    }
  }

  public Map<String, String> getQueryParameters() {
    Map<String, String> map = super.getQueryParameters();
    if (maxMembers > 0) {
      map.put(QUERY_PARAM_MAX_MEMBERS, valueOf(maxMembers));
    }
    if (minMembers > 0) {
      map.put(QUERY_PARAM_MIN_MEMBERS, valueOf(minMembers));
    }
    if (minScore > 0) {
      map.put(QUERY_PARAM_MIN_SCORE, valueOf(minScore));
    }
    if (isNotBlank(locationId)) {
      map.put(QUERY_PARAM_LOCATION_ID, locationId);
    }
    if (isNotBlank(name)) {
      map.put(QUERY_PARAM_NAME, name);
    }
    return map;
  }

}
