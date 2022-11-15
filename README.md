# Spring Backend

## Main Features
This project provides mutltiple useful RestuflAPIS that can be use to manage entities such as building, heaters, rooms and windows with the ability to execute all CRUD operations.

## Technologies Used

- [Spring] - Powerful library for developping backend in Java.
- [Git] - open source distributed version control system.
- [IntelliJ] - integrated development environment written in Java for developing computer software.

## Usage    
In order to operate this backend, we first need to set up authentification since the project is secured with SpringSecurity, to do so, use Basic authentication with the following credentials:
- Username: Admin
- Password: adminpwd

After setting up the Basic Auth we can run the server as follows:
    
    ./gradlew :run 
Now the only thing left to do is call the api on 

    http://localhost:8081/

## Buildings api

The available apis for building managment are as follow:

| Endpoint | Method | Description | Arguments
| ------ | ------ | ------ | ------ 
| api/buildings | GET | Get all buildings in the database |
| api/buildings/{id} | GET | Get a specific building | id: the id of the building in question
| api/buildings/rooms/{id} | GET | Get a list of rooms in a specific building | id: the id of the building in question 
| api/buildings/heaters/{id} | GET | Get a list of heaters in a specific building | id: the id of the building in question   
| api/buildings/windows/{id} | GET | Get a list of windows in a specific building | id: the id of the building in question   
| api/buildings | POST | Create a building or update an existing building | body: { id: [Integer OR null]; name: String; adresse: String } 
| api/buildings/{id} | DELETE | Delete a specific building | id: the id of the building in question 

## Rooms apis

The available apis for Room managment are as follow:

| Endpoint | Method | Description | Arguments
| ------ | ------ | ------ | ------ 
| api/rooms | GET | Get a list of all rooms |
| api/rooms/{id} | GET | Get a specific room | id: the id of the room in question
| api/rooms/heaters/{id} | GET | Get a list of heaters in a specific room | id: the id of the room in question   
| api/rooms/windows/{id} | GET | Get a list of windows in a specific room | id: the id of the room in question   
| api/rooms | POST | Create a room or update an existing room | body: { id: [Integer OR null]; name: String; floor: Integer; target_temperature: Long; current_temperature: Long } 
| api/rooms/{id} | DELETE | Delete a specific room | id: the id of the room in question 
| api/rooms/{id}/switchWindow | PUT | switch the status of all windows in a room |  id: the id of the room in question 
| api/rooms/{id}/switchHeaters | PUT | switch the status of all windows in a room |  id: the id of the room in question 

## Heater apis

The available apis for Heater managment are as follow:

| Endpoint | Method | Description | Arguments
| ------ | ------ | ------ | ------ 
| api/heaters | GET | Get a list of all heaters |
| api/heaters/{id} | GET | Get a specific heater | id: the id of the heater in question
| api/heaters | POST | Create a heater or update an existing heater | body: { id: [Integer OR null]; name: String; roomId: Integer; heater_status: [ON or OFF];}
| api/heaters/{id} | DELETE | Delete a specific heater | id: the id of the heater in question 

## Window apis

The available apis for Window managment are as follow:

| Endpoint | Method | Description | Arguments
| ------ | ------ | ------ | ------ 
| api/windows | GET | Get a list of all windows |
| api/windows/{id} | GET | Get a specific window | id: the id of the window in question
| api/windows | POST | Create a window or update an existing window | body: { id: [Integer OR null]; name: String; roomId: Integer; window_status: [OPEN or CLOSED];}
| api/windows/{id} | DELETE | Delete a specific window | id: the id of the window in question 

## Developper

Zaidane Reda

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [Git]: <https://git-scm.com>
   [Spring]: <https://spring.io/>
   [IntelliJ]: <https://www.jetbrains.com/idea/>