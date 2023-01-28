import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class _08_handleAutoSuggestionDropdown {

    // VIDEO # 20
    public static String browserType = "chrome";
    public static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {

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
        driver.get("https://www.booking.com/index.fr.html");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // POPUP COOKIES
        driver.findElement(By.id("onetrust-reject-all-handler")).click();

        WebElement myDestination = driver.findElement(By.id("ss"));
        myDestination.sendKeys("paris");
        Thread.sleep(2000);
        myDestination.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        myDestination.sendKeys(Keys.ENTER);
        Thread.sleep(2000);









    }

}
