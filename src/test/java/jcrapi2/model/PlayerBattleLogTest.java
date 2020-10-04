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
class PlayerBattleLogTest {

  private PlayerBattleLog unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new PlayerBattleLog();
  }

  @Test
  void setArena_whenWithValidParameter_thenSetArena() {
    PlayerBattleLogArena expected = new PlayerBattleLogArena();
    unitUnderTest.setArena(expected);
    assertEquals(expected, unitUnderTest.getArena());
  }

  @Test
  void setBattleTime_whenWithValidParameter_thenSetBattleTime() {
    String expected = "astring";
    unitUnderTest.setBattleTime(expected);
    assertEquals(expected, unitUnderTest.getBattleTime());
  }

  @Test
  void setChallengeId_whenWithValidParameter_thenSetChallengeId() {
    int expected = 815;
    unitUnderTest.setChallengeId(expected);
    assertEquals(expected, unitUnderTest.getChallengeId());
  }

  @Test
  void setChallengeTitle_whenWithValidParameter_thenSetChallengeTitle() {
    String expected = "astring";
    unitUnderTest.setChallengeTitle(expected);
    assertEquals(expected, unitUnderTest.getChallengeTitle());
  }

  @Test
  void setChallengeWinCountBefore_whenWithValidParameter_thenSetChallengeWinCountBefore() {
    int expected = 815;
    unitUnderTest.setChallengeWinCountBefore(expected);
    assertEquals(expected, unitUnderTest.getChallengeWinCountBefore());
  }

  @Test
  void setDeckSelection_whenWithValidParameter_thenSetDeckSelection() {
    String expected = "astring";
    unitUnderTest.setDeckSelection(expected);
    assertEquals(expected, unitUnderTest.getDeckSelection());
  }

  @Test
  void setGameMode_whenWithValidParameter_thenSetGameMode() {
    PlayerBattleLogGameMode expected = new PlayerBattleLogGameMode();
    unitUnderTest.setGameMode(expected);
    assertEquals(expected, unitUnderTest.getGameMode());
  }

  @Test
  void setLadderTournament_whenWithValidParameter_thenSetLadderTournament() {
    boolean expected = false;
    unitUnderTest.setLadderTournament(expected);
    assertEquals(expected, unitUnderTest.isLadderTournament());
  }

  @Test
  void setOpponent_whenWithValidParameter_thenSetOpponent() {
    List<PlayerBattleLogOpponent> expected = new ArrayList<PlayerBattleLogOpponent>();
    unitUnderTest.setOpponent(expected);
    assertEquals(expected, unitUnderTest.getOpponent());
  }

  @Test
  void setTeam_whenWithValidParameter_thenSetTeam() {
    List<PlayerBattleLogTeam> expected = new ArrayList<PlayerBattleLogTeam>();
    unitUnderTest.setTeam(expected);
    assertEquals(expected, unitUnderTest.getTeam());
  }

  @Test
  void setType_whenWithValidParameter_thenSetType() {
    String expected = "astring";
    unitUnderTest.setType(expected);
    assertEquals(expected, unitUnderTest.getType());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setArena(new PlayerBattleLogArena());
    unitUnderTest.setBattleTime("astring");
    unitUnderTest.setChallengeId(815);
    unitUnderTest.setChallengeTitle("astring");
    unitUnderTest.setChallengeWinCountBefore(815);
    unitUnderTest.setDeckSelection("astring");
    unitUnderTest.setGameMode(new PlayerBattleLogGameMode());
    unitUnderTest.setLadderTournament(false);
    unitUnderTest.setOpponent(new ArrayList<PlayerBattleLogOpponent>());
    unitUnderTest.setTeam(new ArrayList<PlayerBattleLogTeam>());
    unitUnderTest.setType("astring");
    String expected = "PlayerBattleLog(arena=" + new PlayerBattleLogArena() + ", battleTime=astring, challengeId=815, challengeTitle=astring, challengeWinCountBefore=815, deckSelection=astring, gameMode=" + new PlayerBattleLogGameMode() + ", LadderTournament=false, opponent=" + new ArrayList<PlayerBattleLogOpponent>() + ", team=" + new ArrayList<PlayerBattleLogTeam>() + ", type=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}