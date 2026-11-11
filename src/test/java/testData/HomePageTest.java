package testData;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import pages.SearchResultPage;

public class HomePageTest extends TestBase{
	HomePage hp;
	SearchResultPage resultsPage;
	
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		hp = new HomePage();
	}
	
	@Test
	public  SearchResultPage productSearchResultTest() {
		 hp.toSearchProduct(prop.getProperty("productName"));
		 return new SearchResultPage();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
