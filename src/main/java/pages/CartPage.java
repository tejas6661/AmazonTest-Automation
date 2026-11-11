package pages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(id = "nav-cart")
//	@CacheLookup
	WebElement CartIcon;
	
	
	
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void openCartPage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    WebElement cart = wait.until(
		        ExpectedConditions.elementToBeClickable(CartIcon));
		    cart.click();
		}
	
	public String validateCartPageTitle() {
		@Nullable
		String cartpageTitle = driver.getTitle();
		return cartpageTitle;
		}
	
	

}
