package com.ExtentReport;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentreportListener implements IReporter {
	private ExtentReports extent;

  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	outputDirectory = System.getProperty("user.dir") + "\\Execution Reports\\"; 
		new File(outputDirectory).mkdir();

	extent = new ExtentReports(outputDirectory + File.separator + "./Graphic Reports/HTMLExtentReportTestNG.html",true);

	for (ISuite suite : suites) {
		System.out.println("Suite name - " + suite.getName());

		Map<String, ISuiteResult> result = suite.getResults();

		 for (ISuiteResult r : result.values()) {
			ITestContext context = r.getTestContext();

			System.out.println("Test tag name: " + context.getName() + "\t" + "Test start time: "
					+ context.getStartDate() + "\t" + "Test end time: " + context.getEndDate() + "\t"
					+ "Test report output dir: " + context.getOutputDirectory());

			buildTestNodes(context.getPassedTests(), LogStatus.PASS);
			buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
			buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
		}
	}
	System.out.println("Path - " + outputDirectory);

	System.out.println(("Extent Reports Test Suite is ending!"));
		if (extent != null) {
			extent.flush();
			extent.close();
		}
	}

  private void buildTestNodes(IResultMap tests, LogStatus status) {
	ExtentTest test;

	if (tests.size() > 0) {
		for (ITestResult result : tests.getAllResults()) {
			// test = extent.startTest(result.getMethod().getMethodName());
			test=extent.startTest(result.getTestClass().getName()+"@ " + result.getMethod().getMethodName() + "@ " + result.getMethod().getDescription());

			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));

			for (String group : result.getMethod().getGroups())
				test.assignCategory(group);

			String message = "Test " + status.toString().toLowerCase() + "ed";

			if (result.getThrowable() != null)
				message = result.getThrowable().getMessage();
			    test.log(status, message);
			    extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
