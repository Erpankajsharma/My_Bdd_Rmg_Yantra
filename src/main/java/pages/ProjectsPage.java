package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProjectsPage {

    private WebDriver driver;
//    private String proName;

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
    }

    public boolean checkListOfProjectHeaderIsVisible(){
        return driver.findElement(listOfProjects).isDisplayed();
    }

    public void clickCreateProjectBtn(){
        driver.findElement(createProjectBtn).click();
    }

    public void enterProjectName(String projectName){
        driver.findElement(projectNameTxtBx).sendKeys(projectName);
    }

    public void enterProjectManagerName(String projectManagerName){
        driver.findElement(projectManagerTxtBx).sendKeys(projectManagerName);
    }

    public void selectProjectStatusOption(String projectStatus){
//        String status = "Created";
        WebElement statusDD = driver.findElement(projectStatusDD);
        Select s1=new Select(statusDD);
        s1.selectByValue(projectStatus);
    }

    public void clickOnSubmit(){
        driver.findElement(addProjectBtn).click();
    }

    public List<WebElement> getListOfProject(){
        List<WebElement> projectNameList = driver.findElements(projectNames);
//        for (int i=0; i<projectNameList.size(); i++){
//            String projectName = projectNameList.get(i).getText();
//        }
        return projectNameList;
    }

    public String getToastMessage(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
        String toastMessageTxt = driver.findElement(toastMessage).getText();
        return toastMessageTxt;
    }

    public void clickDeleteBtnOfProject(String proName){
//        this.proName=proName;
        driver.findElement(By.xpath("//tr/td[text()='"+proName+"']/../descendant::a[@class='delete']")).click();
    }

    public boolean popupIsDisplayed(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupHeader));
        boolean flag = driver.findElement(popupHeader).isDisplayed();
        return flag;
    }

    public void clickDeleteOnPopup(){
        driver.findElement(deleteOnPopup).click();
    }

}
