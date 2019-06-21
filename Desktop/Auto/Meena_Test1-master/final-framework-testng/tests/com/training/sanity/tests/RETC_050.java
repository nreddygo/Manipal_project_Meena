package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
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

public class RETC_050 {

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
		    driver.findElement(By.name("post_title")).sendKeys("prestige");
		    Thread.sleep(4000);
		    driver.findElement(By.xpath("//*[@class='wp-editor-area']")).sendKeys("home town");
		    Thread.sleep(4000);
		    driver.findElement(By.xpath("//*[@id='in-property_feature-436']")).click();
		    Thread.sleep(4000);
		    driver.findElement(By.xpath("//*[@id='in-region-61']")).click();
		    Thread.sleep(4000);
		    driver.findElement(By.xpath("//*[@class='submitdelete deletion']")).click();
		    Alert alert = driver.switchTo().alert();	
		    alert.accept();
		    
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/ul/li[5]")).click();
		   
		
		
		
		
		
	    
		
		
	}}