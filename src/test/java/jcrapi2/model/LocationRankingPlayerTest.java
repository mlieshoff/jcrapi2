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
class LocationRankingPlayerTest {

  private LocationRankingPlayer unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new LocationRankingPlayer();
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
  void setRank_whenWithValidParameter_thenSetRank() {
    int expected = 815;
    unitUnderTest.setRank(expected);
    assertEquals(expected, unitUnderTest.getRank());
  }

  @Test
  void setPreviousRank_whenWithValidParameter_thenSetPreviousRank() {
    int expected = 815;
    unitUnderTest.setPreviousRank(expected);
    assertEquals(expected, unitUnderTest.getPreviousRank());
  }

  @Test
  void setClan_whenWithValidParameter_thenSetClan() {
    LocationRankingPlayerClan expected = new LocationRankingPlayerClan();
    unitUnderTest.setClan(expected);
    assertEquals(expected, unitUnderTest.getClan());
  }

  @Test
  void setArena_whenWithValidParameter_thenSetArena() {
    LocationRankingPlayerArena expected = new LocationRankingPlayerArena();
    unitUnderTest.setArena(expected);
    assertEquals(expected, unitUnderTest.getArena());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setTag("astring");
    unitUnderTest.setName("astring");
    unitUnderTest.setRank(815);
    unitUnderTest.setPreviousRank(815);
    unitUnderTest.setClan(new LocationRankingPlayerClan());
    unitUnderTest.setArena(new LocationRankingPlayerArena());
    String expected = "LocationRankingPlayer(tag=astring, name=astring, rank=815, previousRank=815, clan=" + new LocationRankingPlayerClan() + ", arena=" + new LocationRankingPlayerArena() + ")";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}