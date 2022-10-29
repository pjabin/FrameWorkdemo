package com.framework.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.framework.utility.BrowserFactory;
import com.framework.utility.ConfigDataProvider;
import com.framework.utility.ExcelDataProvider;
import com.framework.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excl;
	public ConfigDataProvider con;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
	 excl=new ExcelDataProvider();
	 con=new ConfigDataProvider();
	 ExtentSparkReporter extent=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/demo"+Helper.getCurrentDateTime()+".html"));
	 report=new ExtentReports();
	 report.attachReporter(extent);
	}
	@BeforeClass
	public void setUp()
	{
	driver=BrowserFactory.startApplication(driver, con.getBrowser(),con.getUrl());
	
	}
	
	@AfterClass
	public void tearDown(){
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result ) {
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		report.flush();
		
	}


}
