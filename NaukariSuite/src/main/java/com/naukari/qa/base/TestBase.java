package com.naukari.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.naukari.qa.util.TestUtil;
import com.naukari.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public TestBase(){
		
		// Read the config.properties
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/naukari/qa/config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public static WebDriver initializtion(){
		String browserName = prop.getProperty("browser");
		WebDriver driver = null;
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:/selenium-Workspace/NaukariSuite/drivers/chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		
		//vid 4 (43:00 min)
		e_driver= new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver= e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	} 
}

	

