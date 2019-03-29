package com.Automation.Tesatcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Automation.Utility.BrowserFolder;
import com.Automation.Utility.ConfigDataProvider;
import com.Automation.Utility.ExcelDataProvider;
import com.Automation.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config; 
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite 
	public void setUpSuit()
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		
	  excel=new ExcelDataProvider();
	  config=new ConfigDataProvider();
	  
	  ExtentHtmlReporter extent=new ExtentHtmlReporter
	  (new File(System.getProperty("user.dir")+"/ReportFolder/newTours"+Helper.getCurrentDateTime()+".html"));
	  
	  report =new ExtentReports();
	  report.attachReporter(extent);
	  
	  Reporter.log("Setting up is done  and Test can be started", true);
	}
	
	@BeforeClass
	
	public void SetUp() 
	{
		Reporter.log("Starting Browser and getting Application ready", true);
		
		driver=BrowserFolder.startApplication(driver,config.getBrowser(),config.getStagingURL());
		
		Reporter.log("Browser is up and running", true);
	}
	
	

	@AfterClass
	
	public void tearDown() 
	{
		BrowserFolder.quitBrouwser(driver);

		
	}
	
	@AfterMethod 
	public  void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test about to end", true);
		
		if (result.getStatus()==ITestResult.FAILURE)
     {
    	 Helper.captureScreenshot(driver);
    	 
    	 logger.fail("Test Failed", 
         MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	}
		else if(result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.pass("Test Passed", 
			         MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test ", 
			         MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		
		Reporter.log("Test completed  >>> Report Generated", true);
	}
	

}
