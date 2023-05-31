# payroll
NLPC PFA - PayRoll System By Emmanuel Olusegun





# payroll
NLPC PFA - PayRoll System By Emmanuel Olusegun

I have made a basic a basic implementation, in which I can build on When I am fully employed for the service

In this implementation, I have the necessary entity classes (Employee, CadreLevel, Position, PayrollComponent..et.c) mapped with appropriate annotations.
I also have a PayrollSetupService for setting up cadre levels, positions, and payroll components.

The PayrollService provides methods to retrieve employee earnings and deductions based on the employee's cadre level. 
The PayrollController exposes endpoints to fetch employee earnings and deductions.


To test the implemented endpoints using Postman, follow these steps:

Start the application and make sure it is running successfully.
Open Postman and create a new request by clicking on the "New" button.
Set the request type to "GET" and enter the URL for the desired endpoint. For example:
To retrieve employee earnings: http://localhost:8085/payroll/employees/{employeeId}/earnings
To retrieve employee deductions: http://localhost:8085/payroll/employees/{employeeId}/deductions
Replace {employeeId} with the actual ID of the employee you want to retrieve data for.
Add any required request headers or parameters if applicable.
Click the "Send" button to send the request to the server.
Postman will display the response received from the server, showing the employee earnings or deductions.
Make sure you have the appropriate data in your database, including employees, cadre levels, positions, and payroll components, before testing these endpoints. You can use the provided PayrollSetupService to set up the required data or manually add them to your database.

Note: Ensure that the application is running on the specified port (8085 in the example) and adjust the URL accordingly if you are using a different port or host.

Other things to be implemented is Access Control, and a need to further enhance it based on your specific requirements for future purposes



Ensure you have JRE(or Java 17 SDKs) installed on your laptop. You can use any of your desired IDE for this project.   I have included all the classpath in it but you need to update it before you launch the application. Ensure you are also connected to the internet. Thanks



Note: A simple UML has been added to the project folde---->PayRollApplication.png



CREATE DATABASE payrollDB;

Note: you must create a database with the following features:

spring.application.name= PayRoll System

server.port= 8085

spring.datasource.url=jdbc:postgresql://localhost:5432/payrollDB
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



but you can change the password and username to suit you. but ensure you test the connection and the appropriate driver is installed.

THAT IS ALL.
