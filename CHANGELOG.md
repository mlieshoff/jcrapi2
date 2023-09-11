## Changelog

## [Unreleased]

## [3.0.0] - 2023-09-08

### Added

### Fixed

### Changed

### Removed

## [2.1.5] - 2023-08-30

### Added

- Apply data model changes on different endpoints (#162)
* (new field) player.info.Card.evolutionLevel
* (new field) player.info.CurrentDeck.evolutionLevel

### Changed

+ locations_getTopPlayerLeagueSeasons end-to-end test for being more robust

## [2.1.4] - 2023-07-13

### Added

- new endpoint /locations/{locationId}/pathoflegend/players (#158)

## [2.1.3] - 2023-07-13

### Added

- new endpoint /locations/global/seasonsV2

## [2.1.2] - 2023-07-13

### Added

- new endpoint /locations/global/rankings/tournaments/{tournamentTag}

### Changed

- E2E testing to check if received JSON was empty

## [2.1.1] - 2023-07-13

### Added

- new endpoint /locations/global/pathoflegend/{seasonId}/rankings/players (#143)
- possibility to create cached connector for E2E testing (for now)

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

[unreleased]: https://github.com/mlieshoff/jcrapi2/compare/v3.0.0...HEAD
[2.1.5]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.4...v2.1.5}
[2.1.4]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.3...v2.1.4}
[2.1.3]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.2...v2.1.3}
[2.1.2]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.1...v2.1.2}
[2.1.1]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.0...v2.1.1
[2.1.0]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.6...v2.1.0
[2.0.6]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.5...v2.0.6
[2.0.5]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.5...v2.0.5
