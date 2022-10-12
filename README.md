# Project Title

Drone

## Description

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.
Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

## notes
* project use H2 database 
* check database after run the program at [http://localhost:8080/h2-console/login.jsp]
* fleet of 10 drones preloaded to database from sql file at path [src/main/resources/data.sql]
* timer run every 20 sec to check drones battery level and write to [drone-logger.log] at path [src/main/resources/drone-logger.log]

### Dependencies

* Java 8
* Spring Boot
* postman

### Executing program

* Clone the project 
```
git clone https://github.com/AhmMahgoub/drone.git
```
* apply mvn clean install goal
* start java -jar drone-0.0.1-SNAPSHOT.jar
* use postman collection to send restful requests (collection attached with files)

### Test
* test cases sould run in phase of maven install project
