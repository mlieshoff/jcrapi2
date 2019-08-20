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
class TournamentTest {

  private Tournament unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new Tournament();
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
  void setStatus_whenWithValidParameter_thenSetStatus() {
    String expected = "astring";
    unitUnderTest.setStatus(expected);
    assertEquals(expected, unitUnderTest.getStatus());
  }

  @Test
  void setCreatorTag_whenWithValidParameter_thenSetCreatorTag() {
    String expected = "astring";
    unitUnderTest.setCreatorTag(expected);
    assertEquals(expected, unitUnderTest.getCreatorTag());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setCapacity_whenWithValidParameter_thenSetCapacity() {
    int expected = 815;
    unitUnderTest.setCapacity(expected);
    assertEquals(expected, unitUnderTest.getCapacity());
  }

  @Test
  void setMaxCapacity_whenWithValidParameter_thenSetMaxCapacity() {
    int expected = 815;
    unitUnderTest.setMaxCapacity(expected);
    assertEquals(expected, unitUnderTest.getMaxCapacity());
  }

  @Test
  void setPreparationDuration_whenWithValidParameter_thenSetPreparationDuration() {
    int expected = 815;
    unitUnderTest.setPreparationDuration(expected);
    assertEquals(expected, unitUnderTest.getPreparationDuration());
  }

  @Test
  void setDuration_whenWithValidParameter_thenSetDuration() {
    int expected = 815;
    unitUnderTest.setDuration(expected);
    assertEquals(expected, unitUnderTest.getDuration());
  }

  @Test
  void setCreatedTime_whenWithValidParameter_thenSetCreatedTime() {
    String expected = "astring";
    unitUnderTest.setCreatedTime(expected);
    assertEquals(expected, unitUnderTest.getCreatedTime());
  }

  @Test
  void setStartedTime_whenWithValidParameter_thenSetStartedTime() {
    String expected = "astring";
    unitUnderTest.setStartedTime(expected);
    assertEquals(expected, unitUnderTest.getStartedTime());
  }

  @Test
  void setMembersList_whenWithValidParameter_thenSetMembersList() {
    java.util.List<TournamentMember> expected = new java.util.ArrayList<TournamentMember>();
    unitUnderTest.setMembersList(expected);
    assertEquals(expected, unitUnderTest.getMembersList());
  }

  @Test
  void setDescription_whenWithValidParameter_thenSetDescription() {
    String expected = "astring";
    unitUnderTest.setDescription(expected);
    assertEquals(expected, unitUnderTest.getDescription());
  }

  @Test
  void setLevelCap_whenWithValidParameter_thenSetLevelCap() {
    int expected = 815;
    unitUnderTest.setLevelCap(expected);
    assertEquals(expected, unitUnderTest.getLevelCap());
  }

  @Test
  void setFirstPlaceCardPrize_whenWithValidParameter_thenSetFirstPlaceCardPrize() {
    int expected = 815;
    unitUnderTest.setFirstPlaceCardPrize(expected);
    assertEquals(expected, unitUnderTest.getFirstPlaceCardPrize());
  }

  @Test
  void setGameMode_whenWithValidParameter_thenSetGameMode() {
    TournamentGameMode expected = new TournamentGameMode();
    unitUnderTest.setGameMode(expected);
    assertEquals(expected, unitUnderTest.getGameMode());
  }

  @Test
  void setEndedTime_whenWithValidParameter_thenSetEndedTime() {
    String expected = "astring";
    unitUnderTest.setEndedTime(expected);
    assertEquals(expected, unitUnderTest.getEndedTime());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setTag("astring");
    unitUnderTest.setType("astring");
    unitUnderTest.setStatus("astring");
    unitUnderTest.setCreatorTag("astring");
    unitUnderTest.setName("astring");
    unitUnderTest.setCapacity(815);
    unitUnderTest.setMaxCapacity(815);
    unitUnderTest.setPreparationDuration(815);
    unitUnderTest.setDuration(815);
    unitUnderTest.setCreatedTime("astring");
    unitUnderTest.setStartedTime("astring");
    unitUnderTest.setMembersList(new java.util.ArrayList<TournamentMember>());
    unitUnderTest.setDescription("astring");
    unitUnderTest.setLevelCap(815);
    unitUnderTest.setFirstPlaceCardPrize(815);
    unitUnderTest.setGameMode(new TournamentGameMode());
    unitUnderTest.setEndedTime("astring");
    String expected = "Tournament(tag=astring, type=astring, status=astring, creatorTag=astring, name=astring, capacity=815, maxCapacity=815, preparationDuration=815, duration=815, createdTime=astring, startedTime=astring, membersList=" + new java.util.ArrayList<TournamentMember>() + ", description=astring, levelCap=815, firstPlaceCardPrize=815, gameMode=" + new TournamentGameMode() + ", endedTime=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}