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
package jcrapi2.api;

import static jcrapi2.common.Utils.require;

import jcrapi2.connector.Connector;

import lombok.Getter;

@Getter
public class ApiContext {

    private final String url;
    private final String apiKey;

    private final Connector connector;

    public ApiContext(String url, String apiKey, Connector connector) {
        require("url", url);
        require("apiKey", apiKey);
        require("connector", connector);
        this.url = url;
        this.apiKey = apiKey;
        this.connector = connector;
    }
}
