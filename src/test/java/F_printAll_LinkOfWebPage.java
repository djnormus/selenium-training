import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class F_printAll_LinkOfWebPage {

    // VIDEO # 19
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
        driver.get("https://www.sugarcrm.com/au/request-demo/");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // POPUP COOKIES ACCEPT
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonCustomize")).click();
        driver.findElement(By.id("CybotCookiebotDialogBodyButtonDecline")).click();

        // HOW MANY TAG "a"
        List <WebElement> allTags = driver.findElements(By.tagName("a"));
        System.out.println("Total tags are : "+ allTags.size());

        // PRINT ALL LINKS
        for (int i=0; i< allTags.size(); i++) {
            System.out.println("-Link attribute is : "+ allTags.get(i).getAttribute("href"));
            System.out.println(" --Visible text is : "+ allTags.get(i).getText());
        }

        /*  ENHANCED LOOP
            for (WebElement allTag : allTags) {
            System.out.println("-Link attribute is : " + allTag.getAttribute("href"));
            System.out.println(" --Link text is : " + allTag.getText());
             }
        */


    }

}
