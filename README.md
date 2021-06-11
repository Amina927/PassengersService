# passengersService
# Introduction
In this project is created Passenger's service with functionalities, like creating passenger, retrieving passengers or single passenger, updating existing passenger and deleting passengers.

# Technologies
Java
SpringBoot
MySql
Maven

I created code in IntelliJ environment. Code is separated in different cla-sses. Passanger class is for declaration informations about passengers, likefirst name, last name, email adress. This class have constructor and met-hods to get and set passenger properties. PassengerDTO class is for get-ting and setting properties from Postman application about passengers.PassengerService class moves code from controller to service componentfor creating passengers, retrieving passengers, updating passengers and de-leting passengers. Then PassengerController is autowired with service, sowe can invite constructors and methods from service. PassengerControllerclass is responsible for processing incoming requests. Controller is mappedto the /api/passangers path.

# How to run 

First, you should open folder "passenger" in IntelliJ environment and runPassengerAplication, path is passenger/passenger/src/main/java, then inPostman application should be used url: http://localhost:8081/api/passangersfor creating passenger.

![post](https://user-images.githubusercontent.com/85738520/121676253-b4bad800-cab4-11eb-92d3-bb77a1d10fee.jpg)

