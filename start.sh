mvn clean
mvn package -Dmaven.test.skip
java -jar target/hellobank-0.0.1-SNAPSHOT.jar