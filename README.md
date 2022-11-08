[![](https://img.shields.io/badge/java-packagecloud.io-844fec.svg)](https://packagecloud.io/)

# jcrapi2 2.0.3
A Java Wrapper For Official Supercell Clash Royal Api

## Why we don't use the Swagger scheme?

A big sorry for that, but the quality of that scheme changes from day to day.
Another big sorry, but the OpenApi Java generator is producing code quality we like much.
That's simple why :) If you think the same way (it may differ from case to case of course), feel free to continue using our wrapper.

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

Use built-in http connector
```java
    Connector connector = new StandardConnector();
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
    implementation group: 'jcrapi2', name: 'jcrapi2', version: '2.0.3'
```

to Maven:
```xml
    <dependency>
        <groupId>jcrapi2</groupId>
        <artifactId>jcrapi2</artifactId>
        <version>2.0.3</version>
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