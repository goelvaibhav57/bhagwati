FROM eclipse-temurin:8
RUN mkdir /opt/app
COPY target/bhagwati-be-app.jar /opt/app/bgbeapp.jar
CMD ["java", "-jar", "/opt/app/bgbeapp.jar"]