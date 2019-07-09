package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.training.bean.RETC_074Bean;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RETC_074DataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_074POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_074Test {
	private WebDriver driver;
	private String NewURL;
	private RETC_074POM rolePOM;
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
		rolePOM = new RETC_074POM(driver);
		NewURL = properties.getProperty("NewURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(NewURL);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = RETC_074DataProviders.class)
	public void loginDBTest(String username, String password,String new_role, String message) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		String Actual_str, Actual;
		rolePOM.Login(username, password);
		Actual_str = rolePOM.RoleChange(new_role);
		Actual = Actual_str.replace("\n", "");
		Actual = Actual.replace("Dismiss this notice.","");
		Assert.assertEquals(Actual, message);
		screenShot.captureScreenShot("username");

	}

}
