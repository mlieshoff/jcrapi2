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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michael Lieshoff
 */
public class TestTournamentsServlet extends TestJsonFileServlet {

  private static final long serialVersionUID = 2223554163029355420L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String parameter = getRestTagParameter(req);
    String filename;
    if ("tournaments".equals(parameter)) {
      filename = "src/test/resources/tournaments.json";
    } else {
      filename = "src/test/resources/tournament.json";
    }
    doGet(filename, req, resp);
  }

}
