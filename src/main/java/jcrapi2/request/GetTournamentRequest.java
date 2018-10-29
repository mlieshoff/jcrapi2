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

import java.util.List;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Michael Lieshoff
 */
@Getter
public class GetTournamentRequest extends PageableRequest {

  private final String tournamentTag;

  @Builder
  private GetTournamentRequest(int limit, String after, String before, String tournamentTag) {
    super(limit, after, before);
    this.tournamentTag = tournamentTag;
  }

  public static GetTournamentRequest.GetTournamentRequestBuilder builder(String tournamentTag) {
    return new GetTournamentRequest.GetTournamentRequestBuilder().tournamentTag(tournamentTag);
  }

  @Override
  public List<String> getRestParameters() {
    List<String> list = super.getRestParameters();
    list.add(tournamentTag);
    return list;
  }

}
