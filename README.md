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

For retrieving all passengers should be used url: http://localhost:8081/api/passangers/all.
![get](https://user-images.githubusercontent.com/85738520/121676414-e3d14980-cab4-11eb-987c-f117f8c12429.jpg)

For retrieving passengers by id should be used url: http://localhost:8081/api/passangers/id?id=1.
![get_id](https://user-images.githubusercontent.com/85738520/121676463-f5b2ec80-cab4-11eb-8448-184859328b6b.jpg)

For updating passengers should be used url: http://localhost:8081/api/passangers/1.
![put](https://user-images.githubusercontent.com/85738520/121676516-04999f00-cab5-11eb-8d12-3707c431d3b3.jpg)

For deleting all passengers should be used url: http://localhost:8081/api/passangers and method delete.And for deleting passengers by id should be used url: http://localhost:8081/api/passangers/1.

Checkup in database: You will need to install MySQL Workbench anduse connection with username=root and password=root or set in applica-tion.properties (path in IntelliJ: passenger/passenger/src/main/resources)yours username and password.

![base](https://user-images.githubusercontent.com/85738520/121676609-1bd88c80-cab5-11eb-9d5a-9905752927f2.jpg)





