package Base;

import Base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReusableMethods extends BaseClass {

    public static WebDriver driver;
    public static WebDriver EdgeDriver;
    public static Properties prop;

// Chrome Browser.
    public static void StartBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
// Edge Browser. Methods that ends with 2 related to Edge browser.
    public static void StartedgeBrowser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
       /* driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/
    }

  /*  public static void Click(String Locator) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locator)));
       element.click();
   }*/
      public static void Click(String Locator){
          driver.findElement(By.xpath(Locator)).click();
      }

    public static void EnteringText(String Locator, String Text) {
        driver.findElement(By.xpath(Locator)).sendKeys(Text);
    }

    public static String getText(String Locator) {
        String message = driver.findElement(By.xpath(Locator)).getText();
        System.out.println(message);
        return message;
    }

    public static boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static String getTitle() {
        String message = driver.getTitle();
        System.out.println(message);
        return message;
    }

    public static void MouseHover(String Locator) {
        WebElement element = driver.findElement(By.xpath(Locator));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static void EnterButton() {
        Actions builder = new Actions(driver);
        Action Keyboard = builder.sendKeys(Keys.ENTER).build();
        Keyboard.perform();
    }


    public static void Dropdown(String Locator, String value) {
        Select dropdown = new Select(driver.findElement(By.xpath(Locator)));
        dropdown.selectByVisibleText(value);
    }

    public static void Scroll(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0," + pixels + ")", "");
    }


    //Reusable methods for site set up
    public static void SetUpProperties() throws IOException {
        prop = new Properties();
        FileInputStream finput = new FileInputStream("src\\main\\java\\TestData.properties");
        prop.load(finput);
    }

    public static void addCookie(String CookieName, String CookieValue) {
        Cookie TemporaryPassword = new Cookie.Builder(CookieName, CookieValue).domain("").build();
        driver.manage().addCookie(TemporaryPassword);
    }

    public static void NavigateToSite() throws InterruptedException {
        driver.get("https://connectqa.gtsdmz.globetax.com");
        Thread.sleep(3500);
    }
    public static void NavigateToSiteProd() throws InterruptedException {
        driver.get("https://connect.globetax.com");
        Thread.sleep(3500);
    }

    public static String CurrentDateTime(){
        DateFormat customformat=new SimpleDateFormat("MM dd yyyy -HH_mm_ss");
        Date currentdate =new Date();
        return customformat.format(currentdate);
    }

    public static void Closebrowser() {
        driver.close();
    }

}
