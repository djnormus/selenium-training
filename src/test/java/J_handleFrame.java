import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class J_handleFrame {

    // VIDEO # 23
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
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // POPUP COOKIES ACCEPT
        driver.findElement(By.id("accept-choices")).click();

        // 1- SWITCH TO IFRAME --> BY INDEX
        //driver.switchTo().frame(0);

        // 2- SWITCH TO IFRAME --> BY ID
        //driver.switchTo().frame("iframeResult");

        // 3- SWITCH TO IFRAME --> BY webelEment
        WebElement frame1 = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame1);


        // CLICK ON FRAME
        driver.findElement(By.xpath("/html/body/button")).click();

        // SWITCH BACK TO PARENT FRAME
        driver.switchTo().parentFrame();






       // driver.quit();
    }

}
