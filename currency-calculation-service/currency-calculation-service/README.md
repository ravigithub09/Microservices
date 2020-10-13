# Currency-calculation-service (port: 8100,8101,8102.....)
In this service the fuctionality would be to take currency value from currency-exchange-service and convert it into ammount as per currency value.<br/>
<b>Example:</b> this service will ask what is the value of 1$. Now this service will convert the ammount according to doller value of that calculation ammount.

# Configure and call one service from another service
  We can configure and call the another service by useing RestTemplate and calling by another service URI.<br/>
  <b>Example:</b> new RestTemplate().getForEntity("http://localhost:8000/exchageService/from/{from}/to/{to}", 
				CurrncyConversionBean.class	, uriVariables);<br/>
		CurrncyConversionBean currncyConversionBean = responseEntity.getBody();<br/>
    Now we can return this pojo "currncyConversionBean". But while doing the coding it would be bit complex and clumsy as well. So to reduce the code and make easy the code , calling services easily the <b>"Feign"</b> concept comes in picture.<br/>
    
# Architecture Example
<p align="center">
	<img src="https://github.com/ravigithub09/Microservices/blob/master/currency-calculation-service/currency-calculation-service/currency-conversion-service.PNG" width="500" title="currency-conversion-service">
         </p>

    
# Feign concept

  1. Feign provides an abstraction over REST-based calls via annotation, by which microservices can use to communicate with each other without writing detailed REST client code.<br/>
  2. Feign is a rest service client . It makes easy to call restful web services.<br/>
  3. Feign helps us to simplify the client code to talk to restful web services.<br/>
  4. We can use feign to code much simpler than earlier code to invoke microservice calls.<br/>
  5. It provides integration with ribbon which is use to client side load balancing framework.
  
  # Dependency
  1. <b>We can add feign dependency from spring-cloud-starter-openfeign artifact and from org.springframework.cloud groupId.</b>
  
# What it does?
  1. It will make easy to do call another service by making proxy interface.
  2. It will use @FeignEnable(Service-Name which you want call , URI of service which you want to call)
  <b>Example:</b><br/>
@FeignClient(name = "currency-exchange-service", url = "localhost:8001")<br/>
public interface CurrencyConversionFeignProxyService {<br/>
@GetMapping("/exchageService/from/{from}/to/{to}")<br/>
public CurrncyConversionBean getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}

# Problem
1. While calling services for multiple instance (multiple port) because of load balancing to that service we can pass one instance . 
2. In case of multiple instance feign concept would be fail.

# Ribbon Concept
1. To balance the load of service Ribbon concept comes into picture. which can balance the load among all the instances of a service.
2. Ribbon concept we would use for distributing the load between multiple instances of a service. We will enable "Ribbon" using <b>@RibbonClient(Name = service-name)</b> at the proxy class from where you are calling another service.

<p align="center">
	<img src="https://github.com/ravigithub09/Microservices/blob/master/currency-calculation-service/currency-calculation-service/Ribbon.PNG" width="500" title="ribbon">
         </p>


# Dependecy
1. <b>We can add feign dependency from "spring-cloud-starter-netflix-ribbon" artifact and from "org.springframework.cloud" groupId.</b>
 
--> In Ribbon concept we can configure multiple instance of a service in application.properties like<br/>
     service-name(which service is running on multiple port).ribbon.listOfServers=instance1,instance2…..etc
     <b>Example:</b> currency-exchange-service.ribbon.listOfServers =  http://localhost:8000,http://localhost:8001,http://localhost:8002,http://localhost:8003<br/>
          @FeignClient(name = "currency-exchange-service")
    @RibbonClient(name = "currency-exchange-service")
    public interface CurrencyConversionFeignProxyService {<br/>
@GetMapping("/exchageService/from/{from}/to/{to}")<br/>
public CurrncyConversionBean getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);<br/>
}<br/>     
     <b>Note-></b> instance is nothing but on which port it is running.
     **Make sure before running the proxy server first all the instance of another service if completely it will be in running mode then u can execute that service where               you did called all the instances of another service
     
 # Problem With Ribbon
   It is doing load balancing b/w multiple instances(Nothing  but services are  running of different port) of a service and that multiple instance we have to configure in our configuration file every time whenever new instance would be created and that is not a good practice to disturb service configuration file every time.so i want to to based on load dynamically increase or decrease the instances of a service. To overcome this problem <b>"Naming Server"</b> came into the picture.
   
 # Register with Eureka Naming Server
 	1. Add Dependency to pom.xml
		```<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>```

	
     

