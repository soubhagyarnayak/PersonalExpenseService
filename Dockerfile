FROM openjdk:8u121-jre-alpine

WORKDIR /var/personal-expense-service

ADD target/personal-expense-service-0.1.jar /var/personal-expense-service/personal-expense-service.jar
ADD config.yml /var/personal-expense-service/config.yml

EXPOSE 8080 8081

ENTRYPOINT ["java", "-jar", "personal-expense-service.jar", "server", "config.yml"]