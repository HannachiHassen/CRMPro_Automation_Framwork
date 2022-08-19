package com.Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.BaseClass;
import com.ExtentReport.ExtentReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseClass implements ITestListener{
    
public WebDriver driver=null;
	
	ExtentReports extentReport= ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		//String testMethodName=result.getName();
		//extentTest=extentReport.createTest(testMethodName+ " Execution started");
		extentTest=extentReport.createTest(result.getTestClass().getName()+ " @ "+ result.getMethod().getMethodName()+ " @ " + result.getMethod().getDescription());
		extentTestThread.set(extentTest);
		
		System.out.println(("*** Running Test Method " + result.getMethod().getMethodName() + "..."));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testMethodName=result.getName();
		extentTestThread.get().log(Status.PASS, testMethodName+ " Test get Passed");
		
		System.out.println("*** Test Method " + result.getMethod().getMethodName() + " Executed successfully...");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName=result.getName();
		extentTestThread.get().fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		    /* We can replace the above code with a short one: 
		     *      driver=(WebDriver) ((Base)result.getInstance()).driver;
		     */
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String screenshotPath=takeScreenshot(testMethodName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotPath, testMethodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("*** Test Method " + result.getMethod().getMethodName() + " Failed...");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTestThread.get().log(Status.SKIP, " Test skipped");
		System.out.println("*** Test Method " + result.getMethod().getMethodName() + " Skipped...");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test Failed but within percentage % " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("*** Test Failed but with Timeout" + result.getMethod().getMethodName());		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " Started ***");	
	}

	@Override
	public void onFinish(ITestContext context) {		
		extentReport.flush();
		System.out.println(("*** Test Suite " + context.getName() + " is ending! ***"));		
	}
}
