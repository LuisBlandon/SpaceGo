# **Automation Project with Java, Selenium, and Cucumber**

This automation project is designed to test web applications using **Java**, **Selenium**, and **Cucumber**. It implements Behavior-Driven Development (BDD) tests written in **Gherkin** with **Cucumber** to ensure that the system requirements are met efficiently.

---

## **Technologies Used**

- **Java 21**: The main programming language.
- **Selenium**: A framework for automating web application testing.
- **Cucumber**: A BDD framework for behavior-driven testing.
- **JUnit**: A framework for running unit and integration tests.
- **Page Object Model (POM)**: A design pattern for creating classes representing pages in the app.
- **Maven**: A build tool for managing dependencies.
- **Gherkin**: A language used in `.feature` files to define test scenarios.

---

## **Project Structure**

```plaintext
.
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pageobjects       # Page Object classes (interactions with app pages)
│   │   │   ├── stepdefinitions   # Cucumber step definitions
│   │   │   └── utils             # Utilities for language handling and others
│   │   └── resources
│   │       └── features           # .feature files with test scenarios in Gherkin
├── pom.xml                        # Maven dependencies and configuration
└── README.md                      # Project documentation

Prerequisites
To run this project, you need to have the following installed:

Java 17.

Maven for dependency management.

IDE such as IntelliJ IDEA or Eclipse.

Selenium Drivers for the browser you will use (ChromeDriver, GeckoDriver, etc.).

Prerequisites
To run this project, you need to have the following installed:

Java 21 or higher.

Maven for dependency management.

IDE such as IntelliJ IDEA or Eclipse.

Selenium Drivers for the browser you will use (ChromeDriver, GeckoDriver, etc.).

3. Set Up the Environment
Make sure the Selenium drivers are set up for the browser you will use (e.g., Chrome, Firefox).

You can configure browser parameters and execution options in the Maven configuration file if needed.

4. Run the Tests
To run the tests, use the following Maven command to execute Cucumber with JUnit:
mvn test
