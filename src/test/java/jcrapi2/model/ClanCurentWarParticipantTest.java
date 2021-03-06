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
class ClanCurentWarParticipantTest {

  private ClanCurentWarParticipant unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new ClanCurentWarParticipant();
  }

  @Test
  void setBattlesPlayed_whenWithValidParameter_thenSetBattlesPlayed() {
    int expected = 815;
    unitUnderTest.setBattlesPlayed(expected);
    assertEquals(expected, unitUnderTest.getBattlesPlayed());
  }

  @Test
  void setCardsEarned_whenWithValidParameter_thenSetCardsEarned() {
    int expected = 815;
    unitUnderTest.setCardsEarned(expected);
    assertEquals(expected, unitUnderTest.getCardsEarned());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
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
    unitUnderTest.setBattlesPlayed(815);
    unitUnderTest.setCardsEarned(815);
    unitUnderTest.setName("astring");
    unitUnderTest.setTag("astring");
    unitUnderTest.setWins(815);
    String expected = "ClanCurentWarParticipant(battlesPlayed=815, cardsEarned=815, name=astring, tag=astring, wins=815)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}