java-app-on-docker
==================

Short example of working with Docker while developing Java application
 
Project structure:

src
 `- main
     `- java
      - resources
      - webapp
 `- test
     `- java
      - resources
      
This application was created through the following steps:


1. npm install -g yo grunt-cli bower

2. npm install -g generator-ember

3. gem install compass

4. cd src/main/webapp

5. yo ember
    ` - [?] Would you like to include Bootstrap for Sass? (Y/n) Y

6. npm install grunt-connect-proxy --save-dev

7. npm install matchdep --save-dev

8. require('matchdep').filterDev('grunt-*').forEach(grunt.loadNpmTasks);

9. Add grunt.loadNpmTasks('grunt-connect-proxy'); to Gruntfile

10. proxies: [
                   {
                       context: 'api',
                       host: 'localhost',
                       port: 8080,
                       https: false,
                       changeOrigin: true,
                       xforward: false
                   }
               ]
               
11. middleware: function (connect, options) {
                var proxy = require('grunt-connect-proxy/lib/utils').proxyRequest;
                return [
                   // Include the proxy first
                   proxy,
                   // Serve static files.
                   connect.static(options.base),
                   // Make empty directories browsable.
                   connect.directory(options.base)
                ];
             } 
             
12. 'configureProxies'
             
In order to run this application you have to perform:

1. cd src/main/webapp

2. npm install

3. bower install

In order to enable debugging for jetty servlet use: -Dorg.eclipse.jetty.servlet.LEVEL=ALL

In order to import data execute: mongoimport -v -d library -c books --jsonArray --file PATH_TO_PROJECT/src/test/resources/books_array.json 

docker build -t="ihristov/library" .

docker run -p 8080:8080 -i -t ihristov/library

Don't forget to expose the port via the VirtualBox as well

To login docker container put /bin/bash as a final command in the entrypoint.sh script

Troubleshooting: 

In case of : '... Error response from daemon: client and server don't have same version ...'

Run: boot2docker stop && boot2docker download && boot2docker up