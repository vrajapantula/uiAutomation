package com.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	//1. Logger
	//2. Browser Creation
	//3. Invoke url
	
	public WebDriver driver;	
	public static Logger log = Logger.getRootLogger();
	
	String url = "http://automationpractice.com/index.php";
	String browser = "chrome";
	
	public void init(){
		String log4jConfigPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
		selectBrowser(browser);
		getUrl(url);
	}
	
	public void selectBrowser(String browser){
		if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Creating object of:" + browser);
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");		
			driver = new FirefoxDriver();
			log.info("Creating object of:" + browser);
		}
	}
	
	public void getUrl(String url){
		log.info("Navigating to URL:" + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
			
	

}
