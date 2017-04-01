# vinyl-repo

Vinyl repository.
Java 1.8 and Maven 3.3.x required.

Some playing with streams; see more at:
http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html

## Build with or without tests

```
mvn clean install  
mvn clean install -DskipTests=true
```

## Run Spring boot application

```
java -jar target/vinyl-repo-1.0-SNAPSHOT.jar
```

## Store file structure

```
File needs to be tab separated plain text file; see columns from the properties file.
The store implementation can be also "real" db; just add new implementation class.
```
