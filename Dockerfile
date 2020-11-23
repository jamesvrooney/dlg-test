FROM adoptopenjdk/maven-openjdk11 as build

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/

RUN mvn -DskipTests package

FROM adoptopenjdk/maven-openjdk11

WORKDIR /app

COPY --from=build /build/target/dlg-test-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "dlg-test-0.0.1-SNAPSHOT.jar"]