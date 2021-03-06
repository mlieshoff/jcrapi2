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
class SearchedTournamentTest {

  private SearchedTournament unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new SearchedTournament();
  }

  @Test
  void setCapacity_whenWithValidParameter_thenSetCapacity() {
    int expected = 815;
    unitUnderTest.setCapacity(expected);
    assertEquals(expected, unitUnderTest.getCapacity());
  }

  @Test
  void setCreatedTime_whenWithValidParameter_thenSetCreatedTime() {
    String expected = "astring";
    unitUnderTest.setCreatedTime(expected);
    assertEquals(expected, unitUnderTest.getCreatedTime());
  }

  @Test
  void setCreatorTag_whenWithValidParameter_thenSetCreatorTag() {
    String expected = "astring";
    unitUnderTest.setCreatorTag(expected);
    assertEquals(expected, unitUnderTest.getCreatorTag());
  }

  @Test
  void setDescription_whenWithValidParameter_thenSetDescription() {
    String expected = "astring";
    unitUnderTest.setDescription(expected);
    assertEquals(expected, unitUnderTest.getDescription());
  }

  @Test
  void setDuration_whenWithValidParameter_thenSetDuration() {
    int expected = 815;
    unitUnderTest.setDuration(expected);
    assertEquals(expected, unitUnderTest.getDuration());
  }

  @Test
  void setFirstPlaceCardPrize_whenWithValidParameter_thenSetFirstPlaceCardPrize() {
    int expected = 815;
    unitUnderTest.setFirstPlaceCardPrize(expected);
    assertEquals(expected, unitUnderTest.getFirstPlaceCardPrize());
  }

  @Test
  void setGameMode_whenWithValidParameter_thenSetGameMode() {
    SearchedTournamentGameMode expected = new SearchedTournamentGameMode();
    unitUnderTest.setGameMode(expected);
    assertEquals(expected, unitUnderTest.getGameMode());
  }

  @Test
  void setLevelCap_whenWithValidParameter_thenSetLevelCap() {
    int expected = 815;
    unitUnderTest.setLevelCap(expected);
    assertEquals(expected, unitUnderTest.getLevelCap());
  }

  @Test
  void setMaxCapacity_whenWithValidParameter_thenSetMaxCapacity() {
    int expected = 815;
    unitUnderTest.setMaxCapacity(expected);
    assertEquals(expected, unitUnderTest.getMaxCapacity());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setPreparationDuration_whenWithValidParameter_thenSetPreparationDuration() {
    int expected = 815;
    unitUnderTest.setPreparationDuration(expected);
    assertEquals(expected, unitUnderTest.getPreparationDuration());
  }

  @Test
  void setStatus_whenWithValidParameter_thenSetStatus() {
    String expected = "astring";
    unitUnderTest.setStatus(expected);
    assertEquals(expected, unitUnderTest.getStatus());
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
    unitUnderTest.setCapacity(815);
    unitUnderTest.setCreatedTime("astring");
    unitUnderTest.setCreatorTag("astring");
    unitUnderTest.setDescription("astring");
    unitUnderTest.setDuration(815);
    unitUnderTest.setFirstPlaceCardPrize(815);
    unitUnderTest.setGameMode(new SearchedTournamentGameMode());
    unitUnderTest.setLevelCap(815);
    unitUnderTest.setMaxCapacity(815);
    unitUnderTest.setName("astring");
    unitUnderTest.setPreparationDuration(815);
    unitUnderTest.setStatus("astring");
    unitUnderTest.setTag("astring");
    unitUnderTest.setType("astring");
    String expected = "SearchedTournament(capacity=815, createdTime=astring, creatorTag=astring, description=astring, duration=815, firstPlaceCardPrize=815, gameMode=" + new SearchedTournamentGameMode() + ", levelCap=815, maxCapacity=815, name=astring, preparationDuration=815, status=astring, tag=astring, type=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}