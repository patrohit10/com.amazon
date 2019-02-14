package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@title='Samsung Galaxy A7 (Blue, 4GB RAM and 64GB Storage) with Offer']")
	private WebElement productTitle;
	
	
	public void selectProduct() {
		productTitle.click();
		
	}
}
