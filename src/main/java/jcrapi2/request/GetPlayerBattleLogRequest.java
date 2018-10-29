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
import jcrapi2.response.Callback;
import jcrapi2.response.GetPlayerBattleLogResponse;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Michael Lieshoff
 */
@Getter
public class GetPlayerBattleLogRequest extends Request<GetPlayerBattleLogResponse> {

  private final String playerTag;

  @Builder
  private GetPlayerBattleLogRequest(Callback<GetPlayerBattleLogResponse> callback, String playerTag) {
    super(callback);
    checkNotNull(playerTag);
    checkArgument(!playerTag.isEmpty());
    this.playerTag = playerTag;
  }

  public static GetPlayerBattleLogRequest.GetPlayerBattleLogRequestBuilder builder(String clanTag) {
    return new GetPlayerBattleLogRequest.GetPlayerBattleLogRequestBuilder().playerTag(clanTag);
  }

  @Override
  public List<String> getRestParameters() {
    List<String> list = super.getRestParameters();
    list.add(playerTag);
    return list;
  }

}
