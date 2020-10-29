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
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Generated("org.mili.generator")
class CurrentClanRiverRaceTest {

  private CurrentClanRiverRace unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new CurrentClanRiverRace();
  }

  @Test
  void setClan_whenWithValidParameter_thenSetClan() {
    CurrentClanRiverRaceClan expected = new CurrentClanRiverRaceClan();
    unitUnderTest.setClan(expected);
    assertEquals(expected, unitUnderTest.getClan());
  }

  @Test
  void setClans_whenWithValidParameter_thenSetClans() {
    List<CurrentClanRiverRaceClan> expected = new ArrayList<CurrentClanRiverRaceClan>();
    unitUnderTest.setClans(expected);
    assertEquals(expected, unitUnderTest.getClans());
  }

  @Test
  void setSectionIndex_whenWithValidParameter_thenSetSectionIndex() {
    int expected = 815;
    unitUnderTest.setSectionIndex(expected);
    assertEquals(expected, unitUnderTest.getSectionIndex());
  }

  @Test
  void setState_whenWithValidParameter_thenSetState() {
    String expected = "astring";
    unitUnderTest.setState(expected);
    assertEquals(expected, unitUnderTest.getState());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setClan(new CurrentClanRiverRaceClan());
    unitUnderTest.setClans(new ArrayList<CurrentClanRiverRaceClan>());
    unitUnderTest.setSectionIndex(815);
    unitUnderTest.setState("astring");
    String expected = "CurrentClanRiverRace(clan=" + new CurrentClanRiverRaceClan() + ", clans=" + new ArrayList<CurrentClanRiverRaceClan>() + ", sectionIndex=815, state=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}