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
package jcrapi2;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import jcrapi2.request.GetClanMembersRequest;
import jcrapi2.request.GetClanRequest;
import jcrapi2.request.GetClanWarLogRequest;
import jcrapi2.request.GetClansRequest;
import jcrapi2.response.GetClanMembersResponse;
import jcrapi2.response.GetClanResponse;
import jcrapi2.response.GetClanWarLogResponse;
import jcrapi2.response.GetClansResponse;

/**
 * @author Michael Lieshoff
 */
public class Api {

  private final ClientFactory clientFactory;

  private final String url;
  private final String apiKey;

  public Api(String url, String apiKey) {
    this(url, apiKey, new ClientFactory());
  }

  Api(String url, String apiKey, ClientFactory clientFactory) {
    checkString(url, "url");
    checkString(apiKey, "apiKey");
    this.url = url;
    this.apiKey = apiKey;
    this.clientFactory = clientFactory;
  }

  private static void checkString(String s, String key) {
    checkNotNull(s, key);
    checkArgument(!s.isEmpty(), key);
  }

  public GetClansResponse getClans(GetClansRequest getClansRequest) {
    checkNotNull(getClansRequest, "getClansRequest");
    try {
      return createClient().getClans(getClansRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  private Client createClient() {
    return clientFactory.createClient(url, apiKey);
  }

  public GetClanResponse getClan(GetClanRequest getClanRequest) {
    checkNotNull(getClanRequest, "getClanRequest");
    try {
      return createClient().getClan(getClanRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetClanMembersResponse getClanMembers(GetClanMembersRequest getClanMembersRequest) {
    checkNotNull(getClanMembersRequest, "getClanMembersRequest");
    try {
      return createClient().getClanMembers(getClanMembersRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public GetClanWarLogResponse getClanWarLog(GetClanWarLogRequest getClanWarLogRequest) {
    checkNotNull(getClanWarLogRequest, "getClanWarLogRequest");
    try {
      return createClient().getClanWarLog(getClanWarLogRequest);
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

}