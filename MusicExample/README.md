# Getting Started

## How To Run Me
### Step1 - Using Maven
There are two options

* Using the Maven wrapper  <b><i>./mvnw</b></i> or <b><i>mvnw install</b></i> 
* Using the Maven client: <b><i>mvn</b></i> 

### Step2 - Install
At the top of the project run an install to download the relevant dependencies and compile the code  

<b><i>./mvnw install</b></i>


### Step3 - Run
At the top of the project start spring boot which will run your jar, and any REST endpoints should be available at http://localhost:8080/{METHOD_NAME}

<b><i>./mvnw spring-boot:run</b></i>
