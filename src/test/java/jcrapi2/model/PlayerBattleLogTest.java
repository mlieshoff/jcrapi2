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
class PlayerBattleLogTest {

  private PlayerBattleLog unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new PlayerBattleLog();
  }

  @Test
  void setType_whenWithValidParameter_thenSetType() {
    String expected = "astring";
    unitUnderTest.setType(expected);
    assertEquals(expected, unitUnderTest.getType());
  }

  @Test
  void setBattleTime_whenWithValidParameter_thenSetBattleTime() {
    String expected = "astring";
    unitUnderTest.setBattleTime(expected);
    assertEquals(expected, unitUnderTest.getBattleTime());
  }

  @Test
  void setArena_whenWithValidParameter_thenSetArena() {
    PlayerBattleLogArena expected = new PlayerBattleLogArena();
    unitUnderTest.setArena(expected);
    assertEquals(expected, unitUnderTest.getArena());
  }

  @Test
  void setGameMode_whenWithValidParameter_thenSetGameMode() {
    PlayerBattleLogGameMode expected = new PlayerBattleLogGameMode();
    unitUnderTest.setGameMode(expected);
    assertEquals(expected, unitUnderTest.getGameMode());
  }

  @Test
  void setDeckSelection_whenWithValidParameter_thenSetDeckSelection() {
    String expected = "astring";
    unitUnderTest.setDeckSelection(expected);
    assertEquals(expected, unitUnderTest.getDeckSelection());
  }

  @Test
  void setTeam_whenWithValidParameter_thenSetTeam() {
    java.util.List<PlayerBattleLogTeam> expected = new java.util.ArrayList<PlayerBattleLogTeam>();
    unitUnderTest.setTeam(expected);
    assertEquals(expected, unitUnderTest.getTeam());
  }

  @Test
  void setOpponent_whenWithValidParameter_thenSetOpponent() {
    java.util.List<PlayerBattleLogOpponent> expected = new java.util.ArrayList<PlayerBattleLogOpponent>();
    unitUnderTest.setOpponent(expected);
    assertEquals(expected, unitUnderTest.getOpponent());
  }

  @Test
  void setChallengeId_whenWithValidParameter_thenSetChallengeId() {
    int expected = 815;
    unitUnderTest.setChallengeId(expected);
    assertEquals(expected, unitUnderTest.getChallengeId());
  }

  @Test
  void setChallengeWinCountBefore_whenWithValidParameter_thenSetChallengeWinCountBefore() {
    int expected = 815;
    unitUnderTest.setChallengeWinCountBefore(expected);
    assertEquals(expected, unitUnderTest.getChallengeWinCountBefore());
  }

  @Test
  void setChallengeTitle_whenWithValidParameter_thenSetChallengeTitle() {
    int expected = 815;
    unitUnderTest.setChallengeTitle(expected);
    assertEquals(expected, unitUnderTest.getChallengeTitle());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setType("astring");
    unitUnderTest.setBattleTime("astring");
    unitUnderTest.setArena(new PlayerBattleLogArena());
    unitUnderTest.setGameMode(new PlayerBattleLogGameMode());
    unitUnderTest.setDeckSelection("astring");
    unitUnderTest.setTeam(new java.util.ArrayList<PlayerBattleLogTeam>());
    unitUnderTest.setOpponent(new java.util.ArrayList<PlayerBattleLogOpponent>());
    unitUnderTest.setChallengeId(815);
    unitUnderTest.setChallengeWinCountBefore(815);
    unitUnderTest.setChallengeTitle(815);
    String expected = "PlayerBattleLog(type=astring, battleTime=astring, arena=" + new PlayerBattleLogArena() + ", gameMode=" + new PlayerBattleLogGameMode() + ", deckSelection=astring, team=" + new java.util.ArrayList<PlayerBattleLogTeam>() + ", opponent=" + new java.util.ArrayList<PlayerBattleLogOpponent>() + ", challengeId=815, challengeWinCountBefore=815, challengeTitle=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}