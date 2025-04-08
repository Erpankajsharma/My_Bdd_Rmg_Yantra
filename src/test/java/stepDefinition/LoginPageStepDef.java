package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utilities.DriverFactory;
import utilities.Hooks;

public class LoginPageStepDef {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("I am on the rmg yantra login page")
    public void i_am_on_the_rmg_yantra_login_page() {
        DriverFactory.getDriver().get("http://localhost:8084");
        String actTitle = loginPage.getTitle();
        Assert.assertEquals(actTitle, "React App");
    }
    @When("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password() {
        loginPage.enterUserName("rmgyantra");
        loginPage.enterPassword("rmgy@9999");
    }
    @And("I click on login button")
    public void i_click_on_login_button() throws InterruptedException {
        loginPage.clickOnSignIn();
    }
}
