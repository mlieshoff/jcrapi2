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

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.mili.generator")
class ClanWarLogTest {

  private ClanWarLog unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new ClanWarLog();
  }

  @Test
  void setCreatedDate_whenWithValidParameter_thenSetCreatedDate() {
    String expected = "astring";
    unitUnderTest.setCreatedDate(expected);
    assertEquals(expected, unitUnderTest.getCreatedDate());
  }

  @Test
  void setParticipants_whenWithValidParameter_thenSetParticipants() {
    List<ClanWarLogParticipant> expected = new ArrayList<ClanWarLogParticipant>();
    unitUnderTest.setParticipants(expected);
    assertEquals(expected, unitUnderTest.getParticipants());
  }

  @Test
  void setSeasonId_whenWithValidParameter_thenSetSeasonId() {
    int expected = 815;
    unitUnderTest.setSeasonId(expected);
    assertEquals(expected, unitUnderTest.getSeasonId());
  }

  @Test
  void setStandings_whenWithValidParameter_thenSetStandings() {
    List<ClanWarLogStanding> expected = new ArrayList<ClanWarLogStanding>();
    unitUnderTest.setStandings(expected);
    assertEquals(expected, unitUnderTest.getStandings());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setCreatedDate("astring");
    unitUnderTest.setParticipants(new ArrayList<ClanWarLogParticipant>());
    unitUnderTest.setSeasonId(815);
    unitUnderTest.setStandings(new ArrayList<ClanWarLogStanding>());
    String expected = "ClanWarLog(createdDate=astring, participants=" + new ArrayList<ClanWarLogParticipant>() + ", seasonId=815, standings=" + new ArrayList<ClanWarLogStanding>() + ")";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}