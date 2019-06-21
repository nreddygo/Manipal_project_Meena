package com.training.sanity.tests;

import java.awt.Desktop.Action;
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
import com.training.utility.Driver;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_049 {

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
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("//*[@id='wp-admin-bar-site-name']/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='menu-item menu-item-type-post_type menu-item-object-page menu-item-617']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='post-3595']/div/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='comment']")).sendKeys("Good");
		driver.findElement(By.xpath("//*[@id='author']")).sendKeys("Redddd");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("ng027m@gmail.com");
		
		driver.findElement(By.xpath("//*[@id='submit']")).click();
		Thread.sleep(5000);
		 
		driver.get(baseUrl);
	     
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		
	    driver.get("http://realestate.upskills.in/new-launches-3/");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@id='comment-1782']/div[2]/div[2]/a")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id='comment']")).sendKeys("Commentstd");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id='submit']")).click();
	    
	    
		
		    
		    
		    
		
		
		
		
		
	    
		
		
	}}