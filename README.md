
Saks test scripts
### Prerequisites
* JDK 1.8
* maven
* selenium

### Getting started

Make sure you have maven configuration `settings.xml` (root folder of the repo).

If you need to use it in your your project for automated testing of some
domain - make a copy of it and change accordingly maven settings:

* name
* artifactId
* scm
* issueManagement
* ciManagement

`resources` folder should contain your objects/web controls and their ids or css classes. 
In this repo it's empty, but you can copy them over or create one. It was in excel and 
there was a plan to use json or yaml for it.

You also need to replace the content of this readme file to describe your tests.

#### How to run this tests
Make sure you configured `Configuration.properties`
from command line do
```bash
mvn exec:java -Dexec.mainClass="com.hbcd.TestLauncher"  
```

or use launcher of your IDE. Same can be used in CI environment.

### Dependencies

The scripts will require you to add following dependencies.
For maven use
```xml
        <dependency>
            <groupId>com.hbc.ta</groupId>
            <artifactId>framework-core</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.hbc.ta</groupId>
            <artifactId>framework-commonBannerLayer</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```

for sbt use:
```
libraryDependencies += "com.hbc.ta" % "framework-core" % "1.0-SNAPSHOT"
libraryDependencies += "com.hbc.ta" % "framework-commonBannerLayer" % "1.0-SNAPSHOT"
```

Make sure you have the internal repositories in your maven/sbt so it can download jars.

Your code could be either scala or java, it is up to you.
