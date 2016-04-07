# egen-be-challenge

IOT Application - Weighing Tracker

The application uses :-
1) MongoDb as a database source
2) Spring mvc framework
3) Easy Rules API
4) Morphia API for datasource connection with mongoDb
5)JSP pages

Application:

An application which tracks the weight of person and compares the weight with the person's base weight.
Based on some rule it creates alerts and adds them in the database with the actual data. 
The application creates and consumes those very REST calls to make the application extendible and robust and faster.

REST API's created :- 

1) To Send all the metrics data adn Alert data (infomation about the weight and other info) using the rest api
Method = POST
URI : - http://localhost:8080/IoTApplication/rest/weightEntry

This url takes in personData which has attributes like name, weight, baseweight and timestamp to create the data

A scheduler already created in the project to randomly generate the personData and hit this api after every 5 seconds to send POST the data to the database.
look out for schedule in com.neu.io.controller --> SchedulerController class --> callDataSendRest() method -- This method calls the above post api and sends all the data automatically

2) To fetch all the data 




