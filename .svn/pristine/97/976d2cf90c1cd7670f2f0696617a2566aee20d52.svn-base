package com.tr.pageLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tr.genericlib.Common;
import com.tr.trbuisneslib.HandlingPopUps;
/**
 * contact Page Libraries.
 * class provide webdriver contact Page libraries , which can be used to create contact,delete contact  etc
 *
 * @author Deepak HR
 *
 */
public class Contacts {
	
	public WebDriver driver;
	public Common common;
	HandlingPopUps hp;
	
	
	public Contacts(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);
		this.hp=new HandlingPopUps(driver);
	}
	String popuptitle="Search ~ salesforce.com - Developer Edition";
	
		@FindBy(xpath="//input[@name='new']")
		private WebElement newButton;
		
	
	@FindBy(id="p3")
	private WebElement selectContactType;
	
	@FindBy(xpath="//td[label[contains(text(),'Account Name')]]/following-sibling::td/span/input")
	private WebElement accNameEdt;
	
	@FindBy(xpath="//td[label[contains(text(),'First Name')]]/following-sibling::td/input")
	private WebElement firstNameEdt;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//td[label[contains(text(),'Last Name')]]/following-sibling::td/div/input")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//td[label[contains(text(),'Recruiter')]]/following-sibling::td/div/select")
	private WebElement recruiteSel;
	
	@FindBy(xpath="(//td[label[contains(text(),'Publish')]]/following-sibling::td/input[@type='checkbox'])[1]")
	private WebElement publishCbox;
	
	@FindBy(xpath="(//td[label[contains(text(),'Candidate Status')]]/following-sibling::td/span/select)[1]")
	private WebElement candidateSourceLst;
	
	@FindBy(xpath="(//td[label[contains(text(),'Resume Source')]]/following-sibling::td/span/select)[1]")
	private WebElement resumeSourceLst;
	
	@FindBy(xpath="(//td[label[contains(text(),'Experience')]]/following-sibling::td/span/select)[1]")
	private WebElement experienceLst;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//select[@id='fcf']")
	private WebElement selectView;
	
	@FindBy(xpath="//select[@id='fcf']/following-sibling::input[@name='go']")
	private WebElement goBtn;
	
	@FindBy(xpath="//div[contains(@class,'row-first')]/following-sibling::div[4]/descendant::input")
	private WebElement clkOncheckBox;
	
	@FindBy(xpath="//div[contains(@class,'row-first')]/following-sibling::div[1]/descendant::a[contains(@onclick,'confirmDelete')]")
	private WebElement confirmDeleteLink;

	@FindBy(xpath="//span[text()='Jobs']")
	private WebElement jobsLink;
	
	@FindBy(xpath="//input[@value='New Job']")
    private WebElement newJobBtn;
	
	@FindBy(xpath="//td[@id='topButtonRow']/descendant::input[@name='clone']")
	private WebElement cloneBtn;
	
	@FindBy(xpath="//div[@id='contactHeaderRow']/descendant::h2")
	private WebElement verContact;
	
	@FindBy(xpath="//td[label[text()='Account Name']]/following-sibling::td/span/a/img")
	private WebElement accNamelookupBtn;
	
	@FindBy(xpath="//td[label[text()='Account']]/following-sibling::td/span/a/img")
	private WebElement acclookUpBtn;
	
	@FindBy(xpath="//frame[@id='searchFrame']")
	private WebElement searchFrameElement;
	
	@FindBy(xpath="//frame[@id='resultsFrame']")
	private WebElement resultFrameElement;
	
	@FindBy(xpath="//label[text()='Search']")
	private WebElement searchBtnfromLookupIcon;
	
	@FindBy(xpath="//input[@name='lksrch']")
	private WebElement searchBtnFromAccLookUPIcon;
	
	@FindBy(xpath="//label[text()='Search']/following-sibling::input[@name='go']")
	private WebElement goBtnfromLookupIcon;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//td[label[text()='Title']]/following-sibling::td[1]/input")
	private WebElement titleEdt;
	
	@FindBy(xpath="//h2[@class='topName']")
	private WebElement topName;
	
	@FindBy(xpath="//td[label[text()='Mailing City']]/following-sibling::td[1]/input")
	private WebElement mailingCity;
	
	@FindBy(xpath="//td[label[text()='Mailing State/Province']]/following-sibling::td[1]/input")
	private WebElement mailingState;
	
	@FindBy(xpath="//td[label[text()='Mailing Country']]/following-sibling::td[1]/input")
	private WebElement mailingCountry;
	
	@FindBy(xpath="//td[label[text()='Mailing Zip/Postal Code']]/following-sibling::td[1]/input")
	private WebElement postalcodeEdt;
	
	/**
	 * This method to create candidate
	 * @param candifirstName
	 * @param candiLastName
	 */
	public void createCandidate(String candifirstName , String candiLastName){
		selectContact("Candidate");
		firstNameEdt.sendKeys(candifirstName);
		lastNameEdt.sendKeys(candiLastName);
		publishCbox.click();
		saveRecord();
	}
	
	/**
	 * This method to create candidate/contact with below param's
	 * @param candifirstName
	 * @param LastName
	 * @param accName
	 */
	public void createCandidate(String candifirstName , String LastName , String acctName,String contactType){
		selectContact(contactType);
		firstNameEdt.sendKeys(candifirstName);
		lastNameEdt.sendKeys(LastName);
		accNameEdt.sendKeys(acctName);
		saveRecord();
	}
	
	/**
	 * This method to create contact s
	 * @param firstName
	 * @param lastName
	 */
	public void createContact(String firstName,String lastName){		
		selectContact("Contact");
		firstNameEdt.sendKeys(firstName);
		lastNameEdt.sendKeys(lastName);
		saveRecord();
	}
	
	/**
	 * method to select accountName from the look up button
	 * @param accName
	 */
	public void selectacc(String accName){
		hp.lookUpPopupHandling(accNamelookupBtn,popuptitle, searchFrameElement,
		searchBtnFromAccLookUPIcon, accName, goBtnfromLookupIcon, resultFrameElement, accName);
	}
	
	/**
	 * method to create account using below params
	 * @param accName
	 * @param firstName
	 * @param lastName
	 * @param title
	 */
	public void createcontWithAcc(String accName,String firstName,String lastName,String title,String contactType){
		selectContact(contactType);
		selectacc(accName);
		firstNameEdt.sendKeys(firstName);
		lastNameEdt.sendKeys(lastName);
		titleEdt.sendKeys(title);
	}
	
	public void saveRecord(){
		saveBtn.click();
		common.waitForPageToLoad();	
		Assert.assertTrue(topName.isDisplayed(), "contact is not created");
	}
	
	public void adressInformation(String cityName,String countryName,String stateName,String postalCode){
		mailingCity.clear();
		mailingCity.sendKeys(cityName);
		mailingCountry.clear();
		mailingCountry.sendKeys(countryName);
		mailingState.clear();
		mailingState.sendKeys(stateName);
		postalcodeEdt.clear();
		postalcodeEdt.sendKeys(postalCode);
	}
	/**
	 * This method to create candidate with below param's
	 * @param candifirstName
	 * @param candiLastName
	 */
	public void selectContact(String contact){
		newButton.click();
		common.waitForPageToLoad();
		common.select(selectContactType, contact);
		continueBtn.click();
		common.waitForPageToLoad();
		
	}
    
	/**
	 * This method to delete contact
	 * @param typeOfContactView
	 * 
	 */
	public void deleteContact(String contactName){
		common.selectLink(contactName).click();
		common.waitForPageToLoad();
		deleteBtn.click();
		common.acceptAlert();
		common.waitForPageToLoad();
	}
	/**
	 * This method to select contactType from Acounts
	 * @param typeOfContactView
	 * 
	 */
	public void selectContType(String contact)
	{
		common.select(selectContactType, contact);
		continueBtn.click();
		common.waitForPageToLoad();
	 }
	/**
	 * This method to create Contact from AccountsPage
	 *  without using New button 
	 * @param contactName
	 */
	public void createContactFromAcc(String contactName,String accountName){		
		selectContType("Contact");
		lastNameEdt.sendKeys(contactName);
		accNamelookupBtn.click();
        String childId=common.expectedWindow("Search ~ salesforce.com - Developer Edition");
        driver.switchTo().window(childId);
        common.switchToFrame(searchFrameElement);
        searchBtnfromLookupIcon.sendKeys(accountName);
        goBtnfromLookupIcon.click();
        driver.switchTo().defaultContent();
        common.switchToFrame(resultFrameElement);
        common.selectLink(accountName);
        driver.switchTo().window(common.currentWindow);
		saveBtn.click();
		common.waitForPageToLoad();
	}
	/**
	 * This method to select a job related link from the Contacts page
	 *  @param Jobspage
	 */
	public Jobs selectJob(String accountName){
	 jobsLink.click();
	 newJobBtn.click();
	 acclookUpBtn.click();
	 String childId=common.expectedWindow("Search ~ salesforce.com - Developer Edition");
     driver.switchTo().window(childId);
     common.switchToFrame(searchFrameElement);
     searchBtnFromAccLookUPIcon.sendKeys(accountName);
     goBtnfromLookupIcon.click();
     driver.switchTo().defaultContent();
     common.switchToFrame(resultFrameElement);
     common.selectLink(accountName).click();
     driver.switchTo().window(common.currentWindow);
     common.waitForPageToLoad();
	 return PageFactory.initElements(driver, Jobs.class);
	}
	
	/**
	 * This method to select a single candidate from the candidate list
	 *  @param contactName
	 */
	public void selectCandidateNameInList(String contactName){
		WebElement contactLink=common.selectLink(contactName);
		contactLink.click();
	}
	/**
	 * This method to clone the candidate Details 
	 * 
	 */
	public void cloneCandidate(String contactName,String candfirstName,String candLastName){
		selectCandidateNameInList(contactName);
		common.waitForPageToLoad();
		cloneBtn.click();
		firstNameEdt.clear();
		firstNameEdt.sendKeys(candfirstName);
		lastNameEdt.clear();
		lastNameEdt.sendKeys(candLastName);
		saveBtn.click();
		common.waitForPageToLoad();
		Assert.assertEquals(verContact.getText(), candfirstName+" "+candLastName);    
	}
	public HomePage verifyCandDetails(){
		return PageFactory.initElements(driver, HomePage.class);
	}
}
