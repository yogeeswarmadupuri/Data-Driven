package com.tr.accountTest;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.Common;
import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.Accounts;
import com.tr.pageLib.AllTabs;
import com.tr.workflowlib.InitializationClass;
/**
 * .TR_Eend2EndTest scripts
 *  class provide TR_Eend2EndTest scripts, which can be used to verify the longitude value and latitude value .
 *
 * @author Dileep HE
 *
 */
public class VerifyMappingValueTest {

	/*
	 * object Initialization
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	Accounts accountPage;
	InitializationClass init;
	ExtLogger logger;
	Common common;
	
	/*
	 * Login to TR application
	 */
	@BeforeClass
	public void configBeforeClass(XmlTest config){
	    
		logger = ExtLogger.getLogger(VerifyMappingValueTest.class);
		init = new InitializationClass();
		eLib = new ExcelLIb();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		
	}
	
	@Test
	public void verifyMappingValue(XmlTest config) throws InvalidFormatException, IOException, InterruptedException{
		
		logger.testStepLog("Step 1: get test data from excel");
		
		String accName        = eLib.getExcelData("Data", "TC_09", "Account Name");
		String billingCity    = eLib.getExcelData("Data", "TC_09", "BillingCity");
		String billingState   = eLib.getExcelData("Data", "TC_09", "BillingState");
		String zipCode ="98108";
		String billingCountry = eLib.getExcelData("Data", "TC_09", "BillingCountry");

		
		logger.testStepLog("Step 2: create account ");
		accountPage = alltabsPage.navigateToAccountsPage();
		accountPage.createAccount(accName, billingCity, billingState, zipCode, billingCountry);
		System.out.println(accName);
		logger.testStepLog("Step 3: verify latitude value ");
		String latitudeAndLangitudeValue=accountPage.verifyLatitudeValue();
        logger.testStepLog(latitudeAndLangitudeValue);
     }
	/*
	 * Logout From the Application
	 */
	@AfterClass
	public void configAfterclass(){
		init.logout();
		init.quitBrowser();
	}

}