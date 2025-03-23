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
