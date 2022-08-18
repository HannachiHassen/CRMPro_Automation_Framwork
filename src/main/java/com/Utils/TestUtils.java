package com.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.ExtentReport.ExtentreportListener;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.LogStatus;

public class TestUtils extends ExtentreportListener{
	public WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT=60;
    public static long IMPLICIT_WAIT=30;

    public static String takeScreenshot(String testMethodName, WebDriver driver) throws IOException {
    	File SourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String destinationFilePath=System.getProperty("user.dir")+ "/Execution Reports/Fail Case ScreenShots/" + testMethodName +".png";
    	FileUtils.copyFile(SourceFile, new File (destinationFilePath));
         
         return destinationFilePath;		
    }
    
  @AfterMethod
    public void down(ITestResult result) throws IOException {	
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			test.log(LogStatus.FAIL, (Throwable) MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report            
           
            String testMethodName = result.getName();
            String screenshotPath=TestUtils.takeScreenshot(testMethodName, driver);
            
            //String image=test.addScreenCapture(screenshotPath);
            //test.log(LogStatus.FAIL, image);            
                
            test.log(LogStatus.FAIL,"Test Case failed check screenshot below"+  MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); //to add screenshot in extent report
            //test.fail("details").addScreenCaptureFromPath(screenshotPath);
            }
        	else if(result.getStatus()==ITestResult.SKIP){
            test.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
        	}
        	else if(result.getStatus()==ITestResult.SUCCESS){
            test.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
        	}
		extent.endTest(test);
        extent.flush();
	}
}
