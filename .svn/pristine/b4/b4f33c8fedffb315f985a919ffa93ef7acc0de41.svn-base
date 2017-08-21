package com.tr.pageLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tr.genericlib.Common;
import com.tr.logger.ExtLogger;
import com.tr.sampletest.VerifyMappingValueTest;


public class EtcObectsPage {
	public WebDriver driver;
	public Common common;
	public ExtLogger logger = ExtLogger.getLogger(VerifyMappingValueTest.class);

	
	public EtcObectsPage(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);	
	}

	
	@FindBy(xpath="//tr[th[text()='ETCObject Name']]/following-sibling::tr[1]/th/a")
	private WebElement etcObjectName;
	
	@FindBy(xpath="//tr[th[text()='ETCObject Name']]/following-sibling::tr[1]/td[1]")
	private WebElement name;
	
	@FindBy(xpath="//tr[th[text()='ETCObject Name']]/following-sibling::tr[1]/td[3]")
	private WebElement etcStatus;
	
	 public void verEtcDetails(){
		String etcObjName =etcObjectName.getText();
		String etcname =name.getText();
		String status= etcStatus.getText();
		logger.info("ETCObjectName==="+etcObjName);
		logger.info("ETCName==="+etcname);
		logger.info("ETCStatus==="+status);
        driver.quit();
	 }
   }
