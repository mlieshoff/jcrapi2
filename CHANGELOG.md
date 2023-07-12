## Changelog

## [Unreleased]


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

[unreleased]: https://github.com/mlieshoff/jcrapi2/compare/v2.1.0...HEAD
[2.1.0]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.6...v2.1.0
[2.0.6]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.5...v2.0.6
[2.0.5]: https://github.com/mlieshoff/jcrapi2/compare/v2.0.5...v2.0.5
