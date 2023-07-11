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
package jcrapi2.api.intern.tournaments;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Tournament {

  @SerializedName("name")
  private String name;
  @SerializedName("tag")
  private String tag;
  @SerializedName("type")
  private String type;
  @SerializedName("status")
  private String status;
  @SerializedName("creatorTag")
  private String creatorTag;
  @SerializedName("description")
  private String description;
  @SerializedName("levelCap")
  private int levelCap;
  @SerializedName("firstPlaceCardPrize")
  private int firstPlaceCardPrize;
  @SerializedName("capacity")
  private int capacity;
  @SerializedName("maxCapacity")
  private int maxCapacity;
  @SerializedName("preparationDuration")
  private int preparationDuration;
  @SerializedName("duration")
  private int duration;
  @SerializedName("createdTime")
  private String createdTime;
  @SerializedName("gameMode")
  private GameMode gameMode;
  @SerializedName("iconUrls")
  private IconUrls iconUrls;

}

