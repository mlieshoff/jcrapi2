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

import javax.annotation.Generated;

@Generated("org.mili.generator")
class SearchedClanTest {

  private SearchedClan unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new SearchedClan();
  }

  @Test
  void setBadgeId_whenWithValidParameter_thenSetBadgeId() {
    int expected = 815;
    unitUnderTest.setBadgeId(expected);
    assertEquals(expected, unitUnderTest.getBadgeId());
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
  void setClanScore_whenWithValidParameter_thenSetClanScore() {
    int expected = 815;
    unitUnderTest.setClanScore(expected);
    assertEquals(expected, unitUnderTest.getClanScore());
  }

  @Test
  void setClanWarTrophies_whenWithValidParameter_thenSetClanWarTrophies() {
    int expected = 815;
    unitUnderTest.setClanWarTrophies(expected);
    assertEquals(expected, unitUnderTest.getClanWarTrophies());
  }

  @Test
  void setDonationsPerWeek_whenWithValidParameter_thenSetDonationsPerWeek() {
    int expected = 815;
    unitUnderTest.setDonationsPerWeek(expected);
    assertEquals(expected, unitUnderTest.getDonationsPerWeek());
  }

  @Test
  void setLocation_whenWithValidParameter_thenSetLocation() {
    SearchedClanLocation expected = new SearchedClanLocation();
    unitUnderTest.setLocation(expected);
    assertEquals(expected, unitUnderTest.getLocation());
  }

  @Test
  void setMembers_whenWithValidParameter_thenSetMembers() {
    int expected = 815;
    unitUnderTest.setMembers(expected);
    assertEquals(expected, unitUnderTest.getMembers());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setRequiredTrophies_whenWithValidParameter_thenSetRequiredTrophies() {
    int expected = 815;
    unitUnderTest.setRequiredTrophies(expected);
    assertEquals(expected, unitUnderTest.getRequiredTrophies());
  }

  @Test
  void setTag_whenWithValidParameter_thenSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  void setType_whenWithValidParameter_thenSetType() {
    String expected = "astring";
    unitUnderTest.setType(expected);
    assertEquals(expected, unitUnderTest.getType());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setBadgeId(815);
    unitUnderTest.setClanChestLevel(815);
    unitUnderTest.setClanChestMaxLevel(815);
    unitUnderTest.setClanScore(815);
    unitUnderTest.setClanWarTrophies(815);
    unitUnderTest.setDonationsPerWeek(815);
    unitUnderTest.setLocation(new SearchedClanLocation());
    unitUnderTest.setMembers(815);
    unitUnderTest.setName("astring");
    unitUnderTest.setRequiredTrophies(815);
    unitUnderTest.setTag("astring");
    unitUnderTest.setType("astring");
    String expected = "SearchedClan(badgeId=815, clanChestLevel=815, clanChestMaxLevel=815, clanScore=815, clanWarTrophies=815, donationsPerWeek=815, location=" + new SearchedClanLocation() + ", members=815, name=astring, requiredTrophies=815, tag=astring, type=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}