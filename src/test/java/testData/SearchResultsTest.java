package testData;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultPage;

public class SearchResultsTest extends TestBase{
	HomePage hp;
	SearchResultPage resultsPage;
	
	public SearchResultsTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 hp = new HomePage();
//		  resultsPage = new SearchResultsTest();
		 resultsPage = hp.toSearchProduct(prop.getProperty("productName"));
	}
	
	@Test(priority =1)
	public void verifyProductSearchResult() {
		resultsPage.searchResultsTitleTest();
		 Assert.assertEquals(driver.getTitle(), "Amazon.in : iphone17", "resultsPageTitle mismatched");
	}
	
	@Test (priority =2)
	public  CartPage verifyAddProductToCartTest() {
		resultsPage.AddProductToCart();
		return new CartPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
