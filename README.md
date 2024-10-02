# **🛠️ Online Bookstore API Test Framework**

## **📘 About the Project**
This project is a **test automation framework** developed to test an Online Bookstore API.
It is written in **Java** and uses **JUnit** and **RestAssured** libraries to conduct API tests. 
The project includes POJO classes, utility classes, and test scenarios.

---

## **📂 Project Structure**

```
online-bookstore/
│
├── .idea/                     # IDE configuration files
├── allure-results/             # Allure report results
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── net/
│   │   │       └── azurewebsites/
│   │   │           ├── dto/
│   │   │           │   ├── Author.java      # Author POJO Class
│   │   │           │   └── Book.java        # Book POJO Class
│   │   │           └── utility/
│   │   │               └── ApiUtils.java    # API Utility Class
│   └── test/
│       ├── java/
│       │   └── net/
│       │       └── azurewebsites/
│       │           ├── base/                # Base classes for test configuration
│       │           └── tests/
│       │               ├── AuthorApiTests.java # Author API Test Class
│       │               └── BookApiTests.java   # Book API Test Class
├── target/                   # Compiled files
├── JenkinsSmokefile           # Jenkins configuration file
├── .gitignore                 # Git ignored files
├── pom.xml                    # Maven project configuration file
└── .env                       # Environment variables file


💻 Requirements
To run this project, you need the following:

Java 11
Maven 3.6.3
IntelliJ IDEA

🔧 Setup Steps
📦 Maven Dependencies
The dependencies used in this project are defined in the pom.xml file. You can install the necessary dependencies by running the following command:
mvn clean install


🚀 Running Tests
Running All API Tests:
mvn test

Running Only Smoke Tests:
mvn test -Dgroups=smoke


📑 Project Structure Overview
🏷️ POJO Classes (DTO - Data Transfer Objects)
Author.java: POJO class that holds information about an author.
Book.java: POJO class that holds information about a book.
Both POJO classes are used to transfer data between the system components.

Example POJO Class:
java
Copy code
public class Author {
    private String name;
    private String nationality;

    // Constructors, Getters, and Setters
}

🛠️ Utility Class
ApiUtils.java: A helper class that contains utility functions for API tests, such as sending requests to the API endpoints.
Example Utility Class:
java
Copy code
public class ApiUtils {
    public static Response sendGetRequest(String endpoint) {
        return RestAssured.get(endpoint);
    }
}

🧪 Test Classes
Test scenarios are written using JUnit. Separate test classes are created to validate the functionality of the API:
AuthorApiTests.java: Contains tests related to the Author API.
BookApiTests.java: Contains tests related to the Book API.


Example Test Scenario:
@Test
public void verifyAuthorCreation() {
    Response response = ApiUtils.sendPostRequest("/authors", new Author("John", "American"));
    assertEquals(201, response.getStatusCode());
}

📊 Test Reporting
This project uses Allure for test reporting. After running the tests, you can view the Allure report by executing:
 allure serve target/allure-results  
 
 
🤖 Jenkins Integration
The project includes a JenkinsSmokefile, which is configured to run smoke tests in Jenkins CI/CD pipelines. When integrated with Jenkins, 
it will automatically trigger the smoke tests and report the results.

🔐 Environment Variables
The project uses an .env file to store environment variables. You must properly configure this file for the tests to run correctly.

🤝 Contributing
To contribute to the project, follow these steps:

Fork the project.
Create a new branch (git checkout -b feature/your-feature).
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature/your-feature).
Open a Pull Request.
