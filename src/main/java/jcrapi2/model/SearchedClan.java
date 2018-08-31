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
package jcrapi2.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated("org.mili.generator")
@Getter
@Setter
@ToString
public class SearchedClan {

    @SerializedName("tag")
    private String tag;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("badgeId")
    private int badgeId;

    @SerializedName("clanScore")
    private int clanScore;

    @SerializedName("location")
    private SearchedClanLocation location;

    @SerializedName("requiredTrophies")
    private int requiredTrophies;

    @SerializedName("donationsPerWeek")
    private int donationsPerWeek;

    @SerializedName("clanChestLevel")
    private int clanChestLevel;

    @SerializedName("clanChestMaxLevel")
    private int clanChestMaxLevel;

    @SerializedName("members")
    private int members;

}