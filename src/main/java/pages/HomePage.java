package pages;

import org.jspecify.annotations.Nullable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
//import testData.SearchResultsTest;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
	WebElement searchBar ;
	
	@FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
	WebElement searchIcon ;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		@Nullable
		String pageTitle = driver.getTitle();
		return pageTitle;
		}
	
	public SearchResultPage toSearchProduct(String productName) {
		searchBar.sendKeys(productName);
		searchIcon.click();
		System.out.println("product search result are displayed");
		return new SearchResultPage();
	}
	
	

}
