[![](https://img.shields.io/badge/java-packagecloud.io-844fec.svg)](https://packagecloud.io/)
[![Nightlies](https://github.com/mlieshoff/jcrapi2/actions/workflows/nightlies.yml/badge.svg)](https://github.com/mlieshoff/jcrapi2/actions/workflows/nightlies.yml)

# jcrapi2 5.0.0
A Java Wrapper For Official Supercell Clash Royal Api

## Generated API data classes

`src/main/resources/api.yaml` is the source for the generated Java data classes.
Maven runs OpenAPI Generator 7.10.0 during `generate-sources`:

```bash
mvn generate-sources
mvn test
```

Models are generated in `target/generated-sources/openapi/src/main/java`, in the
`jcrapi2.api.generated.model` package, and automatically compiled into the JAR.
The generator uses the Java generator's `feign` templates with Gson serialization
for standalone POJOs. API clients, supporting files, documentation, and generated
tests are disabled; no Feign runtime is needed for these models.
The schema uses API wire values for enums (for example, `inviteOnly`,
`singleChallenge`, and `elder`); parsing also ignores case. Absent arrays remain
null so serialization does not add empty arrays to responses.
Edit `api.yaml` and regenerate instead of editing generated files.

The existing `api.intern` packages, API interfaces, Impls, requests, and response
wrappers remain in place. Object response wrappers now extend generated models;
paginated wrappers use generated item types. Battle logs and challenge responses
retain their list shape with generated elements. This lets the Impls keep using
the existing connector, futures, pagination, error handling, and raw responses.

For example, `CardApi.findAll(CardsRequest)` still returns `Future<CardsResponse>`,
but `CardsResponse` now extends generated `Items`, and `getItems()` returns
`List<jcrapi2.api.generated.model.Item>`. Nested getters now return generated
classes and enums rather than the old handwritten DTO types. Localized names
are strings, while icons and player progress have typed generated models.

Unused handwritten DTOs have been removed from `src/main/java`; response
payloads use the generated models. Callers that explicitly refer to old DTO types
need to update their imports and any string comparisons against enum getters.

The integration tests verify the existing request/response behavior, generated
payload types, and preservation of every non-null field in the JSON fixtures.

## Why we moved to the amazing services of packagecloud?

We moved to packagecloud.io because the bintray closed their nice hosting... And packagecloud.io is a really nice place to be :)

## Join us on Discord

https://discord.gg/WNb5c8hn

## Simplest Usage

Note: Please combine the builder methods as it makes sense. The demonstrated is showing only all possibilities.
For more information please check

https://developer.clashroyale.com/#/documentation

Use one of these endpoints:

Official endpoint
```
    https://api.clashroyale.com/v1
```

Proxy endpoint
```
    https://crproxy.royaleapi.dev/v1
```

Use built-in standard connector
```java
Connector connector = new StandardConnector();
```

or use the new filesystem cached connector
```java
Connector connector = new FilesystemCachedConnector("jcrapi2")
```

or use custom implementation
```java
    Connector connector = new Connector() {
        @Override
        public <T extends IResponse> T get(RequestContext requestContext) throws ConnectorException {
                // do not forget to use auth header with *Bearer*
                String authHeader =  "Authorization: Bearer " + requestContext.getApiKey();
            }
        }
    );
```

connect to the api with creating a *ClashRoyale* instance.
```java
    JCrApi jCrApi = new JCrApi("https://crproxy.royaleapi.dev/v1", "my-api-key", connector);
```

list all supported apis
```java
    System.out.println(jCrApi.listApis());
```

### List of APIs and example usages

#### ClanApi
```java
    // create an instance for the api
    ClanApi api = jCrApi.getApi(ClanApi.class);
```
```java
    // findAll
    ClansResponse response = api.findAll(clansRequest.builder()
           .name()
           .locationId()
           .minMembers()
           .maxMembers()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // findByTag
    ClanResponse response = api.findByTag(clanRequest.builder()
           .clanTag()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getRiverRaceLog
    RiverRaceLogResponse response = api.getRiverRaceLog(riverRaceLogRequest.builder()
           .clanTag()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getMembers
    ClanMembersResponse response = api.getMembers(clanMembersRequest.builder()
           .clanTag()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getCurrentRiverRace
    CurrentRiverRaceResponse response = api.getCurrentRiverRace(currentRiverRaceRequest.builder()
           .clanTag()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
#### PlayerApi
```java
    // create an instance for the api
    PlayerApi api = jCrApi.getApi(PlayerApi.class);
```
```java
    // findByTag
    PlayerResponse response = api.findByTag(playerRequest.builder()
           .playerTag()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getUpcomingChests
    UpcomingChestsResponse response = api.getUpcomingChests(upcomingChestsRequest.builder()
           .playerTag()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getBattleLog
    BattleLogResponse response = api.getBattleLog(battleLogRequest.builder()
           .playerTag()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
#### CardApi
```java
    // create an instance for the api
    CardApi api = jCrApi.getApi(CardApi.class);
```
```java
    // findAll
    CardsResponse response = api.findAll(cardsRequest.builder()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
#### TournamentApi
```java
    // create an instance for the api
    TournamentApi api = jCrApi.getApi(TournamentApi.class);
```
```java
    // findAll
    TournamentsResponse response = api.findAll(tournamentsRequest.builder()
           .name()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // findByTag
    TournamentResponse response = api.findByTag(tournamentRequest.builder()
           .tournamentTag()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
#### LocationApi
```java
    // create an instance for the api
    LocationApi api = jCrApi.getApi(LocationApi.class);
```
```java
    // findAll
    LocationsResponse response = api.findAll(locationsRequest.builder()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // findById
    LocationResponse response = api.findById(locationRequest.builder()
           .locationId()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getClanRankings
    ClanRankingsResponse response = api.getClanRankings(clanRankingsRequest.builder()
           .locationId()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getPlayerRankings
    PlayerRankingsResponse response = api.getPlayerRankings(playerRankingsRequest.builder()
           .locationId()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getClanWarRankings
    ClanWarRankingsResponse response = api.getClanWarRankings(clanWarRankingsRequest.builder()
           .locationId()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getTopPlayerLeagueSeasons
    TopPlayerLeagueSeasonsResponse response = api.getTopPlayerLeagueSeasons(topPlayerLeagueSeasonsRequest.builder()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getTopPlayerLeagueSeason
    TopPlayerLeagueSeasonResponse response = api.getTopPlayerLeagueSeason(topPlayerLeagueSeasonRequest.builder()
           .seasonId()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getTopPlayerLeagueSeasonRankings
    TopPlayerLeagueSeasonRankingsResponse response = api.getTopPlayerLeagueSeasonRankings(topPlayerLeagueSeasonRankingsRequest.builder()
           .seasonId()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getTopPlayerPathOfLegendSeasonRankings
    TopPlayerPathOfLegendSeasonRankingsResponse response = api.getTopPlayerPathOfLegendSeasonRankings(topPlayerPathOfLegendSeasonRankingsRequest.builder()
           .seasonId()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getTopPlayerPathOfLegendRankings
    TopPlayerPathOfLegendRankingsResponse response = api.getTopPlayerPathOfLegendRankings(topPlayerPathOfLegendRankingsRequest.builder()
           .locationId()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getTopPlayerTournamentRankings
    TopPlayerTournamentRankingsResponse response = api.getTopPlayerTournamentRankings(topPlayerTournamentRankingsRequest.builder()
           .tournamentTag()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // getTopPlayerLeagueSeasonsV2
    TopPlayerLeagueSeasonsV2Response response = api.getTopPlayerLeagueSeasonsV2(topPlayerLeagueSeasonsV2Request.builder()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
#### ChallengeApi
```java
    // create an instance for the api
    ChallengeApi api = jCrApi.getApi(ChallengeApi.class);
```
```java
    // findAll
    ChallengesResponse response = api.findAll(challengesRequest.builder()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
#### GlobalTournamentApi
```java
    // create an instance for the api
    GlobalTournamentApi api = jCrApi.getApi(GlobalTournamentApi.class);
```
```java
    // findAll
    GlobalTournamentsResponse response = api.findAll(globalTournamentsRequest.builder()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
#### LeaderboardApi
```java
    // create an instance for the api
    LeaderboardApi api = jCrApi.getApi(LeaderboardApi.class);
```
```java
    // findAll
    LeaderboardsResponse response = api.findAll(leaderboardsRequest.builder()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```
```java
    // findById
    LeaderboardResponse response = api.findById(leaderboardRequest.builder()
           .leaderboardId()
           // pagination
           .limit()
           .after()
           .before()
           // store raw response
           .storeRawResponse()
        .build()
    ).get();
```

## Add or replace registered API's

```java
    JCrApi jCrApi = new JCrApi(...);
    jCrApi.register(MyApi.class, MyApiImpl.class.getName());
    MyApi myApi = jCrApi.getApi(MyApi.class);
    GoodiesResponse goodiesResponse = myApi.findAllGoodies(new GoodiesRequest(...))).get();
```

Custom API implementations just need to inherit from *BaseApi*.

## Asynchronous usage

All requests are returning *java.concurrent.Future*. The execution will be asynchronous by default.

## How to bind the packagecloud repository

```xml
    <repositories>
        <repository>
            <id>packagecloud-jcrapi2</id>
            <url>https://packagecloud.io/mlieshoff/jcrapi2/maven2</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
```

## Add dependency

to Gradle:
```groovy
    implementation group: 'jcrapi2', name: 'jcrapi2', version: '5.0.0'
```

to Maven:
```xml
    <dependency>
        <groupId>jcrapi2</groupId>
        <artifactId>jcrapi2</artifactId>
        <version>5.0.0</version>
    </dependency>
```

## Continuous Integration

https://github.com/mlieshoff/jcrapi2/actions

## Repository

https://packagecloud.io/mlieshoff/jcrapi2

## Logging

We are using SLF4j.

## Usage of RoyaleApi proxy

This wrapper can be easyly connected to the proxy of our friends on RoyaleAPI. Please proceed first the steps described here:

https://docs.royaleapi.com/#/proxy

Then initialize an instance of class Api like that:

```java
    JCrApi jCrApi = new JCrApi("https://crproxy.royaleapi.dev/v1", API_KEY, CONNECTOR);
```

That's all, enjoy :)

## Library updates

Minor versions
```
mvn versions:update-parent versions:use-latest-releases versions:update-properties versions:commit -DallowMajorUpdates=false
```

Major versions
```
mvn versions:update-parent versions:use-latest-releases versions:update-properties versions:commit -DallowMajorUpdates=true
```

Update plugins
```
mvn versions:display-plugin-updates -U
```
## Contributing

1. Feel free to open Pull Requests with your ideas :)