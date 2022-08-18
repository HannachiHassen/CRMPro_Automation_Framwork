package com.ExtentReport;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	protected ExtentReports extent;
	protected ExtentTest test;
	public WebDriver driver;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		outputDirectory = System.getProperty("user.dir") + "\\ExtentReports\\";
		new File(outputDirectory).mkdir();
		 
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter (outputDirectory + File.separator + "./Graphic Reports/HTMLExtentReportTestNG.html");
	     htmlReporter.config().setDocumentTitle("ExtentReports - Created by TestNG Listener");
	     htmlReporter.config().setReportName("ExtentReports - Created by TestNG Listener");
	     htmlReporter.config().setTheme(Theme.STANDARD);
	     
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	     extent.setReportUsesManualConfiguration(true);

		for (ISuite suite : suites) {
			System.out.println("Suite name - " +suite.getName());
			
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				
				System.out.println("Test tag name: " + context.getName() +  "\t" +
                        "Test start time: " + context.getStartDate() +  "\t" +
                        "Test end time: " + context.getEndDate() + "\t" +
                        "Test report output dir: " + outputDirectory);
				
					buildTestNodes(context.getPassedTests(), Status.PASS);
					buildTestNodes(context.getFailedTests(), Status.FAIL);
					buildTestNodes(context.getSkippedTests(), Status.SKIP);					
			}
		}
		System.out.println("Test Report Path - " + outputDirectory);
		
		System.out.println(("Extent Reports Test Suite is ending!"));
		if (extent != null) {
			extent.flush();
			((WebDriver) extent).close();
		}
	}
	
	private void buildTestNodes(IResultMap tests, Status status){
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test=extent.createTest(result.getTestClass().getName()+"@ " + result.getMethod().getMethodName() + "@ " + result.getMethod().getDescription());
				
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				}else {
					test.log(status,"Test " + status.toString().toLowerCase()+ "ed");
				}
				test.getModel().setStartTime(getTime(result.getStartMillis()));
				test.getModel().setEndTime(getTime(result.getEndMillis()));					 			
			}
		}
	}	
	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}