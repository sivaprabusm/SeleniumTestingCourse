package org.maventest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utilities.BaseClass;

public class Facebook_Login extends BaseClass{
	public static void main(String[] args) {
		launchChrome();
		getUrl("https://www.facebook.com/");
		winMax();
		printTitle();
		printCurrentUrl();
		WebElement loginId = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement loginBtn = driver.findElement(By.name("login"));
		
		fill(loginId, "greenstech");
		fill(password, "greens_123");
		btnClick(loginBtn);
		
	}
}
