package managers;

import org.openqa.selenium.WebDriver;

import com.amazon.pages.AddToCartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductDescriptionPage;
import com.amazon.pages.SearchResultPage;


public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private AddToCartPage addToCartPage;
	private ProductDescriptionPage productDescriptionPage;
	private SearchResultPage searchResultPage;
/*	private CheckOutPage checkoutPage;
	private LoginPage loginPage;
	private PaymentPage paymentPage;
	private ThankYouPage thankYouPage;*/

	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
		
	}
	
	public SearchResultPage getSearchResultPage() {
		return (searchResultPage == null) ? searchResultPage = new SearchResultPage(driver):searchResultPage;
		
	}
	
	public ProductDescriptionPage getProductDescriptionPage() {
		return (productDescriptionPage == null) ? productDescriptionPage=new ProductDescriptionPage(driver) : productDescriptionPage;
	}
	
	public AddToCartPage getAddToCartPage() {
		return (addToCartPage == null) ? addToCartPage = new AddToCartPage(driver) : addToCartPage;
	}
	
	
}
