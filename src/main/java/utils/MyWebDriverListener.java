package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import base.TestBase;

public class MyWebDriverListener extends TestBase implements WebDriverListener{
	
//	@Override
	public void beforeGet(WebDriver driver, String url) {
        System.out.println("Opening URL: " + url);
    }
	
	 @Override
	    public void afterClick(WebElement element) {
	        System.out.println("Clicked element: " + element);
	    }

	    @Override
	    public void beforeSendKeys(
	            WebElement element, CharSequence... keysToSend) {
	        System.out.println("Entering text into: " + element);
	    }
	
	    @Override
	    public void onError(
	            Object target,
	            java.lang.reflect.Method method,
	            Object[] args,
	            java.lang.reflect.InvocationTargetException error) {

	        System.out.println("Error in method: " + method.getName());
	        System.out.println("Error details: " + error.getCause());
	    }

}
