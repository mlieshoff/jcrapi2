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

package jcrapi2.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Michael Lieshoff
 */
public class RawResponseTest {

  private RawResponse rawResponse;

  @BeforeEach
  public void setUp() {
    rawResponse = new RawResponse();
  }

  @Test
  public void raw_whenSet_shouldGetValue() {
    rawResponse.setRaw("json");
    assertEquals("json", rawResponse.getRaw());
  }

  @Test
  public void getResponseHeaders_whenConstructed_shouldNotBeNull() {
    assertNotNull(rawResponse.getResponseHeaders());
  }

  @Test
  public void hashCode_whenCalled_shouldEqual() {
    RawResponse rawResponse1 = createRawResponse();
    RawResponse rawResponse2 = createRawResponse();
    assertEquals(rawResponse1.hashCode(), rawResponse2.hashCode());
  }

  private static RawResponse createRawResponse() {
    RawResponse rawResponse = new RawResponse();
    rawResponse.getResponseHeaders().put("hello", "world");
    rawResponse.setRaw("json");
    return rawResponse;
  }

  @Test
  public void equals_whenWithEqualsObjects_shouldEqual() {
    RawResponse rawResponse1 = createRawResponse();
    RawResponse rawResponse2 = createRawResponse();
    assertEquals(rawResponse1, rawResponse2);
  }

  @Test
  public void equals_whenWithOtherRaw_shouldNotEqual() {
    RawResponse rawResponse1 = createRawResponse();
    rawResponse1.setRaw("other");
    RawResponse rawResponse2 = createRawResponse();
    assertNotEquals(rawResponse1, rawResponse2);
  }

  @Test
  public void equals_whenWithOtherResponseHeaders_shouldNotEqual() {
    RawResponse rawResponse1 = createRawResponse();
    rawResponse1.getResponseHeaders().put("other", "other");
    RawResponse rawResponse2 = createRawResponse();
    assertNotEquals(rawResponse1, rawResponse2);
  }

}