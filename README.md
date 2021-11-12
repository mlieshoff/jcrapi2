[![](https://img.shields.io/badge/java-packagecloud.io-844fec.svg)](https://packagecloud.io/)

# jcrapi2
A Java Wrapper For Official Supercell Clash Royal Api 

## Actual version: 1.0.2
(we moved repository to https://packagecloud.io/mlieshoff/jcrapi2)

## Simplest Usage ##

Note: Please combine the builder methods as it makes sense. The demonstrated was is showing only all possibilities. 
For more information please check 

https://developer.clashroyale.com/#/documentation

```java
// connect to api
Api api = new Api("https://api.clashroyale.com/v1/", "my-api-key");
```

```java
// get clans
GetClansResponse getClansResponse = api.getClans(GetClansRequest.builder()
  // search criteria
  .name()
  .locationId()
  .minScore()
  .minMembers()
  .maxMembers()
  // paging
  .after()
  .before()
  .limit()
  .build()
);
```

```java
// get clan
GetClanResponse getClanResponse = api.getClan(GetClanRequest.builder("#RP88QQG").build());
```

```java
// get clan members
GetClanMembersResponse getClanMembersResponse = api.getClanMembers(GetClanMembersRequest.builder("#RP88QQG")
  // paging
  .after()
  .before()
  .limit()
  .build()
);
```

```java
// get clan war log
GetClanWarLogResponse getClanWarLogResponse = api.getClanWarLog(GetClanWarLogRequest.builder("#RP88QQG")
  // paging
  .after()
  .before()
  .limit()
  .build()
);
```

```java
// get clan current war
GetClanCurrentWarResponse getClanCurrentWarResponse = api.getClanCurrentWar(GetClanCurrentWarRequest.builder("#RP88QQG").build());
```

```java
// get player
GetPlayerResponse getPlayerResponse = api.getPlayer(GetPlayerRequest.builder("#L88P2282").build());
```

```java
// get player upcomming chests 
GetPlayerUpcomingChestsResponse getPlayerUpcomingChestsResponse = api.getPlayerUpcomingChests(GetPlayerUpcomingChestsRequest.builder("#L88P2282")
  // paging
  .after()
  .before()
  .limit()
  .build()
);
```

```java
// get player battle log
GetPlayerBattleLogResponse getPlayerBattleLogResponse = api.getPlayerUpcomingChests(GetPlayerUpcomingChestsRequest.builder("#L88P2282"));
```

```java
// get tournaments
GetTournamentsResponse getTournamentsResponse = api.getTournaments(GetTournamentsRequest.builder()
  .name("de")
  // paging
  .after()
  .before()
  .limit()
  .build()
);
```

```java
// get thread safe last response object from last request 
RawResponse rawResponse = api.getLastRawResponse();

String raw = rawResponse.getRaw();
Map<String, String> responseHeaders = rawResponse.getResponseHeaders();
```

```java
// get cards
GetCardsResponse getCardsResponse = api.getCards();
```

```java
// get locations
GetLocationsResponse getLocationsResponse = api.getLocations(GetLocationsRequest.builder()
  // paging
  .after()
  .before()
  .limit()
  .build()
);
```

```java
// get location
GetLocationResponse getLocationResponse = api.getLocation(GetLocationRequest.builder("57000000").build());
```

```java
// get location clan rankings
GetLocationClanRankingsResponse getLocationClanRankingsResponse = api.getLocationClanRankings(GetLocationClanRankingsRequest.builder("57000000").build());
```

```java
// get location player rankings
GetLocationPlayerRankingsResponse getLocationClanRankingsResponse = api.getLocationPlayerRankings(GetLocationPlayerRankingsRequest.builder("57000000").build());
```

```java
// get location clan war rankings
GetLocationClanWarRankingsResponse getLocationClanWarRankingsResponse = api.getLocationPlayerRankings(GetLocationClanWarRankingsRequest.builder("57000000").build());
```

```java
// get clan war log
GetClanRiverRaceLogResponse getClanRiverRaceLogResponse = api.getClanRiverRaceLog(GetClanWarLogRequest.builder("#RP88QQG")
  // paging
  .after()
  .before()
  .limit()
  .build()
);
```

## Asynchronous usage

All requests can have a *callback*. Then execution will be asynchronous.

```java
// get clans
api.getClans(GetClansRequest.builder()
  // search criteria
  .name()
  .locationId()
  .minScore()
  .minMembers()
  .maxMembers()
  // paging
  .after()
  .before()
  .limit()
  .build()
  // async callback
  .callback(new Callback<GetClansResponse>() {
    @Override
    public void onResponse(GetClansResponse getClansResponse) {
      // handle result
    }

    @Override
    public void onException(Exception exception) {
      state.set(true);
    }
  })
);
```
 

## How to bind the packagecloud repository ##

```xml
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
```
## Continuous Integration ##

https://github.com/mlieshoff/jcrapi2/actions

## Repository ##

https://bintray.com/mlieshoff/maven/jcrapi2

## Logging ##

We use SLF4j.

## Usage of RoyaleApi proxy ##

This wrapper can be easy connected to the proxy of our friends on RoyaleAPI. Please proceed first the steps described here:

https://docs.royaleapi.com/#/proxy

Then initialize an instance of class Api like that:

```
Api api = new Api("https://proxy.royaleapi.dev/v1/", API_KEY);
```

That's all, enjoy :)
