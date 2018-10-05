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
package jcrapi2;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Michael Lieshoff
 */
class ApiExceptionTest {

  private CrawlerException crawlerException;

  @BeforeEach
  void setUp() throws Exception {
    crawlerException = mock(CrawlerException.class);
  }

  @Test
  void getCode_whenWithNoneCode_returnZero() throws Exception {
    assertEquals(0, new ApiException(new IllegalStateException("lala")).getCode());
  }

  @Test
  void getCode_whenWithNotKnownException_returnZero() throws Exception {
    assertEquals(0, new ApiException(new IllegalStateException("crapi: 402")).getCode());
  }

  @Test
  void getCode_whenWithCrawlerException_returnCode() throws Exception {
    when(crawlerException.getStatusCode()).thenReturn(SC_NOT_FOUND);
    assertEquals(SC_NOT_FOUND, new ApiException(crawlerException).getCode());
  }

  @Test
  void getMessage_whenWithCrawlerException_returnMessage() throws Exception {
    when(crawlerException.getMessage()).thenReturn("xyz");
    assertEquals("xyz", new ApiException(crawlerException).getMessage());
  }

}