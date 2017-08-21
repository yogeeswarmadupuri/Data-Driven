package com.tr.accounts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.Common;
import com.tr.genericlib.Driver;
import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.Accounts;
import com.tr.pageLib.AllTabs;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.trbuisneslib.HandlingPopUps;
import com.tr.trbuisneslib.VerifyLangAndLatValue;
import com.tr.workflowlib.InitializationClass;

public class VerifyMapValueforAccTest {
	
	
	/**
	 * Object initialization To create an account
	 * 
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	InitializationClass init;
	ExtLogger logger;
	Accounts accountPage;
	Common common;
	HandlingPopUps popup;
	
	/**
	 * Login and navigate to all tabs page
	 * 
	 */
	@BeforeClass
	public void configBeforeClass(XmlTest config){
		logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
		init = new InitializationClass();
		eLib = new ExcelLIb();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		common =new Common(Driver.driver);
		popup=new HandlingPopUps(Driver.driver);
	}
   @Test
   public void VerifyMapValueforAccTest() throws InvalidFormatException, IOException, InterruptedException {
	  
	    logger.testStepLog("Step 1: get test data from excel");
		String accName        = eLib.getExcelData("Account", "TC_02", "AccountName");
		String billingCity    = eLib.getExcelData("Account", "TC_02", "BillingCity");
		String billingState   = eLib.getExcelData("Account", "TC_02", "BillingState");
		String billingCountry = eLib.getExcelData("Account", "TC_02", "BillingCountry");
		String postalcode = eLib.getExcelData("Account", "TC_02", "PostalCode");
		
		VerifyLangAndLatValue verify= PageFactory.initElements(Driver.driver, VerifyLangAndLatValue.class);
		
		logger.testStepLog("Step 2: Navigate to accounts page");
		popup.defaultPopUp();
		accountPage = alltabsPage.navigateToAccountsPage();
		
		logger.testStepLog("Step 3: Create an account and vrify latitude and langitude values");
		accountPage.createAccount(accName, billingCity, billingState, postalcode, billingCountry);
		verify.verifyLatitudeValue();
		
		logger.testStepLog("Step 4: Latitude and langitude are displayed and verified successfully");
	}
   /**
    * Logout and Quit the browser
    */
     @AfterClass
	 public void configAfterclass()
     {
    	init.logout();
		init.quitBrowser();
	}
}
