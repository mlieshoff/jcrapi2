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

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.http.StatusLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Michael Lieshoff
 */
class CrawlerExceptionTest {

  private CrawlerException crawlerException;

  private StatusLine statusLine;

  @BeforeEach
  void setUp() throws Exception {
    statusLine = mock(StatusLine.class);
  }

  @Test
  void construct_whenWithNullStatusCode_shouldThrowException() throws Exception {
    assertThrows(NullPointerException.class, () -> new CrawlerException(null));
  }

  @Test
  void construct_whenWithStatusLine_shouldGetStatusCode() throws Exception {
    when(statusLine.getStatusCode()).thenReturn(SC_OK);
    crawlerException = new CrawlerException(statusLine);
    assertEquals(SC_OK, crawlerException.getStatusCode());
  }

  @Test
  void construct_whenWithStatusLine_shouldGetReason() throws Exception {
    when(statusLine.getReasonPhrase()).thenReturn("that is what she said!");
    crawlerException = new CrawlerException(statusLine);
    assertEquals("that is what she said!", crawlerException.getReason());
  }

  @Test
  void construct_whenWithStatusLine_shouldGetMessage() throws Exception {
    when(statusLine.getStatusCode()).thenReturn(SC_BAD_REQUEST);
    crawlerException = new CrawlerException(statusLine);
    assertEquals("crapi: " + SC_BAD_REQUEST, crawlerException.getMessage());
  }

  @Test
  void construct_whenWithStatusLine_shouldGetStatusCodeAndReason() throws Exception {
    when(statusLine.getReasonPhrase()).thenReturn("that is what she said!");
    when(statusLine.getStatusCode()).thenReturn(SC_BAD_REQUEST);
    crawlerException = new CrawlerException(statusLine);
    assertEquals("crapi: " + SC_BAD_REQUEST + ": that is what she said!", crawlerException.getMessage());
  }

}