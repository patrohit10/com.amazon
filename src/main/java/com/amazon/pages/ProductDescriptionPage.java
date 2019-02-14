package com.amazon.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage {
	
	WebDriver driver;
	
	public ProductDescriptionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='productTitle']")
	private WebElement productTitleLbl ;
	@FindBy(xpath="//*[@class='a-text-strike']")
	private WebElement productMRPLbl ;
	@FindBy(xpath="//*[@id='priceblock_ourprice']")
	private WebElement productPriceLbl ;
	@FindBy(xpath="//td[@class='a-span12 a-color-price a-size-base']")
	private WebElement youSaveLbl ;
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCartBtn ;
	
	
	public void prodctDetails() {
		// Switch tabs
	    Set handles = driver.getWindowHandles();
		System.out.println(handles);
		// Pass a window handle to the other window
        for (String handle1 : driver.getWindowHandles()) {
        	System.out.println(handle1);
        	driver.switchTo().window(handle1);
         }
		System.out.println("Product title - "+productTitleLbl.getText());
		System.out.println("Product MRP - "+productMRPLbl.getText());
		System.out.println("Product price - "+productPriceLbl.getText());
		System.out.println("Total saving - "+youSaveLbl.getText());
		
	}
	
	public void clickAddToCartBtn() {
		addToCartBtn.click();
		
	}
}

