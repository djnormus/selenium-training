import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;


public class _05_handleDropDown_Select_part_1 {

    // VIDEO # 17
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

        // WEBELEMENT : SELECT
        WebElement dropDown = driver.findElement(By.name("employees_c"));

        // NEW OBJECT : SELECT
        Select select  = new Select(dropDown);

        // WHAT FIRST OPTION SELECTED ?
        WebElement firstOption = select.getFirstSelectedOption();
        System.out.println("The first selected option is : " + firstOption.getText());

        // SELECT BY VALUE
        select.selectByValue("level1");
        Thread.sleep(2000); // WAIT IN MS

        // SELECT BY VISIBLE TEXT
        select.selectByVisibleText("101 - 250 employees");
        Thread.sleep(2000);

        // SELECT BY INDEX
        select.selectByIndex(5);
        Thread.sleep(2000);









    }

}
