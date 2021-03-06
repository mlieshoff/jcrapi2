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
class CurrentClanRiverRaceClanParticipantTest {

  private CurrentClanRiverRaceClanParticipant unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new CurrentClanRiverRaceClanParticipant();
  }

  @Test
  void setBoatAttacks_whenWithValidParameter_thenSetBoatAttacks() {
    int expected = 815;
    unitUnderTest.setBoatAttacks(expected);
    assertEquals(expected, unitUnderTest.getBoatAttacks());
  }

  @Test
  void setDecksUsed_whenWithValidParameter_thenSetDecksUsed() {
    int expected = 815;
    unitUnderTest.setDecksUsed(expected);
    assertEquals(expected, unitUnderTest.getDecksUsed());
  }

  @Test
  void setFame_whenWithValidParameter_thenSetFame() {
    int expected = 815;
    unitUnderTest.setFame(expected);
    assertEquals(expected, unitUnderTest.getFame());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setRepairPoints_whenWithValidParameter_thenSetRepairPoints() {
    int expected = 815;
    unitUnderTest.setRepairPoints(expected);
    assertEquals(expected, unitUnderTest.getRepairPoints());
  }

  @Test
  void setTag_whenWithValidParameter_thenSetTag() {
    String expected = "astring";
    unitUnderTest.setTag(expected);
    assertEquals(expected, unitUnderTest.getTag());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setBoatAttacks(815);
    unitUnderTest.setDecksUsed(815);
    unitUnderTest.setFame(815);
    unitUnderTest.setName("astring");
    unitUnderTest.setRepairPoints(815);
    unitUnderTest.setTag("astring");
    String expected = "CurrentClanRiverRaceClanParticipant(boatAttacks=815, decksUsed=815, fame=815, name=astring, repairPoints=815, tag=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}