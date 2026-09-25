package utilities;

import com.mysql.cj.jdbc.Driver;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    private Driver driver;
    private Connection connection;


    public void connectToDB(String db_url, String db_username, String db_password) {
        try {
            driver=new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(db_url, db_username, db_password);
            Reporter.log("===Database has been connected.===", true);
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }

    public void disconnetToDB(){
        try {
            connection.close();
            Reporter.log("===Database has been disconnected.===", true);
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }

}
