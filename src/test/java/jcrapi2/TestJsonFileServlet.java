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

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Michael Lieshoff
 */
public class TestJsonFileServlet extends HttpServlet {

  protected void doGet(String filename, HttpServletRequest httpServletRequest, ServletResponse httpServletResponse)
      throws IOException {
    PrintWriter printWriter = httpServletResponse.getWriter();
    printWriter.print(FileUtils.readFileToString(new File(filename)));
    printWriter.flush();
  }

  public static String getRestTagParameter(HttpServletRequest req) {
    String uri = req.getRequestURI();
    return uri.substring(uri.lastIndexOf('/') + 1);
  }

}
