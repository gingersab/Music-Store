(**CURRENTLY NO BACKEND ONLINE - MODIFY TO USE YOUR OWN**)

The structure of this application is as follows:
- RESTful MVC web app 
- MySQL backend
- Server side is Java using Spring Boot framework
- The server side design follows the Database Access Object (DAO) pattern
- Database interactions follow Spring JPA/Hibernate
- Front end is implemented using React
- Project is built with Maven

**Building the project**

- Download the project ZIP file
- Extract the files to some directory
- Navigate to project directory and into the `MusicExample` folder
- Build the project:
    `mvn clean install`
    
**Running the tests**

- Once the project is built simply execute
    ` mvn test`
    
**Running the application**

- Once the project is built, navigate to `MusicExample/target` folder

- Maven: 
    `mvn spring-boot:run`
    
- JAR execution:
    `java -jar NGMusicWares.JAR`
  
- Runs on `localhost:8080`
