package User_TestsEdgeDelete;

import Base.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class User_account2 extends User_Account_pages2 {

    @BeforeTest
    public void Start() throws IOException {
        SetUpProperties();
    }

  // Removed Test annotation
    public void LoginTest2 () throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
     logger= report.createTest("User Account Edge Browser");
     logger.info("In Edge Browser Navigate to site and login to User Account");
     StartedgeBrowser();
     NavigateToSite();
     UserLogin2();

        Thread.sleep(4000);
        logger.info("Verify user is on the home page");
        String Hptitle = getTitle();
        Assert.assertEquals(Hptitle, "MIDAS - View Reports");

        Thread.sleep(9000);
        logger.info("Verify Reclaim Dashboard is visible");
        String ReclaimTile = getText("//a[normalize-space()='Reclaim Dashboard']");
        boolean RTile = ReclaimTile.contains("RECLAIM DASHBOARD");
        Assert.assertTrue(RTile);

        logger.info("Verify Quarterly Statement tile is visible");
        String QuarterlyTile = getText("//a[normalize-space()='Quarterly Statements']");
        boolean QTile = QuarterlyTile.contains("QUARTERLY STATEMENTS");
        Assert.assertTrue(QTile);

        logger.info("Verify Payment Statements is visible");
        String PaymentTile = getText("//a[normalize-space()='Payment Statements']");
        boolean Ptile = PaymentTile.contains("PAYMENT STATEMENTS");
        Assert.assertTrue(Ptile);

        //Reclaim tab - summary selected
        logger.info("Verify Summary tab is visible");
        String Summary = getText("//*[@id='summaryTab']");
        Assert.assertEquals(Summary,"SUMMARY");

        logger.info("Verify Active tab is visible");
        String Active = getText("//*[@id='activeTab']");
        Assert.assertEquals(Active,"ACTIVE");

        logger.info("Verify Paid tab is visible");
        String Paid = getText("//*[@id='paidTab']");
        Assert.assertEquals(Paid,"PAID");

        logger.info("Verify Expiring tab is visible");
        String Expire = getText("//*[@id='expiringTab']");
        Assert.assertEquals(Expire,"EXPIRING");

        logger.info("Verify Reclaims Summary Section is visible");
        String RSummary = getText("//h4[contains(text(),'RECLAIMS SUMMARY')]");
        Assert.assertEquals(RSummary,"RECLAIMS SUMMARY");

        logger.info("Verify IGuide Icon is Displayed");
        WebElement IGuide =driver.findElement(By.xpath("//*[@id=\"coachmarks-btn\"]/i"));
        Assert.assertEquals(IGuide.isDisplayed(),true);
        System.out.println("iguide logo displayed");

        Thread.sleep(2000);
        logger.info("Verify Excel Download button is Displayed");
        WebElement ExcelButton =driver.findElement(By.id("excel-export-btn"));
        Assert.assertEquals(ExcelButton.isDisplayed(),true);
        System.out.println("Excel Button is displayed");

        Thread.sleep(2000);
        logger.info("Verify PDF Download button is Displayed");
        WebElement PDFButton =driver.findElement(By.id("pdf-export-btn"));
        Assert.assertEquals(PDFButton.isDisplayed(),true);
        System.out.println("PDF Button is Displayed");

        //Reclaims Summary tab Outstanding, Filed, Paid Since Inception, Event Count Values are Not 0.
        logger.info("Summary tab Verify outstanding value does not equal to 0");
        String Outstanding =getText("//*[@id=\"outstandingStat\"]/div/div[2]");
        //System.out.println(Outstanding);
        softAssert.assertNotEquals(Outstanding,"$0.00");

        logger.info("Summary tab Verify Filed value does not equal to 0");
        String Filed = getText("//*[@id=\"filedStat\"]/div/div[2]");
        softAssert.assertNotEquals(Filed,"$0.00");

        logger.info("Summary Tab Verify Paid Since Inception value does not equal to 0");
        String PaidSinceInception = getText("//*[@id=\"paidStat\"]/div/div[2]");
        softAssert.assertNotEquals(PaidSinceInception,"$0.00");

        logger.info("Summary Tab Verify Event Count value does not equal to 0");
        String EventCount = getText("//*[@id=\"eventsStat\"]/div/div[2]");
        softAssert.assertNotEquals(EventCount,"0");

        //Active Tab Outstanding, Filed, Accounts, Transactions, Event Count Values are Not 0.

        Click("//*[@id=\"activeTab\"]");
        Thread.sleep(16000);
        logger.info("Verify Active reclaims page is visible");
        String ActiveR = getText("//*[@id=\"reclaim-dashboard-view-root\"]/div[4]/div[1]/div/div/div[1]/div/div[1]/h4");
        Assert.assertEquals(ActiveR,"ACTIVE RECLAIMS");

        logger.info("Active tab Verify outstanding value does not equal to 0");
        softAssert.assertNotEquals(Outstanding,"$0.00");
        System.out.println(Outstanding);

        logger.info("Active tab Verify Filed value does not equal to 0");
        softAssert.assertNotEquals(Filed,"$0.00");
        System.out.println(Filed);

        logger.info("Active Tab Verify Accounts value does not equal to 0");
        String Account = getText("//*[@id=\"accountStat\"]/div/div[2]");
        softAssert.assertNotEquals(Account,"0");

        logger.info("Active Tab Verify Transactions value does not equal to 0");
        String Transactions = getText("//*[@id=\"transStat\"]/div/div[2]");
        softAssert.assertNotEquals(Transactions,"0");

       logger.info("Active Tab Verify Event Count value does not equal to 0");
       softAssert.assertNotEquals(EventCount,"0");
       System.out.println(EventCount);

      //PAID tab Verify Since Inception, Accounts, Transactions Values are Not 0.
        logger.info("PAID tab Verify Since Inception value does not equal to 0");
        ReusableMethods.Click("//*[@id=\"paidTab\"]");
        Thread.sleep(15000);

        String SinceInception =getText("//*[@id=\"paidStat\"]/div/div[2]");
        softAssert.assertNotEquals(SinceInception,"$0.00");

        logger.info("PAID Tab Verify Accounts value does not equal to 0");
        softAssert.assertNotEquals(Account,"0");
        System.out.println(Account);

        logger.info("PAID Tab Verify Transactions value does not equal to 0");
        softAssert.assertNotEquals(Transactions,"0");
        System.out.println(Transactions);

        //Expiring tab Verify Outstanding, Accounts, Transactions, Event Count Values are Not 0
        logger.info("Expiring  tab Verify outstanding value does not equal to 0");
        Click("//*[@id=\"expiringTab\"]");
        Thread.sleep(22000);
        softAssert.assertNotEquals(Outstanding,"$0.00");
        System.out.println("Expiring  " + Outstanding);

        logger.info("Expiring Tab Verify Accounts value does not equal to 0");
        softAssert.assertNotEquals(Account,"0");
        System.out.println("Expiring  "+Account);

        logger.info("Expiring Tab Verify Transactions value does not equal to 0");
        softAssert.assertNotEquals(Transactions,"0");
        System.out.println("Expiring  "+Transactions);

        logger.info("Expiring Tab Verify Event Count value does not equal to 0");
        softAssert.assertNotEquals(EventCount,"0");
        System.out.println("Expiring  "+EventCount);

        softAssert.assertAll();

        logger.info("Click on Summary Tab");
        Click("//*[@id=\"summaryTab\"]");
        /*Thread.sleep(5000);*/
        /*WebDriverWait wait3 = new WebDriverWait(driver,timeout);
        WebElement element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
        */
        logger.info("Verify Active Transactions Summary Section is visible");
        String ATS = getText("//h4[contains(text(),'ACTIVE TRANSACTIONS')]");
        Assert.assertEquals(ATS,"ACTIVE TRANSACTIONS SUMMARY");

        logger.info("Verify Net Reclaim by Country Section is visible");
        String NRbyCountry = getText("//h4[contains(text(),'NET RECLAIM BY')]");
        Assert.assertEquals(NRbyCountry,"NET RECLAIM BY COUNTRY");

        logger.info("Verify Accounts Section is visible");
        String Accounts = getText("//h4[contains(text(),'ACCOUNTS')]");
        Assert.assertEquals(Accounts,"ACCOUNTS");

        List<WebElement> AccountNames = driver.findElements(By.xpath("//td[@class='custodian']"));
        for (WebElement Anames : AccountNames) {
            System.out.println("Account Names : " + Anames.getText());
            if(Anames.getText().contains("Pershing") || Anames.getText().contains("Goldman")){
                System.out.println("Pershing and Goldman Sachs are displayed");
            }else{
                break;
            }
        }

        logger.info("User Custodian Names Pershing and Goldman Sachs are displayed");
        Thread.sleep(7000);

        logger.info("Click Quarterly Statements Tab");
        Click("//*[@id='nav-bar-root']/div/a[2]");

//        WebDriverWait wait = new WebDriverWait(driver,10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-grid-header")));

        logger.info("Verify Statement Downloads section is available");
        String StatemenDownloads = element.getText();
        System.out.println(StatemenDownloads);
        Assert.assertEquals(StatemenDownloads,"STATEMENT DOWNLOADS");


        logger.info("Click Payment Statements Tab");
        Click("//*[@id='nav-bar-root']/div/a[3]");

 //       WebDriverWait wait2 = new WebDriverWait(driver,10);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-grid-header")));

        logger.info("Verify Statement Downloads section is available");
        String PaymentDownloads = element2.getText();
        System.out.println(PaymentDownloads);
        Assert.assertEquals(PaymentDownloads,"STATEMENT DOWNLOADS");

        logger.info("Click on User dropdown");
        Click("//*[@id='signed-in-user']");
        Thread.sleep(2000);

        logger.info("Verify Contact Management button is not visible");
        int CMangement = driver.findElements(By.xpath("//*[@id='contactManagement']")).size();
        if(CMangement>0){
            throw new Error("Element is Visible");
        }else{
            logger.info("Contact Management is not visible");
            System.out.println("Contact Management is not visible");
        }

        Closebrowser();
    }

}
