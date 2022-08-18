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
//import com.relevantcodes.extentreports.LogStatus;

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
  
}
