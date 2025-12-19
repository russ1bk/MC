package Internal_Admin_Tests;

import Base.ReusableMethods;
import Login_Tests.Login_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

import java.io.IOException;
import java.security.Permission;

public class Admin_Account extends Admin_User_Login_Pages {
 // Permission Type Admin or InternalAdmin(No Access to Contacts)
    private static String Permission = prop.getProperty("Permission2"); //InternalAdmin or Admin

    @BeforeTest
    public void Start() throws IOException {
        SetUpProperties();
    }

    @Test
    public void LoginTest() throws InterruptedException {

        if (Permission=="InternalAdmin"){
            logger = report.createTest("Internal User Account");
            logger.info("Navigate to site and login to Internal User Account");
            StartBrowser();
            NavigateToSite();
            InternalUserLogin();
        } else if (Permission=="Admin") {
            logger = report.createTest("Admin Account");
            logger.info("Navigate to site and login to Admin Account");
            StartBrowser();
            NavigateToSite();
            AdminLogin();
        }
        Thread.sleep(3000);
        logger.pass("Verify user is on the home page");
        String Hptitle = getTitle();
        Assert.assertEquals(Hptitle,"MIDAS Connect - View Reports");

        logger.pass("Verify View Report As Text is visible");
        String ViewReportAsText = getText("//label[@for='viewReportAsField']/span");
        Assert.assertEquals(ViewReportAsText,"VIEW REPORTS AS");


        logger.pass("Verify View Report As drop down is visible");
        boolean ViewReportAsDropD = driver.findElement(By.id("view-report-as-form")).isDisplayed();
        Assert.assertTrue(ViewReportAsDropD);

        logger.pass("Verify Reclaim Dashboard is visible");
        String ReclaimTile = getText("//div[normalize-space()='Reclaim Dashboard']");
        boolean RTile = ReclaimTile.contains("RECLAIM DASHBOARD");
        Assert.assertTrue(RTile);

        logger.pass("Verify Quarterly Statement tile is visible");
        String QuarterlyTile = getText("//div[normalize-space()='Quarterly Statements']");
        boolean QTile = QuarterlyTile.contains("QUARTERLY STATEMENTS");
        Assert.assertTrue(QTile);

        logger.pass("Verify Payment Statements is visible");
        String PaymentTile = getText("//div[normalize-space()='Payment Statements']");
        boolean Ptile = PaymentTile.contains("PAYMENT STATEMENTS");
        Assert.assertTrue(Ptile);

        logger.info("Click on User dropdown");
        Click("//*[@id='signed-in-user']");
        Thread.sleep(2000);

        logger.pass("Verify contact management access");
        String CManagement = getText("//*[@id='contactManagement']");
        Assert.assertEquals(CManagement,"Manage Contacts");

        logger.info("Click contact management");
        Click("//*[@id='contactManagement']");
        Thread.sleep(10000);

        if(Permission == "InternalAdmin"){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid-legend']")));

            logger.pass("Verify Add Contacts is not visible");
            int AddContact =  driver.findElements(By.xpath("//button[contains(text(),'Add Contact')]")).size();
            if (AddContact>0){
                throw new Error("Element is Visible");
            }else{
                logger.pass("Add Contacts button not visible");
                System.out.println("Add Contacts Feature is not visible");
            }

            logger.pass("Verify Edit button is not visible");
            int Edit = driver.findElements(By.xpath("//*[@id=\"contacts-datagrid\"]/div[1]/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[11]/a")).size();
            if(Edit>0){
                throw new Error("Element not Visible");
            }else{
                logger.pass("Edit button not visible");
                System.out.println("Edit button is not visible");
            }

            logger.pass("Verify account status is Active");
            String UserStatus = getText("//body[1]/div[1]/div[3]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]");
            Assert.assertEquals(UserStatus,"ACTIVE");

            logger.pass("Verify status is disabled - Read only access");
            String Readonly = driver.findElement(By.xpath("//*[@id=\"dx-col-62\"]")).getAttribute("class");
            boolean Disabled = Readonly.contains("disabled");
            Assert.assertTrue(Disabled);
        }
        else if (Permission =="Admin") {

            logger.info("Click Add Contact");
            Click("//button[contains(text(),'Add Contact')]");

            Thread.sleep(4000);

            logger.pass("Verify Contact Information Tab");
            String ContactInfo = getText("//span[contains(text(),'Contact Information')]");
            Assert.assertEquals(ContactInfo, "Contact Information");

            logger.pass("Verify Membership & Permissions Tab ");
            String MemberPermission = getText("//span[contains(text(),'Memberships & Permissions')]");
            Assert.assertEquals(MemberPermission, "Memberships & Permissions");

            logger.info("Click Cancel Button");
            Click("//*[@id='cancel-edit-btn']");

            logger.pass("Verify account status is Active");
            String UserStatus = getText("//body[1]/div[1]/div[3]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]");
            Assert.assertEquals(UserStatus, "ACTIVE");

            logger.pass("Verify Edit button is displayed");
            boolean Edit = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[12]/a")).isDisplayed();
            Assert.assertTrue(Edit);
            System.out.println("Edit");
        }
     Closebrowser();

    }//end of Test

}//end of class
