package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.TestBase;

public class SearchResultPage extends TestBase{
	
private Assert Assert;

	@FindBy(xpath = "//span[@id=\"a-autoid-1-announce\"]/preceding-sibling::input")
	WebElement Addcartbutton ;
	//span[@id="a-autoid-1-announce"]/preceding-sibling::input
//	@FindBy(xpath = "")
//	WebElement Addcartbutton ;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String searchResultsTitleTest( ) {
		  @Nullable
		String SearchResultsTitle = driver.getTitle();	
		  System.out.println(SearchResultsTitle);
		  return SearchResultsTitle;
	}
	
	public void AddProductToCart( ) {
		Addcartbutton.click();
		  System.out.println("productAddedToCart");
	}

	
}
