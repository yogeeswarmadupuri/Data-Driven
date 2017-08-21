package com.tr.workflowlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.xml.XmlTest;

import com.tr.genericlib.Driver;
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Login;
import com.tr.pageLib.SalesForceHomePage;
/**
 * InitializationClass Libraries.
 * class provide webdriver InitializationClass libraries , which can be used to launch a browser and login to app etc...
 *
 * @author Deepak HR
 *
 */
public class InitializationClass {
	
	WebDriver driver;
	Login loginPage;
	
	public AllTabs loginToSalesForce(XmlTest config, String userName , String password , String url , String browser){		
		driver = Driver.getDriver(browser);
		loginPage = PageFactory.initElements(driver, Login.class);
		SalesForceHomePage homePage = loginPage.loginTOAPP(userName,password ,url);
		AllTabs alltabsPage = homePage.navigateAllTabsPage();
		
		return alltabsPage;
	}
	
	
	/**
	 * method to login for TR-application
	 */
	public void logout(){		
		loginPage.logOut();
	
	}
	/**
	 *  * method to logout from TR-application
	 */
	public void quitBrowser(){
		driver.quit();
	}

}
