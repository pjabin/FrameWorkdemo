package com.framework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.framework.pages.BaseClass;
import com.framework.pages.LoginPage;
public class LoginTestSwag extends BaseClass{
	@Test
	public void loginapp() {
		System.out.println("Loginto saucedemo");
		logger=report.createTest("Login to saucedemo");
		LoginPage logap=PageFactory.initElements(driver,LoginPage.class);
		logger.info("Starting Application");
		logap.loginTosauce(excl.getStringData("Login", 0, 0), excl.getStringData("Login", 0, 1));
		logger.pass("Login Sucuess");
	//System.out.println(driver);
	}

}
