package com.tr.contact;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

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
  * This class implements a scenario to create a new contact with valid contact
  * details and valid address information and verify whether latitude value and longitude values are displaying are not
  * @author Dileep H.E
  *
  */
public class VerLangAndLatValueForNewCantactTest {
	
	/**
	 * Object initialization Steps to create scripts
	 */
	ExcelLIb eLib;
	WebDriver driver;
	AllTabs alltabsPage;
	InitializationClass init;
	ExtLogger logger;
	Contacts contactPage;
	HandlingPopUps popup;
	
	
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
  public void verLangAndLatToCantactTest() throws InvalidFormatException, IOException, InterruptedException
  {     
	    logger.testStepLog("Step 1: Get the data from excel"); 
	    
	    VerifyLangAndLatValue verify= PageFactory.initElements(Driver.driver, VerifyLangAndLatValue.class);
	    String firstName = eLib.getExcelData("Contact", "TC_03", "ContactFirstName");
		String lastName = eLib.getExcelData("Contact", "TC_03", "ContactLastName");
		String accName = eLib.getExcelData("Contact", "TC_03", "AccountName");
		String title = eLib.getExcelData("Contact", "TC_03", "Title");
		String contactType = eLib.getExcelData("Contact", "TC_03", "ContactType");
		String mailingCity = eLib.getExcelData("Contact", "TC_03", "MailingCity");
		String mailingState = eLib.getExcelData("Contact", "TC_03", "MailingState");
		String mailingCountry = eLib.getExcelData("Contact", "TC_03", "MailingCountry");
		String postalcode="98108";
		
		
		 logger.testStepLog("Step 2: create contact"); 
		 contactPage=alltabsPage.navigateToContactsPage();
		 contactPage.createcontWithAcc(accName, firstName, lastName,title,contactType);	
		 contactPage.adressInformation(mailingCity, mailingCountry, mailingState, postalcode);
		 contactPage.saveRecord();
		 
		 logger.testStepLog("Step 3: Verify langitude and latitude values for new contact"); 
		 verify.verifyLatitudeValue();
		 
  }	
      /**
       * Logout from browser
       */
  @AfterClass
	public void configAfterclass() 
  {
		init.logout();
		init.quitBrowser();
	}
}
