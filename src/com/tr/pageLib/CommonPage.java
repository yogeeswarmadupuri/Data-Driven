package com.tr.pageLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tr.genericlib.Common;

/**
 * common Page Libraries.
 * class provide webdriver common page libraries , which can be used to logout from the application etc
 *
 * @author Deepak HR
 *
 */
public class CommonPage {
	
	public WebDriver driver;
	public Common common;
	
	public CommonPage(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);
		
	}
	
	@FindBy(className="logoutImg")
	private WebElement logoutImg;


	public void logout(){
		logoutImg.click();
	}
	
	

}
