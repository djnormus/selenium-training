import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;


public class B_basicMethods_2 {

    // VIDEO # 15
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
        driver.get("https://www.saucedemo.com/");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // GET ELEMENTS (PLURIEL)
        List<WebElement> webElementsList = driver.findElements(By.xpath("//div[@class='inventory_list']")); // //div[@class='inventory_list']
        System.out.println("List : " + webElementsList);

        // GET WINDOW HANDLE
        // VOIR AUTRE TUTO POUR LE WINDOW HANDLE
        driver.navigate().to("");
        String windowhandle = driver.getWindowHandle();
        System.out.println(windowhandle);






    }

}
