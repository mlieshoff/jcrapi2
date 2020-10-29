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
class PlayerLeagueStatisticsPreviousSeasonTest {

  private PlayerLeagueStatisticsPreviousSeason unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new PlayerLeagueStatisticsPreviousSeason();
  }

  @Test
  void setBestTrophies_whenWithValidParameter_thenSetBestTrophies() {
    int expected = 815;
    unitUnderTest.setBestTrophies(expected);
    assertEquals(expected, unitUnderTest.getBestTrophies());
  }

  @Test
  void setId_whenWithValidParameter_thenSetId() {
    String expected = "astring";
    unitUnderTest.setId(expected);
    assertEquals(expected, unitUnderTest.getId());
  }

  @Test
  void setTrophies_whenWithValidParameter_thenSetTrophies() {
    int expected = 815;
    unitUnderTest.setTrophies(expected);
    assertEquals(expected, unitUnderTest.getTrophies());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setBestTrophies(815);
    unitUnderTest.setId("astring");
    unitUnderTest.setTrophies(815);
    String expected = "PlayerLeagueStatisticsPreviousSeason(bestTrophies=815, id=astring, trophies=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}