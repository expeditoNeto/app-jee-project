
FROM maven AS build
WORKDIR /app
COPY . .
RUN mvn package
RUN mv ./target/jsf-primefaces-0.0.1-SNAPSHOT.war app-jsf.war



FROM tomcat:9-jre17
COPY config-tomcat/context.xml /tmp
COPY config-tomcat/tomcat-users.xml /usr/local/tomcat/conf

RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps
RUN cp /tmp/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY --from=build /app/target/app-jsf.war /usr/local/tomcat/webapps
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]