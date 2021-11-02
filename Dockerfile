FROM tomcat:9.0-jdk16

COPY ./target/library-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/library.war

CMD ["catalina.sh", "run"]
