package utilities;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties prop;
    private DatabaseUtils databaseUtils;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.init_Prop();
    }

    @Before(order = 1)
    public void connectToDatabase() {
        String db_url = prop.getProperty("DB_URL");
        String db_username = prop.getProperty("DB_USERNAME");
        String db_password = prop.getProperty("DB_PASSWORD");

        databaseUtils = new DatabaseUtils();
        databaseUtils.connectToDB(db_url, db_username, db_password);
    }

    @Before(order = 2)
    public void setup(){
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_Driver(browserName);
    }

//    =======================================After Started=============================================

    @After(order = 2)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After(order = 1)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 0)
    public void disconnectDB(){
        databaseUtils.disconnetToDB();
    }
}
