package User_Tests;

import Base.ReusableMethods;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.time.Clock;
import java.time.Duration;
import java.util.List;

public class User_account extends User_Account_pages{
        private static String envName ="QA"; //prop.getProperty("Permission"); QA-Chrome, Prod-Chrome, QA2-Edge


    @BeforeTest
    public void Start() throws IOException {
        SetUpProperties();
    }

    @Test
    public void LoginTest() throws InterruptedException,IOException {
        SoftAssert softAssert = new SoftAssert();
        logger = report.createTest("User Account");

        if(envName == "QA") {
            logger.info("Chrome Browser QA Environment Navigate to site and login to User Account");
            StartBrowser();
            NavigateToSite();
            UserLogin();
           // UserLogin("621638", "8l3QsHdxRPH18FfO2zMSQO3LexgOzGbJG__o7JZHebCnZXBxXtmKzbj-bf3sXC4DwHYC_S_GRq2r2GI8vfSd4Gy_aUw.");
        }
        else if(envName == "Prod") {
            logger.info("Chrome Browser Production Environment Navigate to site and login to User Account");
            StartBrowser();
            NavigateToSiteProd();
            UserLogin3();
          //  UserLogin("970683", "Ix4VwrYEkSbWKySgexKGfoeJjuMcmjd2WXGp3QW3QDviNVIPOxLS5QTQQgQolqfY-6YIfkkfyJGYTcAK7pScyiRmUq8.");
        }
        else if(envName =="QA2"){
            logger.info("Edge Browser QA Environment Navigate to site and login to User Account");
            StartedgeBrowser();
            NavigateToSite();
            UserLogin2();
        }

        Thread.sleep(7000);
        logger.pass("Verify user is on the home page");
        String Hptitle = getTitle();
        Assert.assertEquals(Hptitle, "MIDAS Connect - Reclaim Dashboard > Summary");

        Thread.sleep(7000);
        logger.pass("Verify Reclaim Dashboard is visible");
        String ReclaimTile = getText("//a[normalize-space()='Reclaim Dashboard']");
        boolean RTile = ReclaimTile.contains("RECLAIM DASHBOARD");
        Assert.assertTrue(RTile);

        logger.pass("Verify Quarterly Statement tile is visible");
        String QuarterlyTile = getText("//a[normalize-space()='Quarterly Statements']");
        boolean QTile = QuarterlyTile.contains("QUARTERLY STATEMENTS");
        Assert.assertTrue(QTile);

        logger.pass("Verify Payment Statements is visible");
        String PaymentTile = getText("//a[normalize-space()='Payment Statements']");
        boolean Ptile = PaymentTile.contains("PAYMENT STATEMENTS");
        Assert.assertTrue(Ptile);


        //Reclaim tab - summary selected
        logger.pass("Verify Summary tab is visible");
        String Summary = getText("//*[@id='summaryTab']");
        Assert.assertEquals(Summary,"SUMMARY");

        logger.pass("Verify Active tab is visible");
        String Active = getText("//*[@id='activeTab']");
        Assert.assertEquals(Active,"ACTIVE");

        logger.pass("Verify Paid tab is visible");
        String Paid = getText("//*[@id='paidTab']");
        Assert.assertEquals(Paid,"PAID");

        logger.pass("Verify Expiring tab is visible");
        String Expire = getText("//*[@id='expiringTab']");
        Assert.assertEquals(Expire,"EXPIRING");

        logger.pass("Verify Reclaims Summary Section is visible");
        String RSummary = getText("//*[@id=\"reclaim-dashboard-view-root\"]/div[4]/div/div[1]/div[1]/div[1]/h4");
        Assert.assertEquals(RSummary,"RECLAIMS SUMMARY");

        logger.pass("Verify IGuide Icon is Displayed");
        WebElement IGuide =driver.findElement(By.xpath("//*[@id=\"coachmarks-btn\"]/i"));
        Assert.assertEquals(IGuide.isDisplayed(),true);
        System.out.println("iguide logo displayed");

        Thread.sleep(2000);
        logger.pass("Verify Excel Download button is Displayed");
        WebElement ExcelButton =driver.findElement(By.id("excel-export-btn"));
        Assert.assertEquals(ExcelButton.isDisplayed(),true);
        System.out.println("Excel Button is displayed");

        Thread.sleep(3000);
        logger.pass("Verify PDF Download button is Displayed");
        WebElement PDFButton =driver.findElement(By.id("pdf-export-btn"));
        Assert.assertEquals(PDFButton.isDisplayed(),true);
        System.out.println("PDF Button is Displayed");

        //Reclaims Summary tab Outstanding, Filed, Paid Since Inception, Event Count Values are Not 0.
        logger.pass("Summary tab Verify outstanding value does not equal to 0");
        String Outstanding =getText("//*[@id=\"outstandingStat\"]/div/div[2]");
        //System.out.println(Outstanding);
        softAssert.assertNotEquals(Outstanding,"$0.00");

        logger.pass("Summary tab Verify Filed value does not equal to 0");
        String Filed = getText("//*[@id=\"filedStat\"]/div/div[2]");
        softAssert.assertNotEquals(Filed,"$0.00");

        logger.pass("Summary Tab Verify Paid Since Inception value does not equal to 0");
        String PaidSinceInception = getText("//*[@id=\"paidStat\"]/div/div[2]");
        softAssert.assertNotEquals(PaidSinceInception,"$0.00");

        logger.pass("Summary Tab Verify Event Count value does not equal to 0");
        String EventCount = getText("//*[@id=\"eventsStat\"]/div/div[2]");
        softAssert.assertNotEquals(EventCount,"0");

        //Active Tab Outstanding, Filed, Accounts, Transactions, Event Count Values are Not 0.
        Thread.sleep(12000);
        Click("//*[@id=\"activeTab\"]");
        Thread.sleep(21000);
        logger.pass("Verify Active reclaims page is visible");
        String ActiveR = getText("//*[@id=\"reclaim-dashboard-view-root\"]/div[4]/div/div[1]/div[1]/div[1]/h4");
        Assert.assertEquals(ActiveR,"ACTIVE RECLAIMS");

        logger.pass("Active tab Verify outstanding value does not equal to 0");
        softAssert.assertNotEquals(Outstanding,"$0.00");
        System.out.println(Outstanding);

        logger.pass("Active tab Verify Filed value does not equal to 0");
        softAssert.assertNotEquals(Filed,"$0.00");
        System.out.println(Filed);

        logger.pass("Active Tab Verify Accounts value does not equal to 0");
        String Account = getText("//*[@id=\"accountStat\"]/div/div[2]");
        softAssert.assertNotEquals(Account,"0");

        logger.pass("Active Tab Verify Transactions value does not equal to 0");
        String Transactions = getText("//*[@id=\"transStat\"]/div/div[2]");
        softAssert.assertNotEquals(Transactions,"0");

        logger.pass("Active Tab Verify Event Count value does not equal to 0");
        softAssert.assertNotEquals(EventCount,"0");
        System.out.println(EventCount);

        //PAID tab Verify Since Inception, Accounts, Transactions Values are Not 0.
        logger.pass("PAID tab Verify Since Inception value does not equal to 0");
        ReusableMethods.Click("//*[@id=\"paidTab\"]");
        Thread.sleep(21000);

        String SinceInception =getText("//*[@id=\"paidStat\"]/div/div[2]");
        softAssert.assertNotEquals(SinceInception,"$0.00");

        logger.pass("PAID Tab Verify Accounts value does not equal to 0");
        softAssert.assertNotEquals(Account,"0");
        System.out.println(Account);

        logger.pass("PAID Tab Verify Transactions value does not equal to 0");
        softAssert.assertNotEquals(Transactions,"0");
        System.out.println(Transactions);

        //Expiring tab Verify Outstanding, Accounts, Transactions, Event Count Values are Not 0
        logger.pass("Expiring  tab Verify outstanding value does not equal to 0");
        Click("//*[@id=\"expiringTab\"]");
        Thread.sleep(23000);
        softAssert.assertNotEquals(Outstanding,"$0.00");
        System.out.println("Expiring  " + Outstanding);

        logger.pass("Expiring Tab Verify Accounts value does not equal to 0");
        softAssert.assertNotEquals(Account,"0");
        System.out.println("Expiring  "+Account);

        logger.pass("Expiring Tab Verify Transactions value does not equal to 0");
        softAssert.assertNotEquals(Transactions,"0");
        System.out.println("Expiring  "+Transactions);

        logger.pass("Expiring Tab Verify Event Count value does not equal to 0");
        softAssert.assertNotEquals(EventCount,"0");
        System.out.println("Expiring  "+EventCount);


        logger.info("Click on Summary Tab");
        Click("//*[@id=\"summaryTab\"]");
        Thread.sleep(6000);
        /*WebDriverWait wait3 = new WebDriverWait(driver,timeout);
        WebElement element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
        */

        logger.pass("Verify Active Transactions Summary Section is visible");
        String ATS = getText("//*[@id=\"activeTransSummary\"]/div[1]/h4");
        Assert.assertEquals(ATS,"ACTIVE TRANSACTIONS SUMMARY");

        logger.pass("Verify Net Reclaim by Country Section is visible");
        String NRbyCountry = getText("//h4[contains(text(),'NET RECLAIM BY')]");
        Assert.assertEquals(NRbyCountry,"NET RECLAIM BY STATUS");

        logger.pass("Verify Accounts Section is visible");
        String Accounts = getText("//h4[contains(text(),'ACCOUNTS')]");
        Assert.assertEquals(Accounts,"ACCOUNTS");
/*
        String Accountnames= driver.findElement(By.xpath("//*[@id=\"dx-4f1025e8-1ad6-677d-703e-fbc2d49598b7\"]/tbody/tr[1]/td[2]")).getText();
        System.out.println(Accountnames);

        logger.pass("User Custodian Names Pershing or Goldman Sachs are displayed");
        List<WebElement> Accountrows = driver.findElements(By.xpath("//*[@id=\"dx-06a19bf5-db6b-9516-c52e-ac219c18c7da\"]"));
        System.out.println("no of rows" + Accountrows.size());

        List<WebElement> AccountNames = driver.findElements(By.xpath("//td[@class='custodian']"));
        for (WebElement Anames : AccountNames) {
            System.out.println("Account Names : " + Anames.getText());
            if(Anames.getText().contains("Pershing") || Anames.getText().contains("Goldman")){
                System.out.println("Pershing or Goldman Sachs are displayed");
                logger.pass("User Custodian Names Pershing or Goldman Sachs are displayed");
            }else{
                break;
            }
        }
        logger.fail("User Custodian Names Pershing or Goldman Sachs are not displayed");
 */
        Thread.sleep(18000);

        logger.info("Click Quarterly Statements Tab");
        Click("//*[@id='nav-bar-root']/div/a[2]");
        Thread.sleep(6000);

        if (isElementPresent(By.xpath("/html/body/div[3]/div/div[1]/i")))
        { driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/i")).click();}
        else{System.out.println("Q Report Pop Up Window not there ");}

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //WebDriverWait wait = new WebDriverWait(driver,timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-grid-header")));

        logger.pass("Verify Statement Downloads section is available");
        String StatemenDownloads = element.getText();
        System.out.println(StatemenDownloads);
        Assert.assertEquals(StatemenDownloads, "STATEMENT DOWNLOADS");

        Thread.sleep(8000);
        logger.info("Click Payment Statements Tab");
        Click("//*[@id='nav-bar-root']/div/a[3]");
        Thread.sleep(6000);

        if (isElementPresent(By.xpath("/html/body/div[3]/div/div[1]/i")))
        { driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/i")).click();}
        else{System.out.println("Payment Report Pop Up Window not there ");}

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
  //      WebDriverWait wait2 = new WebDriverWait(driver,timeout);
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-grid-header")));
  //      Click("/html/body/div[3]/div/div[1]/i");

        logger.pass("Verify Statement Downloads section is available");
        String PaymentDownloads = element2.getText();
        System.out.println(PaymentDownloads);
        Assert.assertEquals(PaymentDownloads,"STATEMENT DOWNLOADS");
        Thread.sleep(2000);

        logger.info("Click on User dropdown");
        Click("//*[@id='signed-in-user']");
        Thread.sleep(4000);

        logger.pass("Verify Contact Management button is not visible");
        int CMangement = driver.findElements(By.xpath("//*[@id='contactManagement']")).size();
        if(CMangement>0){
            throw new Error("Element is Visible");
        }else{
            logger.pass("Contact Management is not visible");
            System.out.println("Contact Management is not visible");
        }

Closebrowser();
        softAssert.assertAll();

    }//end of test


}//end of class
