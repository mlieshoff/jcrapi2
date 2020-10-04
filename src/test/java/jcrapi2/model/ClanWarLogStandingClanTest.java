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
class ClanWarLogStandingClanTest {

  private ClanWarLogStandingClan unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new ClanWarLogStandingClan();
  }

  @Test
  void setBadgeId_whenWithValidParameter_thenSetBadgeId() {
    int expected = 815;
    unitUnderTest.setBadgeId(expected);
    assertEquals(expected, unitUnderTest.getBadgeId());
  }

  @Test
  void setBattlesPlayed_whenWithValidParameter_thenSetBattlesPlayed() {
    int expected = 815;
    unitUnderTest.setBattlesPlayed(expected);
    assertEquals(expected, unitUnderTest.getBattlesPlayed());
  }

  @Test
  void setClanScore_whenWithValidParameter_thenSetClanScore() {
    int expected = 815;
    unitUnderTest.setClanScore(expected);
    assertEquals(expected, unitUnderTest.getClanScore());
  }

  @Test
  void setCrowns_whenWithValidParameter_thenSetCrowns() {
    int expected = 815;
    unitUnderTest.setCrowns(expected);
    assertEquals(expected, unitUnderTest.getCrowns());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setParticipants_whenWithValidParameter_thenSetParticipants() {
    int expected = 815;
    unitUnderTest.setParticipants(expected);
    assertEquals(expected, unitUnderTest.getParticipants());
  }

  @Test
  void setTag_whenWithValidParameter_thenSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  void setWins_whenWithValidParameter_thenSetWins() {
    int expected = 815;
    unitUnderTest.setWins(expected);
    assertEquals(expected, unitUnderTest.getWins());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setBadgeId(815);
    unitUnderTest.setBattlesPlayed(815);
    unitUnderTest.setClanScore(815);
    unitUnderTest.setCrowns(815);
    unitUnderTest.setName("astring");
    unitUnderTest.setParticipants(815);
    unitUnderTest.setTag("astring");
    unitUnderTest.setWins(815);
    String expected = "ClanWarLogStandingClan(badgeId=815, battlesPlayed=815, clanScore=815, crowns=815, name=astring, participants=815, tag=astring, wins=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}