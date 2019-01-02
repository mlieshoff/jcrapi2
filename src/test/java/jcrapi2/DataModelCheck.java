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

import static org.apache.http.HttpHeaders.AUTHORIZATION;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jcrapi2.model.Card;
import jcrapi2.model.ClanCurentWar;
import jcrapi2.model.ClanMember;
import jcrapi2.model.ClanWarLog;
import jcrapi2.model.Location;
import jcrapi2.model.LocationRankingClan;
import jcrapi2.model.LocationRankingClanWar;
import jcrapi2.model.LocationRankingPlayer;
import jcrapi2.model.Player;
import jcrapi2.model.PlayerBattleLog;
import jcrapi2.model.PlayerUpcomingChest;
import jcrapi2.model.SearchedClan;
import jcrapi2.model.SearchedTournament;
import jcrapi2.model.Tournament;
import jcrapi2.response.GetCardsResponse;
import jcrapi2.response.GetClanCurrentWarResponse;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClanWarLogResponse;
import jcrapi2.response.GetClansResponse;
import jcrapi2.response.GetLocationClanRankingsResponse;
import jcrapi2.response.GetLocationClanWarRankingsResponse;
import jcrapi2.response.GetLocationPlayerRankingsResponse;
import jcrapi2.response.GetLocationResponse;
import jcrapi2.response.GetLocationsResponse;
import jcrapi2.response.GetPlayerResponse;
import jcrapi2.response.GetPlayerUpcomingChestsResponse;
import jcrapi2.response.GetTournamentsResponse;

/**
 * @author Michael Lieshoff
 */
public class DataModelCheck {

  private static final String API_KEY = System.getProperty("api.key");

  private final String url;
  private final String developerKey;

  private final Map<String, Map<String, Field>> fields = new HashMap<>();
  private final Map<String, Class<?>> classes = new HashMap<>();

  private final Map<String, Integer> typeCount = new HashMap<>();
  private final Map<String, Map<String, Integer>> deprecatedFieldCount = new HashMap<>();

  public DataModelCheck(String url, String developerKey) {
    this.url = url;
    this.developerKey = developerKey;
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    new DataModelCheck("https://api.clashroyale.com/v1/", API_KEY).start();
  }

  private void start() throws IOException, ClassNotFoundException {
    loadModel();

    testClans();
    testClan();
    testClanMembers();
    testClanWarLog();
    testClanCurrentWar();
    testPlayer();
    testPlayerUpcommingChests();
    testPlayerBattleLog();
    testTournaments();
    testTournament();
    testCards();
    testLocations();
    testLocation();
    testLocationClanRankings();
    testLocationPlayerRankings();
    testLocationWarRankings();
  }

