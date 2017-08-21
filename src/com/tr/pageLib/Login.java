package com.tr.pageLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tr.genericlib.Common;

/**
 * Login Page Libraries.
 * class provide webdriver Login Page libraries , which is used to Login and logout from the page . .etc
 *
 * @author Deepak HR
 *
 */
public class Login {
	public WebDriver driver;
	public Common common;
	
	
	
	public Login(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);
		
	}
	
	@FindBy(name="username")
	private WebElement userNameEdt;
	
	@FindBy(id="password")
	private WebElement passwordEdt;
	
	@FindBy(id="Login")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='userNav-arrow']")
	private WebElement logOutArrow;
	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logOutLnk;
	

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

/**
 * Method  to login for the home page
 * @param userNAme
 * @param password
 * @param url
 * @return
 */
	public SalesForceHomePage loginTOAPP(String userNAme , String password ,String url){
		driver.manage().window().maximize();
		driver.get(url);
		common.waitForWebElementPresent(userNameEdt);
		userNameEdt.sendKeys(userNAme);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		common.waitForPageToLoad();
		return PageFactory.initElements(driver, SalesForceHomePage.class);
	}
		
	/**
	 * 
	 * Method to  logout from the page
	 * 
	 */
	public void logOut(){
		
		common.waitForWebElementPresent(logOutArrow);
		logOutArrow.click();
		common.waitForWebElementPresent(logOutLnk);
		logOutLnk.click();
		common.waitForPageToLoad();
	}
	

}
