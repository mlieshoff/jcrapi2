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
package jcrapi2.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import jcrapi2.response.Callback;

abstract class RequestTestBase {

  @Test
  void requestBuilder_whenCalled_thenConstruct() throws Exception {
    assertTrue(Request.requestBuilder() instanceof Request.RequestBuilder);
  }

  abstract Object getBuilder();

  static <T> T invokeBuildMethod(Object builder) throws Exception {
    Method buildMethod = builder.getClass().getDeclaredMethod("build");
    try {
      return (T) buildMethod.invoke(builder);
    } catch (Exception e) {
      if (e.getCause() != null) {
        throw (Exception) e.getCause();
      }
      throw e;
    }
  }

  static Object invokeMethod(String name, Object builder, Object expected, Class<?> clazz) throws Exception {
    Method excludesMethod = builder.getClass().getMethod(name, clazz);
    return excludesMethod.invoke(builder, expected);
  }

  @Test
  void getQueryParameters_whenConstructed_thenWithZeroElements() throws Exception {
    assertEquals(0, Request.requestBuilder().build().getQueryParameters().size());
  }

  @Test
  void getRestParameters_whenConstructed_thenWithZeroElements() throws Exception {
    assertEquals(0, Request.requestBuilder().build().getRestParameters().size());
  }

  @Test
  void getCallback_whenConstructed_thenReturnNull() throws Exception {
    assertNull(Request.requestBuilder().build().getCallback());
  }

  @Test
  void getCallback_whenSet_thenGet() throws Exception {
    Callback expected = mock(Callback.class);
    assertEquals(expected, Request.requestBuilder().callback(expected).build().getCallback());
  }

}