  private void printResults() {
    for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
      String type = entry.getKey();
      int max = entry.getValue();
      Map<String, Integer> map = deprecatedFieldCount.get(type);
      if (map != null) {
        for (Map.Entry<String, Integer> innerEntry : map.entrySet()) {
          String field = innerEntry.getKey();
          int fieldNotFoundCount = innerEntry.getValue();
          if (fieldNotFoundCount == max) {
            System.out.println(type + ".deprecated: " + field + " " + max + " / " + fieldNotFoundCount);
          }
        }
      }
    }
  }

  private void loadModel() throws ClassNotFoundException {
    File dir = new File("src/main/java/jcrapi2/model");
    for (File file : dir.listFiles()) {
      Class<?> clazz = Class.forName("jcrapi2.model." + file.getName().replace(".java", ""));
      registerTemplate(clazz);
    }
    dir = new File("src/main/java/jcrapi2/response");
    for (File file : dir.listFiles()) {
      Class<?> clazz = Class.forName("jcrapi2.response." + file.getName().replace(".java", ""));
      registerTemplate(clazz);
    }
  }

  private void registerTemplate(Class<?> clazz) {
    Map<String, Field> map = new HashMap<>();
    fields.put(clazz.getSimpleName(), map);
    Class<?> clazzToCheck = clazz;
    while (clazzToCheck != null && clazzToCheck != Object.class) {
      classes.put(clazzToCheck.getSimpleName(), clazzToCheck);
      for (Field field : clazzToCheck.getDeclaredFields()) {
        SerializedName serializedName = field.getAnnotation(SerializedName.class);
        if (serializedName != null && field.getAnnotation(Deprecated.class) == null) {
          map.put(serializedName.value(), field);
        }
      }
      for (Class<?> innerClass : clazz.getDeclaredClasses()) {
        registerTemplate(innerClass);
      }
      clazzToCheck = clazzToCheck.getSuperclass();
    }
  }

  private void testClans() throws IOException {
    test(Arrays.asList(
        "clans?name=puzzle"
    ), GetClansResponse.class, false, SearchedClan.class);
  }

  private void testClan() throws IOException {
    test(Arrays.asList(
        "clans/%23RP88QQG"
    ), GetClanResponse.class, false, GetClanResponse.class);
  }

  private void testClanMembers() throws IOException {
    test(Arrays.asList(
        "clans/%23RP88QQG/members"
    ), GetClanMembersResponse.class, false, ClanMember.class);
  }

  private void testClanWarLog() throws IOException {
    test(Arrays.asList(
        "clans/%23RP88QQG/warlog"
    ), GetClanWarLogResponse.class, false, ClanWarLog.class);
  }

  private void testClanCurrentWar() throws IOException {
    test(Arrays.asList(
        "clans/%23RP88QQG/currentwar"
    ), GetClanCurrentWarResponse.class, false, ClanCurentWar.class);
  }

  private void testPlayer() throws IOException {
    test(Arrays.asList(
        "players/%238L9L9GL",
        "players/%23L88P2282",
        "players/%239CQ2U8QJ"
    ), GetPlayerResponse.class, false, Player.class);
  }

  private void testPlayerUpcommingChests() throws IOException {
    test(Arrays.asList(
        "players/%238L9L9GL/upcomingchests",
        "players/%23L88P2282/upcomingchests",
        "players/%239CQ2U8QJ/upcomingchests"
    ), GetPlayerUpcomingChestsResponse.class, false, PlayerUpcomingChest.class);
  }

  private void testPlayerBattleLog() throws IOException {
    test(Arrays.asList(
        "players/%238L9L9GL/battlelog",
        "players/%23L88P2282/battlelog",
        "players/%239CQ2U8QJ/battlelog"
    ), PlayerBattleLog.class, true, PlayerBattleLog.class);
  }

  private void testTournaments() throws IOException {
    test(Arrays.asList(
        "tournaments?name=de",
        "tournaments?name=be",
        "tournaments?name=en"
    ), GetTournamentsResponse.class, false, SearchedTournament.class);
  }

  private void testTournament() throws IOException {
    test(Arrays.asList(
        "tournaments/%23V2RL2Y8",
        "tournaments/%2328RVV2LP",
        "tournaments/%23V2CJR8U"
    ), Tournament.class, false, Tournament.class);
  }

  private void testCards() throws IOException {
    test(Arrays.asList(
        "cards"
    ), GetCardsResponse.class, false, Card.class);
  }

  private void testLocations() throws IOException {
    test(Arrays.asList(
        "locations"
    ), GetLocationsResponse.class, false, Location.class);
  }

  private void testLocation() throws IOException {
    test(Arrays.asList(
        "locations/57000094"
    ), GetLocationResponse.class, false, Location.class);
  }

  private void testLocationClanRankings() throws IOException {
    test(Arrays.asList(
        "locations/57000094/rankings/clans"
    ), GetLocationClanRankingsResponse.class, false, LocationRankingClan.class);
  }

  private void testLocationPlayerRankings() throws IOException {
    test(Arrays.asList(
        "locations/57000094/rankings/players"
    ), GetLocationPlayerRankingsResponse.class, false, LocationRankingPlayer.class);
  }

  private void testLocationWarRankings() throws IOException {
    test(Arrays.asList(
        "locations/57000094/rankings/clanwars"
    ), GetLocationClanWarRankingsResponse.class, false, LocationRankingClanWar.class);
  }

  private void test(List<String> parts, Class<?> clazz, boolean isList, Class<?> itemClass) throws IOException {
    typeCount.clear();
    deprecatedFieldCount.clear();
    try {
      for (String part : parts) {
        String completeUrl = url + part;
        System.out.println("> " + completeUrl);
        File file = new File("/tmp/" + completeUrl.hashCode() + ".json");
        String json;
        if (file.exists()) {
          json = FileUtils.readFileToString(file);
        } else {
          json = new Crawler(new HttpClientFactory()).get(completeUrl, createHeader());
          FileUtils.write(file, json, Charsets.UTF_8.name());
        }
        System.out.println(json);
        JsonElement jelement = new JsonParser().parse(json);
        if (isList) {
          jelement = jelement.getAsJsonArray();
        } else {
          jelement = jelement.getAsJsonObject();
        }
        compare(jelement, null, clazz.getSimpleName(), itemClass.getSimpleName());
      }
      printResults();
    } catch (Throwable t) {
      System.out.println("ERROR: " + t.getMessage());
    }
  }

  private Collection<String> compare(JsonElement jsonElement, Field sourceField, String templateName,
                                     String itemClass) {
    Collection<String> foundFields = new HashSet<>();
    Collection<String> expectedFields = new HashSet<>();
    Class<?> clazz = classes.get(templateName);
    Map<String, Field> map = fields.get(templateName);

    if (map != null) {
      expectedFields.addAll(map.keySet());
    } else {
      if (templateName.equalsIgnoreCase(String.class.getName())) {
        return Collections.emptyList();
      }
      System.out.println("type not found: " + templateName + " " + sourceField);
    }

    if (jsonElement.isJsonArray()) {
      for (Iterator<JsonElement> iterator = jsonElement.getAsJsonArray().iterator(); iterator.hasNext(); ) {
        JsonElement jsonListElement = iterator.next();
        if (!jsonListElement.isJsonPrimitive()) {
          Collection<String>
              collection =
              compare(jsonListElement, sourceField, WordUtils.capitalize(templateName), itemClass);
          if (!collection.isEmpty()) {
            foundFields.addAll(collection);
          }
        }
      }
    } else if (jsonElement.isJsonObject()) {
      JsonObject jsonObject = jsonElement.getAsJsonObject();
      for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String jsonFieldName = entry.getKey();
        foundFields.add(jsonFieldName);
        JsonElement jsonElement1 = entry.getValue();
        Field field = map != null ? map.get(jsonFieldName) : null;
        if (field == null) {
          if (clazz == null || Map.class.isAssignableFrom(clazz)) {
            System.out.println(templateName + ".missing: " + jsonFieldName + " -> " + jsonElement1);
          }
        } else {
          if (!jsonElement1.isJsonPrimitive()) {
            if (isCollection(field) || isArray(field)) {
              String typeName = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0].getTypeName();
              if ("T".equals(typeName)) {
                compare(jsonElement1, field, itemClass, itemClass);
              } else {
                compare(jsonElement1, field, WordUtils.capitalize(typeName.replace("jcrapi2.model.", "")), itemClass);
              }
            } else if (jsonElement1.isJsonObject()) {
              compare(jsonElement1, field, field.getType().getSimpleName(), itemClass);
            }
          }
        }
      }
    }
    typeCount.put(templateName, Optional.fromNullable(typeCount.get(templateName)).or(0) + 1);
    Collection<String> notExpected = CollectionUtils.subtract(expectedFields, foundFields);
    Collection<String> notDefined = CollectionUtils.subtract(foundFields, expectedFields);
    if (!notExpected.isEmpty()) {
      Map<String, Integer> deprecatedMap = deprecatedFieldCount.get(templateName);
      if (deprecatedMap == null) {
        deprecatedMap = new HashMap<>();
        deprecatedFieldCount.put(templateName, deprecatedMap);
      }
      for (String deprecatedFieldName : notExpected) {
        String id = templateName + "." + deprecatedFieldName;
        deprecatedMap.put(id, Optional.fromNullable(deprecatedMap.get(id)).or(0) + 1);
      }
    }
    if (!notDefined.isEmpty()) {
      System.out.println(templateName + ".not defined in model: " + notDefined);
    }
    return foundFields;
  }

  private boolean isCollection(Field field) {
    return Collection.class.isAssignableFrom(field.getType());
  }

  private boolean isArray(Field field) {
    return Array.class.isAssignableFrom(field.getType());
  }

  private Map<String, String> createHeader() {
    return ImmutableMap.<String, String>builder().put(AUTHORIZATION, "Bearer " + developerKey).build();
  }

}
