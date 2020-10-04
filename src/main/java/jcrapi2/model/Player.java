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

import com.google.gson.annotations.SerializedName;

import java.util.List;
import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated("org.mili.generator")
@Getter
@Setter
@ToString
public class Player {

  @SerializedName("achievements")
  private List<PlayerAchievment> achievements;

  @SerializedName("arena")
  private PlayerArena arena;

  @SerializedName("badges")
  private List<PlayerBadge> badges;

  @SerializedName("battleCount")
  private int battleCount;

  @SerializedName("bestTrophies")
  private int bestTrophies;

  @SerializedName("cards")
  private List<PlayerCard> cards;

  @SerializedName("challengeCardsWon")
  private int challengeCardsWon;

  @SerializedName("challengeMaxWins")
  private int challengeMaxWins;

  @SerializedName("clan")
  private PlayerClan clan;

  @SerializedName("clanCardsCollected")
  private int clanCardsCollected;

  @SerializedName("currentDeck")
  private List<PlayerCurrentDeckCard> currentDeck;

  @SerializedName("currentFavouriteCard")
  private PlayerCurrentFavouriteCard currentFavouriteCard;

  @SerializedName("donations")
  private int donations;

  @SerializedName("donationsReceived")
  private int donationsReceived;

  @SerializedName("expLevel")
  private int expLevel;

  @SerializedName("leagueStatistics")
  private PlayerLeagueStatistics leagueStatistics;

  @SerializedName("losses")
  private int losses;

  @SerializedName("name")
  private String name;

  @SerializedName("role")
  private String role;

  @SerializedName("starPoints")
  private int starPoints;

  @SerializedName("tag")
  private String tag;

  @SerializedName("threeCrownWins")
  private int threeCrownWins;

  @SerializedName("totalDonations")
  private int totalDonations;

  @SerializedName("tournamentBattleCount")
  private int tournamentBattleCount;

  @SerializedName("tournamentCardsWon")
  private int tournamentCardsWon;

  @SerializedName("trophies")
  private int trophies;

  @SerializedName("warDayWins")
  private int warDayWins;

  @SerializedName("wins")
  private int wins;

}