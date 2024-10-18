# Rule Engine AST Project

## Overview
This project implements a simple Rule Engine that uses an Abstract Syntax Tree (AST) to represent rules. The Rule Engine allows you to create, combine, and evaluate rules based on logical operators such as `AND` and `OR`.

### Features
- **Create rules**: Convert a rule string into an AST.
- **Combine rules**: Combine multiple rules using logical operators (`AND`, `OR`).
- **Evaluate rules**: Evaluate the rules against user-defined data.

---

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Maven**
- **Postman** (for API testing)

---

## Prerequisites

1. **Java**: Ensure that Java 17 or higher is installed.
   - Download and install Java from [here](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
   
2. **Maven**: Ensure Maven is installed on your system.
   - Download and install Maven from [here](https://maven.apache.org/download.cgi).
   
3. **Postman** (optional but recommended for testing):
   - Download Postman from [here](https://www.postman.com/downloads/).

---

## Setup Instructions

### 1. Clone the Repository
Clone this repository to your local machine using the command below:
---
```bash
https://github.com/Jagadeesh2002/Application.git
---

### 2. Navigate to the Project Directory
bash
Copy code
cd RuleEngineAST
3. Build the Project using Maven
Run the following Maven command to build the project:

bash
Copy code
mvn clean install
This will download all the necessary dependencies and build the project.

4. Run the Application
Run the following command to start the Spring Boot application:

bash
Copy code
mvn spring-boot:run
Alternatively, you can run the generated JAR file (after building) using:

bash
Copy code
java -jar target/RuleEngineAST-0.0.1-SNAPSHOT.jar
API Endpoints
1. Create Rule
URL: /api/rules/create
Method: POST
Request Body: A string representing a rule.
Example: "A AND B"
Response: A JSON representing the Abstract Syntax Tree (AST) for the rule.
Example Request:
bash
Copy code
POST http://localhost:8080/api/rules/create
Body (raw JSON):
"A AND B"
Example Response:
json
Copy code
{
    "type": "operator",
    "operator": "AND",
    "left": {
        "type": "operand",
        "value": "A",
        "left": null,
        "right": null
    },
    "right": {
        "type": "operand",
        "value": "B",
        "left": null,
        "right": null
    }
}
2. Combine Rules
URL: /api/rules/combine
Method: POST
Request Body: A JSON containing two rule nodes and an operator (AND/OR).
Example Request:
bash
Copy code
POST http://localhost:8080/api/rules/combine
Body (raw JSON):
{
  "rule1": {
      "type": "operand",
      "value": "A"
  },
  "rule2": {
      "type": "operand",
      "value": "B"
  },
  "operator": "AND"
}
Example Response:
json
Copy code
{
    "type": "operator",
    "operator": "AND",
    "left": {
        "type": "operand",
        "value": "A",
        "left": null,
        "right": null
    },
    "right": {
        "type": "operand",
        "value": "B",
        "left": null,
        "right": null
    }
}
3. Evaluate Rule
URL: /api/rules/evaluate
Method: POST
Request Body: A JSON containing the rule node and data map.
Example Request:
bash
Copy code
POST http://localhost:8080/api/rules/evaluate
Body (raw JSON):
{
  "rule": {
    "type": "operator",
    "operator": "AND",
    "left": {
        "type": "operand",
        "value": "A"
    },
    "right": {
        "type": "operand",
        "value": "B"
    }
  },
  "data": {
      "A": true,
      "B": false
  }
}
Example Response:
json
Copy code
false
How to Test the API Using Postman
Open Postman and set the method to POST.
Enter the URL (http://localhost:8080/api/rules/create) for the API endpoint you want to test.
Set the request body to raw JSON and add the rule string or JSON object.
Click Send and check the response.
Folder Structure
css
Copy code
RuleEngineAST
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.example.RuleEngineAST
│   │   │   │   ├── controller
│   │   │   │   │   └── RuleEngineController.java
│   │   │   │   ├── model
│   │   │   │   │   └── Node.java
│   │   │   │   ├── service
│   │   │   │   │   └── RuleEngineService.java
│   │   │   └── RuleEngineAstApplication.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── templates
├── pom.xml
└── README.md
License
This project is licensed under the MIT License - see the LICENSE file for details.

vbnet
Copy code

### Key Sections Explained:
1. **Overview**: A summary of the project and its functionality.
2. **Technologies Used**: Lists the main technologies and tools used.
3. **Prerequisites**: What users need to have installed before running the project.
4. **Setup Instructions**: Step-by-step guide on how to clone, build, and run the project.
5. **API Endpoints**: Clear examples of how to use each API with sample requests and responses.
6. **Postman Instructions**: How to test the APIs using Postman.
7. **Folder Structure**: Helps others understand your project's layout.

Let me know if you want to adjust or add anything specific!
