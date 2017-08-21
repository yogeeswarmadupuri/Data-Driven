package com.mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstProgram {
public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://google.com");
}
}
