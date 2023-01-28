import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Iterator;
import java.util.Set;


public class _13_handleMultipleWindows {

    // VIDEO # 25
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
        driver.get("https://www.salesforce.com/au/");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // POPUP COOKIES ACCEPT
        driver.findElement(By.id("onetrust-reject-all-handler")).click();

        // CLIC ON BTN --> this btn open new tab
        driver.findElement(By.xpath("//div[contains(@class,'margin-0-top-lg margin-0-bottom-lg margin-20-left-sm text-left')]//a[contains(@aria-label,'Start my free trial with Salesforce CRM')]")).click();



        /*
        Difference LIST & SET
        List -> can have duplicated elements
        Set -> can't have duplicated elements
         */

        // GET SET OF OPEN WINDOWS
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        // ITERATOR (Class) -> iterate over open windows or tabs
        Iterator<String> iterator = windowHandles.iterator();
        String firstWindow = iterator.next();
        String secondWindow = iterator.next();

        // SWITCH TO SECOND WINDOW OR TAB
        driver.switchTo().window(secondWindow);

        driver.findElement(By.name("UserFirstName")).sendKeys("nordine");
        driver.findElement(By.name("UserLastName")).sendKeys("nordine");

        // RETURN TO FIRST WINDOW
        driver.switchTo().window(firstWindow);


        driver.quit();
    }

}
