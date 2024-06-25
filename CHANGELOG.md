## Changelog

## [Unreleased]

## [4.0.8] - 2024-06-25

### Added

- New endpoint /leaderboard/{leaderboardId} (#196)

## [4.0.7] - 2024-06-25

### Added

- New endpoint /leaderboards (#196)

## [4.0.6] - 2024-06-25

### Changed

- Apply data model changes on players.findByTag endpoint (#194)
* (new field) players.info.Player.progress
* (new class) players.info.Player.GoblinRoad
* (new field) players.info.Player.GoblinRoad.arena
* (new field) players.info.Player.GoblinRoad.trophies
* (new field) players.info.Player.GoblinRoad.bestTrophies

## [4.0.5] - 2024-04-30

### Changed

- test scope: isNotBlank() and EMPTY not depending on wiremock anymore
- test scope: clean up integration test base & tests
- Source code is now ready for Java 21 (#173)
- Binary code is now Java 21 compliant (#173)
- JaCoCo from 0.8.11 to 0.8.12
- Maven Compiler Plugin from 3.11.0 to 3.13.0
- Maven Exec Plugin from 3.1.1 to 3.2.0
- Maven Source Plugin from 3.3.0 to 3.3.1
- Maven Surefire Plugin from 3.2.3 to 3.2.5
- WireMock from 3.0.1 to 3.5.4
- Google Formatter from 1.17.0 to 1.22.0

### Removed

- formatter file intellij_code_formatter.xml

## [4.0.4] - 2024-04-30

### Fixed

- Correct datatype for CurrentFavouriteCard.maxEvolutionLevel (#190)
    * (changed field) players.info.CurrentFavouriteCard.maxEvolutionLevel to Integer

## [4.0.3] - 2024-04-26

### Added

- Apply data model changes on different endpoints (#185)
    * (new field) players.info.CurrentFavouriteCard.maxEvolutionLevel

### Changed

- Apache Commons IO from 2.15.1 to 2.16.1
- JUnit from 5.10.10 to 5.10.2
- Lombok from 1.18.30 to 1.18.32
- Mockito from 5.8.0 to 5.11.0
- SLF4j from 2.0.9 to 2.0.13
- Supercell API Wrapper Essentials from 1.0.0 to 1.0.1

## [4.0.2] - 2024-02-16

### Added

- Apply data model changes on different endpoints (#185)
    * (new field) players.info.Player.supportCards
    * (new field) players.info.Player.currentDeckSupportCards
    * (new field) players.info.Card.rarity
    * (new field) players.info.Card.elixirCost
    * (new field) players.info.CurrentDeck.rarity
    * (new field) players.info.CurrentDeck.elixirCost
    * (new field) players.info.CurrentFavouriteCard.rarity
    * (new field) players.info.CurrentFavouriteCard.elixirCost
    * (new field) players.battlelog.Team.supportCards
    * (new field) players.battlelog.Card.rarity
    * (new field) players.battlelog.Card.elixirCost
    * (new field) players.battlelog.Opponent.supportCards
    * (new field) cards.Cards.supportItems
    * (new field) cards.Card.rarity
    * (new field) cards.Card.elixirCost
    * (new field) globaltournaments.Card.rarity

## [4.0.1] - 2024-02-15

### Fixed

- surefire now uses the build dependencies and no more inner ones.

## [4.0.0] - 2023-12-18

### Added

- new dependency supercell-api-wrapper-essentials

### Changed

- classes in package jcrapi2.api.* moved to supercell.api.wrapper.essentials.api.*
- classes in package jcrapi2.connector moved to supercell.api.wrapper.essentials.connector
- classes in package jcrapi2.api.connector moved to supercell.api.wrapper.essentials.api.connector
- classes in package jcrapi2.build moved to supercell.api.wrapper.essentials.build
- classes in package jcrapi2.common moved to supercell.api.wrapper.essentials.common

### Removed

- class jcrapi2.api.intern.locations.seasons.global.v2.TopPlayerLeagueSeasonsRequest
- class jcrapi2.api.intern.locations.seasons.global.v2.TopPlayerLeagueSeasonsResponse

## [3.0.5] - 2023-12-18

### Added

- Maven enforcer plugin -> Minimum Maven version is now 3.8.8

### Changed

- Lombok from 1.18.24 to 1.18.30
- JaCoCo from 0.8.10 to 0.8.11
- Apache Commons IO from 2.11.0 to 2.15.1
- JUnit from 5.8.2 to 5.10.1
- SLF4j from 1.8.0-beta2 to 2.0.9
- Mockito from 4.5.1 to 5.8.0
- WireMock from 2.27.2 to 3.0.1
- GSON from 2.9.0 to 2.10.1
- Maven Source from 3.0.1 to 3.3.0
- Maven Surefire from 2.22.2 to 3.2.3

## [3.0.4] - 2023-12-12

### Removed

- Qodana

## [3.0.3] - 2023-09-26

### Added

- Test Coverage via Qodana

## [3.0.2] - 2023-09-25

### Added

- Release version check on build time

## [3.0.1] - 2023-09-23

### Added

- Qodana code quality support via actions
- Badges for Nightlies and Qodana

## [3.0.0] - 2023-09-12

### Changed

- Source code is now ready for Java 17 (#149)
- Binary code is now Java 17 compliant (#149)

## [2.1.5] - 2023-08-30

### Added

- Apply data model changes on different endpoints (#162)
* (new field) player.info.Card.evolutionLevel
* (new field) player.info.CurrentDeck.evolutionLevel

### Changed

- Making locations_getTopPlayerLeagueSeasons end-to-end test more robust

## [2.1.4] - 2023-07-13

### Added

- New endpoint /locations/{locationId}/pathoflegend/players (#158)

## [2.1.3] - 2023-07-13

### Added

- New endpoint /locations/global/seasonsV2

## [2.1.2] - 2023-07-13

### Added

- New endpoint /locations/global/rankings/tournaments/{tournamentTag}

### Changed

- E2E testing to check if received JSON was empty

## [2.1.1] - 2023-07-13

### Added

- New endpoint /locations/global/pathoflegend/{seasonId}/rankings/players (#143)
- Possibility to create cached connector for E2E testing (for now)

## [2.1.0] - 2023-07-12

### Changed

- Move tournament package to tournaments (#147)

## [2.0.6] - 2023-07-12

### Added

- Apply data model changes on different endpoints (#150)
    * (new field) cards.Card.maxEvolutionLevel
    * (new field) cards.IconUrls.evolutionMedium
    * (new field) players.battlelog.Cards.maxEvolutionLevel
    * (new field) players.battlelog.Cards.evolutionLevel
    * (new field) players.battlelog.IconUrls.evolutionMedium
    * (new field) players.battlelog.LogEntry.leagueNumber
    * (new field) players.battlelog.Opponent.globalRank
    * (new field) players.battlelog.Team.globalRank
    * (new field) players.info.Card.maxEvolutionLevel
    * (new field) players.info.CurrentDeck.maxEvolutionLevel
    * (new field) players.info.IconUrls.evolutionMedium
    * (new field) players.info.Player.legacyTrophyRoadHighScore
    * (new field) players.info.Player.currentPathOfLegendSeasonResult
    * (new field) players.info.Player.lastPathOfLegendSeasonResult
    * (new field) players.info.Player.bestPathOfLegendSeasonResult
    * (new type) players.infoPathOfLegendSeasonResult

### Changed

- EndToEnd test class to pass nightlies

## [2.0.5] - 2023-07-12

### Added

- Create a Release job (#152)

[unreleased]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.8...HEAD
[4.0.8]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.7...4.0.8
[4.0.7]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.6...4.0.7
[4.0.6]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.5...4.0.6
[4.0.5]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.4...4.0.5
[4.0.4]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.3...4.0.4
[4.0.3]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.2...4.0.3
[4.0.2]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.1...4.0.2
[4.0.1]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.0...4.0.1
[4.0.0]: https://github.com/mlieshoff/jcrapi2/compare/v3.0.5...4.0.0
[3.0.5]: https://github.com/mlieshoff/jcrapi2/compare/v3.0.4...3.0.5
[3.0.4]: https://github.com/mlieshoff/jcrapi2/compare/v3.0.3...3.0.4
[3.0.3]: https://github.com/mlieshoff/jcrapi2/compare/v3.0.2...3.0.3
[3.0.2]: https://github.com/mlieshoff/jcrapi2/compare/v3.0.1...3.0.2
[3.0.1]: https://github.com/mlieshoff/jcrapi2/compare/v3.0.0...3.0.1
[3.0.0]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.5...3.0.0
[2.1.5]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.4...v2.1.5
[2.1.4]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.3...v2.1.4
[2.1.3]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.2...v2.1.3
[2.1.2]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.1...v2.1.2
[2.1.1]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.0...v2.1.1
[2.1.0]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.6...v2.1.0
[2.0.6]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.5...v2.0.6
[2.0.5]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.5...v2.0.5
