FROM alpine as builder

RUN apk update && apk add openjdk17 && apk add maven

COPY src /usr/app/src
COPY pom.xml /usr/app
RUN mvn -f /usr/app/pom.xml package

FROM tomcat:9-jre17
USER root
COPY --from=builder /usr/app/target/jsf-primefaces-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/app-jee.war
EXPOSE 8080
COPY config-tomcat/context.xml /tmp
COPY config-tomcat/tomcat-users.xml /usr/local/tomcat/conf

RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps
RUN cp /tmp/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
ENTRYPOINT ["catalina.sh", "run"]