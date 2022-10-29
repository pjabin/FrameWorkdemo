package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	@FindBy(name="user-name") WebElement uname;
	@FindBy(how = How.NAME, using = "password") WebElement pass;
	@FindBy(how = How.ID, using = "login-button") WebElement logb;
	
	public void loginTosauce(String usernameapp,String passwapp) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			
		}
	
		uname.sendKeys(usernameapp);
		pass.sendKeys(passwapp);
		logb.click();
	}
	
}
