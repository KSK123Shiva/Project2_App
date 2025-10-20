FROM openjdk:17-oracle

ENV SPRING_PROFILES_ACTIVE cloud

COPY target/audit-service-0.0.1-SNAPSHOT.jar audit-service.jar

ENTRYPOINT [ "java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","-jar","audit-service.jar" ]

