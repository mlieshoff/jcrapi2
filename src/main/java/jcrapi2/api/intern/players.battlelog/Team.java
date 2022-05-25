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
package jcrapi2.api.intern.players.battlelog;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import lombok.Data;

@Data
public class Team {

  @SerializedName("tag")
  private String tag;
  @SerializedName("name")
  private String name;
  @SerializedName("startingTrophies")
  private int startingTrophies;
  @SerializedName("crowns")
  private int crowns;
  @SerializedName("trophyChange")
  private int trophyChange;
  @SerializedName("kingTowerHitPoints")
  private int kingTowerHitPoints;
  @SerializedName("princessTowersHitPoints")
  private List<Integer> princessTowersHitPoints;
  @SerializedName("clan")
  private Clan clan;
  @SerializedName("cards")
  private List<Card> cards;

}