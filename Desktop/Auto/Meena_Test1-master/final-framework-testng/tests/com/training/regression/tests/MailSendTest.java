package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RealEstateDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.MailSendPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MailSendTest {
	private WebDriver driver;
	private String baseUrl;
	private MailSendPOM mailPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		mailPOM = new MailSendPOM(driver);
		baseUrl = properties.getProperty("NewURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "excel-inputs", dataProviderClass = RealEstateDataProviders.class)
	public void loginDBTest(String search, String name,String email, String subject, String comments) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		mailPOM.Login(search, name, email, subject, comments);
		screenShot.captureScreenShot("Send_mail");
	}
}
