package org.ingini.docker.ilibrary.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import javax.inject.Named;
import java.net.UnknownHostException;

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
public class JongoModule extends AbstractModule {

    public static final String DB_NAME = "library";
    public static final String BOOKS_COLLECTION = "books";
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 27017;

    private Jongo jongo ;

	@Override
	protected void configure() {
        try {
            jongo = new Jongo(new MongoClient(HOST, PORT).getDB(DB_NAME));
        } catch (UnknownHostException e) {
            throw new IllegalStateException(e);
        }
    }

	@Provides
	@Named(BOOKS_COLLECTION)
	public MongoCollection provideBooksCollection() {
		return jongo.getCollection(BOOKS_COLLECTION);
	}
}
