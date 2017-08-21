package com.tr.pageLib;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.tr.genericlib.Common;
import com.tr.logger.ExtLogger;
import com.tr.sampletest.VerifyMappingValueTest;

public class SetupPage {

	public WebDriver driver;
	public Common common;
	public ExtLogger logger = ExtLogger.getLogger(VerifyMappingValueTest.class);
	
	
	public SetupPage(WebDriver driver){
		this.driver = driver;
		this.common = new Common(driver);	
	}
	
	@FindBy(id="setupSearch")
	private WebElement setupSearchBox;
	
	@FindBy(linkText="Email Services")
	private WebElement emailServicesLink;
	
	@FindBy(linkText="EmailToCandidate")
	private WebElement emailToCandidateLink;
	
	@FindBy(xpath="//thead[tr[th[div[text()='Action']]]]/following-sibling::tbody/tr[1]/td/a")
	private WebElement emailAdress1;
	
    @FindBy(name="Email")
	  public WebElement gmailUn;
    
	@FindBy(name="Passwd")
	 public WebElement gmailPwd;
	
	@FindBy(name="signIn")
	 public WebElement gmailSignIn;
	
	@FindBy(xpath="//div[text()='COMPOSE']")
	 public WebElement gmailComposeBtn;
	
	@FindBy(name="to")
	 public WebElement gmailTo;
	
	@FindBy(name="subjectbox")
	 public WebElement gmailSubBox;
	
	@FindBy(xpath="//div[@id=':ot']")
     public WebElement gmailAttachBtn;
	
	@FindBy(xpath="//div[text()='Send']")
	 public WebElement clkSendBtn;
	
	@FindBy(xpath="//div[contains(text(),'Your message has been sent')]")
	 public WebElement verSentsuccessMsg;
	    
	
	public String getEmailAdress(String searchableName){
		setupSearchBox.sendKeys(searchableName);
		emailServicesLink.click();
		emailToCandidateLink.click();
		return emailAdress1.getText();
	}
	 /**
     * Method To create a Candidate through ETC from Gmail
     * @param url
     * @param un
     * @param pwd
     * @param toAdress
     * @param subj
     * @throws InterruptedException
     * @throws IOException
     */
    public void createEtcCandidate(String url,String un,String pwd,String toAdress,String subj) throws InterruptedException, IOException{
    	driver.navigate().to(url);
    	gmailUn.clear();
    	gmailUn.sendKeys(un);
    	gmailPwd.clear();
    	gmailPwd.sendKeys(pwd);
    	Thread.sleep(10000);
    	gmailSignIn.click();
    	Thread.sleep(5000);
    	gmailComposeBtn.click();
    	Thread.sleep(5000);
    	gmailTo.sendKeys(toAdress);
    	gmailSubBox.sendKeys(subj);
    	gmailAttachBtn.click();
    	Runtime.getRuntime().exec("E:\\TRFameWork\\AutoIT\\demo5.exe");
    	Thread.sleep(15000);
    	clkSendBtn.click();
    	Thread.sleep(12000);
    	common.waitForWebElementPresent(verSentsuccessMsg);
    	logger.info("verSentsuccessMsg====="+verSentsuccessMsg.getText());
    	Assert.assertTrue(verSentsuccessMsg.isDisplayed(), "sent message not displayed");
    	driver.findElement(By.xpath("//a[contains(@title,'Account')]")).click();
    	driver.findElement(By.xpath("//a[text()='Sign out']")).click();
    	driver.close();
    }   
    
}
