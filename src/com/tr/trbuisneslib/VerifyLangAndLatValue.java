package com.tr.trbuisneslib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tr.genericlib.Common;
import com.tr.genericlib.Driver;
import com.tr.pageLib.Contacts;
/**
 * class implements a methods to verify latitude and longitude values for new record as well as for existing record
 * @author Dileep H.E
 *
 */
public class VerifyLangAndLatValue {
	WebDriver driver;
	Common common;
	int count;
	boolean flag;
	Contacts contactPage;

	public VerifyLangAndLatValue(WebDriver driver) {
		this.driver = driver;
		this.common = new Common(Driver.driver);
	}

	@FindBy(xpath = "//td[text()='Longitude']/following-sibling::td[1]/div")
	private WebElement langitudeValue;

	@FindBy(xpath = "//td[text()='Latitude']/following-sibling::td[1]/div")
	private WebElement latitudeValue;

	@FindBy(xpath = "//td[@id='topButtonRow']/input[@name='edit']")
	private WebElement editBtn;

	@FindBy(xpath = "//td[label[text()='Mailing Zip/Postal Code']]/following-sibling::td[1]/input")
	private WebElement postalcodeEdt;

	@FindBy(xpath = "//td[@id='topButtonRow']/input[@name='save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//td[text()='Mapping Status']/following-sibling::td/div")
	private WebElement mappingStatus;

  /**
   * method to verify longitude latitude values 
   * 
   */
	public void verifyLatitudeValue() throws InterruptedException
	{  
	while(count<5){
		try{
		common.refreshPage();
		common.waitForWebElementPresent(langitudeValue);
		flag=true;
		break;
		}
		catch(Exception E){
			Thread.sleep(2000);
			count++;
		}
	}
		String lanValue=langitudeValue.getText();
		try
		{
		Assert.assertTrue(!(lanValue.trim().length()==0)&&(!(lanValue.trim().length()==0)), "Langitude value is empty");
		}
		catch(Throwable T){
			Assert.fail("Langitude and latitude  value is empty");
		}
	}

	/**
	 * method to verify latitude and longitude values are correspondingly changing or not when ever we change the values for existing record
	 * @param contactName
	 * @param newPostalcode
	 * @param cityName
	 * @param countryName
	 * @param stateName
	 * @throws InterruptedException
	 */
	public void verifyLatitudeValueForExistingRecord(String contactName,String newPostalcode,
			String cityName,String countryName,String stateName) throws InterruptedException
		{
		contactPage=PageFactory.initElements(Driver.driver, Contacts.class);
		common.selectLink(contactName).click();
		common.waitForPageToLoad();
		String existingLongValue=langitudeValue.getText();
		String existingLatvalue=latitudeValue.getText();
		common.mouseClickAtHiddenElement(editBtn);
		contactPage.adressInformation(cityName, countryName, stateName, newPostalcode);
		saveBtn.click();
		common.waitForPageToLoad();
		while(count<5){
			try{
			common.refreshPage();
			common.waitForWebElementPresent(langitudeValue);
			flag=true;
			break;
			}
			catch(Exception E){
				Thread.sleep(2000);
				count++;
			}
		}
		String modifiedLongValue=langitudeValue.getText();
		String modifiedLatvalue=latitudeValue.getText();
		Assert.assertNotEquals(existingLongValue, modifiedLongValue, "Latitude and langitde value is not changing eventhough if changed lattitude values");
		Assert.assertNotEquals(existingLatvalue, modifiedLatvalue, "Latitude and langitde value is not changing eventhough if changed lattitude values");
		Assert.assertTrue(mappingStatus.getText().equals("Located"), "mapping status not showing the status as Located");
	}
}
