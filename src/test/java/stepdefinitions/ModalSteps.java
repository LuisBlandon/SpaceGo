package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import pageobjects.AcceptTermsModalPage;

public class ModalSteps {
    private AcceptTermsModalPage acceptTermsModalPage;

    public ModalSteps() {
        acceptTermsModalPage = new AcceptTermsModalPage(Hooks.driver);
    }
    @And("the user clicks the Accept button in the terms modal")
    public void theUserClicksAcceptButton() {
        acceptTermsModalPage.clickAcceptButton();
    }
}
