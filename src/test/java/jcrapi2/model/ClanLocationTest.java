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
class ClanLocationTest {

  private ClanLocation unitUnderTest;

  @BeforeEach
  void setUp() {
    unitUnderTest = new ClanLocation();
  }

  @Test
  void setCountry_whenWithValidParameter_thenSetCountry() {
    boolean expected = false;
    unitUnderTest.setCountry(expected);
    assertEquals(expected, unitUnderTest.isCountry());
  }

  @Test
  void setCountryCode_whenWithValidParameter_thenSetCountryCode() {
    String expected = "astring";
    unitUnderTest.setCountryCode(expected);
    assertEquals(expected, unitUnderTest.getCountryCode());
  }

  @Test
  void setId_whenWithValidParameter_thenSetId() {
    int expected = 815;
    unitUnderTest.setId(expected);
    assertEquals(expected, unitUnderTest.getId());
  }

  @Test
  void setName_whenWithValidParameter_thenSetName() {
    String expected = "astring";
    unitUnderTest.setName(expected);
    assertEquals(expected, unitUnderTest.getName());
  }

  @Test
  void toString_whenCalled_thenReturnStringRepresentation() {
    unitUnderTest.setCountry(false);
    unitUnderTest.setCountryCode("astring");
    unitUnderTest.setId(815);
    unitUnderTest.setName("astring");
    String expected = "ClanLocation(country=false, countryCode=astring, id=815, name=astring)";
    String actual = unitUnderTest.toString();
    assertEquals(expected, actual);
  }

}