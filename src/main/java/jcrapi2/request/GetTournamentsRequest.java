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

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Map;
import jcrapi2.response.Callback;
import jcrapi2.response.GetTournamentsResponse;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Michael Lieshoff
 */
@Getter
public class GetTournamentsRequest extends PageableRequest<GetTournamentsResponse> {

  static final String QUERY_PARAM_NAME = "name";

  private final String name;

  @Builder
  private GetTournamentsRequest(Callback<GetTournamentsResponse> callback, int limit, String after, String before, String name) {
    super(callback, limit, after, before);
    this.name = name;
  }

  public Map<String, String> getQueryParameters() {
    Map<String, String> map = super.getQueryParameters();
    if (isNotBlank(name)) {
      map.put(QUERY_PARAM_NAME, name);
    }
    return map;
  }

}
