package com.indiatoday.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.indiatoday.qa.util.TestUtil;
import com.indiatoday.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	@SuppressWarnings("deprecation")
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase () {
		
		prop=new Properties() ;
			try {
				FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/indiatoday"
						+ "/confiq/confiq.properties");
					prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
		@SuppressWarnings("deprecation")
		public static void initialization() {
        	  String browserName= prop.getProperty("browser");
        	  if (browserName.equals("chrome")) {
        		  WebDriverManager.chromedriver().setup();
        			ChromeOptions options = new ChromeOptions();
        			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        			options.addArguments("headless");
        			options.addArguments("--no-sandbox");
        			options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("window-size=1200x600");
        			driver=new ChromeDriver(options);
        	  }
        	  else if (browserName.equalsIgnoreCase("firefox")) 
      		{
        		  WebDriverManager.firefoxdriver();
      			driver=new FirefoxDriver();
      			
      		}
      		
      		else if (browserName.equalsIgnoreCase("internetexplorer")) 
      		{
      			WebDriverManager.iedriver();
      			driver=new InternetExplorerDriver();
      			Reporter.log("IE Launched", true);	
      		}
      		
      		else if (browserName.equalsIgnoreCase("edge")) 
      		{
      			WebDriverManager.edgedriver();
      			driver=new EdgeDriver();
      			Reporter.log("Edge Launched", true);	
      		
      		}
        	  e_driver = new EventFiringWebDriver(driver);
      		// Now create object of EventListerHandler to register it with EventFiringWebDriver
      		eventListener = new WebEventListener();
      		e_driver.register(eventListener);
      		driver = e_driver;
        	driver.manage().window().maximize();
        	driver.manage().deleteAllCookies();
        	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
        	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
        	driver.get(prop.getProperty("url"));

           }

}
