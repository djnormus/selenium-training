import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class S_implicitWait {

    // VIDEO # 33
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
        driver.get("https://www.ebay.com.au/");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // IMPLICIT WAIT
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // UNDER SELENIUM V4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // FROM SELENIUM V4

        // POPUP COOKIES ACCEPT
        //driver.findElement(By.id("gdpr-banner-decline")).click();

        WebElement element = driver.findElement(By.xpath("//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[3]/a[1]"));

        // INSTANTIATE ACTION OBJECT
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        driver.findElement(By.xpath("//a[normalize-space()='Computer Graphics & Video Cards']")).click();



        //driver.quit();
    }

}
