# Microservices
 It is an approach to developing a single application as a suite of small services,each running in it's own process and communicating with light weight mechanisms like HTTP resource API.
 These services are built around business capabilities and independently deployable by fully automated deployment machinery.
 Microservices arranges an application as a collection of loosely coupled services. In a microservices architecture, services are fine-grained and the protocols are lightweight.
 <p align="center">	
	![alt text](https://github.com/ravigithub09/Microservices/blob/master/limit-service/img/multiple-services.png?raw=true)
	<img src="https://github.com/ravigithub09/Microservices/blob/master/limit-service/img/multiple-services.PNG" width="350" title="microservices" >
	</p>
 
 # Microservices Architecture
 A microservices architecture consists of a collection of small, autonomous services. Each service is self-contained and should implement a single business capability.
 <br/>
 <p align="center">	
	<img src="https://github.com/ravigithub09/Microservices/blob/master/limit-service/img/Microservice_Architecture.png" width="350" title="Microservices Architecture" >
	</p>
 
 # Microservices Challenges
 1. Bounded context-> we are developing more number of services like 5 , 10, 20 and more than that service in one application. Then we have challenges like in which service what should we do or what we should not do.For this we need to do so many processes to give correct services.
 
 2. Configuration Management-> While developing more services for an application might we can have a different environment . Then Configuration of all the services together is a   bit challenging.
 
 3. Dynamic scale up and scale down-> In microservices in some point of time we have two instance of a service but in in future i want some more instance the we can sale up or we can create some more instance the application and if want to down another services instance then we can do if that is really not needed.
 
 4. Visibility-> if we have more services in an application if we found any kind of bug then in that case it's difficult to find.
 
 5. Pack of cards-> if we have more services in an application if suppose one is down then the whole application goes down because one is connected to another.
 
# Advantage Of Microservices
1. New Technology and process adaption-> While developing the application there are multiple services which are communicating to each other . that technologies might be in different technologies.
	
2. Dynamic scaling -> if load is more on any services i can manage the load( Ex: on shopping websites in holidays time more user are visiting in that case load will be more on that service. )
	
3. Faster Release cycle-> Bring new features to market faster.

4. spring cloud Config server -> It is used to manage all the configuration of multiple microservices. It provides an approach where you can store configuration of all the services into the local git repository.

**Dynamic scale up and down: Naming server(Eureka) use to register services ,Ribbon(Client side load balancing),Feign (Easier Rest client)

# Ports
1. On below port configuring all services
	 <p align="center">	
	<img src="https://github.com/ravigithub09/Microservices/blob/master/limit-service/img/ports.PNG" width="350" title="Service ports" >
	</p>  
