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
class LocationRankingClanWarTest {

  private LocationRankingClanWar unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new LocationRankingClanWar();
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
    LocationRankingClanWarLocation expected = new LocationRankingClanWarLocation();
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
  void setPreviousRank_whenWithValidParameter_thenSetPreviousRank() {
    int expected = 815;
    unitUnderTest.setPreviousRank(expected);
    assertEquals(expected, unitUnderTest.getPreviousRank());
  }

  @Test
  void setRank_whenWithValidParameter_thenSetRank() {
    int expected = 815;
    unitUnderTest.setRank(expected);
    assertEquals(expected, unitUnderTest.getRank());
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
    unitUnderTest.setLocation(new LocationRankingClanWarLocation());
    unitUnderTest.setMembers(815);
    unitUnderTest.setName("astring");
    unitUnderTest.setPreviousRank(815);
    unitUnderTest.setRank(815);
    unitUnderTest.setTag("astring");
    String expected = "LocationRankingClanWar(badgeId=815, clanScore=815, location=" + new LocationRankingClanWarLocation() + ", members=815, name=astring, previousRank=815, rank=815, tag=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}