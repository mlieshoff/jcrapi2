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
class ClanRiverRaceLogStandingClanTest {

  private ClanRiverRaceLogStandingClan unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new ClanRiverRaceLogStandingClan();
  }

  @Test
  void setBadgeId_whenWithValidParameter_thenSetBadgeId() {
    int expected = 815;
    unitUnderTest.setBadgeId(expected);
    assertEquals(expected, unitUnderTest.getBadgeId());
  }

  @Test
  void setClanScore_whenWithValidParameter_thenSetClanScore() {
    int expected = 815;
    unitUnderTest.setClanScore(expected);
    assertEquals(expected, unitUnderTest.getClanScore());
  }

  @Test
  void setFame_whenWithValidParameter_thenSetFame() {
    int expected = 815;
    unitUnderTest.setFame(expected);
    assertEquals(expected, unitUnderTest.getFame());
  }

  @Test
  void setFinishTime_whenWithValidParameter_thenSetFinishTime() {
    String expected = "astring";
    unitUnderTest.setFinishTime(expected);
    assertEquals(expected, unitUnderTest.getFinishTime());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setParticipants_whenWithValidParameter_thenSetParticipants() {
    List<ClanRiverRaceLogStandingClanParticipant> expected = new ArrayList<ClanRiverRaceLogStandingClanParticipant>();
    unitUnderTest.setParticipants(expected);
    assertEquals(expected, unitUnderTest.getParticipants());
  }

  @Test
  void setRepairPoints_whenWithValidParameter_thenSetRepairPoints() {
    int expected = 815;
    unitUnderTest.setRepairPoints(expected);
    assertEquals(expected, unitUnderTest.getRepairPoints());
  }

  @Test
  void setTag_whenWithValidParameter_thenSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setBadgeId(815);
    unitUnderTest.setClanScore(815);
    unitUnderTest.setFame(815);
    unitUnderTest.setFinishTime("astring");
    unitUnderTest.setName("astring");
    unitUnderTest.setParticipants(new ArrayList<ClanRiverRaceLogStandingClanParticipant>());
    unitUnderTest.setRepairPoints(815);
    unitUnderTest.setTag("astring");
    String expected = "ClanRiverRaceLogStandingClan(badgeId=815, clanScore=815, fame=815, finishTime=astring, name=astring, participants=" + new ArrayList<ClanRiverRaceLogStandingClanParticipant>() + ", repairPoints=815, tag=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}