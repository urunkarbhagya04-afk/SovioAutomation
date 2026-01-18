Sovio Automation Testing Project

This document describes the setup instructions and execution steps for the Sovio Automation Testing Project, which automates key authentication flows of the Sovio web application using Selenium, Java, TestNG, and Maven.
Tech Stack Used
- Java (JDK 17 / 21)
- Selenium WebDriver 4.x
- TestNG
- Maven
- Google Chrome & ChromeDriver
- Git


Project Structure
SovioAutomation
 ├── src/main/java/Base/BaseTest.java
 ├── src/test/java/tests/
 │    ├── LoginTest.java
 │    ├── PasskeyLoginTest.java
 │    └── PasskeyRegistrationTest.java
 ├── pom.xml
 └── README / Documentation

 
Prerequisites
1. Java JDK installed (17 or above)
2. Maven installed and configured
3. Latest Google Chrome browser
4. Compatible ChromeDriver available in system PATH


Setup Instructions
1. Clone the repository from GitHub
2. Navigate to the project directory
3. Run 'mvn clean install' to download dependencies

   
Test Execution Steps
Run all tests using:
mvn test

Run individual test classes using:
mvn -Dtest=LoginTest test
mvn -Dtest=PasskeyLoginTest test
mvn -Dtest=PasskeyRegistrationTest test


Passkey Test Note
Passkey login and registration require manual OS-level authentication (Windows Hello / device security). Automation covers UI steps only.
Reports & Screenshots
TestNG reports are generated under target/surefire-reports.
Screenshots are captured automatically on test failures.


Author
Bhagyashree Urunkar
QA Automation Engineer
GitHub: https://github.com/urunkarbhagya04-afk
