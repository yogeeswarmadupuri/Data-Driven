package com.tr.genericlib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;



/**
 * WebDriver common utills.
 * class provide wendriver common libraries , which can be used to handle handle dynamic object , taking screenshot ..etc
 *
 * @author Deepak HR
 *
 */


public class Common {
	WebDriver driver;
	  public static String currentWindow;
	  protected static final int DEFAULTTIMEOUT = 30;
	  private static final String LOADING = "//span[contains(text(),'Report generated in')]";
	  protected static final int POLLING_INTERVAL = 2000;

	  
	
	public Common(WebDriver driver){
		this.driver = driver;	
	}
	
	  /**
	   * To wait entire page get download
	   */
	
	public void waitForPageToLoad(){

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	
	  /**
	   * To wait entire page get download
	   * @param pass linkname from the UI
	   */
	public void waitForLinkPresent(String linkText){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
		
	}
	
	
	
	  /**
	   * To wait entire page get download
	   * @param pass linkname from the UI
	   */
	public void waitForWbXpath(String wbXpath){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wbXpath)));
		
	}
	
	  /**
	   * To verify the text from the UI 
	   * @param pass webelemnet xpath & expected text needs to be verified
	   * @return returns boolean value true, if text is verified from the UI
	   */
	public boolean verifyText(String textXpath , String expectedText){
		boolean flag = false;
		String actText = driver.findElement(By.xpath(textXpath)).getText();
		
		if(expectedText.equals(actText)){
			flag = true;
			System.out.println(actText + " = text is verified");
		}else{
			System.out.println(actText + " = text is not verified");
		}
		return flag;
	}
	
	
	  /**
	   * To verify the text from the UI 
	   * @param pass webelemnet xpath & expected text needs to be verified
	   * @return returns boolean value , if text is verified from the UI
	   */
	public void select(String selBoxXpath , String visibleText){	
		WebElement selWb = driver.findElement(By.xpath(selBoxXpath));
		Select sel = new Select(selWb);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * To select the text from the Dropdown box based on index
	 * @param selBoxXpath, index
	 * 
	 */
		
	
	public void select(String selBoxXpath , int index){	
		WebElement selWb = driver.findElement(By.xpath(selBoxXpath));
		Select sel = new Select(selWb);
		sel.selectByIndex(index);
	}
	/**
	 * To select the text from the Dropdown box based on text
	 * @param selwb
	 * @param visibleText
	 */
	public void select(WebElement selwb , String visibleText){
		Select sel = new Select(selwb);
		sel.selectByVisibleText(visibleText);
	}
	
	
	/**
	 * To select accept for the alert popup
	 */
	
	public void acceptAlert(){
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}
	/**
	 * To select cancel for the alert popup
	 */
	public void cancelAlert(){
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
	}
	
	
	
	
	/**
	   * To create screen shot of web page.
	   *
	   * @param fileNameWithPath to store the screen shot
	   *
	   */
	  public void takeScreenShot(String fileNameWithPath) {

	      try {
	
	          File scrFile = (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
	          FileUtils.copyFile(scrFile, new File(fileNameWithPath));
	      } catch (Exception e) {
	         // logger.testLog(Level.INFO, "Failed to take the screenshot " + e);
	      }

	  }

	  
	  

	  
	  
	  /**
	   * To wait till the element present on page.
	   *
	   * @param By Element which has either the XPath or the ID or the Link Text
	   *
	   */
	  public void waitForWebElementPresent(WebElement element) {
	  	
	  	WebDriverWait wait = new WebDriverWait(driver, DEFAULTTIMEOUT);
	  	wait.until(ExpectedConditions.visibilityOf(element));
	  	
	  }
	  
	  /**
	   * To Verify the element present on page.
	   *
	   * @param By Element which has either the XPath or the ID or the Link Text
	   *
	   */
	  
	  public boolean verifyElementPresent(WebElement element) throws InterruptedException {
	  	boolean flag = false;
	  	int count = 0;
	  	while(count < 10)
	  	try{
	  	element.isDisplayed();
	  	flag = true;
	  	break;
	  	}catch(NoSuchElementException e){
	  		Thread.sleep(2000);
	  		count ++;
	  	}
	  	return flag;
	  }


	 

	  /**
	   * To wait till element disappear.
	   * @throws InterruptedException
	   */
	  public void waitForElementNotPresent(String xpath) throws InterruptedException {

	      try {

	          WebElement element = driver.findElement(By.xpath(xpath));
	          try {
	              while (element.isDisplayed()) {
	                  Thread.sleep(3000);
	                  element = driver.findElement(By.xpath(xpath));

	              }
	          } catch (StaleElementReferenceException ignored) {

	          }

	      } catch (NoSuchElementException e) {
	          //logger.testLog(Level.INFO, "Element is not displayed");
	      }

	  }
	  

	  
	  
	  /**
	   * To wait till element disappear.
	   * @throws InterruptedException
	   */
	  public void waitForElementNotPresent(By elementLocator) throws InterruptedException {
		  
		  

	      try {

	          WebElement element = driver.findElement(elementLocator);
	          try {
	              while (element.isDisplayed()) {
	                  Thread.sleep(3000);
	                  element = driver.findElement(elementLocator);

	              }
	          } catch (StaleElementReferenceException ignored) {

	          }

	      } catch (NoSuchElementException e) {
	          //logger.testLog(Level.INFO, "Element is not displayed");
	      }

	  }

	
	  /**
	   * To Verify the element present on the page passing the Id
	   * @param Id of the web element
	   */

	  public boolean isElementPresentByID(String Id) {

	      return isElementPresent(By.id(Id));

	  }

	  /**
	   * To Verify the element present on the page passing the XPath
	   * @param XPath of the web element
	   */

	  public boolean isElementPresentByXPath(String XPath) {

	      return isElementPresent(By.xpath(XPath));

	  }
	  /**
	   * To verify the webelement present on the page passing the webelement
	   */
	  public boolean isElementPresentByWebelement(WebElement webelement) {

	      return webelement.isDisplayed();

	  }
	  /**
	   * To Verify the element present on the page passing the Link Text
	   * @param Link Text of the web element
	   */

	  public boolean isElementPresentByLinkText(String linkText) {

	      return isElementPresent(By.linkText(linkText));

	  }

	  /**
	   * To Verify the element present on the page
	   * @param By Element
	   */

	  public boolean isElementPresent(By byElement) {
	      try {
	          if (driver.findElement(byElement).isDisplayed()) {

	             // logger.testLog(Level.INFO, "Element with the given xpath or ID exists: " + byElement.toString());
	              return true;
	          }
	         // logger.testLog(Level.INFO, "Could not find element with the given xpath or ID: " + byElement.toString());
	          return false;

	      } catch (NoSuchElementException ignored) {
	        //  logger.testLog(Level.INFO, "Could not find element with the given xpath or ID: " + byElement.toString());
	          return false;
	      }

	  }

	  /**
	   * @param webelement - web element upon which double click needs to be performed
	   * To simulate mouse double click on web page.
	   */

	  public void mouseDoubleClick(WebElement element) {
	      mouseClick("double", element);
	  }

	  /**
	   * @param webelement - web element upon which right click needs to be performed
	   * To simulate mouse right click on web page.
	   */

	  public void mouseRightClick(WebElement element) {
	      mouseClick("right", element);
	  }

	  /**
	   * @param action- double,right
	   * @param webelement - webelement upon which the required action needs to be performed
	   * To simulate mouse click on web page.
	   */

	  public void mouseClick(String action, WebElement element) {
	      try {
	          Actions builderq = new Actions(driver);
	          Action clickType = null;
	          if (action.equals("double")) {
	              clickType = builderq.doubleClick(element).build();

	          } else if (action.equals("right")) {
	              clickType = builderq.contextClick(element).build();

	          } else {
	             // logger.testLog(Level.INFO, "The action specified should be \"double\" or \"right\"");
	              return;
	          }
	          clickType.perform();
	      } catch (NoSuchElementException ignored) {
	          //logger.testLog(Level.ERROR, "Could not find the element with given xpath:" + element.toString());
	      }
	  }

	public void moveToElement(WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	/**
	 * To scroll down a page to the bottom
	 */
   
	public void scrolldowntoBottom(){
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}
	  /**
	   * To Click at hidden elements in a web page.
	   */
	  public void mouseClickAtHiddenElement(WebElement element) {
	      try {
	          ((JavascriptExecutor) driver).executeScript("return arguments[0].click();", element);
	      } catch (NoSuchElementException ignore) {
	      
	      }
	  }

	  /**
	   * @param WebElement element
	   * Returns the Status of Check Box Menuitem.
	   */

	  public boolean getCheckBoxStatus(WebElement element) {

	      //Get Check Box Menu Item Class Name
	      String checkMenuClassName = element.getAttribute("class").toString();
	      return checkMenuClassName.contains("x-menu-checked");
	  }

	  /**
	   * Checks if a check box is selected or not
	   * @param element
	   * @return boolean
	   */
	  public boolean isCheckBoxSelected(WebElement element) {

	      // Get Check Box Menu Item Class Name
	      String checkMenuClassName = element.getAttribute("class").toString();
	      boolean status = false;
	      if (checkMenuClassName.contains("x-menu-checked")) {
	          status = true;
	         // logger.testLog(Level.INFO, "<isCheckBoxSelected>: Check Box Status of " + element.toString() + " is " + status);
	      }
	      return status;
	  }

	  /**
	   * @param WebElement element
	   * Returns the Status of Button.
	   */

	  public boolean getButtonStatus(WebElement element) {

	      //Get Button Item Class Name
	      String buttonClassName = element.getAttribute("class").toString();
	      return !buttonClassName.contains("x-item-disabled");
	  }

	  /**
	   * @param WebElement element
	   * Returns view item status.
	   */

	  public boolean getViewItemStatus(WebElement element) {

	      //Get View Item Class Name
	      String viewItemClassName = element.getAttribute("class").toString();
	      return viewItemClassName.contains("x-view-item-sel");
	  }

	 

	  /**
	  <<<<
	   * Java script based mouse over function
	   * @param element, Target element to perform mouse launch
	   */
	  public void mouseOver(WebElement element) {
	      String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');" + "evObj.initEvent( 'mouseover', true, false );" + "fireOnThis.dispatchEvent(evObj);";
	      ((JavascriptExecutor) driver).executeScript(code, element);
	  }

	  /**
	   * Java script based mouse out function
	   * @param element, Target element to perform mouse launch
	   */
	  public void mouseOut(WebElement element) {
	      String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');" + "evObj.initEvent( 'mouseout', true, false );" + "fireOnThis.dispatchEvent(evObj);";
	      ((JavascriptExecutor) driver).executeScript(code, element);
	  }

	  /**
	   * method to generate random number
	   * return int
	   */
	  public static int getRandomNumber() {
	      Random random = new Random();
	      int randomNumber = random.nextInt(9999);
	      while (!(randomNumber > 0)) {
	          randomNumber = random.nextInt();
	      }
	      return randomNumber;
	  }

	
	  /**
	   * To clear existing text from text box.
	   * @param textboxElement
	   */
	  public void clearText(WebElement textboxElement) {
//	      textboxElement.sendKeys(Keys.END);
//	      int textBoxCharCount = textboxElement.getAttribute("value").length();
//	      for (int i = 0; i < textBoxCharCount; i++) {
//	          textboxElement.sendKeys(Keys.BACK_SPACE);
//	      }
		  textboxElement.clear();
	  }

	  /**
	   * Enters a text into the text box
	   * @param textboxElement
	   * @param textBoxValue
	   */
	  public void setTextBox(WebElement textboxElement, String textBoxValue) {

	      this.clearText(textboxElement);

	      textboxElement.sendKeys(textBoxValue);
	  }

	 


	  /**
	   *  Click Option in a Select List
	   *  @param WebElement selectElement, String optionValue
	   * @throws InterruptedException
	   */
	  public void clickOptionInSelectList(WebElement selectElement, String optionValue) throws InterruptedException {
	      // Then instantiate the Select class with that WebElement
	      Select select = new Select(selectElement);

	      // Get a list of the options
	      List<WebElement> options = select.getOptions();
	      // For each option in the list, verify if it's the one you want and then return that web element
	      for (WebElement we : options) {
	         // logger.testLog(Level.INFO, we.getText());
	          if (we.getText().equals(optionValue)) {
	              select.selectByVisibleText(optionValue);
	              this.waitForPageToLoad();
	          }
	      }

	  }

	 /**
	  * To select a value from the dropdown box for dynamically changing values
	  * @param selectElement
	  * @param optionValue
	  * @throws InterruptedException
	  */
	 public void selectDynamicValueFromWebList(WebElement selectElement, String optionValue) throws InterruptedException {
	     // Then instantiate the Select class with that WebElement
	     Select select = new Select(selectElement);

	     // Get a list of the options
	     List<WebElement> options = select.getOptions();
	     // For each option in the list, verify if it's the one you want and then return that web element
	     for(int k=0;k<options.size();k++) {
	        // logger.testLog(Level.INFO, we.getText());
	         if ((options.get(k).getText()).trim().contains(optionValue)) {
	             select.selectByIndex(k);

	             this.waitForPageToLoad();
	         }
	     }

	 }
	 /**
	  * To returns all the dropdown box values
	  * @param element
	  * @return
	  */
	 public List<WebElement> selectAllElements(WebElement element){
		 Select select=new Select(element);
		  List<WebElement> options = select.getOptions();
		  return options;
	 }

	
      /*
       * To get the current milli seconds
       */
	  public static Long getTimestamp() {
	      long millis = System.currentTimeMillis();
	      return millis;
	  }





	  /**
	   * Api will take screenshot [ filename will be auto generated based on method and class name]
	   * @param fileName
	   */
	  public static void takeScreenShot(Method method, WebDriver driverParam) {

	      String fullClassName = getFullClassName(method);
	      String fileName = fullClassName + ".jpeg";
	    //  logger.testLog(Level.INFO, "File Name is " + fileName);
	      String imageFolderPath = System.getProperty("IMAGE_FOLDER_PATH");
	      File dir = null;
	      try {
	          if (imageFolderPath == null) {
	              String userDir = System.getProperty("user.dir");

	              String path = userDir + File.separator + "images";
	              System.setProperty("IMAGE_FOLDER_PATH", path);
	            //  logger.testLog(Level.INFO, "Path is " + path);
	              dir = new File(path);
	              if (!dir.exists())
	                  dir.mkdir();
	          } else {
	              dir = new File(imageFolderPath);
	          }
	          WebDriver localDriver = new Augmenter().augment(driverParam);
	          File scrFile = (((TakesScreenshot) localDriver).getScreenshotAs(OutputType.FILE));
	          String screenShotFName = dir.getAbsoluteFile() + File.separator + fileName;
	          File oldFile = new File(screenShotFName);
	          if (oldFile.exists()) {
	              oldFile.delete();
	          }
	        //  FileUtils.moveFile(scrFile, new File(screenShotFName));
	          //logger.info("Have taken screen shot");

	      } catch (Exception e) {
	          e.printStackTrace();

	      }
	  }

	  /**
	   * API will return file name in a combination of method name and class name
	   * @param method
	   * @return
	   */
	  private static String getFullClassName(Method method) {
	      String methodName = method.toString();
	      Pattern p = Pattern.compile("([A-Za-z.]*)[\\(]");
	      Matcher m = p.matcher(methodName);
	      String result = "";
	      while (m.find()) {
	          result = m.group();
	      }
	      result = result.replaceAll("\\(", "").replaceAll("\\.", "_");

	      return result;
	  }



	  /*
	   * returns the time of the machine which runs this code in the format hh:mmAM/PM, dd MMM
	   * eg: 03:09PM, 25 Mar
	   */
	  public static String getCurrentSystemTime() throws Exception {
	      DateFormat dateFormat = new SimpleDateFormat("hh:mma, d MMM");
	      Date date = new Date();
	      String currentSystemTime = null;
	      currentSystemTime = dateFormat.format(date);
	      //logger.info("Curent System Time(Time of the Machine that executes the code):" + currentSystemTime);
	      return currentSystemTime;

	  }

	  /*This returns the result of the  test case*/
	  public static String getTestResult(ITestResult testResult)
	  {
	      String resultString=null;
	      try {
	        resultString="Execution result for "+testResult.getMethod().getMethodName()+" :"+ (testResult.isSuccess()?"PASSED":"FAILED" );
	        //logger.testCaseLog(resultString);
	      } catch (Exception e) {
	         // logger.error("Error while generating the test result from the ITestResult object Passed");
	      }
	      return resultString;
	  }

	  /**
	   * The methods returns the value in a text box
	   * @param textBoxElement
	   * @return
	   */
	  public static String getTextBoxValue(WebElement textBoxElement){
	      return textBoxElement.getAttribute("value");

	  }

	  /**
	   * This methoid will write the test case results in to file. In the format ClassName:TestCaseName:Status
	   * Example Format output: com.netapp.oc.testcases.featureIntegration.Volume.VolumeRecommendationTest:volume_space_event_thickVol_fixedSize_andThen_autogrow:1
	   * @param testResult
	   * @return
	   */
	  public static void writeTestResultInToFile(ITestResult testResult) {

	      getTestResult(testResult);
	      String msg;
	      try {
	          msg = testResult.getTestClass().getName() + ":" + testResult.getMethod().getDescription().split(":")[1].trim() + ":" + testResult.getStatus();
	      } catch (Exception ignored) {
	          msg = "";
	      }
	      try {

	          OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("Test_results.txt", true), "UTF-8");
	          BufferedWriter fbw = new BufferedWriter(writer);
	          fbw.write(msg);
	          fbw.newLine();
	          fbw.close();

	      } catch (Exception e) {
	          //logger.error("Error: " + e);
	      }
	  }
      /**
       * This method use to handle the Window popups
       * @return windowIds
       */
	  public HashMap<String, String> getwindowIDs() {
	  	HashMap<String, String> hashWindowLst = new HashMap<String, String>();
	  	Set setLst = driver.getWindowHandles();
	  	Iterator<String> it = setLst.iterator();
	  	hashWindowLst.put("parentWindow" , it.next());
	  	hashWindowLst.put("childWindow" , it.next());
	  	
			return hashWindowLst;    
	  }
	  
	  
	 
		
		/**
		 * Method to drag and drop web element. 
		 * @param source
		 * @param target
		 */
		public void dragAndDrop(WebElement source, WebElement target){
			  Actions builder = new Actions(driver);	  
			  Action dragAndDrop = builder.clickAndHold(source)
			     .moveToElement(target)
			     .release(target)
			     .build();

			  dragAndDrop.perform();
		}
	
	   /**
	    * Method to close the unexpected popup 
	    */
		public void colseUnexpetedWindow(){
			String currentWindow = driver.getWindowHandle();
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String actWindow = it.next();
				if(currentWindow.equals(actWindow)){
					
				}else{
					driver.switchTo().window(actWindow);
					driver.close();
				}
				
			}
			
		}
	   /** 
	    * Method is use to refresh the Page
	    */
	 
	   public void refreshPage()
	   {
		driver.navigate().refresh();
	   }
	
	  /**
	   * Method to get Current page Url
	   * 
	   */
	   public String getCurrentPageUrl()
	   {
		return driver.getCurrentUrl();
	   }
	
	   /**
		 * Method to get Current page Title
		 * 
	     */
	   public String getCurrentPageTitle()
		{
		 return driver.getTitle();
	    }
		
	  /**
	   * Method to Scroll Down the Page 
	   * @return
	   */
	  public void scrollDownPage(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	   }	
	
	  /**
	   * Method to Scroll Down the Page to Specific Webelement
	   * @return
	   */
	  public void scrolldoDownToWebelement(String wbXpath){
	 	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(wbXpath)));
	   }
	
	  /**
	   * Method to Switch to frame
	   * 
	   */
	  public void switchToFrame(WebElement webElement){
		driver.switchTo().frame(webElement);
	  }
	 /**
	  * method to select webLink
	  * @param linkName
	  * @return webelement
	  */
	
	 public WebElement selectLink(String linkName){
		return driver.findElement(By.linkText(linkName));
	  }
	 /**
	  * method to select partialwebLink
	  * @param partialLinkName
	  * @return webelement
	  */
	public WebElement selectpartialLink(String partialLinkName){
		return driver.findElement(By.partialLinkText(partialLinkName));
	 }
	
	public WebElement getWebElement(String elementxpath){
		return driver.findElement(By.xpath(elementxpath));
	}
	/**
	 * Method to handle multiple windows
	 * @param epectedWindowTitle
	 * @return String
	 */
	public String expectedWindow(String epectedWindowTitle){
		String requriedWindowID = null;
		currentWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		it.next();
		while(it.hasNext()){
			String actWindow = it.next();
			driver.switchTo().window(actWindow);
			if(epectedWindowTitle.equals(driver.getTitle())){
				requriedWindowID = actWindow;
				System.out.println("catch =" + requriedWindowID);
				
			}else{		
				
				driver.close();
			
			}
			
		}
		return requriedWindowID;
	}

}
