# spring-boot-crud
Basic CRUD App with JPA + Hibernate + MySQL in Spring Boot

**Description**
This project is a restful API with Spring Boot and MySQL. Created all the Front end with ReactJs and Material UI. Used Axios to consume the Spring Boot API. Finally, used Redux to handle the state management. You can find the front end app here .... `Coming soon!`

**Endpoints**

1. `http://localhost:8080`: The initial endpoint
2. `/api/members`: This returns the list of Members in the members table which is created in MySql Table (members)
3. `/api/{id}`: This returns the details of the Members for the member Id passed in URL

**Libraries used**

1. Spring Boot
2. JPA with Hibernate
3. MySql
4. Maven

**Tools used**

1. Visual Code
2. MySql running locally

**Prerequisites**
* Java 1.8
* Latest version of Maven
* Latest version of MySQL
* NodeJs 

**Build and run**

*Configurations*

Open the `application.properties` file and set your own configurations for the database connection.

*From terminal*

Go on the project's root folder, then type:

`mvn spring-boot:run` 

*From Visual Code*

Go to your code that contains the main method and click on `run` above the main method
