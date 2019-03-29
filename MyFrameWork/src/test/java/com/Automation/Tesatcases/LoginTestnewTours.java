package com.Automation.Tesatcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Automation.Pages.LoginPage;
import com.Automation.Utility.ExcelDataProvider;

public class LoginTestnewTours extends BaseClass {
	
	@Test
	
	public void logingApplication()
	{
		
		logger=report.createTest("Login to NewTours");
		
		ExcelDataProvider excel=new ExcelDataProvider();
	
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToPHPtravels(excel.getStringData("LogIn", 0, 0), excel.getStringData("LogIn", 0, 1));
		
		logger.pass("Login Sucess");
		
		
			}
	

}
