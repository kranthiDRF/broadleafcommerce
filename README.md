# Installation Instructions

These should be sufficient to get up and running locally with the DRF Digital eCommerce project.

## Install the latest Java 7 JDK
1. Make sure that the latest version of the Java Development Kit (JDK 7 Update 60 or later) is installed on your machine. Go to [the Oracle download site](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) and follow the instructions on Oracle's website to download the latest version of the JDK (Java SE 7 Update 60 or later) for the operating system of your computer. That link takes you to 7u67
1. Install the JDK to a directory on your computer, e.g. C:\Java\jdk7_60.
1. Create an environment variable called JAVA_HOME that points to the JDK installation directory, for example `C:\Java\jdk7_60`.

## Install the latest Maven version
1. Follow the [Maven installation instructions](http://maven.apache.org/download.cgi#Installation). You can use the latest stable release which is currently **3.2.3**.


## Install WildFly 8.1
1.  Get the latest stable version of the WildFly Application Server (8.1.0.Final) from http://download.jboss.org/wildfly/8.1.0.Final/wildfly-8.1.0.Final.zip.
1. Extract the zip archive to a directory on your computer, e.g. C:\app. The path must not contain any spaces. A new directory, e.g. C:\app\wildfly-8.1.0.Final, containing the WildFly files will be created.
1. Create an environment variable called JBOSS_HOME that points to the WildFly installation directory, for example `C:\app\wildfly-8.1.0.Final and append %JBOSS_HOME%\bin` to your Path variable.
set JAVA_HOME in the standalone configuration file located at `<WildFly directory>\bin\standaloneconf.conf` by adding the below property to the file

```
set JAVA_HOME=C:\Java\jdk1.7.0_60
```

1. Replace your `<WildFly directory>\standalone\configuration\standalone.xml` with [this file](setup/standalone.xml)
1. Copy the [keystore file](setup/blc-example.keystore) to `<WildFly directory>\standalone\configuration\`. (PS:There is a whole another tutorial for generating your own keys. But this should work for dev setup)
1. Use the script `<WildFly directory>\bin\standalone.bat` to start the WildFly server and check the installation. After startup, you should be able to access the web server at http://localhost:8080.
1. Open the link Administration Console located at http://localhost:9990 and follow the instructions to add a new management user.

### Install the MySQL Driver jar file
1. Create a new directory structure for your driver in your JBoss installation (`<WildFly directory>/modules/com/mysql/jdbc/main`)
1. Copy your the [mysql JDBC driver jar](setup/mysql-connector-java-5.1.32.jar) into the "main" directory you just created
1. Create a module.xml file in the "main" directory. Here are its contents:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.0" name="com.mysql.jdbc">
<resources>
<resource-root path="mysql-connector-java-5.1.32.jar"/>
<!-- Insert resources here -->
</resources>
<dependencies>
<module name="javax.api"/>
<module name="javax.transaction.api"/>
</dependencies>
</module>
```

### Update `JAVA_OPTS` for debugging, spring-instrument and jrebel
1. Open up `<WildFly directory>\bin\stadnalone.conf` and add this snippet at the bottom of the file:

```
# Setup remote debugger
JAVA_OPTS="$JAVA_OPTS -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
# Add JRebel
JAVA_OPTS="$JAVA_OPTS -javaagent:/usr/lib/jrebel/jrebel.jar -Drebel.thymeleaf_plugin=true"
# Add Spring Instrument
JAVA_OPTS="$JAVA_OPTS -javaagent:/Users/phillipverheyden/broadleaf/client-drf/setup/spring-instrument-4.1.0.RELEASE.jar"
```

You will need to change the paths to refer to the actual locations of the jar files. You can download the JRebel jar from https://zeroturnaround.com/software/jrebel/download/ and `spring-instrument` is included in the [setup directory](setup/spring-instrument-4.1.0.RELEASE) of the project.


## Installing MySQL
1. Get the latest stable version of MySQL . Follow the set up instructions from http://dev.mysql.com/doc/refman/5.7/en/windows-installation.html
1. Once the installation is complete create an empty database called broadleaf in MySQL. This is the name that has been referenced in the datasource configuration in `standalone.xml`. If you decide to choose a different name, please make sure to update it in all the places

## Installing Eclipse
1. Get the latest stable version of Eclipse and add JDK in the installed JREs.
1. Download the latest code from GitHub repository that was provided in earlier emails.
1. Import Maven projects into Eclipse. The instructions are very similar to what is referenced in http://www.broadleafcommerce.com/docs/core/3.2/appendix/environment-setup/eclipse-setup. The difference is that you should use the DRF root project that you got from GitHub

> This will import 4 projects, core, site, admin and a parent 

1. Right click on the **parent project** in Eclipse and do Maven-->update project followed by Run As-->Maven install. Since the other 3 projects (core, site and admin) are child projects, this will build all of the projects

## Deploying BLC on WildFly servern

There are a few options that you can use to actually deploy the plugin: 

1. Use the Eclipse Wildfly plugin
1. Use the `wildfly:deploy` Maven execution (see the docs at `https://docs.jboss.org/wildfly/plugins/maven/latest/`)
    1. Right click on the project that you want to deploy (either **site** or **admin**)
    1. Go to Run-as -> Maven Build
    2. For the goal use `wildfly:deploy`: http://cl.ly/image/3Y202F2V113B

    > This can be done either in Eclipse as mentioned above or directly from the command line


