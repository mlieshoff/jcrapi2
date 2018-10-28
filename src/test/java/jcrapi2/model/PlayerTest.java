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

import javax.annotation.Generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Generated("org.mili.generator")
class PlayerTest {

  private Player unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new Player();
  }

  @Test
  void setTag_whenWithValidParameter_thenSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setExpLevel_whenWithValidParameter_thenSetExpLevel() {
    int expected = 815;
    unitUnderTest.setExpLevel(expected);
    assertEquals(expected, unitUnderTest.getExpLevel());
  }

  @Test
  void setTrophies_whenWithValidParameter_thenSetTrophies() {
    int expected = 815;
    unitUnderTest.setTrophies(expected);
    assertEquals(expected, unitUnderTest.getTrophies());
  }

  @Test
  void setBestTrophies_whenWithValidParameter_thenSetBestTrophies() {
    int expected = 815;
    unitUnderTest.setBestTrophies(expected);
    assertEquals(expected, unitUnderTest.getBestTrophies());
  }

  @Test
  void setWins_whenWithValidParameter_thenSetWins() {
    int expected = 815;
    unitUnderTest.setWins(expected);
    assertEquals(expected, unitUnderTest.getWins());
  }

  @Test
  void setLosses_whenWithValidParameter_thenSetLosses() {
    int expected = 815;
    unitUnderTest.setLosses(expected);
    assertEquals(expected, unitUnderTest.getLosses());
  }

  @Test
  void setBattleCount_whenWithValidParameter_thenSetBattleCount() {
    int expected = 815;
    unitUnderTest.setBattleCount(expected);
    assertEquals(expected, unitUnderTest.getBattleCount());
  }

  @Test
  void setThreeCrownWins_whenWithValidParameter_thenSetThreeCrownWins() {
    int expected = 815;
    unitUnderTest.setThreeCrownWins(expected);
    assertEquals(expected, unitUnderTest.getThreeCrownWins());
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
  void setTournamentCardsWon_whenWithValidParameter_thenSetTournamentCardsWon() {
    int expected = 815;
    unitUnderTest.setTournamentCardsWon(expected);
    assertEquals(expected, unitUnderTest.getTournamentCardsWon());
  }

  @Test
  void setTournamentBattleCount_whenWithValidParameter_thenSetTournamentBattleCount() {
    int expected = 815;
    unitUnderTest.setTournamentBattleCount(expected);
    assertEquals(expected, unitUnderTest.getTournamentBattleCount());
  }

  @Test
  void setRole_whenWithValidParameter_thenSetRole() {
    String expected = "astring";
    unitUnderTest.setRole(expected);
    assertEquals(expected, unitUnderTest.getRole());
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
  void setTotalDonations_whenWithValidParameter_thenSetTotalDonations() {
    int expected = 815;
    unitUnderTest.setTotalDonations(expected);
    assertEquals(expected, unitUnderTest.getTotalDonations());
  }

  @Test
  void setWarDayWins_whenWithValidParameter_thenSetWarDayWins() {
    int expected = 815;
    unitUnderTest.setWarDayWins(expected);
    assertEquals(expected, unitUnderTest.getWarDayWins());
  }

  @Test
  void setClanCardsCollected_whenWithValidParameter_thenSetClanCardsCollected() {
    int expected = 815;
    unitUnderTest.setClanCardsCollected(expected);
    assertEquals(expected, unitUnderTest.getClanCardsCollected());
  }

  @Test
  void setClan_whenWithValidParameter_thenSetClan() {
    PlayerClan expected = new PlayerClan();
    unitUnderTest.setClan(expected);
    assertEquals(expected, unitUnderTest.getClan());
  }

  @Test
  void setArena_whenWithValidParameter_thenSetArena() {
    PlayerArena expected = new PlayerArena();
    unitUnderTest.setArena(expected);
    assertEquals(expected, unitUnderTest.getArena());
  }

  @Test
  void setAchievements_whenWithValidParameter_thenSetAchievements() {
    java.util.List<PlayerAchievment> expected = new java.util.ArrayList<PlayerAchievment>();
    unitUnderTest.setAchievements(expected);
    assertEquals(expected, unitUnderTest.getAchievements());
  }

  @Test
  void setCards_whenWithValidParameter_thenSetCards() {
    java.util.List<PlayerCard> expected = new java.util.ArrayList<PlayerCard>();
    unitUnderTest.setCards(expected);
    assertEquals(expected, unitUnderTest.getCards());
  }

  @Test
  void setPlayerCurrentFavouriteCard_whenWithValidParameter_thenSetPlayerCurrentFavouriteCard() {
    PlayerCurrentFavouriteCard expected = new PlayerCurrentFavouriteCard();
    unitUnderTest.setPlayerCurrentFavouriteCard(expected);
    assertEquals(expected, unitUnderTest.getPlayerCurrentFavouriteCard());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setTag("astring");
    unitUnderTest.setName("astring");
    unitUnderTest.setExpLevel(815);
    unitUnderTest.setTrophies(815);
    unitUnderTest.setBestTrophies(815);
    unitUnderTest.setWins(815);
    unitUnderTest.setLosses(815);
    unitUnderTest.setBattleCount(815);
    unitUnderTest.setThreeCrownWins(815);
    unitUnderTest.setChallengeCardsWon(815);
    unitUnderTest.setChallengeMaxWins(815);
    unitUnderTest.setTournamentCardsWon(815);
    unitUnderTest.setTournamentBattleCount(815);
    unitUnderTest.setRole("astring");
    unitUnderTest.setDonations(815);
    unitUnderTest.setDonationsReceived(815);
    unitUnderTest.setTotalDonations(815);
    unitUnderTest.setWarDayWins(815);
    unitUnderTest.setClanCardsCollected(815);
    unitUnderTest.setClan(new PlayerClan());
    unitUnderTest.setArena(new PlayerArena());
    unitUnderTest.setAchievements(new java.util.ArrayList<PlayerAchievment>());
    unitUnderTest.setCards(new java.util.ArrayList<PlayerCard>());
    unitUnderTest.setPlayerCurrentFavouriteCard(new PlayerCurrentFavouriteCard());
    String expected = "Player(tag=astring, name=astring, expLevel=815, trophies=815, bestTrophies=815, wins=815, losses=815, battleCount=815, threeCrownWins=815, challengeCardsWon=815, challengeMaxWins=815, tournamentCardsWon=815, tournamentBattleCount=815, role=astring, donations=815, donationsReceived=815, totalDonations=815, warDayWins=815, clanCardsCollected=815, clan=" + new PlayerClan() + ", arena=" + new PlayerArena() + ", achievements=" + new java.util.ArrayList<PlayerAchievment>() + ", cards=" + new java.util.ArrayList<PlayerCard>() + ", playerCurrentFavouriteCard=" + new PlayerCurrentFavouriteCard() + ")";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}