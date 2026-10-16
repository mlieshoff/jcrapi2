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
package supercell.api.wrapper.essentials.api;

import static supercell.api.wrapper.essentials.common.Utils.require;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import supercell.api.wrapper.essentials.common.IResponse;
import supercell.api.wrapper.essentials.common.Request;
import supercell.api.wrapper.essentials.connector.Connector;
import supercell.api.wrapper.essentials.connector.RequestContext;

import java.util.concurrent.Future;

@Slf4j
@RequiredArgsConstructor
public class BaseApi implements Api {

    private final ExecutorServiceDecorator executorServiceDecorator =
            new ExecutorServiceDecorator();

    @NonNull private final ApiContext apiContext;

    protected <T extends IResponse> Future<T> get(
            String part, Request request, Class<T> responseClass) {
        require("part", part);
        require("request", request);
        require("responseClass", responseClass);
        String apiKey = apiContext.apiKey();
        Connector connector = apiContext.connector();
        String url = apiContext.url() + part;
        RequestContext requestContext = new RequestContext(url, apiKey, request, responseClass);
        return executorServiceDecorator.submit(connector, requestContext);
    }
}
