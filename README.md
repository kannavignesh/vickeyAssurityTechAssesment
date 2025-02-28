1. API Test Automation Framework:
This project is a Service Object Model (SOM) based API test automation framework built using Cucumber, TestNG, RestAssured, Request Specification Builder, and Response Specification Builder.

2. Project Structure
src/test/java/
├── features/                  # Contains Cucumber feature files
│   └── category_details.feature
├── stepdefinitions/           # Contains step definitions for feature files
│   └── CategoryDetailsSteps.java
├── services/                  # Contains service classes for API logic
│   └── CategoryService.java
├── runners/                   # Contains TestNG runner class
│   └── TestRunner.java
├── utilities/                 # Contains utility classes
    └── ApiUtils.java

3. Prerequisites
   #.Java Development Kit (JDK): Version 11 or higher.
   #.Maven: For dependency management and build automation.
   #.IDE: IntelliJ IDEA, Eclipse, or any preferred IDE.
   #.Git: For version control (optional).

4. Setup Instructions
   #.Clone the Repository
     --> git clone <repository-url>
     --> cd <project-folder>
   #.Install Dependencies
     --> mvn clean install

5. Running the Tests:
   #.From the Terminal
     $ To run the tests from the terminal, use the following command:
       --> mvn clean test
     $ Run specific tags (e.g., @Positive or @Negative):
       --> mvn clean test -Dcucumber.options="--tags @Positive"
     $ Run tests in parallel:
       --> mvn clean test -Dcucumber.execution.parallel.enabled=true
  #. From an IDE
     $ Open the project in your preferred IDE.
     $ Navigate to the TestRunner class under the runners package.
     $ Right-click and select Run or Debug.

6. Test Reports
   After test execution, the following reports will be generated:
   --> Cucumber HTML Report: Located at target/cucumber-reports/cucumber.html.
   --> Cucumber JSON Report: Located at target/cucumber-reports/cucumber.json.
   To view the HTML report, open the cucumber.html file in a web browser.

Best Practices
1. Modularity
Service Classes: Encapsulate API logic in service classes (e.g., CategoryService).
Utilities: Centralize reusable methods (e.g., ApiUtils).

2. Request and Response Specifications
Use Request Specification Builder to define common request configurations (e.g., base URI, headers).
Use Response Specification Builder to define common response validations (e.g., status code, content type).

3. BDD with Cucumber
Write feature files in Gherkin syntax for better readability and collaboration.
Step Definitions: Keep step definitions clean and focused on test steps.
Use tags (e.g., @Positive, @Negative) to categorize and filter test scenarios.

4. Reporting
Use Cucumber reporting plugins to generate detailed HTML and JSON reports.

5. Parallel Execution
Leverage TestNG's parallel execution capabilities to reduce test execution time.

6. Error Handling
Validate error responses for negative test scenarios (e.g., invalid Category ID, invalid query parameter).
