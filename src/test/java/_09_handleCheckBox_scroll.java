import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;


public class _09_handleCheckBox_scroll {

    // VIDEO # 21
    public static String browserType = "chrome";
    public static WebDriver driver;


    public static void main(String[] args) {

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
        driver.get("https://www.sugarcrm.com/au/request-demo/");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // POPUP COOKIES ACCEPT
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonCustomize")).click();
        driver.findElement(By.id("CybotCookiebotDialogBodyButtonDecline")).click();

        WebElement checkBox = driver.findElement(By.id("doi0"));

        // SCROLL --> scroll to btn
        WebElement btn = driver.findElement(By.className("submit-box-container"));
        Actions actions = new Actions(driver);
        actions.moveToElement(btn);
        actions.perform();

        checkBox.click();

        List <WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Total 'check box type' are : "+ list.size());

    }

}
