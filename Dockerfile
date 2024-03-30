FROM openjdk:17-alpine
WORKDIR /app
COPY /target/BudgetWise-0.0.1-SNAPSHOT.jar ./BudgetWise-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "BudgetWise-0.0.1-SNAPSHOT.jar"]