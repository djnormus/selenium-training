import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class _26_screenshot {

    // VIDEO # 38
    public static String browserType = "chrome";
    public static WebDriver driver;


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


        // GET URL
        driver.get("https://extendsclass.com/text-compare");

        // POPUP COOKIES ACCEPT
        driver.findElement(By.xpath("//button[@aria-label='Do not consent']")).click();

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();


        // TAKE SCREENSHOT
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // ******* TO SAVE SCREENSHOT *******
        // Add dependency from "mvn repository" : commons io

        // Tips :  create date to use in file name of the picture
        Date currentDate = new Date();
        String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");

        // SAVE METHOD & PATH
        FileUtils.copyFile(screenshotFile, new File(".//screeshot/" + screenshotFileName + ".png"));




        //driver.quit();
    }

}
