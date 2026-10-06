package stepDefinition;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utilities.DriverFactory;

public class HomePageStepDef {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());
//    private SeleniumSupport support=new SeleniumSupport(DriverFactory.getDriver());

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {

//        support.acceptAlert();
//        support.explicitWait(homePage.getHomePageHeadingLocator());
        boolean flag = homePage.checkHomePageHeaderIsVisible();
        Assert.assertEquals(flag, true);
    }

    @Then("I am on rmg yantra home page")
    public void i_am_on_rmg_yantra_home_page() {

//        support.acceptAlert();
//        support.explicitWait(homePage.getHomePageHeadingLocator());
        boolean flag = homePage.checkHomePageHeaderIsVisible();
        Assert.assertEquals(flag, true);
    }

    @When("I click on projects feature")
    public void i_click_on_projects_feature() {
        homePage.clickProjectsFeature();
    }





}
