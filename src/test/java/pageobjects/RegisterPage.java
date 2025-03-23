package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(css = "[data-testid='slotcom-register-emailEmptyInput-errorText']")
    private WebElement emailMandatoryMessage;

    @FindBy(css = "[data-testid='slotcom-register-passwordEmptyInput-errorText']")
    private WebElement passwordMandatoryMessage;

    @FindBy(css = "input[data-testid='slotcom-register-emailText-input']")
    private WebElement emailInput;

    @FindBy(css = "input[data-testid='slotcom-register-passwordText-input']")
    private WebElement passwordInput;

    @FindBy(css = "input[data-testid='slotcom-register-confirmPasswordText-input']")
    private WebElement passwordConfirmInput;

    @FindBy(css = "input[data-testid='slotcom-register-passwordWrongFormat-errorText']")
    private WebElement passwordWrongFormat;

    @FindBy(css = "input[data-testid='slotcom-register-passwordWrongFormat-errorText']")
    private WebElement passwordWrongMismatchMessage;

    @FindBy(css = "div[data-testid='slotcom-register-emailWrongFormat-errorText']")
    private WebElement emailError;
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAccountButton(String buttonText) {
        WebElement createAccountButton = driver.findElement(
                By.xpath("//span[contains(., '" + buttonText + "')]")
        );
        createAccountButton.click();
    }

    public void enterInvalidEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        passwordConfirmInput.clear();
        passwordConfirmInput.sendKeys(password);
    }

    public String getEmailWrongFormatMessage() {
        return emailError.getText();
    }

    public String getPasswordWrongLengthMessage() {
        return passwordWrongFormat.getText();
    }

    public String getPasswordMismatchMessage() {
        return passwordWrongMismatchMessage.getText();
    }

    public String getEmailErrorMessage() {
        return emailMandatoryMessage.getText().trim();
    }

    public String getPasswordErrorMessage() {
        return passwordMandatoryMessage.getText().trim();
    }
}
