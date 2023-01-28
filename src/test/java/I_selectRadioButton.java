import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class I_selectRadioButton {

    // VIDEO # 22
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
        driver.get("https://www.singaporeair.com/fr_FR/fr/home#/book/bookflight");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();

        // POPUP COOKIES ACCEPT
        driver.findElement(By.className("acceptEssential")).click();

        WebElement radio1 = driver.findElement(By.id("bookFlights"));
        WebElement radio2 = driver.findElement(By.id("redeemFlights"));

        radio2.click();
        System.out.println("Radio 01 is selected ? : "+ radio1.isSelected());
        System.out.println("Radio 02 is selected ? : "+ radio2.isSelected());

        // HOW MANY RADIO
        System.out.println("Nbr of radio btn : " + driver.findElements(By.xpath("//*[@name='book-flight-radio']")).size());










    }

}
