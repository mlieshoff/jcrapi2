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

import static java.lang.String.valueOf;
import static jcrapi2.request.PageableRequest.QUERY_PARAM_AFTER;
import static jcrapi2.request.PageableRequest.QUERY_PARAM_BEFORE;
import static jcrapi2.request.PageableRequest.QUERY_PARAM_LIMIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

abstract class PageableRequestTestBase<T extends PageableRequest> extends RequestTestBase {

  private static final int PAGEABLE_LIMIT = 100;

  private static final String PAGEABLE_AFTER = "abc";
  private static final String PAGEABLE_BEFORE = "xyz";

  @Test
  void pageableRequestBuilder_whenCalled_thenConstruct() throws Exception {
    assertTrue(PageableRequest.pageableRequestBuilder() instanceof PageableRequest.PageableRequestBuilder);
  }

  @Test
  void build_whenWithLimit_thenShouldConstruct() throws Exception {
    assertEquals(PAGEABLE_LIMIT, getRequestWithLimit().getLimit());
  }

  private static Object invokeLimitMethod(Object builder, int limit) throws Exception {
    return invokeMethod(QUERY_PARAM_LIMIT, builder, limit, int.class);
  }

  private T getRequestWithLimit() throws Exception {
    Object builder = getBuilder();
    builder = invokeLimitMethod(builder, PAGEABLE_LIMIT);
    return invokeBuildMethod(builder);
  }

  @Test
  void getQueryParameters_whenWithLimit_thenHaveParameter() throws Exception {
    assertEquals(valueOf(PAGEABLE_LIMIT), getRequestWithLimit().getQueryParameters().get(QUERY_PARAM_LIMIT));
  }

  @Test
  void build_whenWithAfter_thenShouldConstruct() throws Exception {
    assertEquals(PAGEABLE_AFTER, getRequestWithAfter().getAfter());
  }

  private static Object invokeAfterMethod(Object builder, String after) throws Exception {
    return invokeMethod(QUERY_PARAM_AFTER, builder, after, String.class);
  }

  private T getRequestWithAfter() throws Exception {
    Object builder = getBuilder();
    builder = invokeAfterMethod(builder, PAGEABLE_AFTER);
    return invokeBuildMethod(builder);
  }

  @Test
  void getQueryParameters_whenWithAfter_thenHaveParameter() throws Exception {
    assertEquals(PAGEABLE_AFTER, getRequestWithAfter().getQueryParameters().get(QUERY_PARAM_AFTER));
  }

  @Test
  void build_whenWithBefore_thenShouldConstruct() throws Exception {
    assertEquals(PAGEABLE_BEFORE, getRequestWithBefore().getBefore());
  }

  private static Object invokeBeforeMethod(Object builder, String before) throws Exception {
    return invokeMethod(QUERY_PARAM_BEFORE, builder, before, String.class);
  }

  private T getRequestWithBefore() throws Exception {
    Object builder = getBuilder();
    builder = invokeBeforeMethod(builder, PAGEABLE_BEFORE);
    return invokeBuildMethod(builder);
  }

  @Test
  void getQueryParameters_whenWithBefore_thenHaveParameter() throws Exception {
    assertEquals(PAGEABLE_BEFORE, getRequestWithBefore().getQueryParameters().get(QUERY_PARAM_BEFORE));
  }

}