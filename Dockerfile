FROM openjdk:8
ADD target/contacts-api.jar contacts-api.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","contacts-api.jar"]