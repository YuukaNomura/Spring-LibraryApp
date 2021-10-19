FROM tomcat:9.0-jdk16

COPY ./target/kakeibo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/kakeibo.war

CMD ["catalina.sh", "run"]