package User_TestsEdgeDelete;

import Base.ReusableMethods;
import org.testng.Assert;

public class User_Account_pages2 extends ReusableMethods {
// Edge Browser login and cookies handling
    public static void UserLogin2() throws InterruptedException{

        ReusableMethods.EnteringText("//*[@name='EmailAddress']","Espds120@globetax.com");
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);

        String WelcomeUser = ReusableMethods.getText("//*[@id='greeting']");
        Assert.assertEquals(WelcomeUser,"Welcome back, Ruslan Mishiyev!");

        ReusableMethods.EnteringText("//*[@name='MagicWord']","Test123?");

        ReusableMethods.addCookie("621638","q165rDvHePxxdISlZUKqfDMYlDKLS-GJtp7PHe3YfeE0Gw9okS1zCUuNENvur-dzQCpmVEB41p9zba6fJxXePD7ICEA.");
        Thread.sleep(2000);
        ReusableMethods.Click("//*[@type='submit']");
        Thread.sleep(2000);


    }


}
