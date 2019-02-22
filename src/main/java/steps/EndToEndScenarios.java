package steps;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.pages.AddToCartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductDescriptionPage;
import com.amazon.pages.SearchResultPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import managers.BrowserFactory;
import managers.FileReaderManager;
import managers.PageObjectManager;

public class EndToEndScenarios {
	WebDriver driver;
	PageObjectManager pageObjectManager;
	HomePage homePage;
	AddToCartPage addToCartPage;
	ProductDescriptionPage productDescriptionPage;
	SearchResultPage searchResultPage;
	BrowserFactory browserFactory;
	
	
	@Given("^user navigates to amazon website$")
	public void user_navigates_to_amazon_website() throws Throwable {
		System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@When("^user search for product$")
	public void user_search_for_product() throws Throwable {
		pageObjectManager = new PageObjectManager(this.driver);
		homePage = pageObjectManager.getHomePage();
		
	    homePage.searchItem("samsung a7");
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    
	    
	    
	}

	@Then("^user navigate to SearchResult page$")
	public void user_navigate_to_SearchResult_page() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		searchResultPage = pageObjectManager.getSearchResultPage();
		
		// Switch tabs
	    Set handles = driver.getWindowHandles();
		System.out.println(handles);
		// Pass a window handle to the other window
        for (String handle1 : driver.getWindowHandles()) {
        	System.out.println(handle1);
        	driver.switchTo().window(handle1);
         }
        
        System.out.println("User is on - "+driver.getTitle());
		
	}

	@When("^user clicks on product$")
	public void user_clicks_on_product() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		searchResultPage = pageObjectManager.getSearchResultPage();
		
		// Switch tabs
	    Set handles = driver.getWindowHandles();
		System.out.println(handles);
		// Pass a window handle to the other window
        for (String handle1 : driver.getWindowHandles()) {
        	System.out.println(handle1);
        	driver.switchTo().window(handle1);
         }
		
		searchResultPage.selectProduct();
	}

	@Then("^user navigates to ProductDescriptionPage$")
	public void user_navigates_to_ProductDescriptionPage() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		productDescriptionPage=pageObjectManager.getProductDescriptionPage();
		
		productDescriptionPage.prodctDetails();
		System.out.println("User is on - "+driver.getTitle());
	    
	}

	@Then("^user reads specific product details$")
	public void user_reads_specific_product_details() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		productDescriptionPage=pageObjectManager.getProductDescriptionPage();
		
		productDescriptionPage.prodctDetails();
		productDescriptionPage.clickAddToCartBtn();
	}

	@When("^user clicks on Add to Cart button$")
	public void user_clicks_on_Add_to_Cart_button() throws Throwable {
		productDescriptionPage.clickAddToCartBtn();
	}

	@Then("^user navigates to Add to Cart page$")
	public void user_navigates_to_Add_to_Cart_page() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		addToCartPage=pageObjectManager.getAddToCartPage();

		addToCartPage.validateAddToCartPage();
	
	}

}
