# Spring-Cloud-Config-Server

 1. It is use to manage/handle centralized configuration among various small services.
 2. In this application we can use official Git location or you can download Git from https://git-scm.com/download/ url(Download as per your OS) and make local git repository to store the configuration files.
 3. We have below some basic command to do work with local Git reporitory.
 4. After installing Git you can have two command prompt , System command prompt and Git CMD . You can use any of one among those cmd.
 # Command and Steps to work with local git				
    1. Open git cmd/system cmd
    2. Go to some different directory , default it will point to user location (ex: C:\Users\ravis>f:)
    3. create one folder here<br/>
			        <b> F:\>mkdir git-local-repo </b>
    4. Move to that directory<br/>
			      <b>  F:\>cd git-local-repo</b>
    5. Initialize git<br/>
			        <b> F:\git-local-repo>git init</b><br />
<b>Note:</b> After these above steps completed you will get this message <b>“Initialized empty Git repository in F:/git-local-repo/.git/”</b> means git has been initialized.<br/>
<b>Add local repo folder to spring-cloud-config-server </b><br/>
1. Right click on project-> build path-> configure build path-> source ->link source-> select local repo folder-> apply-> apply and close <b>(For Eclipse IDE)</b>
2. To register this local repository with configuration server place below configuration value in config file of cloud-config-server<br/>
spring.cloud.config.server.git.uri = file://location of local repo<br/>
 <b>(Ex: spring.cloud.config.server.git.uri = file:///F:/git-local-repo)</b><br/>
 <b>Note →</b> In git local repo whatever property files will be available the suffix of that file should be the same as service name.<br/>
(Ex: limit-service-qa.properties)
3. Configure this server to another application we have to give it’s uri and and need to declare it’s profile(It's environment-> QA,Dev,Prod)<br/>
<b>Ex:</b> B server is configuring in A service then in a configuration file (Rename the file with some other name ex: bootstrap.xml) we can put it’s uri <b>(spring.cloud.config.uri=http://localhost:8888)</b>
and it’s profile environment <b>(spring.profiles.active=qa)</b>
4. Create some properties files for a specific environment which you want to register. Take the same properties from that application.properties file of another  service Give some different values to differentiate.
5. Add this file to the local git repository using this command instead of A you can use your file name as well.<br/>
		   <b> F:\git-local-repo>git add -A</b><br/>
      <b>Note:</b> If you will commit it will ask your identity  as email and name you give any random email and name just for identity.
6. To commit that file execute that command
			<b>git commit -m "commit done"
			-m-> indicate to message</b>
      
			For check the status : git status
5. Local git repository register with cloud config server by using local git repository location. Right click on git local repo folder in project properties and copy location.	 
6. Run that config server. opening the browser and append the exactly the same name what the properties file you have committed to the git without extension		 
7. In the end we have to enable config server  using <b>@EnableConfigServer</b> at the top of <b>@SpringBootApplication</b> of config server application.
8. We can give multiple properties file to local git repo folder in config server and we will commit it into local git repo<br/>
	example : default properties file<br/>
		      qa properties file(limit-service-qa.properties)(the suffix should be service name(example: limit-service))<br/>
			    dev properties file<br/>
         <b> Note:</b> If we will not give any value to dev and qa properties files it will point to default file( ex: limit-service.properties)<br/>
         To get value from default properties file will access url like: http://localhost:8888/default
         










      



