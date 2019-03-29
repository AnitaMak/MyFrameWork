package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="userName")WebElement UName;
	
	@FindBy(name="password")WebElement PWord;
	
	
	@FindBy(name="login")WebElement LogIn;
	
    public void loginToPHPtravels(String username, String password) 
    
    {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
    	{
			
		}
    	
    	UName.sendKeys(username);
    	PWord.sendKeys(password);
    	LogIn.click();
    }
}
