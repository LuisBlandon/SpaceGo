package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.RegisterPage;

public class RegisterPageSteps {
    private RegisterPage registerPage;

    public RegisterPageSteps() {
        registerPage = new RegisterPage(Hooks.driver);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheCreateAccountButton(String buttonText) {
        registerPage.clickCreateAccountButton(buttonText);
    }

    @Then("the user should see the message {string} for the email field")
    public void theUserShouldSeeTheMessageForEmailField(String expectedMessage) {
        String actualMessage = registerPage.getEmailErrorMessage();
        Assert.assertEquals("The email error message is incorrect.", expectedMessage, actualMessage);
    }

    @Then("the user should see the message {string} for the password field")
    public void theUserShouldSeeTheMessageForPasswordField(String expectedMessage) {
        String actualMessage = registerPage.getPasswordErrorMessage();
        Assert.assertEquals("The password error message is incorrect.", expectedMessage, actualMessage);
    }

    @And("the user enters an invalid email {string}")
    public void theUserEntersAnInvalidEmail(String invalidEmail) {
        registerPage.enterInvalidEmail(invalidEmail);
    }

    @And("the user enters a password {string} in the Password field")
    public void theUserEntersPasswordInThePasswordField(String password) {
        registerPage.enterPassword(password);
    }

    @And("the user enters a password {string} in the Confirm Password field")
    public void theUserEntersPasswordInTheConfirmPasswordField(String password) {
        registerPage.enterConfirmPassword(password);
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayedIndicatingAnInvalidEmailAddress(String expectedErrorMessage) {
        String actualErrorMessage = registerPage.getEmailWrongFormatMessage();
        Assert.assertEquals("The email error format error message is not expected.", expectedErrorMessage, actualErrorMessage);
    }

    @Then("an error length password message {string} should be displayed")
    public void anErrorLengthPasswordMessageShouldBeDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = registerPage.getPasswordWrongLengthMessage();
        Assert.assertEquals("The Password Length format error message is not expected.", expectedErrorMessage, actualErrorMessage);
    }

    @Then("an error mismatch password message {string} should be displayed")
    public void anErrorMismatchPasswordMessageShouldBeDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = registerPage.getPasswordMismatchMessage();
        Assert.assertEquals("The Password mismatch error message is not expected.", expectedErrorMessage, actualErrorMessage);
    }
}
