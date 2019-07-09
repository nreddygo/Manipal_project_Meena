package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_074POM {
	
private WebDriver driver; 
	
	public RETC_074POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement username; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-users")
	private WebElement user; 
	
	@FindBy(linkText="All Users")
	private WebElement all_user;
	
	@FindBy(id="user_180")
	private WebElement user_link;
	
	@FindBy(id="new_role")
	private WebElement new_role;
	
	@FindBy(id="changeit")
	private WebElement change;
	
	@FindBy(id="message")
	private WebElement message;
	
	
	public void Login(String username,String password) throws InterruptedException {
		this.username.clear();
		this.username.sendKeys(username);
		this.password.clear(); 
		this.password.sendKeys(password); 
		this.loginBtn.click(); 
		Thread.sleep(3000);
	}
	
	public String RoleChange(String new_role) throws InterruptedException {
		String Actual;
		Actions act = new Actions(driver);
		act.moveToElement(user).build().perform();
		act.sendKeys(this.all_user,Keys.ENTER).build().perform();
		Thread.sleep(3000);
		this.user_link.click();
		Select se = new Select(this.new_role);
		se.selectByValue(new_role);
		Thread.sleep(3000);
		this.change.click();
		Actual = this.message.getText();
		return Actual;
		
	}

}
