package com.automation.uiAutomation.homepage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.uiAutomation.testBase.TestBase;
import com.automation.uiAutomation.uiActions.HomePage;

public class TC003_VerifyLoginWithDifferentRecords extends TestBase {
	
	HomePage homePage = null;
	@BeforeTest
	public void setUp(){			
		init();
			
	}
	
	@DataProvider(name="getTestData")
	public String[][] getTestData(){
		String[][] data = getData("LoginTest");
		return data;
	}
	
	@Test(dataProvider="getTestData")
	public void testLogin(String userName, String loginPassword){
		log.info("===========Starting TC003_VerifyLoginWithDifferentRecords========");
		homePage = new HomePage(driver);
		homePage.loginToApplication(userName,loginPassword );
		homePage.getInvalidLoginText();
		log.info("===========Finish TC003_VerifyLoginWithDifferentRecords========");
	}
	
	@AfterClass
	public void endTest(){	
		//driver.close();
		log.info("Closing Browser");
	}

}
