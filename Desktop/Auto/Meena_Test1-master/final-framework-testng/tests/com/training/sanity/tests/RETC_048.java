package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_048 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		
		driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-multisite']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("region-add-toggle")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("newregion")).sendKeys("Electronic City");
		Thread.sleep(3000);
		Select s1=new Select(driver.findElement(By.name("newregion_parent")));
		s1.selectByValue("54");
		Thread.sleep(4000);
		driver.findElement(By.id("region-add-submit")).click();
		Thread.sleep(4000);
		Actions action = new Actions(driver);
	    action.sendKeys(Keys.F5);
	    Thread.sleep(5000);
	    driver.findElement(By.name("post_title")).sendKeys("prestige");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@class='wp-editor-area']")).sendKeys("home town");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id='in-property_feature-431']")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.name("publish")).click();
	    
		
		
		
		
		
		
	    
		
		
	}}