package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @FindBy(css = "input[data-testid='slotcom-register-emailText-input']")
    private WebElement emailInput;

    @FindBy(css = "div[data-testid='slotcom-register-emailWrongFormat-errorText']")
    private WebElement emailError;


    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectButtonByLabel(String buttonLabel) {
        WebElement button = driver.findElement(By.xpath("//span[contains(text(), '" + buttonLabel + "')]"));
        button.click();
    }
}
