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
package jcrapi2.api.intern.cards;

import static org.assertj.core.api.Assertions.assertThat;

import jcrapi2.IntegrationTestBase;
import jcrapi2.api.generated.model.Item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardApiImplIntegrationTest extends IntegrationTestBase {

    private CardApi unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = getJCrApi().getApi(CardApi.class);
    }

    @Test
    void findAll_whenApiReturnsSuccess_thenReturnGeneratedResponse() throws Exception {
        jcrapi2.api.intern.cards.CardsRequest.CardsRequestBuilder builder =
                jcrapi2.api.intern.cards.CardsRequest.builder();
        jcrapi2.api.intern.cards.CardsRequest request = builder.storeRawResponse(true).build();

        prepare("/cards", EMPTY, "src/test/resources/card-findAll.json", request);

        jcrapi2.api.intern.cards.CardsResponse expected =
                fromJson(jcrapi2.api.intern.cards.CardsResponse.class, getExpected());

        assertResponse(expected, () -> unitUnderTest.findAll(request).get());
    }

    @Test
    void findAll_whenRawResponseDisabled_thenReturnGeneratedCardsWithoutRawResponse()
            throws Exception {
        CardsRequest request = CardsRequest.builder().storeRawResponse(false).build();
        prepare("/cards", EMPTY, "src/test/resources/card-findAll.json", request);

        CardsResponse response = unitUnderTest.findAll(request).get();
        assertGeneratedCardsWithoutRawResponse(response);
    }

    private void assertGeneratedCardsWithoutRawResponse(CardsResponse response) {
        assertThat(response.getItems()).isNotEmpty();
        Item knight = response.getItems().getFirst();
        assertThat(knight.getName()).isEqualTo("Knight");
        assertThat(knight.getId()).isEqualTo(26000000);
        assertThat(response.getRawResponse()).isNull();
    }

    @Test
    void findAll_whenApiReturnsError_thenThrowConnectorException() {
        jcrapi2.api.intern.cards.CardsRequest.CardsRequestBuilder builder =
                jcrapi2.api.intern.cards.CardsRequest.builder();
        jcrapi2.api.intern.cards.CardsRequest request = builder.storeRawResponse(true).build();

        assertRequestFails("/cards", EMPTY, request, () -> unitUnderTest.findAll(request).get());
    }
}
