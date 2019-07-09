package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RETC_075DataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_075POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_075Test {
	
	private WebDriver driver;
	private String baseUrl;
	private RETC_075POM postPOM;
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
		postPOM = new RETC_075POM(driver);
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


	@Test(dataProvider = "excel-inputs1", dataProviderClass = RETC_075DataProviders.class)
	public void NewPost(String username, String password, String addCat, String parentValue, String titlePost) throws InterruptedException
	{
		postPOM.Login(username, password);
		postPOM.AddNewCat(addCat, parentValue, titlePost);
	}

}
