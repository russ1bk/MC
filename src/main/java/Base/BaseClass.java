package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
// import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseClass {

    public ExtentReports report;
    public ExtentTest logger;
    public ExtentSparkReporter spark;

    @BeforeSuite
    public void setUpSuite(){
        report = new ExtentReports();
  //      ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("src\\main\\java\\Reports\\MidasConnect.html"));
      spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/MidasConnect "+ReusableMethods.CurrentDateTime()+".html");
  //    spark= new ExtentSparkReporter("I:\\Common\\MIDASConnect\\Automated Test Results"+"/MidasConnect "+ReusableMethods.CurrentDateTime()+".html");
        report.attachReporter(spark);
        spark.config().setReportName("MIDAS CONNECT Automation Report");

    }

    @AfterMethod
    public void getresult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE) {
            logger.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            logger.pass(result.getTestName());
        }
        else {
            logger.info(result.getTestName());
        }
    }

    @AfterTest
    public void close(){
        report.flush();
    }
}
