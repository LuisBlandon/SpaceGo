package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcceptTermsModalPage {

    @FindBy(css = "slotcom-button[data-testid='slotcom-terms-and-conditions-button'] button")
    private WebElement acceptButton;

    private WebDriver driver;

    public AcceptTermsModalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAcceptButton() {
        acceptButton.click();
    }
}
