# Eureka-Naming-Server(Port= 8761)
   Naming server is used to load balancing b/w multiple instances(Nothing  but services are  running of different port) of a service and that multiple instance we have to configure in our configuration file every time whenever new instance would be created and that is not a good practice to disturb service configuration file every time.so i want to to based on load dynamically increase or decrease the instances of a service. To overcome this problem Naming server came into the picture.
   
   <p align="center">
  <img src="https://github.com/ravigithub09/Microservices/blob/master/netflix-eureka-naming-server/Eureka%20naming%20server.PNG" width="500" title="Eureka naming server">
  </p>
  
# Namig server does
1. To avoid the problem of disturbing config files of services “Naming Server” came. Naming server is a kind of host or a kind of provider which provides active or running instance details of another service.
2. In the naming server service would be registered and if another service need any info about other service which should be registered with server and it can ask to naming server please give me info about the running instance of another service.<br/>
<b>Example:</b> Service A can ask details of running instance of Service B.<br/>

# Feature
Tow main feature of Naming server : <br/>
1. Service registration<br/>
2. Service discovery
                                
# How to work with Eureka Naming Server(Step-by-step)
1. Create new project
2. Annotate bootstrap class with @EnableEurekaServer
3. Open configuration file (application.properties)
      1. spring.application.name= application_name     
      2. server.port=8761
      3. eureka.client.register-with-eureka=false
      4. eureka.client.fetch-registry=false
 4. Start the application
 5. Hit the url http://localhost:8761/  
 
 # Add dependency
 		```<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>```
		
<b>Note: Make sure before running all the services first run naming server after run all the services in sequence.</b>

