package com.tr.contact;

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
import com.tr.pageLib.AllTabs;
import com.tr.pageLib.Contacts;
import com.tr.sampletest.TR_Eend2EndTest;
import com.tr.trbuisneslib.HandlingPopUps;
import com.tr.trbuisneslib.VerifyLangAndLatValue;
import com.tr.workflowlib.InitializationClass;

/**
 * This class implements a scenario to modify the address information like postal code, state name . country name
 * than verify whether corresponding latitude and longitude are changing alternatively or not
 * @author Dileep H.E
 *
 */
public class VerLatAndLongVlaueForExistingContactTest {

	/**
	 * 
	 * Object initialization Steps to create scripts
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	InitializationClass init;
	ExtLogger logger;
	Contacts contactPage;
	HandlingPopUps popup;
	Common common;
	
	@BeforeClass
	public void configBeforeClass(XmlTest config) {
		/**
		 * 
		 * Login and navigate to all tabs page
		 */
		logger = ExtLogger.getLogger(TR_Eend2EndTest.class);
		init = new InitializationClass();
		eLib = new ExcelLIb();
		popup=new HandlingPopUps(Driver.driver);
        alltabsPage = init.loginToSalesForce(config,
				config.getParameter("tr_username"),
				config.getParameter("tr_password"),
				config.getParameter("tr_url"), config.getParameter("browser"));
	}
	
  @Test
  public void verLatitudeValueToExistingContact() throws InvalidFormatException, IOException, InterruptedException 
  {
	  
	  logger.testStepLog("Step 1: get the excel from data");
	  
	  VerifyLangAndLatValue verifyLangAndLat= PageFactory.initElements(Driver.driver, VerifyLangAndLatValue.class);
	  String contactName = eLib.getExcelData("Contact", "TC_04", "ContactFirstName");
	  String mailingCity = eLib.getExcelData("Contact", "TC_04", "MailingCity");
	  String mailingState = eLib.getExcelData("Contact", "TC_04", "MailingState");
	  String mailingCountry = eLib.getExcelData("Contact", "TC_04", "MailingCountry"); 
	  String postalId="31406";
	
	  logger.testStepLog("Step 2: Navigate to contactPage"); 
      contactPage=alltabsPage.navigateToContactsPage();
      
      logger.testStepLog("Step 3: Select a contact than , change the postalId Nor And"
      		+ " verify wheather different langitude and lattitude values are displayed"); 
      verifyLangAndLat.verifyLatitudeValueForExistingRecord(contactName, postalId, mailingCity, mailingCountry, mailingState);
      
      logger.testStepLog("Step 4: values are verified and it is working fine"); 
  }
  
  /**
   * 
   * Logout from browser
   */
	@AfterClass
	public void configAfterclass() {
		init.logout();
		init.quitBrowser();
	}
}
