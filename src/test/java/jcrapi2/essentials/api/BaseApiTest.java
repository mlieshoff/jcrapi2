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

import static jcrapi2.essentials.TestConstants.EMPTY;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import jcrapi2.essentials.common.PaginationRequest;
import jcrapi2.essentials.common.PaginationResponse;
import jcrapi2.essentials.connector.Connector;
import jcrapi2.essentials.connector.ConnectorException;
import jcrapi2.essentials.connector.RequestContext;

import lombok.Getter;
import lombok.Setter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void get_whenWithNullPart_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> unitUnderTest.get(null, request, FooResponse.class));
    }

    @Test
    void get_whenWithEmptyPart_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> unitUnderTest.get(EMPTY, request, FooResponse.class));
    }

    @Test
    void get_whenWithNullRequest_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> unitUnderTest.get(URL, null, FooResponse.class));
    }

    @Test
    void get_whenWithNullResponseClass_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> unitUnderTest.get(URL, request, null));
    }

    @Test
    void get_whenConnectorThrowsException_thenPropagateCause() {
        when(connector.get(any(RequestContext.class))).thenThrow(ConnectorException.class);

        assertThatThrownBy(() -> unitUnderTest.get(URL, request, FooResponse.class).get())
                .isInstanceOf(ExecutionException.class)
                .hasCauseInstanceOf(ConnectorException.class);
    }

    @Test
    void get_whenConnectorThrowsIllegalStateException_thenPropagateCause() {
        when(connector.get(any(RequestContext.class))).thenThrow(IllegalStateException.class);

        assertThatThrownBy(() -> unitUnderTest.get(URL, request, FooResponse.class).get())
                .isInstanceOf(ExecutionException.class)
                .hasCauseInstanceOf(IllegalStateException.class);
    }

    @Test
    void get_whenWithValidParameters_thenReturnResponse() throws Exception {
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
