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
public class PlayerCurrentDeckCard {

  @SerializedName("name")
  private String name;

  @SerializedName("id")
  private int id;

  @SerializedName("level")
  private int level;

  @SerializedName("starLevel")
  private int starLevel;

  @SerializedName("maxLevel")
  private int maxLevel;

  @SerializedName("count")
  private int count;

  @SerializedName("iconUrls")
  private PlayerCurrentDeckCardIconUrls iconUrls;

}