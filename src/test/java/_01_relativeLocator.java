import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.locators.RelativeLocator;


public class _01_relativeLocator {

    public static String browserType = "chrome";
    public static WebDriver driver;


    public static void main(String[] args) {

        /*
        A RETENIR :
         ChromeDriver driver = new ChromeDriver(); // <-- Avec la classe ChromeDriver
         WebDriver driver = new ChromeDriver(); // <-- Avec l'interface WebDriver
        */


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


        driver.get("https://www.saucedemo.com/");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("1");

        // Usage de : RelativeLocator -> uniquement dans Selenium V.4 et supp
        By loginLocator = RelativeLocator.with(By.tagName("input")).above(password);
        WebElement login = driver.findElement(loginLocator);
        login.sendKeys("test");



        /*
        RelativeLocator
        Link : https://www.selenium.dev/documentation/webdriver/elements/locators/

        Mots clés disponible :
         - above
         - below
         - leftOf
         - rightOf
         - near
         Remarque : enchainement possible des Mots clés

       */




    }

}
