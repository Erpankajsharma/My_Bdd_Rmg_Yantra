package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumSupport {

    private WebDriver driver;
    private WebDriverWait wait;
    private Alert alert;
    private Select select;
//    private Select select;

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public SeleniumSupport(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void acceptAlert(){
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert(){
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void explicitWait(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void selectOptionByValue(WebElement dropDownLocator, String value){
        select=new Select(dropDownLocator);
        select.selectByValue(value);
    }

    public void sendText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public boolean isElementDisplayed(WebElement element){
        boolean flag = element.isDisplayed();
        return flag;
    }

    public String getElementText(WebElement element){
        return element.getText();
    }

}
