package stepDefinition;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utilities.DriverFactory;

public class HomePageStepDef {

    private HomePage homePage;

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.presenceOfEleLocated();
        boolean flag = homePage.checkHomePageHeaderIsVisible();
        Assert.assertEquals(flag, true);
    }

    @When("I click on projects feature")
    public void i_click_on_projects_feature() {
        homePage.clickProjectsFeature();
    }





}
