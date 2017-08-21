package com.tr.accounts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
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
import com.tr.pageLib.Contacts;
import com.tr.pageLib.Interviews;
import com.tr.pageLib.JobApplicants;
import com.tr.pageLib.Jobs;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.workflowlib.InitializationClass;

public class CreateMultipleAccTest {
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
	}

	@Test
	public void createMultipleAcc() throws InvalidFormatException, IOException {
		for (int i = 1; i <= 4; i++) 
	      {
			String accName = eLib.getExcelData("Account", "TC_01", "Account Name"+i+"");
			System.out.println(accName);
		    accountPage = alltabsPage.navigateToAccountsPage();
			accountPage.createAccount(accName);
			common.waitForPageToLoad();
			common.selectLink("Accounts").click();
		 }
	}

	@AfterClass
	public void configAfterclass() {
		init.logout();
		init.quitBrowser();
	}
}
