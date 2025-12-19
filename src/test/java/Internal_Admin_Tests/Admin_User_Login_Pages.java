package Internal_Admin_Tests;

import Base.ReusableMethods;
import org.testng.Assert;

public class Admin_User_Login_Pages extends ReusableMethods {


    //Admin Account
    public static void AdminLogin() throws InterruptedException {
        ReusableMethods.EnteringText("//*[@name='EmailAddress']", prop.getProperty("AdminLoginEmail"));
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser,"Welcome back, Ruslan Mishiyev!");

        ReusableMethods.EnteringText("//*[@name='MagicWord']",prop.getProperty("AdminLoginPassword"));

        ReusableMethods.addCookie("718397", prop.getProperty("AdminLoginCookieValue"));
        Thread.sleep(2000);
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

    }//end of method
    //  Internal User
    public static void InternalUserLogin() throws InterruptedException {
        ReusableMethods.EnteringText("//*[@name='EmailAddress']", prop.getProperty("InternalUserLoginEmail"));
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser, "Welcome back, Ruslan Mishiyev!");

        ReusableMethods.EnteringText("//*[@name='MagicWord']", prop.getProperty("InternalUserLoginPassword"));

        ReusableMethods.addCookie("928694", prop.getProperty("InternalUserLoginCookieValue"));
        Thread.sleep(2000);
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);
    }

}
