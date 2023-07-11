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
package jcrapi2.common;

import static jcrapi2.common.Utils.isNotBlank;

import java.util.Map;

public class PaginationRequest extends Request {

  static final String QUERY_PARAM_LIMIT = "limit";
  static final String QUERY_PARAM_AFTER = "after";
  static final String QUERY_PARAM_BEFORE = "before";

  private final int limit;

  private final String after;
  private final String before;

  protected PaginationRequest(int limit, String after, String before, boolean storeRawResponse) {
    super(storeRawResponse);
    this.limit = limit;
    this.after = after;
    this.before = before;
  }

  public Map<String, Object> getQueryParameters() {
    Map<String, Object> map = super.getQueryParameters();
    if (limit > 0) {
      map.put(QUERY_PARAM_LIMIT, String.valueOf(limit));
    }
    if (isNotBlank(after)) {
      map.put(QUERY_PARAM_AFTER, after);
    }
    if (isNotBlank(before)) {
      map.put(QUERY_PARAM_BEFORE, before);
    }
    return map;
  }

}


