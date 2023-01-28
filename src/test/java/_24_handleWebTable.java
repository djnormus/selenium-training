import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;


public class _24_handleWebTable {

    // VIDEO # 36
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
        driver.get("https://tablepress.org/demo/");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();


        // POPUP COOKIES ACCEPT
        // driver.findElement(By.id("gdpr-banner-decline")).click();


        //Step 1- Switch to frame which has that particular table
        //Step 2- Get the number of rows
        //Step 3- Get the number of columns
        //Step 4- iterate rows and columns and get text and print it

        // = driver.findElement(By.id(""));
        //driver.switchTo().frame(frame1);


        //Step 2- Get the number of rows
        List<WebElement> rowElements = driver.findElements(By.xpath("//*[@id=\"tablepress-demo\"]/tbody/tr"));
        System.out.println("number of rows : " + rowElements.size());
        int rowSize = rowElements.size();

        //Step 3- Get the number of columns
        List<WebElement> columnsElements = driver.findElements(By.xpath("//*[@id=\"tablepress-demo\"]/tbody/tr[1]/td"));
        System.out.println("number of columns : " + columnsElements.size());
        int colSize = columnsElements.size();

        //Step 4- iterate rows and columns and get text and print it
        for (int i = 1; i <= rowSize; i++) {

            for (int j = 1; j <= colSize; j++) {

                System.out.print(
                        driver.findElement(By.xpath("//*[@id=\"tablepress-demo\"]/tbody/tr[" + i + "]/td[" + j + "]"))
                                .getText() + " | ");
            }
            System.out.println();
        }


        //driver.quit();
    }

}
