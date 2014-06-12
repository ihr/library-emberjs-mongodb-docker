package org.ingini.docker.ilibrary;

import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.ingini.docker.ilibrary.guice.GuiceBootstrapConfig;
import org.ingini.docker.ilibrary.guice.ServletModule;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Copyright (c) 2014 Ivan Hristov
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        String webappDirLocation = "src/main/webapp/";

        Server server = new Server(8080);
        WebAppContext webAppContext = new WebAppContext();

        webAppContext.setContextPath("/");
        webAppContext.setResourceBase(webappDirLocation);
        webAppContext.setParentLoaderPriority(true);
        webAppContext.addEventListener(new GuiceBootstrapConfig());
        webAppContext.addFilter(GuiceFilter.class, ServletModule.API + "/*", EnumSet.allOf(DispatcherType.class));

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }
}
