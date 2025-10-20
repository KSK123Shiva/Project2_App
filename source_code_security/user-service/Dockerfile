FROM openjdk:17-oracle

ENV SPRING_PROFILES_ACTIVE cloud

COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar

EXPOSE 8085

ENTRYPOINT [ "java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","-jar","user-service.jar" ]


# docker run -d -p 9897:8085 -e SPRING_PROFILES_ACTIVE=cloud <docker-image-name>