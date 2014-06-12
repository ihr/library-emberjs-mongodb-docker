package org.ingini.docker.ilibrary.guice;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.ingini.docker.ilibrary.api.BooksResource;

import static com.google.inject.Scopes.SINGLETON;

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
public class ServletModule extends JerseyServletModule {

	public static final String API = "/api";

	@Override
	protected void configureServlets() {

		bind(BooksResource.class).in(SINGLETON);

		bind(JacksonJsonProvider.class).in(SINGLETON);

		filter(API + "/*").through(GuiceContainer.class);
	}
}
