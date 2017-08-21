package com.tr.accounts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.tr.genericlib.ExcelLIb;
import com.tr.logger.ExtLogger;
import com.tr.pageLib.Accounts;
import com.tr.pageLib.AllTabs;
import com.tr.workflowlib.InitializationClass;
/**
 * .TR_Eend2EndTest scripts
 *  class provide TR_Eend2EndTest scripts, which can be used to delete account .
 *
 * @author Dileep HE
 *
 */
public class DeleteAccountTest {

	/*
	 * object Initialization
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	Accounts accountPage;
	InitializationClass init;
	ExtLogger logger;
	
	
	/*
	 * Login to TR application
	 */
	@BeforeClass
	public void configBeforeClass(XmlTest config){
		// create object intilization

		eLib = new ExcelLIb();
		logger = ExtLogger.getLogger(DeleteAccountTest.class);
		init = new InitializationClass();
		alltabsPage = init.loginToSalesForce(config, config.getParameter("tr_username"), config.getParameter("tr_password"), config.getParameter("tr_url"), config.getParameter("browser"));
		
	}
	
	
	@Test
	public void test(XmlTest config) throws InvalidFormatException, IOException{
		
		logger.testStepLog("Step 1: get test data from excel");
	    String accountName=eLib.getExcelData("Account", "TC_06", "AccountName");
	    System.out.println(accountName);
	    
		logger.testStepLog("Step 2: Delete an account");
		accountPage = alltabsPage.navigateToAccountsPage();
		accountPage.deleteAccount(accountName);
		logger.testStepLog("Step 2: Account is deleted Successfully");
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
