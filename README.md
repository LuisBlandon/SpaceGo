Automation Project with Java, Selenium, and Cucumber
This automation project is designed to test web applications using Java, Selenium, and Cucumber. It implements Behavior-Driven Development (BDD) tests written in Gherkin with Cucumber to ensure that the system requirements are met efficiently.

Technologies Used
Java 21: The main programming language.

Selenium: A framework for automating web application testing.

Cucumber: A BDD framework for behavior-driven testing.

JUnit: A framework for running unit and integration tests.

Page Object Model (POM): A design pattern for creating classes representing pages in the app.

Maven: A build tool for managing dependencies.

Gherkin: A language used in .feature files to define test scenarios.

Project Structure
plaintext
Copiar
Editar
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

Java 21 or higher.

Maven for dependency management.

IDE such as IntelliJ IDEA or Eclipse.

Selenium Drivers for the browser you will use (ChromeDriver, GeckoDriver, etc.).

Setup and Execution
1. Clone the Repository
Clone the repository to your local machine using Git:

bash
Copiar
Editar
git clone https://github.com/your-username/your-repository.git
2. Install Dependencies
Navigate to the project directory and use Maven to download the dependencies:

bash
Copiar
Editar
cd your-repository
mvn clean install
3. Set Up the Environment
Make sure the Selenium drivers are set up for the browser you will use (e.g., Chrome, Firefox).

You can configure browser parameters and execution options in the Maven configuration file if needed.

4. Run the Tests
To run the tests, use the following Maven command to execute Cucumber with JUnit:

bash
Copiar
Editar
mvn test
Cucumber will run the scenarios defined in the .feature files and generate a report with the results.

Test Project Structure
1. Page Object Model (POM)
This project follows the Page Object Model (POM) design pattern to separate the logic of interacting with pages from the test logic.

The classes inside the pageobjects package represent pages in the app. These classes contain methods to interact with elements on the page like forms, buttons, etc.

2. Cucumber Step Definitions
The .feature files in the src/main/resources/features folder contain the test scenarios written in Gherkin.

Example of a .feature file:

gherkin
Copiar
Editar
Feature: Email format validation

  Scenario Outline: Email format validation
    Given the user is on the home page
    When the user selects "<language>" as the language
    And the user clicks "Start Playing"
    And the user clicks the Accept button in the terms modal
    And the user selects "Jugar con Email"
    And the user enters an invalid email "<invalid_email>"
    Then an error message should be displayed indicating an invalid email address

    Examples:
      | language | invalid_email |
      | es       | user@         |
      | en       | user.com      |
      | it       | user@         |
Each step of the scenario is implemented in the step definition classes inside the stepdefinitions package. The steps are methods that interact with page elements using Selenium.

3. Language Handling
The project supports multiple languages for error message validation. The LanguageUtils class manages the language switching and retrieves the correct error messages based on the selected language.

The language is set using the setLanguage method, and error messages are retrieved using getExpectedErrorMessage.

Key Files
1. RegisterPage.java
Class representing the register page and interacting with its UI elements.

java
Copiar
Editar
public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By emailInput = By.cssSelector("input[data-testid='slotcom-register-emailText-input']");
    private By emailError = By.cssSelector("div[data-testid='slotcom-register-emailWrongFormat-errorText']");

    public void enterInvalidEmail(String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public String getEmailErrorMessage() {
        return driver.findElement(emailError).getText();
    }
}
2. RegisterPageSteps.java
Class that contains the step definitions for Cucumber scenarios. This class validates error messages.

java
Copiar
Editar
public class RegisterPageSteps {

    private final RegisterPage registerPage;

    public RegisterPageSteps() {
        this.registerPage = new RegisterPage(DriverFactory.getDriver());
    }

    @And("the user enters an invalid email {string}")
    public void theUserEntersAnInvalidEmail(String invalidEmail) {
        registerPage.enterInvalidEmail(invalidEmail);
    }

    @Then("an error message should be displayed indicating an invalid email address")
    public void anErrorMessageShouldBeDisplayedIndicatingAnInvalidEmailAddress() {
        String expectedErrorMessage = LanguageUtils.getExpectedErrorMessage("invalid_email");
        String actualErrorMessage = registerPage.getEmailErrorMessage();
        
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, 
            "The error message is not as expected.");
    }
}
Contributions
If you want to contribute to this project, feel free to fork it and submit a pull request with your changes. Be sure to follow the coding conventions and write proper tests.

License
This project is licensed under the MIT License - see the LICENSE file for more details.

Thank you for using this automation project! 🚀
