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

import com.google.gson.annotations.SerializedName;

import java.util.List;
import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated("org.mili.generator")
@Getter
@Setter
@ToString
public class Tournament {

  @SerializedName("capacity")
  private int capacity;

  @SerializedName("createdTime")
  private String createdTime;

  @SerializedName("creatorTag")
  private String creatorTag;

  @SerializedName("description")
  private String description;

  @SerializedName("duration")
  private int duration;

  @SerializedName("endedTime")
  private String endedTime;

  @SerializedName("firstPlaceCardPrize")
  private int firstPlaceCardPrize;

  @SerializedName("gameMode")
  private TournamentGameMode gameMode;

  @SerializedName("levelCap")
  private int levelCap;

  @SerializedName("maxCapacity")
  private int maxCapacity;

  @SerializedName("membersList")
  private List<TournamentMember> membersList;

  @SerializedName("name")
  private String name;

  @SerializedName("preparationDuration")
  private int preparationDuration;

  @SerializedName("startedTime")
  private String startedTime;

  @SerializedName("status")
  private String status;

  @SerializedName("tag")
  private String tag;

  @SerializedName("type")
  private String type;

}