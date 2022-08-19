package com.ExtentReport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	static ExtentReports extentReport;
	static String outputDirectory;

	public static ExtentReports getExtentReport() {
		try {
			 outputDirectory = System.getProperty("user.dir") + "/Execution Reports/";
			 new File(outputDirectory).mkdir();
		   } catch (Exception e) {
			e.printStackTrace();
		   }
		
		String extentReportPath = outputDirectory + File.separator + "./Graphic Reports/HTMLExtentReportTestNG.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		
		reporter.config().setDocumentTitle("ExtentReports - CRMPro Automation");
		reporter.config().setReportName("Test Results");
		reporter.config().setTheme(Theme.STANDARD);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System","Windows 10");
		extentReport.setSystemInfo("Tested By","Hassen Hannachi");
        extentReport.setSystemInfo("GUI Testing", "QA");
        extentReport.setSystemInfo("Application","crmpro.com/index.html");
        extentReport.setSystemInfo("Browser", "Chrome");
		
		System.out.println("Test Report Path - " + outputDirectory);
		System.out.println(("Extent Reports Test Suite is ending!"));

		return extentReport;
	}
}
