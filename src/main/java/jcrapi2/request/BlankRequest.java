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

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

import java.util.List;
import java.util.Map;
import jcrapi2.response.IResponse;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Michael Lieshoff
 */
@Getter
public class BlankRequest<T extends IResponse> extends Request<T> {

  @Builder
  public BlankRequest() {
    super(null);
  }

  @Override
  public Map<String, String> getQueryParameters() {
    return emptyMap();
  }

  @Override
  public List<String> getRestParameters() {
    return emptyList();
  }

}
