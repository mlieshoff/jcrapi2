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
package jcrapi2.api.intern.players.info;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Progress {

    @SerializedName("goblin-road")
    private GoblinRoad goblinRoad;

    @SerializedName("Royals_2v2")
    private Royals2v2 royals2v2;

    @SerializedName("Royals_2v2_2025")
    private Royals2v22025 royals2v22025;
}
