package com.qa.reusableComponent;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.base.BaseClass;

public class ReportUsingExtentReports extends BaseClass {

	@BeforeSuite
	public static ExtentReports setupExtendReports() {
		ExtentReports extentReports=new ExtentReports();
		String reportLocation=System.getProperty("user.dir")+"/Reports/ExceutionReport.html";	
		ExtentSparkReporter extentSparkReporter=new  ExtentSparkReporter(reportLocation);
		extentReports.attachReporter(extentSparkReporter);

		extentSparkReporter.config().setDocumentTitle("Report of Tested Content");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setReportName("Executions Report");
		
		return extentReports;
	}
}
