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
class PlayerBattleLogOpponentTest {

  private PlayerBattleLogOpponent unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new PlayerBattleLogOpponent();
  }

  @Test
  void setCards_whenWithValidParameter_thenSetCards() {
    List<PlayerBattleLogOpponentCard> expected = new ArrayList<PlayerBattleLogOpponentCard>();
    unitUnderTest.setCards(expected);
    assertEquals(expected, unitUnderTest.getCards());
  }

  @Test
  void setClan_whenWithValidParameter_thenSetClan() {
    PlayerBattleLogOpponentClan expected = new PlayerBattleLogOpponentClan();
    unitUnderTest.setClan(expected);
    assertEquals(expected, unitUnderTest.getClan());
  }

  @Test
  void setCrowns_whenWithValidParameter_thenSetCrowns() {
    int expected = 815;
    unitUnderTest.setCrowns(expected);
    assertEquals(expected, unitUnderTest.getCrowns());
  }

  @Test
  void setKingTowerHitPoints_whenWithValidParameter_thenSetKingTowerHitPoints() {
    int expected = 815;
    unitUnderTest.setKingTowerHitPoints(expected);
    assertEquals(expected, unitUnderTest.getKingTowerHitPoints());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setPrincessTowersHitPoints_whenWithValidParameter_thenSetPrincessTowersHitPoints() {
    List<Integer> expected = new ArrayList<Integer>();
    unitUnderTest.setPrincessTowersHitPoints(expected);
    assertEquals(expected, unitUnderTest.getPrincessTowersHitPoints());
  }

  @Test
  void setStartingTrophies_whenWithValidParameter_thenSetStartingTrophies() {
    int expected = 815;
    unitUnderTest.setStartingTrophies(expected);
    assertEquals(expected, unitUnderTest.getStartingTrophies());
  }

  @Test
  void setTag_whenWithValidParameter_thenSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  void setTrophyChange_whenWithValidParameter_thenSetTrophyChange() {
    int expected = 815;
    unitUnderTest.setTrophyChange(expected);
    assertEquals(expected, unitUnderTest.getTrophyChange());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setCards(new ArrayList<PlayerBattleLogOpponentCard>());
    unitUnderTest.setClan(new PlayerBattleLogOpponentClan());
    unitUnderTest.setCrowns(815);
    unitUnderTest.setKingTowerHitPoints(815);
    unitUnderTest.setName("astring");
    unitUnderTest.setPrincessTowersHitPoints(new ArrayList<Integer>());
    unitUnderTest.setStartingTrophies(815);
    unitUnderTest.setTag("astring");
    unitUnderTest.setTrophyChange(815);
    String expected = "PlayerBattleLogOpponent(cards=" + new ArrayList<PlayerBattleLogOpponentCard>() + ", clan=" + new PlayerBattleLogOpponentClan() + ", crowns=815, kingTowerHitPoints=815, name=astring, princessTowersHitPoints=" + new ArrayList<Integer>() + ", startingTrophies=815, tag=astring, trophyChange=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}