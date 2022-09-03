# Microservices and RESTful web services with Spring cloud and Spring Boot: #

### 1. Create springboot-microservice2 parent project
* Creating a Project
     
     ```
     mvn archetype:generate -DgroupId=com.spboot.guru -DartifactId=springboot-microservice2 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
     ```
* POM.xml Configuration
### 2. Create sub project customer project:
* Creating a model Project with maven
* Create docker compose file for postgres and pgadmin 
* Insert new customer

### 3. Create sub project fraud project:
* Create model, repository and controller
* Communication between customer and fraud service with restTemplate

### 4. Create sub project Eureka Server project:
* Create customer Client
* Create customer Fraud
* Change url in restTemplate from "http://localhost:8182/api/v1/fraud-check/{customerId}" to "http://FRAUD/api/v1/fraud-check/{customerId}"
* Add @LoadBalanced annotation for RestTemplate bean ( to remove the conflicts between fraud instances service)
* Check in Postman : http://localhost:8181/api/v1/customers