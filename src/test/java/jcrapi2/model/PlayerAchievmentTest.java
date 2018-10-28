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
class PlayerAchievmentTest {

  private PlayerAchievment unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new PlayerAchievment();
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void setStars_whenWithValidParameter_thenSetStars() {
    int expected = 815;
    unitUnderTest.setStars(expected);
    assertEquals(expected, unitUnderTest.getStars());
  }

  @Test
  void setValue_whenWithValidParameter_thenSetValue() {
    int expected = 815;
    unitUnderTest.setValue(expected);
    assertEquals(expected, unitUnderTest.getValue());
  }

  @Test
  void setTarget_whenWithValidParameter_thenSetTarget() {
    int expected = 815;
    unitUnderTest.setTarget(expected);
    assertEquals(expected, unitUnderTest.getTarget());
  }

  @Test
  void setInfo_whenWithValidParameter_thenSetInfo() {
    String expected = "astring";
    unitUnderTest.setInfo(expected);
    assertEquals(expected, unitUnderTest.getInfo());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setName("astring");
    unitUnderTest.setStars(815);
    unitUnderTest.setValue(815);
    unitUnderTest.setTarget(815);
    unitUnderTest.setInfo("astring");
    String expected = "PlayerAchievment(name=astring, stars=815, value=815, target=815, info=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}