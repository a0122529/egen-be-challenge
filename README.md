# egen-be-challenge

IOT Application - Weighing Tracker

The application uses :-
1) MongoDb as a database source
2) Spring mvc framework
3) Easy Rules API
4) Morphia API for datasource connection with mongoDb
5)JSP pages
6) HTML, CSS and BOOTSTRAP

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

2) To fetch all the metrics data, created a get rest call
Method = GET
URI : - http://localhost:8080/IoTApplication/rest/read/allMetrics

This url fetches all the rows from the metrics collection from mongodb and displays the result in the json format

3) 2) To fetch all the alert data, created a get rest call
Method = GET
URI : - http://localhost:8080/IoTApplication/rest/read/allAlerts

This url fetches all the rows from the alert collection from mongodb and displays the result in the json format

4) To fetch data based on timestamp, we have created a rest api which takes in two arguments or path params. These path params are called as timestamps:-

a) To get data from metrics collection
Method = GET
URI : - http://localhost:8080/IoTApplication/rest/read/metrics/timestamp1/timestamp2"

a) To get data from alert collection
Method = GET
URI : - http://localhost:8080/IoTApplication/rest/read/alert/timestamp1/timestamp2"

format of timestamp 1 and timestamp 2 is - yyyy-MM-dd--kk:mm:ss.SSS

example : - 
URI : -http://localhost:8080/IoTApplication/rest/read/metrics/2006-01-01--07:14:38.000/2016-04-07--23:14:38.000
URI : -http://localhost:8080/IoTApplication/rest/read/alert/2006-01-01--07:14:38.000/2016-04-07--23:14:38.000


SCHEDULERS:-
Application has a SchedulerController class which run all these rest api's through the java code.
For creting the data timer has been put on for every 5 seconds

MONGODB:-
Database used is Mongo DB and all the data is besing sent to the database using morphia api which directly sends and create the data using the POJO classes.
Same while fetching the information 

JSP Servler Pages(Extra Implementation):-
Front end has also been created using html, css and Bootstrap framework

1) Home page - Provision to add the data using the home page like name, base weight, current weight - created randomly
All this data is being sent to JQUERY which basically call the rest api's using AJAX service to POST data into the database

2) Read Data page - Page to show all the received json on hitting the rest calls for:
a) All metrics rows - in json format 
2) All alert rows - in json format
3) specific metrics rows(based on timestamp search)
4) specific alert rows(based on timestamp search)




