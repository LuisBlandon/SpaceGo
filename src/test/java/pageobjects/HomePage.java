package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "letsplay-button")
    private WebElement startPlayingButton;

    @FindBy(css = ".languages .dropdown-toogle")
    private WebElement languageDropdown;

    @FindBy(css = ".cc-nb-okagree")
    private WebElement acceptCookiesButton;
    @FindBy(css = "slotcom-button[data-testid='slotcom-terms-and-conditions-button'] button")
    private WebElement acceptButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectLanguage(String language) {
        WebElement currentLanguageElement = languageDropdown.findElement(By.cssSelector(".current-language"));
        String currentLanguage = currentLanguageElement.getText().toLowerCase();

        if (currentLanguage.equals(language.toLowerCase())) {
            System.out.println("language configured to: " + language);
            return;
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(languageDropdown).perform();
        WebElement languageOption = driver.findElement(By.xpath("//a[text()='" + language + "']"));
        languageOption.click();
        actions.moveByOffset(0, 0).perform();
    }

    public void clickStartPlaying() {
        startPlayingButton.click();
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public void clickAcceptButton() {
        acceptButton.click();
    }
}
