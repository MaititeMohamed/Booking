FROM openjdk:11
ARG WAR_FILE=target/*.war
COPY target/Booking-0.0.1-SNAPSHOT.war Booking.war
ENTRYPOINT ["java", "-jar","Booking.war"]
