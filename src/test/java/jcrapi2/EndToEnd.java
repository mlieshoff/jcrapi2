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

import java.io.IOException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EndToEnd {

  public static void main(String[] args) throws IOException {

    String key = args[0];

    Call.Factory okHttpClient = new OkHttpClient();
    Request request = new Request.Builder()
        .get()
        .url("https://api.clashroyale.com/v1/clans?name=puzzle")
        .addHeader("authorization", "Bearer " + key)
        .build();

    Response response = okHttpClient.newCall(request).execute();

    System.out.println(response.body().string());
  }

}
