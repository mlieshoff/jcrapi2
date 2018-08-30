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

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;

/**
 * @author Michael Lieshoff
 */
class JettyServer {

  private final Server server;

  private final Context context;

  JettyServer(int port, String contextPath) {
    server = new Server(port);
    context = new Context(server, contextPath, Context.SESSIONS);
    context.setContextPath(contextPath);
    server.setHandler(context);
  }

  public void addServlet(String pathSpec, Servlet servlet) {
    context.addServlet(new ServletHolder(servlet), pathSpec);
  }

  public void start() throws Exception {
    if (server != null) {
      server.start();
    }
  }

  public void stop() throws Exception {
    if (server != null) {
      server.stop();
    }
  }

}