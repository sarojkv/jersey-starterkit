Overview
========
Sample stocks project. Starter kit forked from : https://github.com/jasonray/jersey-starterkit 

How-to run
==========
0.1) Pre-req

You will need the following installed:
Java 
Gradle 
Tomcat.


```

1) Compile
The project compiles using gradle.  If you already have gradle installed, compile using:
```
gradle build
```

If you do not have gradle installed, you can utilize the gradle wrapper included in the source
```
./gradlew war
```

The war file is compiled to: `build/libs/stocks.war`


2) Deploy the war file to web container. 
```

Shortcut: if you are using tomcat, and $CATALINA_HOME is set, you can run: `./deploy.bat or ./deploy.sh`

Design Details
==============
https://docs.google.com/document/d/12-KhgEIMgJnAqB0KIIEC0CTtv2VNoaL6vTAThYAdhmk/edit?usp=sharing 

