package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (BaseClass.getProperty("browser")) {
//			switch ("chrome") {

			case "firefox":

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "Chrome":

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "safari":

				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			case "headless":

				// headless Driver
				break;

			}

		//	driver.get("https://www.techcircleschool.com");
			
			driver.get("http://practice.automationtesting.in/");

		}

		return driver;
	}
	
	
	//close/quit browser
	@AfterMethod
	public static void tearDown() {
		
		if(driver != null) {
			driver.close();
			
			driver = null;
			
		}
		
	}
	
	// configReaderClass
	private static Properties configfile;
	
	// example.
	// public static WebDriver driver;

	static {

		try {
			String filePath = "src/test/resources/propertiesFolder/config.properties";
			
			FileInputStream input = new FileInputStream(filePath);

			configfile = new Properties();
			configfile.load(input);

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String keyName) {

		return configfile.getProperty(keyName);
	}
	
	/////////////////////////////
	
	// configReaderClass
	private static Properties userDataConfig;
	
	// example.
	// public static WebDriver driver;

	static {

		try {
			String filePath = "src/test/resources/propertiesFolder/userData.properties";
			
			FileInputStream input = new FileInputStream(filePath);

			userDataConfig = new Properties();
			userDataConfig.load(input);

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getUserProperty(String keyName) {

		return userDataConfig.getProperty(keyName);
	}
	
	
	
	
	
	
	
	
}
