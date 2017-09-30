package com.test.selenium;

import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;  
import org.testng.Assert;  

//import org.apache.commons.collections.CollectionUtils;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;  

import com.test.module.TestFoundation;

public class TestBaiduSearch extends TestFoundation {
	
	private static String SYSTEM = "https://www.baidu.com";
	private static String PATH = "";
	private static String USERNAME = "test";
	private static String PASSWORD = "123456";
	private static String BROWSER = "chrome";
	
	public TestBaiduSearch() {
		super(SYSTEM, PATH, USERNAME, PASSWORD, BROWSER);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		super.setUp();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testBaiduSearch01() throws InterruptedException {
		/* ###### */ P.println("Test BaiduSearch01 started"); /* ###### */
		Thread.sleep(1500);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("kw"))).clear();
		Thread.sleep(500);
		/* ###### */ P.println("clear the input area of baidu search"); /* ###### */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("kw"))).sendKeys("selenium");
		Thread.sleep(500);
		/* ###### */ P.println("input text 'selenium' into text area"); /* ###### */
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("su"))).click();
		/* ###### */ P.println("click button to trigger search"); /* ###### */
		Thread.sleep(2500);
		/* ###### */ P.println("current test case is over"); /* ###### */
	}
	
	@Test
	public void testBaiduSearch02() throws InterruptedException {
		/* ###### */ P.println("Test BaiduSearch02 started"); /* ###### */
		Thread.sleep(1500);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("kw"))).clear();
		Thread.sleep(500);
		/* ###### */ P.println("clear           w12the input area of baidu search"); /* ###### */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("kw"))).sendKeys("webdriver");
		Thread.sleep(500);
		/* ###### */ P.println("input text 'webdriver' into text area"); /* ###### */
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("su"))).click();
		/* ###### */ P.println("click button to trigger search"); /* ###### */
		Thread.sleep(2500);
		/* ###### */ P.println("current test case is over"); /* ###### */
	}
	
	@Test
	public void testBaiduSearch03() throws InterruptedException {
		/* ###### */ P.println("Test BaiduSearch03 started"); /* ###### */
		Thread.sleep(1500);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("kw"))).clear();
		Thread.sleep(500);
		/* ###### */ P.println("clear the input area of baidu search"); /* ###### */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("kw"))).sendKeys("appium");
		Thread.sleep(500);
		/* ###### */ P.println("input text 'appium' into text area"); /* ###### */
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("su"))).click();
		/* ###### */ P.println("click button to trigger search"); /* ###### */
		Thread.sleep(2500);
		/* ###### */ P.println("current test case is over"); /* ###### */
	}

}
