package PracticeAutomation51TestCases.HomePage18;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _7MoreBooks {
	
	
	
WebDriver driver;
WebDriverWait wait;
Actions act;
	
	@BeforeClass
		
		
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
        
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	
	@Test
	public void arrivalsAddToBasketWithMoreBooks() throws InterruptedException {
		
		String clickShop = "//a[contains(text(),\"Shop\")]";
		WebElement shopButton = driver.findElement(By.xpath(clickShop));
		shopButton.click();
		
		String clickHome = "//a[contains(text(),\"Home\")]";
		WebElement homeButton = driver.findElement(By.xpath(clickHome));
		homeButton.click();
		
		List<WebElement> newArrivals = driver.findElements(By.xpath("//h2[contains(text(),\"new arrivals\")]/../../../../../div/div[2]/div"));
		int countNewArrivals = newArrivals.size();
		assert(countNewArrivals == 3);
		
		
		driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[5]/ul/li[1]/a[1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='product_title entry-title']/../div/p/span")));
		
		//check and keep the price to compare after add to basket
		String expectedPrice = driver.findElement(By.xpath("//*[@class='product_title entry-title']/../div/p/span")).getText();
		System.out.println(expectedPrice);
		
		
		//add to basket button
		driver.findElement(By.xpath("//button[contains(text(), 'Add to basket')]")).click();
		
		//Verify that the book has been added to the basket
		String cart = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[2]")).getText();
		System.out.println(cart);
		//String expectedCart = price;
		Assert.assertTrue(cart.equals(expectedPrice));
		
		//add more books
		
		String getMax = driver.findElement(By.xpath("//*[@class=\"quantity\"]/input ")).getAttribute("Max");
		System.out.println(getMax);
		int moreThanMax = Integer.valueOf(getMax)+1;
		
		driver.findElement(By.xpath("//form/div/input")).clear();
		driver.findElement(By.xpath("//form/div/input")).sendKeys(String.valueOf(moreThanMax));
		driver.findElement(By.xpath("//button[contains(text(), 'Add to basket')]")).click();
		
		//Check if there is an error message pop up (using javascript)
		WebElement ele = driver.findElement(By.xpath("//form/div/input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", ele);
		System.out.println(isValidInput);
		String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", ele);
		System.out.println(validationMessage);
		
		Assert.assertFalse(isValidInput);

		String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(getMax));
		
		Assert.assertTrue(validationMessage.equals(alert));
	
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
			
	}
}
