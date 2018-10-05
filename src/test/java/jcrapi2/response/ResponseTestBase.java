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

import org.junit.jupiter.api.Test;

abstract class ResponseTestBase<T extends Response> {

  private static final String MESSAGE = "message";
  private static final String REASON = "reason";

  @Test
  void setMessage_whenWithValidParameter_shouldGet() throws Exception {
    T response = getResponse();
    response.setMessage(MESSAGE);
    assertEquals(MESSAGE, response.getMessage());
  }

  @Test
  void setReason_whenWithValidParameter_shouldGet() throws Exception {
    T response = getResponse();
    response.setReason(REASON);
    assertEquals(REASON, response.getReason());
  }

  abstract T getResponse();

}