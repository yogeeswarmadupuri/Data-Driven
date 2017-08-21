package com.tr.pageLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.tr.genericlib.Common;
/**
 * SalesForceHomePage Libraries.
 * class provide webdriver SalesForceHomePage libraries , which can be used to navigate to alltabs page etc
 *
 * @author Deepak HR
 *
 */

public class SalesForceHomePage {
	public WebDriver driver;
	public Common common;
	
	
	
	public SalesForceHomePage(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);
		
	}
	
	@FindBy(xpath="//img[@class='allTabsArrow']")
	private WebElement showMoresymbol;
	
	@FindBy(xpath="//td/a[text()='Accounts']")
	private WebElement passwordEdt;
	
	@FindBy(id="Login")
	private WebElement loginBtn;

	public WebElement getShowMoresymbol() {
		return showMoresymbol;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

    /**
     * Method use to navigate to all tabs page
     * @return alltabspage
     */
	public AllTabs navigateAllTabsPage(){
		common.waitForWebElementPresent(showMoresymbol);
		showMoresymbol.click();
		common.waitForPageToLoad();
		return PageFactory.initElements(driver, AllTabs.class);
		
		
	}

}
