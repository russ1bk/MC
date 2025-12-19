package Login_Tests;

import Base.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Locked_Account extends Login_Pages {

    @BeforeTest
    public void Start() throws IOException {
        SetUpProperties();
    }

    @Test(priority = 0)
    public void UnregisteredUser() throws InterruptedException {

        logger = report.createTest("Locked Account Test");

        logger.info("Navigate to site");
        StartBrowser();
        NavigateToSite();

        logger.info("Enter to be locked account email address");
        LockedAccount();

        //1st invalid attempt to log in
        logger.info("Enter invalid password - first attempt");
        EnteringText("//*[@name='MagicWord']","Tester1");
        Click("//*[@type='submit']");
        Thread.sleep(2000);

        logger.pass("Capture error message - first attempt. User should have 4 attempts left");
        String ErrorMessage = getText("//*[@id='app-name']//following::div[1]/div");
        Assert.assertEquals(ErrorMessage, "Incorrect Password");

        String FullMessage = getText("//*[@id='app-name']//following::p");
        boolean error1 = FullMessage.contains("4 sign-in");
        if (error1==true) {
            System.out.println(FullMessage);
        }else{
            System.out.println("Error message is not updating");
        }
        logger.pass("incorrect password error message: " + FullMessage);

        //2nd invalid attempt to log in
        logger.info("Enter invalid password - second attempt");
        EnteringText("//*[@name='MagicWord']","Tester2");
        Click("//*[@type='submit']");
        Thread.sleep(2000);

        logger.pass("Capture error message - second attempt. User should have 3 attempts left");
        String ErrorMessage2 = getText("//*[@id='app-name']//following::div[1]/div");
        Assert.assertEquals(ErrorMessage2, "Incorrect Password");

        String FullMessage2 = getText("//*[@id='app-name']//following::p");
        boolean error2 = FullMessage2.contains("3 sign-in");
        if (error2==true) {
            System.out.println(FullMessage2);
        }else{
            System.out.println("Error message is not updating");
        }
        logger.pass("incorrect password error message: " + FullMessage2);


        //3rd invalid attempt to log in
        logger.info("Enter invalid password - third attempt");
        EnteringText("//*[@name='MagicWord']","Tester3");
        Click("//*[@type='submit']");
        Thread.sleep(2000);

        logger.pass("Capture error message - third attempt. User should have 2 attempts left");
        String ErrorMessage3 = getText("//*[@id='app-name']//following::div[1]/div");
        Assert.assertEquals(ErrorMessage3, "Incorrect Password");

        String FullMessage3 = getText("//*[@id='app-name']//following::p");
        boolean error3 = FullMessage3.contains("2 sign-in");
        if (error3==true) {
            System.out.println(FullMessage3);
        }else{
            System.out.println("Error message is not updating");
        }
        logger.pass("incorrect password error message: " + FullMessage3);


        //4th invalid attempt to log in
        logger.info("Enter invalid password - fourth attempt");
        EnteringText("//*[@name='MagicWord']","Tester4");
        Click("//*[@type='submit']");
        Thread.sleep(2000);

        logger.pass("Capture error message - fourth attempt. User should have 1 attempts left");
        String ErrorMessage4 = getText("//*[@id='app-name']//following::div[1]/div");
        Assert.assertEquals(ErrorMessage4, "Incorrect Password");

        String FullMessage4 = getText("//*[@id='app-name']//following::p");
        boolean error4 = FullMessage4.contains("1 sign-in");
        if (error4==true) {
            System.out.println(FullMessage4);
        }else{
            System.out.println("Error message is not updating");
        }
        logger.pass("incorrect password error message: " + FullMessage4);

        //5th invalid attempt to log in
        logger.info("Enter invalid password - fifth attempt");
        EnteringText("//*[@name='MagicWord']","Tester5");
        Click("//*[@type='submit']");
        Thread.sleep(2000);

        logger.pass("Capture error message - fifth attempt. User account is locked");
        String ErrorMessage5 = getText("//*[@id='app-name']//following::div[1]/div");
        Assert.assertEquals(ErrorMessage5, "Your account has been locked");

        String FullMessage5 = getText("//*[@id='app-name']//following::p");
        boolean error5 = FullMessage5.equalsIgnoreCase("Please contact your account administrator for assistance.");
        if (error5==true) {
            System.out.println(FullMessage5);
        }else{
            System.out.println("Error message is not updating");
        }
        logger.pass("incorrect password error message: " + FullMessage5);


        //log into Admin account
        logger.info("Log into Admin account");
        AdminLogin();

        logger.info("Click on User dropdown");
        Click("//*[@id='signed-in-user']");
        Thread.sleep(2000);

        logger.pass("Verify contact management access");
        String CManagement = getText("//*[@id='contactManagement']");
        Assert.assertEquals(CManagement,"Manage Contacts");

        logger.info("Click contact management");
        Click("//*[@id='contactManagement']");

        logger.pass("Verify Locked account user email");
        Click("//div[contains(text(),'espds104')]");
        String lockedUser = getText("//div[contains(text(),'espds104')]");
        boolean user = lockedUser.contains("espds104@globetax.com");
        Assert.assertTrue(user);

        logger.pass("Verify account status is Locked");
        String lockedStatus = getText("//div[contains(text(),'espds104')]//following::td[7]/div");
        Assert.assertEquals(lockedStatus,"LOCKED");

        logger.info("Click on Locked status to unlock account");
        Click("//div[contains(text(),'espds104')]//following::td[7]/div");

        logger.info("Log out of Admin account");
        Click("//*[@id='signed-in-user']");
        Thread.sleep(2000);

        Click("//*[@id='signOut']");
        Thread.sleep(2000);

        logger.info("Log into locked account");
        LockedAccount();

        ReusableMethods.EnteringText("//*[@name='MagicWord']","Test123-");

        ReusableMethods.addCookie("624172","u0RZMOZPDUOK6rmDTs2vy3JU-CZojECtlFZFQIJ-Ez1edMFn53Ea8n25AZihhfJ7rj3eUAtnwDr5bCde8mXqqE0pIcc.");
        Thread.sleep(2000);
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(5000);


        logger.pass("Verify user is on the home page");
        String Hptitle = getTitle();
        Assert.assertEquals(Hptitle,"MIDAS - Reclaim Dashboard > Summary");


    }

}
