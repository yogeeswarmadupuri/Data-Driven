package com.tr.pageLib;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tr.genericlib.Common;

/**
 * Account Page Libraries.
 * class provide webdriver account page libraries , which can be used create account, delete account ..etc
 *
 * @author Deepak HR
 *
 */

public class Accounts {
	
	
	public WebDriver driver;
	public Common common;
	
	
	
	public Accounts(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);	
	}
	
	
	@FindBy(xpath="//input[@name='new']")
	private WebElement newButton;
	
	@FindBy(xpath="//td[label[contains(text(),'Account Name')]]/following-sibling::td/div/input")
	private WebElement accNameEdt;
	
	@FindBy(xpath="(//td[label[contains(text(),'Account Number')]]/following-sibling::td/input)[1]")
	private WebElement accNumEdt;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//td[label[text()='Billing City']]/following-sibling::td[1]/input")
	private WebElement billingCityEdt;
	
	@FindBy(xpath="//td[label[text()='Billing State/Province']]/following-sibling::td[1]/input")
	private WebElement billingStateEdt;
	
	@FindBy(xpath="//td[label[text()='Billing Zip/Postal Code']]/following-sibling::td[1]/input")
	private WebElement zipCodeEdt;
	
	@FindBy(xpath="//td[label[text()='Billing Country']]/following-sibling::td[1]/input")
	private WebElement billingCountryEdt;
	
	@FindBy(xpath="//td[text()='Latitude']")
	private WebElement langitude;
	
	@FindBy(xpath="//td[text()='Longitude']/following-sibling::td[1]/div")
	private WebElement langitudeValue;
	
	@FindBy(xpath="//td[text()='Latitude']/following-sibling::td[1]/divs")
	private WebElement latitudeValue;
	
	@FindBy(xpath="//tr[th[text()='Account Name']]/following-sibling::tr[2]/th/a")
	private WebElement selectAccRecord;
	
	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//input[@value='New Contact']")
	private WebElement newContackBtn;
	
	/**
	 * To create a account
	 * @param accName
	 */
	public void createAccount(String accName){
		newButton.click();
		common.waitForPageToLoad();
		accNameEdt.sendKeys(accName);
		saveBtn.click();
		common.waitForPageToLoad();
		
	}
	/**
	 * To create an account using below param's
	 * @param accName
	 * @param billingCity
	 * @param billingState
	 * @param zipCode
	 * @param billingCountry
	 */
	public void createAccount(String accName,String billingCity,String billingState,String zipCode,String billingCountry){
		newButton.click();
		common.waitForPageToLoad();
		accNameEdt.sendKeys(accName);
		billingCityEdt.sendKeys(billingCity);
		billingStateEdt.sendKeys(billingState);
		zipCodeEdt.sendKeys(zipCode);
		billingCountryEdt.sendKeys(billingCountry);
		saveBtn.click();	
		common.waitForWebElementPresent(langitude);
	}
	
	/**
	 * This method is use to Verify the langitude value
	 * 
	 */
	public String verifyLatitudeValue(){
		common.refreshPage();
		String lanValue=langitudeValue.getText();
		System.out.println(lanValue);
		try{
		Assert.assertTrue(!(lanValue.trim().length()==0), "Langitude value is empty");
		}
		catch(Throwable T){
			common.takeScreenShot("C:\\Users\\hunasd\\TargetRecruit\\TRFameWork\\ScreenShots\\");
		}
		return lanValue+"latitude value============>"+latitudeValue.getText();
	}
	
	/**
	 * This method is use to delete the account
	 */
	public void deleteAccount(String accName){
		common.selectLink(accName).click();
		common.waitForPageToLoad();
		common.mouseClickAtHiddenElement(deleteBtn);
		common.acceptAlert();
		common.waitForPageToLoad();
	}
	/**
	 * This method is use to select contact from Account page
	 * @return Contactpage
	 */
	public Contacts selContactLink(){
		contactLink.click();
		newContackBtn.click();
		common.waitForPageToLoad();
		return PageFactory.initElements(driver, Contacts.class);
	}
}
