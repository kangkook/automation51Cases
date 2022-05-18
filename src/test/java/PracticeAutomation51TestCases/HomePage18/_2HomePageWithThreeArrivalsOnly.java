package PracticeAutomation51TestCases.HomePage18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _2HomePageWithThreeArrivalsOnly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 2. Home page with three Arrivals only
		 * 1) Open the browser
2) Enter the URL ¡°http://practice.automationtesting.in/¡±
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
		 */
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://practice.automationtesting.in");
		
		WebElement shopMenu = driver.findElement(By.id("menu-item-40"));
		
		shopMenu.click();
		
		WebElement siteLogoHomeMenu = driver.findElement(By.id("site-logo"));
		siteLogoHomeMenu.click();
		
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		

	}

}
