import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class _27_handleSSLError {

    // VIDEO # 39
    public static String browserType = "firefox";
    public static WebDriver driver;

    public static void main(String[] args) {

        DesiredCapabilities handleSSError = new DesiredCapabilities();

        switch (browserType) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                handleSSError.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                handleSSError.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

                ChromeOptions chOptions = new ChromeOptions();
                chOptions.merge(handleSSError);
                driver = new ChromeDriver(chOptions);
                break;
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                handleSSError.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                handleSSError.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.merge(handleSSError);
                driver = new FirefoxDriver(ffOptions);
                break;
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                handleSSError.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                handleSSError.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

                SafariOptions safOptions = new SafariOptions();
                safOptions.merge(handleSSError);
                driver = new SafariDriver(safOptions);
                break;
            }
        }


        // GET URL
        driver.get("https://expired.badssl.com/");


        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();





        //driver.quit();
    }

}
