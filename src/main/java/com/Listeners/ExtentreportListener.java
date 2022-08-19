package com.Listeners;

import java.io.File;
import java.io.IOException;
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
import org.testng.annotations.AfterMethod;
import org.testng.xml.XmlSuite;

import com.Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentreportListener implements IReporter {
	protected ExtentReports extentReport;
	protected ExtentTest test;
	public WebDriver driver=null;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		outputDirectory = System.getProperty("user.dir") + "/Execution Reports/";
		new File(outputDirectory).mkdir();

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(outputDirectory + File.separator + "./Graphic Reports/HTMLExtentReportTestNG.html");
	
	    htmlReporter.config().setDocumentTitle("Test Results");
	    htmlReporter.config().setReportName("ExtentReports - CRMPro Automation");
	    htmlReporter.config().setTheme(Theme.STANDARD);
	     
	    extentReport = new ExtentReports();
	    extentReport.attachReporter(htmlReporter);
	    extentReport.setReportUsesManualConfiguration(true);
	     
	    extentReport.setSystemInfo("Operating System","Windows 10");
		extentReport.setSystemInfo("Tested By","Hassen Hannachi");

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
		if (extentReport != null) {
			extentReport.flush();
			((WebDriver) extentReport).close();
		}
	}
	
	private void buildTestNodes(IResultMap tests, Status status){
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test=extentReport.createTest(result.getTestClass().getName()+"@ " + result.getMethod().getMethodName() + "@ " + result.getMethod().getDescription());
				
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
	
	@AfterMethod
    public void down(ITestResult result) throws IOException {	
		if(result.getStatus()==ITestResult.FAILURE){
			//test.log(Status.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			test.log(Status.FAIL, (MarkupHelper.createLabel(result.getName() + " - TEST CASE FAILED ", ExtentColor.RED)));
            test.log(Status.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report            
           
            String testMethodName = result.getName();
            String screenshotPath=BaseClass.takeScreenshot(testMethodName, driver);
            //test.log(Status.FAIL, ("Test Case Failed Check Screenshot below: " + (Markup) test.addScreenCaptureFromPath(screenshotPath, testMethodName)));
                           
            test.log(Status.FAIL,"Test Case failed check screenshot below"+  MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); //to add screenshot in extent report
          
            }
        	else if(result.getStatus()==ITestResult.SKIP){
            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
        	}
        	else if(result.getStatus()==ITestResult.SUCCESS){
            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        	}
		//extentReport.endTest(test);
        extentReport.flush();
	}
	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}