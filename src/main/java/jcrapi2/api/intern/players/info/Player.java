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
package jcrapi2.api.intern.players.info;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.util.List;

@Data
public class Player {

    @SerializedName("name")
    private String name;

    @SerializedName("expLevel")
    private int expLevel;

    @SerializedName("trophies")
    private int trophies;

    @SerializedName("bestTrophies")
    private int bestTrophies;

    @SerializedName("wins")
    private int wins;

    @SerializedName("losses")
    private int losses;

    @SerializedName("battleCount")
    private int battleCount;

    @SerializedName("threeCrownWins")
    private int threeCrownWins;

    @SerializedName("challengeCardsWon")
    private int challengeCardsWon;

    @SerializedName("challengeMaxWins")
    private int challengeMaxWins;

    @SerializedName("tag")
    private String tag;

    @SerializedName("tournamentCardsWon")
    private int tournamentCardsWon;

    @SerializedName("tournamentBattleCount")
    private int tournamentBattleCount;

    @SerializedName("role")
    private String role;

    @SerializedName("donations")
    private int donations;

    @SerializedName("donationsReceived")
    private int donationsReceived;

    @SerializedName("totalDonations")
    private int totalDonations;

    @SerializedName("warDayWins")
    private int warDayWins;

    @SerializedName("clanCardsCollected")
    private int clanCardsCollected;

    @SerializedName("starPoints")
    private int starPoints;

    @SerializedName("expPoints")
    private int expPoints;

    @SerializedName("totalExpPoints")
    private int totalExpPoints;

    @SerializedName("clan")
    private Clan clan;

    @SerializedName("arena")
    private Arena arena;

    @SerializedName("leagueStatistics")
    private LeagueStatistics leagueStatistics;

    @SerializedName("badges")
    private List<Badge> badges;

    @SerializedName("achievements")
    private List<Achievment> achievements;

    @SerializedName("cards")
    private List<Card> cards;

    @SerializedName("currentDeck")
    private List<CurrentDeck> currentDeck;

    @SerializedName("currentFavouriteCard")
    private CurrentFavouriteCard currentFavouriteCard;

    @SerializedName("legacyTrophyRoadHighScore")
    private int legacyTrophyRoadHighScore;

    @SerializedName("currentPathOfLegendSeasonResult")
    private PathOfLegendSeasonResult currentPathOfLegendSeasonResult;

    @SerializedName("lastPathOfLegendSeasonResult")
    private PathOfLegendSeasonResult lastPathOfLegendSeasonResult;

    @SerializedName("bestPathOfLegendSeasonResult")
    private PathOfLegendSeasonResult bestPathOfLegendSeasonResult;

    @SerializedName("supportCards")
    private List<SupportCard> supportCards;

    @SerializedName("currentDeckSupportCards")
    private List<CurrentDeckSupportCard> currentDeckSupportCards;

    @SerializedName("progress")
    private Progress progress;
}
