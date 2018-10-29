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
class TournamentMemberTest {

  private TournamentMember unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new TournamentMember();
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
  void setScore_whenWithValidParameter_thenSetScore() {
    int expected = 815;
    unitUnderTest.setScore(expected);
    assertEquals(expected, unitUnderTest.getScore());
  }

  @Test
  void setRank_whenWithValidParameter_thenSetRank() {
    int expected = 815;
    unitUnderTest.setRank(expected);
    assertEquals(expected, unitUnderTest.getRank());
  }

  @Test
  void setClan_whenWithValidParameter_thenSetClan() {
    TournamentMemberClan expected = new TournamentMemberClan();
    unitUnderTest.setClan(expected);
    assertEquals(expected, unitUnderTest.getClan());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setTag("astring");
    unitUnderTest.setName("astring");
    unitUnderTest.setScore(815);
    unitUnderTest.setRank(815);
    unitUnderTest.setClan(new TournamentMemberClan());
    String expected = "TournamentMember(tag=astring, name=astring, score=815, rank=815, clan=" + new TournamentMemberClan() + ")";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}