package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import pageobjects.LandingPage;

public class LandingPageSteps {
    private LandingPage landingPage;

    public LandingPageSteps() {
        landingPage = new LandingPage(Hooks.driver);
    }

    @And("the user selects {string}")
    public void theUserSelectsPlayWithEmail(String buttonLabel) {
        landingPage.selectButtonByLabel(buttonLabel);
   }
}
