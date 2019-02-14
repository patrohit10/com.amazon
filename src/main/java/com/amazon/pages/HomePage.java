package com.amazon.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
	private WebElement searchTxt;
	
	/*Method for Searching item */
	public void searchItem(String productName) {
		searchTxt.sendKeys(productName);
		searchTxt.sendKeys(Keys.ENTER);
	}
	
	
}
