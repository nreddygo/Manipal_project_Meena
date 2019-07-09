package com.training.pom;

import java.util.ArrayList;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MailSendPOM {
	
private WebDriver driver; 
	
	public MailSendPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Real Estate")
	private WebElement realEstate; 
	
	@FindBy(xpath="//*[@name='phrase' and @type='search']")
	private WebElement search;
	
	@FindBy(css="span.overlap")
	private WebElement search_click; 
	
	@FindBy(xpath="//*[@href='/contact/']")
	private WebElement drop_us; 
	
	@FindBy(xpath="//*[@type='text' and @name='name']")
	private WebElement name;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(name="id:comments")
	private WebElement comments;
	
	@FindBy(xpath="//*[@type='submit' and @value='Send']")
	private WebElement send;
	
	
	public void Login(String search,String name, String email, String subject, String comments) throws InterruptedException {
		this.realEstate.click();
		Thread.sleep(3000);
		this.search.sendKeys(search);
		this.search_click.click();
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);
		this.drop_us.click();
		Thread.sleep(3000);
		this.name.sendKeys(name);
		this.email.sendKeys(email);
		this.subject.sendKeys(subject);
		this.comments.sendKeys(comments);
		this.send.click();
	}
}
