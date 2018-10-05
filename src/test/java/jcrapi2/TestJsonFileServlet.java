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

import static jcrapi2.IntegrationTest.API_KEY;
import static org.apache.http.HttpHeaders.AUTHORIZATION;
import static org.apache.http.HttpStatus.SC_FORBIDDEN;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michael Lieshoff
 */
public class TestJsonFileServlet extends HttpServlet {

  private static final long serialVersionUID = 7511948564064679157L;

  void doGet(String filename, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws IOException {
    if (checkAuth(httpServletRequest)) {
      try (PrintWriter printWriter = httpServletResponse.getWriter()) {
        printWriter.print(FileUtils.readFileToString(new File(filename)));
        printWriter.flush();
      }
    } else {
      httpServletResponse.setStatus(SC_FORBIDDEN);
    }
  }

  static String getRestTagParameter(HttpServletRequest httpServletRequest) {
    String uri = httpServletRequest.getRequestURI();
    return uri.substring(uri.lastIndexOf('/') + 1);
  }

  private static boolean checkAuth(HttpServletRequest httpServletRequest) {
    String apiKey = httpServletRequest.getHeader(AUTHORIZATION);
    return ("Bearer " + API_KEY).equals(apiKey);
  }

}
