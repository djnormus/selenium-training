import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;


public class R_performKeyboardEvents {

    // VIDEO # 31
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
        driver.get("https://extendsclass.com/text-compare");

        // POPUP COOKIES ACCEPT
        driver.findElement(By.xpath("//button[@aria-label='Do not consent']")).click();

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // TEXT AREA ELEMENT
        WebElement sourceTextArea = driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[1]/pre/span"));
        WebElement destinationTextArea = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[1]/pre/span"));

        // OBJECT ACTIONS
        Actions action = new Actions(driver);

        // COPY / PAST ACTIONS
        action.keyDown(sourceTextArea, Keys.COMMAND).sendKeys("a").sendKeys("c").build().perform();
        action.keyDown(destinationTextArea, Keys.COMMAND).sendKeys("a").sendKeys("v").build().perform();



        //driver.quit();
    }

}
