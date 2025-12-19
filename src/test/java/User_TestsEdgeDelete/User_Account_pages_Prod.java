package User_TestsEdgeDelete;

import Base.ReusableMethods;
import org.testng.Assert;

public class User_Account_pages_Prod extends ReusableMethods {

    // Production Environment Login and Cookie handling
    public static void UserLogin3() throws InterruptedException {

        ReusableMethods.EnteringText("//*[@name='EmailAddress']", "Espds120@globetax.com");
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser, "Welcome back, Test QA!");

        ReusableMethods.EnteringText("//*[@name='MagicWord']", "Test123-");

        ReusableMethods.addCookie("970683", "Ix4VwrYEkSbWKySgexKGfoeJjuMcmjd2WXGp3QW3QDviNVIPOxLS5QTQQgQolqfY-6YIfkkfyJGYTcAK7pScyiRmUq8.");
        Thread.sleep(2000);
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);


    }
}
