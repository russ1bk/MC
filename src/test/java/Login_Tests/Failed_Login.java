package Login_Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
public class Failed_Login extends Login_Pages {

    @BeforeTest
    public void Start() throws IOException {
        SetUpProperties();
    }

    @Test(priority = 0)
    public void UnregisteredUser() throws InterruptedException {

        logger = report.createTest("Unregisterd User");

        logger.info("Navigate to site");
        StartBrowser();
         NavigateToSite();

        logger.info("Attempt to login using unregistered email");
        UnregisteredAccount();
        logger.info("User receives error message - Unregistered Email");
    }

    @Test(priority = 1)
    public void FailedLoginTest() throws InterruptedException {

        logger = report.createTest("Failed login");
        logger.info("Navigate to site");
        StartBrowser();
        NavigateToSite();

        logger.info("Attempt to login using incorrect credentials");
        FailedLogin();


        String ErrorMessage = getText("//*[@id='app-name']//following::div[1]/div");
        Assert.assertEquals(ErrorMessage, "Incorrect Password");

        String FullMessage = getText("//*[@id='app-name']//following::p");
        logger.info("incorrect password error message: " + FullMessage);

        addCookie("621638","zBAda6TuUTgtBcv4HmauVNJgQln0PRGfNobsEAlsIWqc3HQV38LCZo2Gr2eEzH5YpGjE7G0HjWT6bvu458dKNCUnQbY.");

        logger.info("attempt to log in using correct password");
        EnteringText("//*[@name='MagicWord']","Test123?");
        Click("//*[@type='submit']");
        Thread.sleep(2000);

        logger.info("Verify user is on the home page");
        String Hptitle = getTitle();
        Assert.assertEquals(Hptitle,"MIDAS - Reclaim Dashboard > Summary");

    }
}
