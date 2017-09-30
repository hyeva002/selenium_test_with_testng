package com.test.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logon {

	private WebDriver driver;

	public Logon(WebDriver driver) {
		this.driver = driver;
	}
    /*
	public void logon(String username, String password) {
		driver.findElement(By.id("xs_username-inner")).clear();
		driver.findElement(By.id("xs_username-inner")).sendKeys(username);
		driver.findElement(By.id("xs_password-inner")).clear();
		driver.findElement(By.id("xs_password-inner")).sendKeys(password);
		driver.findElement(By.id("logon_button")).click();
	}
	*/
}
