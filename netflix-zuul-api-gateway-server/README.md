# ZUUL API Gateway (port: 8765)
<b>It provides :</b><br/>
1. Authentication, authorization and security
2. Rate limit (For specific client wants to provide certain number of calls per day or per day)
3. Fault tolerance (If some of the instance is down then able to provide some default response)
4. Service aggregation (External client who wants to call some different services as part of the process.It’s better to aggregate all service and provide one services call for external consumer)
# Microservices provides Zuul Api gateway.
# Steps to setup zuul API
1. Create a component.
2. When one service call to another service is intercepted what Zuul API gateway to do
3. All the important request configure to the pass through Zuul api
4. To implement ZUUL API we required zuul, Eureka Discovery client, Actuator, Devtools dependencies.
5. Use some annotation over bootstrap class @EnableZuulProxy and @EnableDiscoveryClient and also configure naming server in application.properties<br/>
    <b>Example: </b>eureka.client.service-url.default-zone=http://localhost:8761/eureka<br/>
    
 # Create an example for zuul API gateway server
    1. Create a class and extend it with a ZuulFilter abstract class and annotate with @component which contains some default method which would be overriding in that clustom  class zuul api gateway project.
    2. Methods are:<br/>
          shouldFilter(){}-> it can be either true or false 
		      run(){}-> here we can write some business logic
		      filterType(){}-> there is 3 condition ‘pre’,’post’ or ‘error’ 
		      filterOrder(){} -> we can provide order for filters like 1,2….
    3. Follow above 5th step to make application as a  Zuul API gateway server.
    4. Running sequence 
        i. Naming server
        ii. services which registered with naming server
        iii. Zuul API Gateway
        iv. Run the service through Zuul API Gateway<br/>
      <b>Syntax: http://localhost:8765/{application-name}/{uri}</b>
  <b>Example: http://localhost:8765/currency-exchange-service/exchageService/from/USD/to/INR</b>




 
