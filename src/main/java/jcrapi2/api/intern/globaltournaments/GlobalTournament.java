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
package jcrapi2.api.intern.globaltournaments;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import lombok.Data;

@Data
public class GlobalTournament {

  @SerializedName("tag")
  private String tag;
  @SerializedName("title")
  private String title;
  @SerializedName("startTime")
  private String startTime;
  @SerializedName("endTime")
  private String endTime;
  @SerializedName("maxTopRewardRank")
  private int maxTopRewardRank;
  @SerializedName("maxLosses")
  private int maxLosses;
  @SerializedName("minExpLevel")
  private int minExpLevel;
  @SerializedName("tournamentLevel")
  private int tournamentLevel;
  @SerializedName("milestoneRewards")
  private List<MilestoneReward> milestoneRewards;
  @SerializedName("freeTierRewards")
  private List<FreeTierReward> freeTierRewards;
  @SerializedName("topRankReward")
  private List<TopRankReward> topRankReward;
  @SerializedName("gameMode")
  private GameMode gameMode;

}