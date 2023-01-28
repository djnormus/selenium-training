import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class _22_explicitWait {

    // VIDEO # 34
    public static String browserType = "firefox";
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


        // POPUP COOKIES ACCEPT
        //driver.findElement(By.id("gdpr-banner-decline")).click();

        WebElement element = driver.findElement(
                By.xpath("//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[3]/a[1]"));

        // INSTANTIATE ACTION OBJECT
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        // EXPLICIT WAIT SELENIUM 4.xx
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[normalize-space()='Computer Graphics & Video Cards']"))).click();


         /* EXPLICIT WAIT SELENIUM 3.xx

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[normalize-space()='Computer Graphics & Video Cards']"))).click();
        */



        //driver.quit();
    }

}
