package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_075POM {
	
private WebDriver driver; 
	
	public RETC_075POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement username;
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login_button;
	
	@FindBy(id="menu-posts")
	private WebElement post;
	
	@FindBy(xpath="//a[@href='post-new.php']")
	private WebElement addNew;
	
	@FindBy(id="category-add-toggle")
	private WebElement addCatlink;
	
	@FindBy(id="newcategory")
	private WebElement addCat;
	
	@FindBy(id="newcategory_parent")
	private WebElement parentfrom;
	
	@FindBy(id="category-add-submit")
	private WebElement addCatButton;
	
	@FindBy(name="post_title")
	private WebElement titlePost;
	
	@FindBy(name="publish")
	private WebElement publish;
	
	@FindBy(id="wp-admin-bar-my-account")
	private WebElement howdy;
	
	@FindBy(id="wp-admin-bar-logout")
	private WebElement logOut;
	
	@FindBy(linkText="Real Estate")
	private WebElement realEstate; 
	
	@FindBy(xpath="//*[@name='phrase' and @type='search']")
	private WebElement search;
	
	@FindBy(css="span.overlap")
	private WebElement search_click; 
	
	
	public void Login(String username, String password) throws InterruptedException
	{
		this.username.clear();
		this.username.sendKeys(username);
		this.password.clear();
		this.password.sendKeys(password);
		this.login_button.click();
		Thread.sleep(3000);
	}
	
	
	public void AddNewCat(String addCat,String parentValue,String titlePost) throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(this.post).build().perform();
		this.addNew.click();
		Thread.sleep(3000);
		this.addCatlink.click();
		this.addCat.sendKeys(addCat);
		Select se = new Select(this.parentfrom);
		se.selectByValue(parentValue);
		this.addCatButton.click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		this.titlePost.sendKeys(titlePost);
		this.publish.click();
		Thread.sleep(3000);
		act.moveToElement(this.howdy).build().perform();
		this.logOut.click();
		Thread.sleep(3000);
		this.realEstate.click();
		Thread.sleep(3000);
		this.search.sendKeys(titlePost);
		this.search_click.click();
		Thread.sleep(3000);
	}

	
}
