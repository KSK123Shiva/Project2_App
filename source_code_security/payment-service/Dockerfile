FROM openjdk:17-oracle

ENV SPRING_PROFILES_ACTIVE cloud

COPY target/payment-service-0.0.1-SNAPSHOT.jar payment-service.jar

ENTRYPOINT [ "java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","-jar","payment-service.jar" ]

