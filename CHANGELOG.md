## Changelog

## [Unreleased]

## [4.0.0] - 2023-12-18

### Added

- new dependency supercell-api-wrapper-essentials

### Changed

- classes in package jcrapi2.api.* moved to supercell.api.wrapper.essentials.api.*
- classes in package jcrapi2.connector moved to supercell.api.wrapper.essentials.connector
- classes in package jcrapi2.api.connector moved to supercell.api.wrapper.essentials.api.connector
- classes in package jcrapi2.build moved to supercell.api.wrapper.essentials.build
- classes in package jcrapi2.common moved to supercell.api.wrapper.essentials.common

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

[unreleased]: https://github.com/mlieshoff/jcrapi2/compare/v4.0.0...HEAD
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
