# Integration-test response fixtures

Checked against `https://api.clashroyale.com/v1` on **2026-10-16**. These are
fixed snapshots; the integration tests replay them through WireMock and do not
require a live API key. The audit key was used only in memory and is not stored.

## Current successful responses

Fixtures contain sampled response bodies from the requests below. Every list,
including nested lists, keeps at most five entries. Lists with fewer entries,
empty lists, and null values retain their observed shape. Fields on retained
objects, API counts, ranks, and paging cursors are preserved. Mock request
parameters exercise URL construction independently of snapshot provenance.

| Fixture | Verified request | Retained items |
| --- | --- | --- |
| `card-findAll.json` | `/cards` | 5 |
| `clan-findAll.json` | `/clans?name=Royal&limit=10` | 5 |
| `clan-findByTag.json` | `/clans/%23RYQJYLQV` | object |
| `clan-getCurrentRiverRace.json` | `/clans/%23RYQJYLQV/currentriverrace` | object |
| `clan-getMembers.json` | `/clans/%23RYQJYLQV/members?limit=10` | 5 |
| `clan-getRiverRaceLog.json` | `/clans/%23RYQJYLQV/riverracelog?limit=2` | 2 |
| `globalTournament-findAll.json` | `/globaltournaments` | 0 |
| `leaderboard-findAll.json` | `/leaderboards` | 5 |
| `leaderboard-findById.json` | `/leaderboard/679855?limit=10` | 5 |
| `location-findAll.json` | `/locations` | 5 |
| `location-findById.json` | `/locations/57000094` | object |
| `location-getClanRankings.json` | `/locations/57000094/rankings/clans?limit=10` | 5 |
| `location-getClanWarRankings.json` | `/locations/57000094/rankings/clanwars?limit=10` | 5 |
| `location-getPlayerRankings.json` | `/locations/57000094/rankings/players?limit=10` | 0 |
| `location-getTopPlayerLeagueSeason.json` | `/locations/global/seasons/2026-09` | object |
| `location-getTopPlayerLeagueSeasonRankings.json` | `/locations/global/seasons/2022-04/rankings/players?limit=10` | 5 |
| `location-getTopPlayerLeagueSeasons.json` | `/locations/global/seasons` | 5 |
| `location-getTopPlayerLeagueSeasonsV2.json` | `/locations/global/seasonsV2` | 5 |
| `location-getTopPlayerPathOfLegendRankings.json` | `/locations/57000094/pathoflegend/players?limit=10` | 5 |
| `location-getTopPlayerPathOfLegendSeasonRankings.json` | `/locations/global/pathoflegend/2026-09/rankings/players?limit=10` | 5 |
| `player-findByTag.json` | `/players/%232PGGCJJL` | object |
| `player-getBattleLog.json` | `/players/%232PGGCJJL/battlelog` | 5 |
| `player-getUpcomingChests.json` | `/players/%232PGGCJJL/upcomingchests` | 5 |
| `tournament-findAll.json` | `/tournaments?name=de&limit=10` | 4 |
| `tournament-findByTag.json` | `/tournaments/%232JVPU9JL` | object |

## Unavailable live data

- `challenge-findAll.json`: retained historical success response. `/challenges`
  returned HTTP 404 during this audit; this does not establish permanent removal.
- `location-getTopPlayerTournamentRankings.json`: retained historical success
  response. No active global tournaments were listed, and both tested historical
  tournament tags (`#URP0P0LU0`, `#URP89CGRJ`) returned HTTP 404 for rankings.
- `location-getGlobalTournamentRankings.json`: the previously empty, unused file
  now contains the real HTTP 404 JSON response for tournament `#URP89CGRJ`.
  A dedicated integration test verifies the connector failure for that response.
- Legacy league rankings remain available for season `2022-04`, so that fixture
  was refreshed using `limit=10`. Seasons `2024-12` and `2026-09` returned 404.

## Compact edge cases

Current `/globaltournaments` and local legacy player rankings returned empty
collections. Current season V2 entries returned null `code`, `uniqueId`, and
`endTime` values. Their main fixtures retain those cases. Three small populated
samples from earlier responses exercise normal list deserialization too:

| Additional fixture | Coverage |
| --- | --- |
| `globalTournament-findAll-populated.json` | Tournament items and reward fields |
| `location-getPlayerRankings-populated.json` | Player ranking items |
| `location-getTopPlayerLeagueSeasonsV2-populated.json` | Non-null season fields |

These samples use the same five-entry limit, including nested lists, and are
replayed by the corresponding parameterized integration tests. The separate
archive directory has been removed. The absent-support-items model test removes
that optional property from the current card sample in memory.

The schema now includes `IconUrls.heroMedium`. Player progress is a typed
`Map<String, TrophyRoadProgress>` because live keys include an empty string,
season-specific Merge Tactics identifiers, event names, and seasonal trophy-road
identifiers. Fixed Java properties would silently lose these entries.

All successful fixture cases verify generated payload types, raw response data,
and preservation of every non-null JSON field. Specific model tests also check
hero icons, support items, and dynamic progress keys. No fixture is generated
from model serialization as its expected API response.
