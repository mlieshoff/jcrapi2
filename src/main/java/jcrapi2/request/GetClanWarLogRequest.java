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
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Michael Lieshoff
 */
@Getter
public class GetClanWarLogRequest extends PageableRequest {

  private final String clanTag;

  @Builder
  private GetClanWarLogRequest(int limit, String after, String before, String clanTag) {
    super(limit, after, before);
    checkNotNull(clanTag, "clanTag");
    checkArgument(!clanTag.isEmpty(), "clanTag");
    this.clanTag = clanTag;
  }

  public static GetClanWarLogRequest.GetClanWarLogRequestBuilder builder(String clanTag) {
    return new GetClanWarLogRequest.GetClanWarLogRequestBuilder().clanTag(clanTag);
  }

  @Override
  public List<String> getRestParameters() {
    List<String> list = super.getRestParameters();
    list.add(clanTag);
    return list;
  }

}
