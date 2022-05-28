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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jcrapi2.api.Api;
import jcrapi2.api.ApiContext;
import jcrapi2.api.BaseApi;
import jcrapi2.api.intern.clans.ClanApi;
import jcrapi2.connector.Connector;
import lombok.NonNull;

@ExtendWith(MockitoExtension.class)
class JCrApiTest {

  private static final String URL = "url";
  private static final String API_KEY = "apiKey";

  private JCrApi unitUnderTest;

  @Mock
  private Connector connector;

  @BeforeEach
  void setUp() {
    unitUnderTest = new JCrApi(URL, API_KEY, connector);
  }

  @Test
  void listApis_whenCalled_shouldReturnListOfApiInterfaceNames() {
    Set<String>
        expected =
        new HashSet<>(
            Arrays.asList(
                "jcrapi2.api.intern.cards.CardApi",
                "jcrapi2.api.intern.challenges.ChallengeApi",
                "jcrapi2.api.intern.clans.ClanApi",
                "jcrapi2.api.intern.globaltournaments.GlobalTournamentApi",
                "jcrapi2.api.intern.locations.LocationApi",
                "jcrapi2.api.intern.players.PlayerApi",
                "jcrapi2.api.intern.tournament.TournamentApi"
            )
        );

    List<String> actual = unitUnderTest.listApis();

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  void getApi_whenWithValidParameter_shouldReturnApiInstance() {
    ClanApi actual = unitUnderTest.getApi(ClanApi.class);

    assertNotNull(actual);
  }

  @ParameterizedTest
  @CsvSource(value = "null,", nullValues = "null")
  void registerApi_whenWithNull_thenThrowException(String actual) {

    assertThrows(IllegalArgumentException.class, () -> unitUnderTest.register(FooApi.class, actual));
  }

  @Test
  void registerAndGetApi_whenWithValidParameter_shouldRegister() {
    unitUnderTest.register(FooApi.class, FooApiImpl.class.getName());
    FooApi actual = unitUnderTest.getApi(FooApi.class);

    assertNotNull(actual);
  }

  public interface FooApi extends Api {

  }

  public static class FooApiImpl extends BaseApi implements FooApi {

    public FooApiImpl(@NonNull ApiContext apiContext) {
      super(apiContext);
    }

  }

}