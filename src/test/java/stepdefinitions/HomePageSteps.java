package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import hooks.Hooks;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage(Hooks.driver);
    }

    @When("the user selects {string} as the language")
    public void the_user_selects_as_the_language(String language) {
        homePage.selectLanguage(language);
    }

    @And("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        //hoooks, modifiy options or the urk changes :)
    }

    @And("the user clicks \"Start Playing\"")
    public void the_user_clicks_start_playing() {
        homePage.clickStartPlaying();
    }
}
