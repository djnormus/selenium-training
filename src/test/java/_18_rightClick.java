import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;


public class _18_rightClick {

    // VIDEO # 30
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
        driver.get("https://jqueryui.com/slider/#colorpicker");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // SWITCH TO IFRAME --> BY webelEment
        WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
        driver.switchTo().frame(frame);

        //
        WebElement rectangle = driver.findElement(By.id("swatch"));

        // INSTANTIATE ACTION OBJECT
        Actions action = new Actions(driver);

        // RIGHT CLICK
        action.contextClick(rectangle).perform();



        //driver.quit();
    }

}
