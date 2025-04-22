package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;
import utilities.SeleniumSupport;

import java.util.List;

public class ProjectsPage {

//    private String proName;
    private WebDriver driver;
    private SeleniumSupport seleniumSupport;

    private By listOfProjects = By.xpath("//h2[text()='List of']/b[text()=' Projects']");
    private By createProjectBtn = By.xpath("//button[@class=\"btn btn-success\"]");
//    private By deleteButtonOfProject = By.xpath("//tr/td[text()='"+proName+"']/../descendant::a[@class='delete']");
    private By popupHeader = By.xpath("//div[@id=\"deleteProjectModal\"]/descendant::h4[text()='Delete Project']");
    private By deleteOnPopup = By.xpath("//div[@id=\"deleteProjectModal\"]/descendant::input[@value=\"Delete\"]");

    private By projectNameTxtBx = By.name("projectName");
    private By projectManagerTxtBx = By.name("createdBy");
    private By projectStatusDD = By.xpath("//label[text()='Project Status ']/../select[@name='status']");
    private By addProjectBtn = By.xpath("//input[@value='Add Project']");

    private By projectNames = By.xpath("//tr/td[2]");
    private By toastMessage = By.xpath("//div[@class='Toastify']/descendant::div[@class='Toastify__toast-body']");

    public ProjectsPage(WebDriver driver){
        this.driver = driver;
        seleniumSupport = new SeleniumSupport(DriverFactory.getDriver());
    }

    public boolean checkListOfProjectHeaderIsVisible(){
        WebElement element = driver.findElement(listOfProjects);
        boolean flag = seleniumSupport.isElementDisplayed(element);
        return flag;
    }

    public void clickCreateProjectBtn(){
        WebElement element = driver.findElement(createProjectBtn);
        seleniumSupport.clickOnElement(element);
    }

    public void enterProjectName(String projectName){
        WebElement element = driver.findElement(projectNameTxtBx);
        seleniumSupport.sendText(element, projectName);
    }

    public void enterProjectManagerName(String projectManagerName){
//        driver.findElement(projectManagerTxtBx).sendKeys(projectManagerName);
        WebElement element = driver.findElement(projectManagerTxtBx);
        seleniumSupport.sendText(element, projectManagerName);
    }

    public void selectProjectStatusOption(String projectStatus){
        WebElement statusDD = driver.findElement(projectStatusDD);
        seleniumSupport.selectOptionByValue(statusDD, projectStatus);
    }

    public void clickOnSubmit(){
        WebElement element = driver.findElement(addProjectBtn);
        seleniumSupport.clickOnElement(element);
    }

    public List<WebElement> getListOfProject(){
        List<WebElement> projectNameList = driver.findElements(projectNames);
//        for (int i=0; i<projectNameList.size(); i++){
//            String projectName = projectNameList.get(i).getText();
//        }
        return projectNameList;
    }

    public String getToastMessage(){
        seleniumSupport.explicitWait(toastMessage);
        WebElement element = driver.findElement(toastMessage);
        String toastMessageTxt = seleniumSupport.getElementText(element);
        return toastMessageTxt;
    }

    public void clickDeleteBtnOfProject(String proName){
//        this.proName=proName;
        WebElement element = driver.findElement(By.xpath("//tr/td[text()='"+proName+"']/../descendant::a[@class='delete']"));
        seleniumSupport.clickOnElement(element);
    }

    public boolean popupIsDisplayed(){
        seleniumSupport.explicitWait(popupHeader);
        WebElement element = driver.findElement(popupHeader);
        boolean flag = seleniumSupport.isElementDisplayed(element);
        return flag;
    }

    public void clickDeleteOnPopup(){
        WebElement element = driver.findElement(deleteOnPopup);
        seleniumSupport.clickOnElement(element);
    }

}
