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

import static supercell.api.wrapper.essentials.common.Utils.require;

import static java.util.stream.Collectors.toList;

import jcrapi2.api.intern.DefaultApiClasses;

import supercell.api.wrapper.essentials.api.Api;
import supercell.api.wrapper.essentials.api.ApiContext;
import supercell.api.wrapper.essentials.connector.Connector;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JCrApi {

    private final ApiContext apiContext;

    private final ConcurrentHashMap<Class<? extends Api>, ?> apiInstanceMap =
            new ConcurrentHashMap<>();
    private final Map<Class<? extends Api>, String> apiClassMap = new HashMap<>();

    public JCrApi(String url, String apiKey, Connector connector) {
        apiContext = new ApiContext(url, apiKey, connector);
        apiClassMap.putAll(new DefaultApiClasses().getApiClassMap());
    }

    public <T extends Api> T getApi(Class<T> apiInterface) {
        return (T)
                apiInstanceMap.computeIfAbsent(
                        apiInterface, key -> instantiateApi(apiClassMap.get(key)));
    }

    private <T extends Api> T instantiateApi(String apiImplClassname) {
        try {
            Class<?> apiImplClass = Class.forName(apiImplClassname);
            Constructor<?> constructor = apiImplClass.getDeclaredConstructor(ApiContext.class);
            constructor.setAccessible(true);
            return (T) constructor.newInstance(apiContext);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public List<String> listApis() {
        return apiClassMap.keySet().stream().map(Class::getName).collect(toList());
    }

    public <T extends Api> void register(Class<T> apiInterface, String apiImplClassname) {
        require("apiInterface", apiInterface);
        require("apiImplClassname", apiImplClassname);
        apiClassMap.put(apiInterface, apiImplClassname);
    }
}
