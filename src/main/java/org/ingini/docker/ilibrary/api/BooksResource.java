package org.ingini.docker.ilibrary.api;

import com.google.common.collect.Lists;
import org.ingini.docker.ilibrary.domain.Book;
import org.ingini.docker.ilibrary.domain.BookList;
import org.ingini.docker.ilibrary.guice.JongoModule;
import org.ingini.docker.ilibrary.guice.ServletModule;
import org.jongo.MongoCollection;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
@Path(ServletModule.API + "/books")
public class BooksResource {

    @Inject
    @Named(JongoModule.BOOKS_COLLECTION)
    private MongoCollection bookCollection;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        return Response.ok(new BookList(Lists.newArrayList(bookCollection.find().as(Book.class)))).build();
    }
}
