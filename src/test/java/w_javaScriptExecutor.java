import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class w_javaScriptExecutor {

    // VIDEO # 37
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
        driver.get("https://w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();


        // POPUP COOKIES ACCEPT
        driver.findElement(By.id("accept-choices")).click();

        // JAVASCRIPT EXECUTOR
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;

        //Print the title of the page
        String script = "return document.title;";
        String title = (String) jsExec.executeScript(script);
        System.out.println(title);

        //Click button & accept alert
        driver.switchTo().frame("iframeResult");
        jsExec.executeScript("myFunction()");
        driver.switchTo().alert().accept();

        //Highlight element
        WebElement btn = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        jsExec.executeScript("arguments[0].style.border='5px solid green'", btn);

        //Scroll
        driver.navigate().to("https://w3schools.com/");
        WebElement gotoBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/div[10]/div/a"));
        jsExec.executeScript("arguments[0].scrollIntoView(true);", gotoBtn);
        jsExec.executeScript("arguments[0].style.border='5px solid red'", gotoBtn); // Highlight the btn











        //driver.quit();
    }

}
