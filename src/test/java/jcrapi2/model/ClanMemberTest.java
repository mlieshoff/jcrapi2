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
public class ClanMemberTest {

  private ClanMember unitUnderTest;

  @BeforeEach
  public void setUp() {
    unitUnderTest = new ClanMember();
  }

  @Test
  public void shouldGetSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  public void shouldGetSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  public void shouldGetSetRole() {
    String expected = "astring";
    unitUnderTest.setRole(expected);
    assertEquals(expected, unitUnderTest.getRole());
  }

  @Test
  public void shouldGetSetExpLevel() {
    int expected = 815;
    unitUnderTest.setExpLevel(expected);
    assertEquals(expected, unitUnderTest.getExpLevel());
  }

  @Test
  public void shouldGetSetTrophies() {
    int expected = 815;
    unitUnderTest.setTrophies(expected);
    assertEquals(expected, unitUnderTest.getTrophies());
  }

  @Test
  public void shouldGetSetArena() {
    ClanMemberArena expected = new ClanMemberArena();
    unitUnderTest.setArena(expected);
    assertEquals(expected, unitUnderTest.getArena());
  }

  @Test
  public void shouldGetSetClanRank() {
    int expected = 815;
    unitUnderTest.setClanRank(expected);
    assertEquals(expected, unitUnderTest.getClanRank());
  }

  @Test
  public void shouldGetSetPreviousClanRank() {
    int expected = 815;
    unitUnderTest.setPreviousClanRank(expected);
    assertEquals(expected, unitUnderTest.getPreviousClanRank());
  }

  @Test
  public void shouldGetSetDonations() {
    String expected = "astring";
    unitUnderTest.setDonations(expected);
    assertEquals(expected, unitUnderTest.getDonations());
  }

  @Test
  public void shouldGetSetDonationsReceived() {
    int expected = 815;
    unitUnderTest.setDonationsReceived(expected);
    assertEquals(expected, unitUnderTest.getDonationsReceived());
  }

  @Test
  public void shouldGetSetClanChestPoints() {
    int expected = 815;
    unitUnderTest.setClanChestPoints(expected);
    assertEquals(expected, unitUnderTest.getClanChestPoints());
  }

  @Test
  public void shouldToString() {
    unitUnderTest.setTag("astring");
    unitUnderTest.setName("astring");
    unitUnderTest.setRole("astring");
    unitUnderTest.setExpLevel(815);
    unitUnderTest.setTrophies(815);
    unitUnderTest.setArena(new ClanMemberArena());
    unitUnderTest.setClanRank(815);
    unitUnderTest.setPreviousClanRank(815);
    unitUnderTest.setDonations("astring");
    unitUnderTest.setDonationsReceived(815);
    unitUnderTest.setClanChestPoints(815);
    String expected = "ClanMember(tag=astring, name=astring, role=astring, expLevel=815, trophies=815, arena=" + new ClanMemberArena() + ", clanRank=815, previousClanRank=815, donations=astring, donationsReceived=815, clanChestPoints=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}