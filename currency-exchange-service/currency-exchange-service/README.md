# Currency-Exchange-Service (port: 8000,8001,8002.....)
1. It's an another service which is use to exchange the ammount from one form to another form (Ex: INR to USD) and in this service this doing DB operation Using H2 database.
2. This service will communicate with another service to evalute the ammount from one form to another form.
3. We have sql file to insert data manually into db<br/>

# H2 Database Configuration
1. For test purpose i am using H2 db for that i need to comfigure some properties in config file(application.properties). As your choice you can use any db.<br/>

	spring.jpa.show-sql = true<br/>
	spring.h2.console.enabled = true<br/>
	spring.datasource.url=jdbc:h2:mem:testdb<br/>

# Architecture Example
<p align="center">
	<img src="https://github.com/ravigithub09/Microservices/blob/master/currency-exchange-service/currency-exchange-service/currency-exchange-service.PNG" width="500" title="currency-exchange-service">
         </p>
