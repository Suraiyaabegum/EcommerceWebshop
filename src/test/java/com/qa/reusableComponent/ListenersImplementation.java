package com.qa.reusableComponent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.base.BaseClass;

public class ListenersImplementation extends BaseClass implements ITestListener {
	
	//public ListenersImplementation(WebDriver driver) {
	//	driver=this.driver;
//	}
	
	ReportUsingExtentReports reportUsingExtentReports=new ReportUsingExtentReports();
	ExtentTest test=ReportUsingExtentReports.setupExtendReports().createTest("Testing Phase");
	
	public void onTestStart(ITestResult result) {
		test.log(Status.PASS, "Test Case"+result.getMethod().getMethodName()+"started");
		System.out.println("The Test is Started : "+result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case"+result.getMethod().getMethodName()+"passed");
		System.out.println("The Test is Pass : "+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case"+result.getMethod().getMethodName()+"Failed");
		test.log(Status.FAIL, result.getThrowable());
		System.out.println("The Test is Failed : "+result.getMethod().getMethodName());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date=new Date();  //get current date
		String actualDate=simpleDateFormat.format(date);
		String ssPath=System.getProperty("user.dir")+"/Reports/Screenshots_"+actualDate+".png";
		File des=new File(ssPath);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(ssPath,"Tese Case Failed screenshot");	
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The Test is Skipped : "+result.getMethod().getMethodName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ReportUsingExtentReports.setupExtendReports();
	}
	
	@AfterSuite
	public void onFinish(ITestContext context) {
		ReportUsingExtentReports.setupExtendReports().flush();
	}	
}