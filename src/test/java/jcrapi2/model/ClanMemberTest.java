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
class ClanMemberTest {

  private ClanMember unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new ClanMember();
  }

  @Test
  void setArena_whenWithValidParameter_thenSetArena() {
    ClanMemberArena expected = new ClanMemberArena();
    unitUnderTest.setArena(expected);
    assertEquals(expected, unitUnderTest.getArena());
  }

  @Test
  void setClanChestPoints_whenWithValidParameter_thenSetClanChestPoints() {
    int expected = 815;
    unitUnderTest.setClanChestPoints(expected);
    assertEquals(expected, unitUnderTest.getClanChestPoints());
  }

  @Test
  void setClanRank_whenWithValidParameter_thenSetClanRank() {
    int expected = 815;
    unitUnderTest.setClanRank(expected);
    assertEquals(expected, unitUnderTest.getClanRank());
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
  void setLastSeen_whenWithValidParameter_thenSetLastSeen() {
    String expected = "astring";
    unitUnderTest.setLastSeen(expected);
    assertEquals(expected, unitUnderTest.getLastSeen());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setPreviousClanRank_whenWithValidParameter_thenSetPreviousClanRank() {
    int expected = 815;
    unitUnderTest.setPreviousClanRank(expected);
    assertEquals(expected, unitUnderTest.getPreviousClanRank());
  }

  @Test
  void setRole_whenWithValidParameter_thenSetRole() {
    String expected = "astring";
    unitUnderTest.setRole(expected);
    assertEquals(expected, unitUnderTest.getRole());
  }

  @Test
  void setTag_whenWithValidParameter_thenSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  void setTrophies_whenWithValidParameter_thenSetTrophies() {
    int expected = 815;
    unitUnderTest.setTrophies(expected);
    assertEquals(expected, unitUnderTest.getTrophies());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setArena(new ClanMemberArena());
    unitUnderTest.setClanChestPoints(815);
    unitUnderTest.setClanRank(815);
    unitUnderTest.setDonations(815);
    unitUnderTest.setDonationsReceived(815);
    unitUnderTest.setExpLevel(815);
    unitUnderTest.setLastSeen("astring");
    unitUnderTest.setName("astring");
    unitUnderTest.setPreviousClanRank(815);
    unitUnderTest.setRole("astring");
    unitUnderTest.setTag("astring");
    unitUnderTest.setTrophies(815);
    String expected = "ClanMember(arena=" + new ClanMemberArena() + ", clanChestPoints=815, clanRank=815, donations=815, donationsReceived=815, expLevel=815, lastSeen=astring, name=astring, previousClanRank=815, role=astring, tag=astring, trophies=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}