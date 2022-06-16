# Build with maven
FROM maven:3-alpine as build

LABEL maintainer="affessalem@hotmail.fr"
LABEL part-of="github spring boot crud"
LABEL framework="spring boot"

WORKDIR /app
COPY /src /app/src
COPY pom.xml /app/pom.xml
# Clean and package the artifact without test
RUN mvn clean package -DskipTests

# Serve the app on a tomcat server
FROM tomcat:9.0.0-alpine
WORKDIR /usr/local/tomcat/webapps/
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY --from=build /app/target/spring-boot-data-jpa-mvc-jsp-1.0.jar /usr/local/tomcat/webapps/ROOT.jar
# Start server
CMD ["catalina.sh", "run"]
