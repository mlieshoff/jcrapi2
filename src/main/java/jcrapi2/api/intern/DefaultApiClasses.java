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
package jcrapi2.api.intern;

import jcrapi2.api.Api;
import jcrapi2.api.intern.cards.CardApi;
import jcrapi2.api.intern.challenges.ChallengeApi;
import jcrapi2.api.intern.clans.ClanApi;
import jcrapi2.api.intern.globaltournaments.GlobalTournamentApi;
import jcrapi2.api.intern.locations.LocationApi;
import jcrapi2.api.intern.players.PlayerApi;
import jcrapi2.api.intern.tournaments.TournamentApi;

import lombok.Getter;

import java.util.Map;

@Getter
public class DefaultApiClasses {

    private final Map<Class<? extends Api>, String> apiClassMap =
            Map.of(
                    ClanApi.class, "jcrapi2.api.intern.clans.ClanApiImpl",
                    PlayerApi.class, "jcrapi2.api.intern.players.PlayerApiImpl",
                    CardApi.class, "jcrapi2.api.intern.cards.CardApiImpl",
                    TournamentApi.class, "jcrapi2.api.intern.tournaments.TournamentApiImpl",
                    LocationApi.class, "jcrapi2.api.intern.locations.LocationApiImpl",
                    ChallengeApi.class, "jcrapi2.api.intern.challenges.ChallengeApiImpl",
                    GlobalTournamentApi.class,
                            "jcrapi2.api.intern.globaltournaments.GlobalTournamentApiImpl");
}
