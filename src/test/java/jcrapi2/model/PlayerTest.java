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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.mili.generator")
class PlayerTest {

  private Player unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new Player();
  }

  @Test
  void setAchievements_whenWithValidParameter_thenSetAchievements() {
    List<PlayerAchievment> expected = new ArrayList<PlayerAchievment>();
    unitUnderTest.setAchievements(expected);
    assertEquals(expected, unitUnderTest.getAchievements());
  }

  @Test
  void setArena_whenWithValidParameter_thenSetArena() {
    PlayerArena expected = new PlayerArena();
    unitUnderTest.setArena(expected);
    assertEquals(expected, unitUnderTest.getArena());
  }

  @Test
  void setBadges_whenWithValidParameter_thenSetBadges() {
    List<PlayerBadge> expected = new ArrayList<PlayerBadge>();
    unitUnderTest.setBadges(expected);
    assertEquals(expected, unitUnderTest.getBadges());
  }

  @Test
  void setBattleCount_whenWithValidParameter_thenSetBattleCount() {
    int expected = 815;
    unitUnderTest.setBattleCount(expected);
    assertEquals(expected, unitUnderTest.getBattleCount());
  }

  @Test
  void setBestTrophies_whenWithValidParameter_thenSetBestTrophies() {
    int expected = 815;
    unitUnderTest.setBestTrophies(expected);
    assertEquals(expected, unitUnderTest.getBestTrophies());
  }

  @Test
  void setCards_whenWithValidParameter_thenSetCards() {
    List<PlayerCard> expected = new ArrayList<PlayerCard>();
    unitUnderTest.setCards(expected);
    assertEquals(expected, unitUnderTest.getCards());
  }

  @Test
  void setChallengeCardsWon_whenWithValidParameter_thenSetChallengeCardsWon() {
    int expected = 815;
    unitUnderTest.setChallengeCardsWon(expected);
    assertEquals(expected, unitUnderTest.getChallengeCardsWon());
  }

  @Test
  void setChallengeMaxWins_whenWithValidParameter_thenSetChallengeMaxWins() {
    int expected = 815;
    unitUnderTest.setChallengeMaxWins(expected);
    assertEquals(expected, unitUnderTest.getChallengeMaxWins());
  }

  @Test
  void setClan_whenWithValidParameter_thenSetClan() {
    PlayerClan expected = new PlayerClan();
    unitUnderTest.setClan(expected);
    assertEquals(expected, unitUnderTest.getClan());
  }

  @Test
  void setClanCardsCollected_whenWithValidParameter_thenSetClanCardsCollected() {
    int expected = 815;
    unitUnderTest.setClanCardsCollected(expected);
    assertEquals(expected, unitUnderTest.getClanCardsCollected());
  }

  @Test
  void setCurrentDeck_whenWithValidParameter_thenSetCurrentDeck() {
    List<PlayerCurrentDeckCard> expected = new ArrayList<PlayerCurrentDeckCard>();
    unitUnderTest.setCurrentDeck(expected);
    assertEquals(expected, unitUnderTest.getCurrentDeck());
  }

  @Test
  void setCurrentFavouriteCard_whenWithValidParameter_thenSetCurrentFavouriteCard() {
    PlayerCurrentFavouriteCard expected = new PlayerCurrentFavouriteCard();
    unitUnderTest.setCurrentFavouriteCard(expected);
    assertEquals(expected, unitUnderTest.getCurrentFavouriteCard());
  }

  @Test
  void setDonations_whenWithValidParameter_thenSetDonations() {
    int expected = 815;
    unitUnderTest.setDonations(expected);
    assertEquals(expected, unitUnderTest.getDonations());
  }

  @Test
  void setDonationsReceived_whenWithValidParameter_thenSetDonationsReceived() {
    int expected = 815;
    unitUnderTest.setDonationsReceived(expected);
    assertEquals(expected, unitUnderTest.getDonationsReceived());
  }

  @Test
  void setExpLevel_whenWithValidParameter_thenSetExpLevel() {
    int expected = 815;
    unitUnderTest.setExpLevel(expected);
    assertEquals(expected, unitUnderTest.getExpLevel());
  }

  @Test
  void setLeagueStatistics_whenWithValidParameter_thenSetLeagueStatistics() {
    PlayerLeagueStatistics expected = new PlayerLeagueStatistics();
    unitUnderTest.setLeagueStatistics(expected);
    assertEquals(expected, unitUnderTest.getLeagueStatistics());
  }

  @Test
  void setLosses_whenWithValidParameter_thenSetLosses() {
    int expected = 815;
    unitUnderTest.setLosses(expected);
    assertEquals(expected, unitUnderTest.getLosses());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setRole_whenWithValidParameter_thenSetRole() {
    String expected = "astring";
    unitUnderTest.setRole(expected);
    assertEquals(expected, unitUnderTest.getRole());
  }

  @Test
  void setStarPoints_whenWithValidParameter_thenSetStarPoints() {
    int expected = 815;
    unitUnderTest.setStarPoints(expected);
    assertEquals(expected, unitUnderTest.getStarPoints());
  }

  @Test
  void setTag_whenWithValidParameter_thenSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  void setThreeCrownWins_whenWithValidParameter_thenSetThreeCrownWins() {
    int expected = 815;
    unitUnderTest.setThreeCrownWins(expected);
    assertEquals(expected, unitUnderTest.getThreeCrownWins());
  }

  @Test
  void setTotalDonations_whenWithValidParameter_thenSetTotalDonations() {
    int expected = 815;
    unitUnderTest.setTotalDonations(expected);
    assertEquals(expected, unitUnderTest.getTotalDonations());
  }

  @Test
  void setTournamentBattleCount_whenWithValidParameter_thenSetTournamentBattleCount() {
    int expected = 815;
    unitUnderTest.setTournamentBattleCount(expected);
    assertEquals(expected, unitUnderTest.getTournamentBattleCount());
  }

  @Test
  void setTournamentCardsWon_whenWithValidParameter_thenSetTournamentCardsWon() {
    int expected = 815;
    unitUnderTest.setTournamentCardsWon(expected);
    assertEquals(expected, unitUnderTest.getTournamentCardsWon());
  }

  @Test
  void setTrophies_whenWithValidParameter_thenSetTrophies() {
    int expected = 815;
    unitUnderTest.setTrophies(expected);
    assertEquals(expected, unitUnderTest.getTrophies());
  }

  @Test
  void setWarDayWins_whenWithValidParameter_thenSetWarDayWins() {
    int expected = 815;
    unitUnderTest.setWarDayWins(expected);
    assertEquals(expected, unitUnderTest.getWarDayWins());
  }

  @Test
  void setWins_whenWithValidParameter_thenSetWins() {
    int expected = 815;
    unitUnderTest.setWins(expected);
    assertEquals(expected, unitUnderTest.getWins());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setAchievements(new ArrayList<PlayerAchievment>());
    unitUnderTest.setArena(new PlayerArena());
    unitUnderTest.setBadges(new ArrayList<PlayerBadge>());
    unitUnderTest.setBattleCount(815);
    unitUnderTest.setBestTrophies(815);
    unitUnderTest.setCards(new ArrayList<PlayerCard>());
    unitUnderTest.setChallengeCardsWon(815);
    unitUnderTest.setChallengeMaxWins(815);
    unitUnderTest.setClan(new PlayerClan());
    unitUnderTest.setClanCardsCollected(815);
    unitUnderTest.setCurrentDeck(new ArrayList<PlayerCurrentDeckCard>());
    unitUnderTest.setCurrentFavouriteCard(new PlayerCurrentFavouriteCard());
    unitUnderTest.setDonations(815);
    unitUnderTest.setDonationsReceived(815);
    unitUnderTest.setExpLevel(815);
    unitUnderTest.setLeagueStatistics(new PlayerLeagueStatistics());
    unitUnderTest.setLosses(815);
    unitUnderTest.setName("astring");
    unitUnderTest.setRole("astring");
    unitUnderTest.setStarPoints(815);
    unitUnderTest.setTag("astring");
    unitUnderTest.setThreeCrownWins(815);
    unitUnderTest.setTotalDonations(815);
    unitUnderTest.setTournamentBattleCount(815);
    unitUnderTest.setTournamentCardsWon(815);
    unitUnderTest.setTrophies(815);
    unitUnderTest.setWarDayWins(815);
    unitUnderTest.setWins(815);
    String expected = "Player(achievements=" + new ArrayList<PlayerAchievment>() + ", arena=" + new PlayerArena() + ", badges=" + new ArrayList<PlayerBadge>() + ", battleCount=815, bestTrophies=815, cards=" + new ArrayList<PlayerCard>() + ", challengeCardsWon=815, challengeMaxWins=815, clan=" + new PlayerClan() + ", clanCardsCollected=815, currentDeck=" + new ArrayList<PlayerCurrentDeckCard>() + ", currentFavouriteCard=" + new PlayerCurrentFavouriteCard() + ", donations=815, donationsReceived=815, expLevel=815, leagueStatistics=" + new PlayerLeagueStatistics() + ", losses=815, name=astring, role=astring, starPoints=815, tag=astring, threeCrownWins=815, totalDonations=815, tournamentBattleCount=815, tournamentCardsWon=815, trophies=815, warDayWins=815, wins=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}