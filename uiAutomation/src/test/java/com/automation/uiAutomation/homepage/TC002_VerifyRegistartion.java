package com.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.uiAutomation.testBase.TestBase;
import com.automation.uiAutomation.uiActions.HomePage;


public class TC002_VerifyRegistartion extends TestBase {
	//public static final Logger log = Logger.getLogger(TC002_VerifyRegistartion.class.getName());
	
	HomePage homePage = null;
	
	@BeforeTest
	public void setUp(){				
		init();		
	}
	
	@Test
	public void myTest() throws InterruptedException{
		log.info("============Starting of TestCase:" + "TC002_VerifyRegistartion" + "===================");
		homePage = new HomePage(driver);
		homePage.registerUser();			
	}
	
	@AfterClass
	public void endTest(){	
		driver.close();
		log.info("Closing Browser");
	}
}
