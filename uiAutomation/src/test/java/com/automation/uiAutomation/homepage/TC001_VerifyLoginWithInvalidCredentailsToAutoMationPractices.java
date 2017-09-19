package com.automation.uiAutomation.homepage;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.uiAutomation.testBase.TestBase;
import com.automation.uiAutomation.uiActions.HomePage;


public class TC001_VerifyLoginWithInvalidCredentailsToAutoMationPractices extends TestBase {
	
	HomePage homePage;
	@BeforeTest
	public void setUp(){			
		init();
			
	}
	
	
	@Test
	public void myTest() throws InterruptedException{
		
		log.info("============Starting of TestCase:" + "TC001_VerifyLoginWithInvalidCredentailsToAutoMationPractices" + "===================");
		homePage = new HomePage(driver);		
		homePage.loginToApplication("tett@gmail.com", "pwd");
		Assert.assertTrue(homePage.getInvalidLoginText().equals("Invalid password."));
		
		
		
	}
	
	@AfterClass
	public void endTest(){	
		driver.close();
		log.info("Closing Browser");
	}

}
