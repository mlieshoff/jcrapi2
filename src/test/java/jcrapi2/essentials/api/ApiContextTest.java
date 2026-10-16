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
package jcrapi2.essentials.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import jcrapi2.essentials.connector.Connector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApiContextTest {

    private static final String API_KEY = "apiKey";
    private static final String URL = "url";

    @Mock private Connector connector;

    @ParameterizedTest
    @NullAndEmptySource
    void construct_whenUrlMissing_thenThrowException(String actual) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ApiContext(actual, API_KEY, connector));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void construct_whenApiKeyMissing_thenThrowException(String actual) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ApiContext(URL, actual, connector));
    }

    @Test
    void construct_whenConnectorMissing_thenThrowException() {

        assertThatIllegalArgumentException().isThrownBy(() -> new ApiContext(URL, API_KEY, null));
    }

    @Test
    void construct_whenParametersValid_thenSetValues() {

        ApiContext actual = new ApiContext(URL, API_KEY, connector);

        assertThat(actual)
                .extracting(ApiContext::apiKey, ApiContext::connector, ApiContext::url)
                .containsExactly(API_KEY, connector, URL);
    }
}
