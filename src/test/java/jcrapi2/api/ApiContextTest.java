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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import jcrapi2.connector.Connector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApiContextTest {

    private static final String API_KEY = "apiKey";
    private static final String URL = "url";

    @Mock private Connector connector;

    @ParameterizedTest
    @CsvSource(value = "null,", nullValues = "null")
    void construct_withoutUrl_shouldThrowException(String actual) {

        assertThrows(
                IllegalArgumentException.class, () -> new ApiContext(actual, API_KEY, connector));
    }

    @ParameterizedTest
    @CsvSource(value = "null,", nullValues = "null")
    void construct_withoutApiKey_shouldThrowException(String actual) {

        assertThrows(IllegalArgumentException.class, () -> new ApiContext(URL, actual, connector));
    }

    @Test
    void construct_withoutConnector_shouldThrowException() {

        assertThrows(IllegalArgumentException.class, () -> new ApiContext(URL, API_KEY, null));
    }

    @Test
    void construct_whenWithParameters_shouldSetValues() {
        ApiContext actual = new ApiContext(URL, API_KEY, connector);

        assertEquals(URL, actual.url());
        assertEquals(API_KEY, actual.apiKey());
        assertEquals(connector, actual.connector());
    }
}
