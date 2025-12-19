package User_Tests;

import Base.ReusableMethods;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class User_Account_pages extends ReusableMethods {


    //Espds120@globetax.com -- External User Chrome - QA Environment
    public static void UserLogin() throws InterruptedException, IOException {
        ReusableMethods.SetUpProperties();
        ReusableMethods.EnteringText("//*[@name='EmailAddress']",prop.getProperty("UserLoginEmail"));
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser,"Welcome back, Ruslan Mishiyev !");

        ReusableMethods.EnteringText("//*[@name='MagicWord']",prop.getProperty("UserLoginPassword"));

       // ReusableMethods.addCookie(cookieName, cookieValue);
        ReusableMethods.addCookie("621638",prop.getProperty("UserLoginCookieValue"));
        Thread.sleep(2000);
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

    }//end of method

    // //Espds120@globetax.com -- External User Chrome - PROD Environment
    public static void UserLogin3() throws InterruptedException {

        ReusableMethods.EnteringText("//*[@name='EmailAddress']", prop.getProperty("UserLogin3Email"));
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser, "Welcome back, Test QA!");

        ReusableMethods.EnteringText("//*[@name='MagicWord']", prop.getProperty("UserLogin3Password"));

        ReusableMethods.addCookie("970683", prop.getProperty("UserLogin3CookieValue"));
        Thread.sleep(2000);
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

    }
    // QA Environemnt ONLY! Edge Browser login and cookies handling
    public static void UserLogin2() throws InterruptedException{

        ReusableMethods.EnteringText("//*[@name='EmailAddress']", prop.getProperty("UserLogin2Email"));
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser,"Welcome back, Ruslan Mishiyev!");

        ReusableMethods.EnteringText("//*[@name='MagicWord']", prop.getProperty("UserLogin2Password"));

        ReusableMethods.addCookie("621638", prop.getProperty("UserLogin2CookieValue"));
        Thread.sleep(2000);
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);


    }


}//end of class
