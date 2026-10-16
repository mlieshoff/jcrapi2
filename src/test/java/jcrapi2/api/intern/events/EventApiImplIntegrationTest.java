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
package jcrapi2.api.intern.events;

import static org.assertj.core.api.Assertions.assertThat;

import jcrapi2.IntegrationTestBase;
import jcrapi2.api.generated.model.TrailEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventApiImplIntegrationTest extends IntegrationTestBase {

    private EventApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(EventApi.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"event-findAll.json", "event-findAll-empty.json"})
    void findAll_whenApiReturnsSuccess_thenReturnGeneratedEvents(String fixture) throws Exception {
        EventsRequest request = EventsRequest.builder().storeRawResponse(true).build();
        prepare("/events", EMPTY, "src/test/resources/" + fixture, request);
        EventsResponse expected = fromJson(EventsResponse.class, getExpected());

        assertResponse(expected, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findAll_whenRawResponseDisabled_thenReturnEventsWithoutRawResponse() throws Exception {
        EventsRequest request = EventsRequest.builder().storeRawResponse(false).build();
        prepare("/events", EMPTY, "src/test/resources/event-findAll.json", request);
        EventsResponse response = unitUnderTest.findAll(request).get();

        assertEventsWithoutRawResponse(response);
    }

    private void assertEventsWithoutRawResponse(EventsResponse response) {
        assertThat(response).hasSize(5);
        TrailEvent first = response.getFirst();
        assertThat(first.getEventTag()).isEqualTo("#2CJYY8JP");
        assertThat(first.getTitle()).isEqualTo("C.H.A.O.S Mega Draft Challenge");
        assertThat(response.get(3).getDescription()).isNull();
        assertThat(response.getRawResponse()).isNull();
    }

    @Test
    void findAll_whenApiReturnsError_thenThrowConnectorException() {
        EventsRequest request = EventsRequest.builder().storeRawResponse(true).build();

        assertRequestFails("/events", EMPTY, request, () -> unitUnderTest.findAll(request).get());
    }
}
