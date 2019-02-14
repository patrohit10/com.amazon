package com.amazon;

import static org.junit.Assert.assertEquals;

import java.awt.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.html5.AddApplicationCache;

import com.amazon.pages.HomePage;
import com.amazon.pages.ProductDescriptionPage;
import com.amazon.pages.SearchResultPage;

public class EndToEnd {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {	
		
		System. setProperty("webdriver.chrome.driver", "E:\\Continuum Data\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//navigate to search result page
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@title='Samsung Galaxy A7 (Blue, 4GB RAM and 64GB Storage) with Offer']")).click();
		
		//switch tab
		Set handles = driver.getWindowHandles();
		System.out.println(handles);
		// Pass a window handle to the other window
        for (String handle1 : driver.getWindowHandles()) {
        	System.out.println(handle1);
        	driver.switchTo().window(handle1);
         }
		
		//navigate to product description page
		String productTitle=driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
		System.out.println("Product title - "+productTitle);
		String productMRP=driver.findElement(By.xpath("//*[@class='a-text-strike']")).getText();
		System.out.println("MRP - " + productMRP);
		String productPrice=driver.findElement(By.xpath("//*[@id='priceblock_ourprice']")).getText();
		System.out.println("Price - " + productPrice);
		String youSave=driver.findElement(By.xpath("//td[@class='a-span12 a-color-price a-size-base']")).getText();
		System.out.println("Total amount You save on product - " + youSave);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		//navigate to Cart page
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		String addedToCart=driver.findElement(By.xpath("//div[@id='huc-v2-order-row-confirm-text']")).getText();
		System.out.println("User is on Cart page");
		System.out.println(addedToCart);
		
		
		driver.quit();
		
		/*HomePage homepage=new HomePage(driver);
		homepage.navigateToAmazonWebsite();
		
		SearchResultPage searchResultPage=new SearchResultPage(driver);
		searchResultPage.selectProduct();
		homepage.waitForPageToLoad();
		
		homepage.switchWindow();
		ProductDescriptionPage productDescriptionPage=new ProductDescriptionPage(driver);
		productDescriptionPage.prodctDetails();
		productDescriptionPage.clickAddToCartBtn();
		
		homepage.waitForPageToLoad();
		AddToCartPage addToCartPage=new AddToCartPage(driver);
		addToCartPage.validateAddToCartPage();
		
		driver.quit();*/
	}
	


}
