FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./build/libs/SchedullerYandexTaxi-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "SchedullerYandexTaxi-0.0.1-SNAPSHOT.jar"]