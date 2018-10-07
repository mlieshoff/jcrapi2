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
class ClanCurentWarTest {

  private ClanCurentWar unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new ClanCurentWar();
  }

  @Test
  void setState_whenWithValidParameter_thenSetState() {
    String expected = "astring";
    unitUnderTest.setState(expected);
    assertEquals(expected, unitUnderTest.getState());
  }

  @Test
  void setWarEndTime_whenWithValidParameter_thenSetWarEndTime() {
    String expected = "astring";
    unitUnderTest.setWarEndTime(expected);
    assertEquals(expected, unitUnderTest.getWarEndTime());
  }

  @Test
  void setClan_whenWithValidParameter_thenSetClan() {
    ClanCurentWarClan expected = new ClanCurentWarClan();
    unitUnderTest.setClan(expected);
    assertEquals(expected, unitUnderTest.getClan());
  }

  @Test
  void setParticipants_whenWithValidParameter_thenSetParticipants() {
    java.util.List<ClanCurentWarParticipant> expected = new java.util.ArrayList<ClanCurentWarParticipant>();
    unitUnderTest.setParticipants(expected);
    assertEquals(expected, unitUnderTest.getParticipants());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setState("astring");
    unitUnderTest.setWarEndTime("astring");
    unitUnderTest.setClan(new ClanCurentWarClan());
    unitUnderTest.setParticipants(new java.util.ArrayList<ClanCurentWarParticipant>());
    String expected = "ClanCurentWar(state=astring, warEndTime=astring, clan=" + new ClanCurentWarClan() + ", participants=" + new java.util.ArrayList<ClanCurentWarParticipant>() + ")";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}