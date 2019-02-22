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

import dataProviders.ConfigFileReader;
import managers.FileReaderManager;

public class HomePage {
	
	WebDriver driver;
	/*ConfigFileReader configFileReader;*/
	
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
	
	public void openAmazonWebsite() {
		System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
}
