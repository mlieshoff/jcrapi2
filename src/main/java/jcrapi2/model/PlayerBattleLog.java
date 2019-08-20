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
package jcrapi2.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated("org.mili.generator")
@Getter
@Setter
@ToString
public class PlayerBattleLog {

  @SerializedName("type")
  private String type;

  @SerializedName("battleTime")
  private String battleTime;

  @SerializedName("arena")
  private PlayerBattleLogArena arena;

  @SerializedName("gameMode")
  private PlayerBattleLogGameMode gameMode;

  @SerializedName("deckSelection")
  private String deckSelection;

  @SerializedName("team")
  private java.util.List<PlayerBattleLogTeam> team;

  @SerializedName("opponent")
  private java.util.List<PlayerBattleLogOpponent> opponent;

  @SerializedName("challengeId")
  private int challengeId;

  @SerializedName("challengeWinCountBefore")
  private int challengeWinCountBefore;

  @SerializedName("challengeTitle")
  private String challengeTitle;

  @SerializedName("isLadderTournament")
  private boolean LadderTournament;

}