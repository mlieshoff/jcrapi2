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

import static java.util.Collections.emptyList;
import static jcrapi2.response.PageableResponse.Paging.Cursors;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jcrapi2.response.PageableResponse.Paging;

abstract class PageableResponseTestBase<T extends PageableResponse> extends ResponseTestBase<T> {

  private static final String AFTER = "abc";
  private static final String BEFORE = "xyz";

  @Test
  void setPaging_whenWithValidParameter_shouldGet() throws Exception {
    T response = getResponse();
    Paging expected = new Paging();
    response.setPaging(expected);
    assertEquals(expected, response.getPaging());
  }

  @Test
  void pagingSetCursors_whenWithValidParameter_shouldGet() throws Exception {
    Paging paging = new Paging();
    Cursors expected = new Cursors();
    paging.setCursors(expected);
    assertEquals(expected, paging.getCursors());
  }

  @Test
  void pagingCursorsSetAfter_whenWithValidParameter_shouldGet() throws Exception {
    Cursors expected = new Cursors();
    expected.setAfter(AFTER);
    assertEquals(AFTER, expected.getAfter());
  }

  @Test
  void pagingCursorsSetBefore_whenWithValidParameter_shouldGet() throws Exception {
    Cursors expected = new Cursors();
    expected.setBefore(BEFORE);
    assertEquals(BEFORE, expected.getBefore());
  }

  @Test
  void setItems_whenWithValidParameter_shouldGet() throws Exception {
    T response = getResponse();
    response.setItems(emptyList());
    assertEquals(emptyList(), response.getItems());
  }

}