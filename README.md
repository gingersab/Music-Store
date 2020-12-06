This project is a code/technical test for NextGate UK (https://nextgate.com/uk/)

The structure of this application is as follows:
- RESTful MVC web app 
- MySQL backend hosted for free by https://www.freemysqlhosting.net/
- Server side is Java using Spring Boot framework
- The server side design follows the Database Access Object (DAO) pattern
- Database interactions follow Spring JPA/Hibernate
- Front end is implemented using React
- Project is built with Maven

**Quick Start**

- Get started without downloading or cloning the project
- Download the `NGMusicWares.JAR` file from the latest release
- Run the JAR file: 
    `java -jar NGMusicWares.JAR`
    
- Open a browser and enter `localhost:8080` as the URL 

**Building the project**

- Download the project ZIP file
- Extract the files to some directory
- Navigate to project directory and into the `MusicExample` folder
- Build the project:
    `mvn clean package`
    
**Running the tests**

- Once the project is built simply execute
    ` mvn test`
    
**Running the application**

- Once the project is built, navigate to `MusicExample/target` folder

- Run the JAR file: 
    `java -jar NGMusicWares.JAR`
  
- To use the application open a browser and enter `localhost:8080` as the URL 

**Logging In**

Any of the username/password combinations from the given sample data will work.
Alternatively use `Username: Scott Password: Password` 
