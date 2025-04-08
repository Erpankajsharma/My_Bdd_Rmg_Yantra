package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private By homePageHeadingLocator = By.xpath("//h2[text()='Welcome To Project Management System']");
    private By homeFeatureLocator = By.linkText("Home");
    private By projectsLocator = By.linkText("Projects");
    private By logoutBtnLocator = By.linkText("Logout");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean checkHomePageHeaderIsVisible(){
        return driver.findElement(homePageHeadingLocator).isDisplayed();
    }

    public void presenceOfEleLocated(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(homePageHeadingLocator));
    }

    public void clickHomeFeature(){
        driver.findElement(homeFeatureLocator).click();
    }

    public void clickProjectsFeature(){
        driver.findElement(projectsLocator).click();
    }

    public void clickLogout(){
        driver.findElement(logoutBtnLocator).click();
    }

}
