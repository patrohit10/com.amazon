package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='huc-v2-order-row-confirm-text']")
	private WebElement addedToCartLbl;
	
	public void validateAddToCartPage() {
		System.out.println(addedToCartLbl.getText());
	}
	
}
