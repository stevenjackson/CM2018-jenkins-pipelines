# Continuous Delivery Workshop

This project is a niave application used to demonstrate how to set up a continuous delivery pipe line.

# Requirements

- Java 8
- Maven (3.1 or higher)

# Build Commands

Execute the full build
```
mvn clean install
```

Execute jasmine tests

```
mvn jasmine:test
```

Active work on jasmine tests

```
mvn jasmine:bdd
```

Execute unit tests

```
mvn clean test
```

Execute integration tests

```
mvn failsafe:integration-test
```

Launch application

```
mvn package && java -jar target/cdd-workshop-app-0.1.0.jar
```

On a spefic port use
 
 ```
java -jar target/cdd-workshop-app-0.1.0.jar --server.port=8090 
```

To turn on the feature flag edit the application.properties file or add this argument on start up
```
-DflagOn=true
```
Health Check

```
curl localhost:8080/health
```