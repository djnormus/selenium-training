import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class _12_handleAlertPopup {

    // VIDEO # 24
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
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

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
        // SWITCH TO IFRAME
        driver.switchTo().frame(frame1);

        // CLICK ON FRAME
        driver.findElement(By.xpath("/html/body/button")).click();

        // GET TEXT IN ALERT
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text is : "+alertText);

        // ACCEPT ALERT
        //driver.switchTo().alert().accept();

        // DISMISS ALERT
        //driver.switchTo().alert().dismiss();

        // PROMPT() ALERT -- with input
        driver.switchTo().alert().sendKeys("test");


        // ACCEPT ALERT
        driver.switchTo().alert().accept();


        // SWITCH BACK TO PARENT FRAME
        driver.switchTo().parentFrame();

        // PARENT PAGE TITLE
        System.out.println("Page title is : "+driver.getTitle());





       // driver.quit();
    }

}
