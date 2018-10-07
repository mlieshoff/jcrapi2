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
class ClanWarLogTest {

  private ClanWarLog unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new ClanWarLog();
  }

  @Test
  void setSeasonId_whenWithValidParameter_thenSetSeasonId() {
    int expected = 815;
    unitUnderTest.setSeasonId(expected);
    assertEquals(expected, unitUnderTest.getSeasonId());
  }

  @Test
  void setCreatedDate_whenWithValidParameter_thenSetCreatedDate() {
    String expected = "astring";
    unitUnderTest.setCreatedDate(expected);
    assertEquals(expected, unitUnderTest.getCreatedDate());
  }

  @Test
  void setParticipants_whenWithValidParameter_thenSetParticipants() {
    java.util.List<ClanWarLogParticipant> expected = new java.util.ArrayList<ClanWarLogParticipant>();
    unitUnderTest.setParticipants(expected);
    assertEquals(expected, unitUnderTest.getParticipants());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setSeasonId(815);
    unitUnderTest.setCreatedDate("astring");
    unitUnderTest.setParticipants(new java.util.ArrayList<ClanWarLogParticipant>());
    String expected = "ClanWarLog(seasonId=815, createdDate=astring, participants=" + new java.util.ArrayList<ClanWarLogParticipant>() + ")";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}