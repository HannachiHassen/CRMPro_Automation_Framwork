package com.ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utils.TestUtils;

public class TestListener extends TestUtils implements ITestListener{		

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		String testMethodName = result.getName();
		try {
			String screenshotPath=takeScreenshot(testMethodName, driver);
			test.addScreenCapture(screenshotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test method" + result.getMethod().getMethodName() + " skipped...");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
	}

}
