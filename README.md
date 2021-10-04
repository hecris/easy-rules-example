# Overview
[Router](https://github.com/hecris/easy-rules-example/blob/main/src/main/java/com/mycompany/app/Router.java)
class reads routing rules from [routing\_rules.json](https://github.com/hecris/easy-rules-example/blob/main/routing_rules.json). `Router.getRoutingGroup()` takes in a [QueryContext](https://github.com/hecris/easy-rules-example/blob/main/src/main/java/com/mycompany/app/QueryContext.java) object (basically a struct with attributes submittedApp, submittedSubApp, etc) and fills in the `routingGroup` attribute.

## Build and Run
### Build
```
mvn clean package assembly:single
```
### Run
```
java -jar target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar
```

