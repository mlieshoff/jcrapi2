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
class ClanTest {

  private Clan unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new Clan();
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
  void setType_whenWithValidParameter_thenSetType() {
    String expected = "astring";
    unitUnderTest.setType(expected);
    assertEquals(expected, unitUnderTest.getType());
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
  void setLocation_whenWithValidParameter_thenSetLocation() {
    ClanLocation expected = new ClanLocation();
    unitUnderTest.setLocation(expected);
    assertEquals(expected, unitUnderTest.getLocation());
  }

  @Test
  void setRequiredTrophies_whenWithValidParameter_thenSetRequiredTrophies() {
    int expected = 815;
    unitUnderTest.setRequiredTrophies(expected);
    assertEquals(expected, unitUnderTest.getRequiredTrophies());
  }

  @Test
  void setDonationsPerWeek_whenWithValidParameter_thenSetDonationsPerWeek() {
    int expected = 815;
    unitUnderTest.setDonationsPerWeek(expected);
    assertEquals(expected, unitUnderTest.getDonationsPerWeek());
  }

  @Test
  void setClanChestStatus_whenWithValidParameter_thenSetClanChestStatus() {
    String expected = "astring";
    unitUnderTest.setClanChestStatus(expected);
    assertEquals(expected, unitUnderTest.getClanChestStatus());
  }

  @Test
  void setClanChestLevel_whenWithValidParameter_thenSetClanChestLevel() {
    int expected = 815;
    unitUnderTest.setClanChestLevel(expected);
    assertEquals(expected, unitUnderTest.getClanChestLevel());
  }

  @Test
  void setClanChestMaxLevel_whenWithValidParameter_thenSetClanChestMaxLevel() {
    int expected = 815;
    unitUnderTest.setClanChestMaxLevel(expected);
    assertEquals(expected, unitUnderTest.getClanChestMaxLevel());
  }

  @Test
  void setMembers_whenWithValidParameter_thenSetMembers() {
    int expected = 815;
    unitUnderTest.setMembers(expected);
    assertEquals(expected, unitUnderTest.getMembers());
  }

  @Test
  void setMemberList_whenWithValidParameter_thenSetMemberList() {
    java.util.List<ClanMember> expected = new java.util.ArrayList<ClanMember>();
    unitUnderTest.setMemberList(expected);
    assertEquals(expected, unitUnderTest.getMemberList());
  }

  @Test
  void setDescription_whenWithValidParameter_thenSetDescription() {
    String expected = "astring";
    unitUnderTest.setDescription(expected);
    assertEquals(expected, unitUnderTest.getDescription());
  }

  @Test
  void setClanChestPoints_whenWithValidParameter_thenSetClanChestPoints() {
    int expected = 815;
    unitUnderTest.setClanChestPoints(expected);
    assertEquals(expected, unitUnderTest.getClanChestPoints());
  }

  @Test
  void setClanWarTrophies_whenWithValidParameter_thenSetClanWarTrophies() {
    int expected = 815;
    unitUnderTest.setClanWarTrophies(expected);
    assertEquals(expected, unitUnderTest.getClanWarTrophies());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setTag("astring");
    unitUnderTest.setName("astring");
    unitUnderTest.setType("astring");
    unitUnderTest.setBadgeId(815);
    unitUnderTest.setClanScore(815);
    unitUnderTest.setLocation(new ClanLocation());
    unitUnderTest.setRequiredTrophies(815);
    unitUnderTest.setDonationsPerWeek(815);
    unitUnderTest.setClanChestStatus("astring");
    unitUnderTest.setClanChestLevel(815);
    unitUnderTest.setClanChestMaxLevel(815);
    unitUnderTest.setMembers(815);
    unitUnderTest.setMemberList(new java.util.ArrayList<ClanMember>());
    unitUnderTest.setDescription("astring");
    unitUnderTest.setClanChestPoints(815);
    unitUnderTest.setClanWarTrophies(815);
    String expected = "Clan(tag=astring, name=astring, type=astring, badgeId=815, clanScore=815, location=" + new ClanLocation() + ", requiredTrophies=815, donationsPerWeek=815, clanChestStatus=astring, clanChestLevel=815, clanChestMaxLevel=815, members=815, memberList=" + new java.util.ArrayList<ClanMember>() + ", description=astring, clanChestPoints=815, clanWarTrophies=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}