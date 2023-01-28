import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class _06_handleDropDown_Select_part_2 {

    // VIDEO # 18
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
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        // MAXIMIZE WINDOWS
        driver.manage().window().maximize();


        // WEBELEMENT : SELECT
        WebElement dropDown = driver.findElement(By.id("multi-select"));

        // NEW OBJECT : SELECT
        Select select = new Select(dropDown);

        select.selectByValue("California");

        select.selectByIndex(5);

        // GET SIZE SELECTED ITEMS
        List<WebElement> selectedItems = select.getAllSelectedOptions();
        System.out.println("Size List : " + selectedItems.size());
        System.out.println("------------------------------------------");
        select.deselectAll();

        // POSSIBLE TO LOOP
        List <WebElement> dropDownElements = select.getOptions();


        // LOOP
        for (WebElement dropDownElement : dropDownElements) {
            System.out.println("------------------------------------------");
            System.out.println("-attribute is : " + dropDownElement.getAttribute("value"));
            System.out.println(" --Visible text is : " + dropDownElement.getText());
            System.out.println("------------------------------------------");
        }

             /*  LOOP OTHER

             for (int i = 0; i < dropDownElements.size(); i++) {
                    System.out.println("------------------------------------------");
                    System.out.println("-attribute is : "+ dropDownElements.get(i).getAttribute("value"));
                    System.out.println(" --get text is : "+ dropDownElements.get(i).getText());
                    System.out.println("------------------------------------------");
                }
            */

    }

}
