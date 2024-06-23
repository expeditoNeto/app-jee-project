FROM maven AS build
WORKDIR /app
COPY . .
RUN mvn package

FROM tomcat:9-jdk11
COPY config-tomcat/context.xml /tmp
COPY config-tomcat/tomcat-users.xml /usr/local/tomcat/conf

RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps
RUN cp /tmp/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY --from=build /app/target/gerenciador.war /usr/local/tomcat/webapps
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]