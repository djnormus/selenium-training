import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class Z_handleAuthenticationPopup {

    // VIDEO # 40
    public static String browserType = "chrome";
    public static WebDriver driver;

    // LOGIN VARIABLES
    public static String username = "admin";
    public static String password = "admin";

    public static void main(String[] args) throws IOException {

        switch (browserType) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            }
        }


        // GET URL --> admin:password inside link with variables
        driver.get("https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth");


        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();


        //driver.quit();
    }

}
