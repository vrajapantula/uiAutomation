package com.automation.uiAutomation.uiActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver =  null;
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	


	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement submittButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger']/ol/li")
	WebElement authenticlatiobFailed;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement createAccountEmailAddress;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createAccountButton;
	
	
	public void loginToApplication(String userName, String pwd){
		signIn.click();
		log.info("Clicked on Sign Link");
		loginEmailAddress.sendKeys(userName);
		log.info("Entered UserName:" + userName);
		loginPassword.sendKeys(pwd);
		log.info("Entered Password:" + pwd);
		submittButton.click();		
		log.info("Clicked on submit Button");
		
	}
	
	public String getInvalidLoginText(){
		String authenticationFailedMessage = authenticlatiobFailed.getText();
		log.info("Returned authentication Failed Message: "+ authenticationFailedMessage);
		return authenticationFailedMessage;	
	}
	
	public void createAccount(String userEmail){
		signIn.click();
		log.info("Clicked on Sign Link");
		createAccountEmailAddress.sendKeys(userEmail);
		log.info("Entered required Email Address");
		createAccountButton.click();
		log.info("Clicked on CreateAccountButton");	
	}
	
	public void registerUser(){
		System.out.println("Register new user");
		log.info("Register new user");
		
	}
	
	
			
}
