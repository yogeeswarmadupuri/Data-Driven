package com.tr.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
  
/**
 * WebDriver driver class.
 * class provide wendriver driver libraries , which can be used to launch the different browsers like ,firefox,chrome etc
 *
 * @author Deepak HR
 *
 */

public class Driver {

	public static WebDriver driver;
	public static WebDriver getDriver(String browser){
		
		
		
		if (browser.equalsIgnoreCase("ie")){
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer(); 
			
	           capability = DesiredCapabilities.internetExplorer();
	            capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.ie.driver", "C:\\Users\\hunasd\\TargetRecruit\\TRFameWork\\resources\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
		}
			
		else if (browser.equalsIgnoreCase("chrome")) {
			//File file = new File("resources/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hunasd\\TargetRecruit\\TRFameWork\\resources\\chromedriver.exe");
	
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("safari")){
			
			DesiredCapabilities ca = DesiredCapabilities.safari();
			driver = new SafariDriver();
		}else{
			
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
}
