import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class _19_performKeyboardEvents {

    // VIDEO # 31
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
        driver.get("https://www.google.fr/");


        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // COOKIES
        driver.findElement(By.id("W0wltc")).click();

        // SEARCH INPUT
        WebElement searchInput = driver.findElement(By.xpath("//input[@title='Rechercher']"));

        // KEY ENTER
        searchInput.sendKeys("Paris" + Keys.ENTER);


        //driver.quit();
    }

}
