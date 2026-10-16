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

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import static supercell.api.wrapper.essentials.TestConstants.EMPTY;

import lombok.Getter;
import lombok.Setter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import supercell.api.wrapper.essentials.common.PaginationRequest;
import supercell.api.wrapper.essentials.common.PaginationResponse;
import supercell.api.wrapper.essentials.connector.Connector;
import supercell.api.wrapper.essentials.connector.ConnectorException;
import supercell.api.wrapper.essentials.connector.RequestContext;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@ExtendWith(MockitoExtension.class)
class BaseApiTest {

    private static final String API_KEY = "apiKey";
    private static final String PART = "part";
    private static final String URL = "url";

    private BaseApi unitUnderTest;

    @Mock private Connector connector;

    private PaginationRequest request;

    private static ArgumentMatcher<RequestContext> createRequestContextArgumentMatcher(
            RequestContext expected) {
        return actual -> {
            assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
            return true;
        };
    }

    @BeforeEach
    void setUp() {
        ApiContext apiContext = new ApiContext(URL, API_KEY, connector);
        request = new FooRequest(100, "after", "before", true);
        unitUnderTest = new BaseApi(apiContext);
    }

    @Test
    void get_whenWithNullPart_shouldThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> unitUnderTest.get(null, request, FooResponse.class));
    }

    @Test
    void get_whenWithEmptyPart_shouldThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> unitUnderTest.get(EMPTY, request, FooResponse.class));
    }

    @Test
    void get_whenWithNullRequest_shouldThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> unitUnderTest.get(URL, null, FooResponse.class));
    }

    @Test
    void get_whenWithNullResponseClass_shouldThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> unitUnderTest.get(URL, request, null));
    }

    @Test
    void get_whenWithConnectorException_shouldThrowApiException() {
        when(connector.get(any(RequestContext.class))).thenThrow(ConnectorException.class);

        assertThatExceptionOfType(ExecutionException.class)
                .isThrownBy(() -> unitUnderTest.get(URL, request, FooResponse.class).get());
    }

    @Test
    void get_whenWithException_shouldThrowIllegalStateException() {
        when(connector.get(any(RequestContext.class))).thenThrow(IllegalStateException.class);

        assertThatExceptionOfType(ExecutionException.class)
                .isThrownBy(() -> unitUnderTest.get(URL, request, FooResponse.class).get());
    }

    @Test
    void get_whenWithValidParameters_shouldReturnResponse() throws Exception {
        FooResponse expected = new FooResponse();
        RequestContext requestContext =
                new RequestContext(URL + PART, API_KEY, request, FooResponse.class);
        when(connector.get(argThat(createRequestContextArgumentMatcher(requestContext))))
                .thenReturn(expected);

        FooResponse actual = unitUnderTest.get(PART, request, FooResponse.class).get();

        assertThat(actual).isEqualTo(expected);
    }

    @Getter
    @Setter
    static class FooResponse extends PaginationResponse<FooRequest> {}

    @Getter
    @Setter
    static class FooRequest extends PaginationRequest {

        protected FooRequest(int limit, String after, String before, boolean storeRawResponse) {
            super(limit, after, before, storeRawResponse);
        }

        @Override
        public Map<String, Object> getRestParameters() {
            Map<String, Object> map = super.getRestParameters();
            map.put("param", "value");
            return map;
        }
    }
}
