package testData;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultPage;
import utils.extentTestListener;

@Listeners(extentTestListener.class)
public class CartPageTest extends TestBase{
	HomePage hp;
	SearchResultPage resultsPage;
	CartPage cp;
	
	public CartPageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		 hp = new HomePage();
		 cp = new CartPage();
//		  resultsPage = new SearchResultsTest();
		 resultsPage = hp.toSearchProduct(prop.getProperty("productName"));
		 resultsPage.AddProductToCart();
	}
	
	@Test(priority = 1)
	public void verifyCartPageTest() {
		
		  cp.openCartPage();
		
	}
	
	@Test (priority = 2, dependsOnMethods = "verifyCartPageTest")
	public void verifyCartPageTitleTest() {
		String cptitle = cp.validateCartPageTitle();
		
		
		 Assert.assertEquals(cptitle, "Amazon.in Shopping Cart", "cartPageTitle mismatched");
//		 Assert.assertTrue(true,"cartPageTestPassed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
