import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;


public class N_performDragAndDrop {

    // VIDEO # 27
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
        driver.get("https://jqueryui.com/droppable/");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // 3- SWITCH TO IFRAME --> BY webelEment
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame'] "));
        driver.switchTo().frame(frame1);

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        // INSTANTIATE ACTION OBJECT
        Actions action = new Actions(driver);

        // DRAG & DROP
        action.dragAndDrop(drag, drop).perform();

        //driver.quit();
    }

}
