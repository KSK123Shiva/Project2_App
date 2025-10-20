FROM openjdk:17-oracle

ENV SPRING_PROFILES_ACTIVE cloud

COPY target/apigateway-service-0.0.1-SNAPSHOT.jar apigateway-service.jar

ENTRYPOINT [ "java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","-jar","apigateway-service.jar" ]

