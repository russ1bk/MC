package BroswerTest;

import Base.ReusableMethods;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Class extends ReusableMethods {
@Test(priority = 1)
    public void Test() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rmishiyev\\Desktop\\MC Automation Workspace\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().setPosition(new Point(2000,0));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    String handle = driver.getWindowHandle();
    driver.close();

    }

    @Test(priority = 2)
    void Test2(){
    System.out.println("Passed this");

    }




}
