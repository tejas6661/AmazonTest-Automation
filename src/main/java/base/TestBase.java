package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import utils.MyWebDriverListener;
import utils.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
//		try {
//			prop=new Properties();
////			FileInputStream ip = new FileInputStream("/AmazonTest/src/main/java/config/config.properties");
//
//FileInputStream ip = new FileInputStream("C:\\Users\\tejas\\eclipse-workspace\\AmazonTest\\src\\main\\java\\config\\config.properties");
//
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			throw new RuntimeException("Failed to load config.properties", e);
//		}
		
		 prop = new Properties();

		    try (InputStream ip = TestBase.class.getClassLoader()
		            .getResourceAsStream("config.properties")) {

		        if (ip == null) {
		            throw new RuntimeException(
		                "config.properties was not found on the classpath"
		            );
		        }

		        prop.load(ip);

		    } catch (IOException e) {
		        throw new RuntimeException(
		            "Failed to load config.properties", e
		        );
		    }
		
	}
		
		
//			public static void initialization(){
//				
//				String browserName = prop.getProperty("browser");
//				
//				if(browserName.equals("chrome")){	
//					driver = new ChromeDriver(); 
//				}
//				else if(browserName.equals("FF")){
//					driver = new FirefoxDriver(); 
//				}
//				
////				e_driver = new EventFiringWebDriver(driver);
////				// Now create object of EventListerHandler to register it with EventFiringWebDriver
////				eventListener = new WebEventListener();
////				e_driver.register(eventListener);
////				driver = e_driver;
//				
//				
//				driver.manage().window().maximize();
//				driver.manage().deleteAllCookies();
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
//				driver.get(prop.getProperty("url"));
//	}

	//new code
	public static void initialization() {

	    String browserName = prop.getProperty("browser");

	    if (browserName == null) {
	        throw new RuntimeException("Browser is missing in config.properties");
	    }

	    WebDriver originalDriver;

	    if (browserName.equalsIgnoreCase("chrome")) {
	        originalDriver = new ChromeDriver();
	    } else if (browserName.equalsIgnoreCase("FF")) {
	        originalDriver = new FirefoxDriver();
	    } else {
	        throw new RuntimeException("Unsupported browser: " + browserName);
	    }

	    // Register the listener and decorate the driver
	     MyWebDriverListener listener = new MyWebDriverListener();

	    driver = new EventFiringDecorator<WebDriver>(listener)
	            .decorate(originalDriver);

	    // Continue normal browser setup
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();

	    driver.manage().timeouts()
	            .pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));

	    driver.manage().timeouts()
	            .implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

	    driver.get(prop.getProperty("url"));
	}
	
}

