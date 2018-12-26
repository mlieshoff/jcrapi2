# jcrapi2
A Java Wrapper For Official Supercell Clash Royal Api 

## Actual version: 1.0.0-M4

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
 

## How to bind the bintray repository ##

```xml
<repository>
    <id>org-mili-repo</id>
    <url>http://dl.bintray.com/mlieshoff/maven</url>
    <releases>
        <enabled>true</enabled>
    </releases>
    <snapshots>
        <enabled>false</enabled>
    </snapshots>
</repository>
```
## Continuous Integration ##

https://travis-ci.org/mlieshoff/jcrapi2

## Repository ##

https://bintray.com/mlieshoff/maven/jcrapi2

## Logging ##

We use SLF4j.

## Working Agreement

1. Get a ticket
* Assign it to you
* Move it in the projects board from "To Do" to "In Progress" 
2. Create a branch: issue<ticket number>_<small_description>
3. Implement your changes, do TDD!
* Reformat the code with the projects formatter (intellij_code_formatter.xml)
* Analyze the changed files with the projects inspection rules (intellij_inspection_rules.xml)
* Commit with message like: [Issue<ticket_number>] <your message>
4. Create a pull request as fast as possible, base it to master
* Name it like: [Issue<ticket_number>] <your message>
* Put label WIP
5. You're done if:
* All tests are green (old and new ones)
* Code coverage is 100%
* Build system is also okay with compiling and tests, check pull request mergeability
* Remove label WIP
6. Shift the ticket to done into the projects board
7. Do "Squash and Merge" in your pull request
8. Copy the pull requests link to your ticket as close comment and close the ticket
9. Shift the ticket to merged in the projects board
10. If you have to update from master:
a) use merge not rebase

### Testing
1. Create an end to end test
2. Create an integration test
3. Create an unit test