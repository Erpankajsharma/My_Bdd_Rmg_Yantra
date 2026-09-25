package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private By usernameLocator = By.id("usernmae");
    private By passwordLocator = By.id("inputPassword");
    private By signInLocator = By.xpath("//button[text()='Sign in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
        String actTitle = driver.getTitle();
        return actTitle;
    }

    public void enterUserName(String userName){
        WebElement usernameTxtBx = driver.findElement(usernameLocator);
        usernameTxtBx.sendKeys(userName);
    }

    public void enterPassword(String password){
        WebElement passwordTxtBx = driver.findElement(passwordLocator);
        passwordTxtBx.sendKeys(password);
    }

    public void clickOnSignIn(){
        WebElement signInBtn = driver.findElement(signInLocator);
        signInBtn.click();
    }

}
