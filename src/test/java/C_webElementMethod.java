import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;


public class C_webElementMethod {

    // VIDEO # 15 & 16
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

        // POPUP COOKIES
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonCustomize")).click();
        driver.findElement(By.id("CybotCookiebotDialogBodyButtonDecline")).click();

        driver.findElement(By.name("firstname")).sendKeys("testing");
        driver.findElement(By.name("firstname")).clear();

        // GET ATTRIBUTE
        System.out.println("attribute : " + driver.findElement(By.name("firstname")).getAttribute("class"));

        // GET CSS VALUE
        System.out.println("Css Value : " + driver.findElement(By.xpath("//input[@value='Request a Demo']")).getCssValue("text-transform"));

        // GET SIZE
        System.out.println("Size : " + driver.findElement(By.xpath("//input[@value='Request a Demo']")).getSize());

        // GET LOCATION
        System.out.println("Location : " + driver.findElement(By.xpath("//input[@value='Request a Demo']")).getLocation());

        // GET TEXT
        System.out.println("Text : " + driver.findElement(By.xpath("//input[@value='Request a Demo']")).getText());

        // GET TAG NAME
        System.out.println("Tag name : " + driver.findElement(By.xpath("//input[@value='Request a Demo']")).getTagName());

        // IS DISPLAYED --> RETURN BOOLEAN
        System.out.println("Is displayed ? : " + driver.findElement(By.xpath("//input[@value='Request a Demo']")).isDisplayed());

        // IS ENABLED --> RETURN BOOLEAN
        System.out.println("Is enabled ? : " + driver.findElement(By.xpath("//input[@value='Request a Demo']")).isEnabled());

        // IS DISPLAYED --> RETURN BOOLEAN
        System.out.println("Is selected ? : " + driver.findElement(By.xpath("//input[@value='Request a Demo']")).isSelected());

    }

}
