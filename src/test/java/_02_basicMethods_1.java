import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class _02_basicMethods_1 {

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

        // GET URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("page URL is : " + currentUrl);

        // GET TITLE
        String title = driver.getTitle();
        System.out.println("Title is : " + title);

        // GET PAGE SOURCE
        String pageSource = driver.getPageSource();
        System.out.println("page source is : " + pageSource);

        // NAVIGATE
        // navigate to de la 1ere page dans get(url) vers navigate().to("")
        driver.navigate().to("https://www.google.fr/");

        // QUIT
        // Quits this driver, closing every associated window
        // driver.quit();

        // CLOSE
        // Close the current windows, quitting the browser if it's the last window currently open
        // driver.close();




    }

}
