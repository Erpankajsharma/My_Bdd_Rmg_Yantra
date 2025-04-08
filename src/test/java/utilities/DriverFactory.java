package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_Driver(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            tlDriver.set(new ChromeDriver(options));
        }
        else if (browser.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            tlDriver.set(new FirefoxDriver(options));
        }
        else if (browser.equalsIgnoreCase("edge")){
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            tlDriver.set(new EdgeDriver(options));
        }
        else {
            System.out.println("Please pass the correct browser value : "+browser);
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }


}
