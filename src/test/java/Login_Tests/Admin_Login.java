package Login_Tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import sun.awt.windows.ThemeReader;

import java.io.IOException;

public class Admin_Login extends Login_Pages {

    @BeforeTest
    public void Start() throws IOException {
       SetUpProperties();
    }

    @Test
    public void LoginTest() throws InterruptedException {

        logger = report.createTest("Admin Successful login");
        logger.info("Navigate to site and log in");
        StartBrowser();
        NavigateToSite();
        AdminLogin();

        Thread.sleep(2000);
        logger.info("Verify user is on the home page");
        String Hptitle = getTitle();
        Assert.assertEquals(Hptitle,"MIDAS - Reclaim Dashboard > Summary");

        logger.info("Click on User dropdown");
        Click("//*[@id='signed-in-user']");
        Thread.sleep(2000);

        logger.info("Verify contact management access");
        String CManagement = getText("//*[@id='contactManagement']");
        Assert.assertEquals(CManagement,"Manage Contacts");



    }//end of test

}//end of class
