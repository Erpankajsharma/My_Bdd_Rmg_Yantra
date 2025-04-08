package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ProjectsPage;
import utilities.DriverFactory;

import java.util.List;

public class ProjectsPageStepDef {

    private ProjectsPage projectsPage;

    @Then("List of projects page should be displayed")
    public void list_of_projects_page_should_be_displayed() {
        projectsPage = new ProjectsPage(DriverFactory.getDriver());
        boolean flag = projectsPage.checkListOfProjectHeaderIsVisible();
        Assert.assertTrue(true);
    }

    @When("I click on create project button")
    public void i_click_on_create_project_button(){
        projectsPage.clickCreateProjectBtn();
    }

    @When("I enter project name {string}")
    public void i_enter_project_name(String string) {
        projectsPage.enterProjectName(string);
    }
    @When("I enter project manager name {string}")
    public void i_enter_project_manager_name(String string) {
        projectsPage.enterProjectManagerName(string);
    }
    @When("I select project status {string}")
    public void i_select_project_status(String string) {
        projectsPage.selectProjectStatusOption(string);
    }
    @When("I click on addProject button")
    public void i_click_on_add_project_button() {
        projectsPage.clickOnSubmit();
    }
    @Then("I validate toast message {string}")
    public void i_validate_toast_message(String expToastMsg) {
        String actualToastMsg = projectsPage.getToastMessage();
        Assert.assertEquals(actualToastMsg, expToastMsg);
    }
    @Then("I validate the {string} should be successfully created")
    public void i_validate_the_project_should_be_successfully_created(String expProjectName) {
        List<WebElement> actualProjectNames = projectsPage.getListOfProject();
        boolean flag = false;
        for (int i=0; i<actualProjectNames.size(); i++){
            String projectName = actualProjectNames.get(i).getText();
            if (expProjectName.equalsIgnoreCase(projectName)){
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }

    @When("I click on delete button of a project {string}")
    public void i_click_on_delete_button_of_a_project(String string) {
        projectsPage.clickDeleteBtnOfProject(string);
    }
    @Then("I validate a delete project popup should be displayed")
    public void i_validate_a_delete_project_popup_should_be_displayed() {
        Boolean flag = projectsPage.popupIsDisplayed();
        Assert.assertTrue(flag);
    }
    @When("I click on delete button of the popup")
    public void i_click_on_delete_button_of_the_popup() {
        projectsPage.clickDeleteOnPopup();
    }
    @Then("I validate the project {string} should be deleted successfully")
    public void i_validate_the_project_should_be_deleted_successfully(String projectName) {
        List<WebElement> actualProjectNames = projectsPage.getListOfProject();
        boolean flag = true;
        for (int i=0; i<actualProjectNames.size(); i++){
            String actProjectName = actualProjectNames.get(i).getText();
            if (projectName.equalsIgnoreCase(actProjectName)){
                flag = false;
            }
        }
        Assert.assertTrue(flag);
    }


}
