package com.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.ExtentReport.ExtentreportListener2;
import com.aventstack.extentreports.Status;

public class TestUtils extends ExtentreportListener2{
	public static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT=60;
    public static long IMPLICIT_WAIT=30;

    public static void takeScreenshotAtEndOfTest(String testMethodName) throws IOException {
    	//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File sourceFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir=System.getProperty("user.dir");
        String destinationFilePath=System.getProperty(currentDir + "/Execution Reports/Fail Case ScreenShots/"+ System.currentTimeMillis() +".png" );
        FileUtils.copyFile(sourceFile, new File (destinationFilePath));
		
    }
    
    @AfterMethod
    public void down(ITestResult result) throws IOException {	
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			//test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report            
                    
            takeScreenshotAtEndOfTest(result.getName());
            //test.fail("Test Case failed check screenshot below"+ test.addScreenCaptureFromPath(screenshotPath));
            //extenttest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); //to add screenshot in extent report
            //extenttest.fail("details").addScreenCaptureFromPath(screenshotPath);
		}
        else if(result.getStatus()==ITestResult.SKIP){
            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        }
     extent.flush();
	}
}
