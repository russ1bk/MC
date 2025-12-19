package Login_Tests;

import Base.ReusableMethods;
import org.testng.Assert;

public class Login_Pages extends ReusableMethods {

//Ruslan main account
    public static void AdminLogin() throws InterruptedException {
            ReusableMethods.EnteringText("//*[@name='EmailAddress']","Ruslan_Mishiyev@globetax.com");
            ReusableMethods.Click("//*[@type='submit']");
            Thread.sleep(2000);

            String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
            Assert.assertEquals(WelcomeUser,"Welcome back, Ruslan Mishiyev!");

            ReusableMethods.EnteringText("//*[@name='MagicWord']","Test321?");

            ReusableMethods.addCookie("718397","W7KVKNU2YKjA53vDirMt7E_dom94xKMkIfNqjRaEIGxB5EEA0exV6JgbXjvJsoQA5_sMjaEFuUOYSe9Dl_33mHOxWOH845nWOAkG");
            Thread.sleep(2000);
            ReusableMethods.Click("//*[@type='submit']");
            Thread.sleep(2000);
    }

    public static void UnregisteredAccount() throws InterruptedException {
        ReusableMethods.EnteringText("//*[@name='EmailAddress']","Test@globetax.com");
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String ErrorMessage = ReusableMethods.getText("//*[@id='app-name']//following::div[1]/div");
        Assert.assertEquals(ErrorMessage, "Unregistered Email");
    }

//Espds120 account
    public static void FailedLogin() throws InterruptedException {
        ReusableMethods.EnteringText("//*[@name='EmailAddress']","Espds120@globetax.com");
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser,"Welcome back, Ruslan Mishiyev!");

        ReusableMethods.EnteringText("//*[@name='MagicWord']","Test1234?");
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);
    }

//Espds129
    public static void LockedAccount () throws InterruptedException {
        ReusableMethods.EnteringText("//*[@name='EmailAddress']","Espds104@globetax.com");
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser,"Welcome back, Espds104 Tester!");
    }





}
