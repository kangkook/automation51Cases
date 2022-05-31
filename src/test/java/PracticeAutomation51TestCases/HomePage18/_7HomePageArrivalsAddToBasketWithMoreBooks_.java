package PracticeAutomation51TestCases.HomePage18;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _7HomePageArrivalsAddToBasketWithMoreBooks_ {

	/*
	 * 1) Open the browser
2) Enter the URL ��http://practice.automationtesting.in/��
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and should navigate to next page where user can add that book to his basket
10) Click on the Add To Basket button which adds that book to your basket
11) User can view that Book in the Menu item with price.
12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
14) Click the add to basket button
15) Now it throws an error prompt like you must enter a value between 1 and 20
	 */
	
	

WebDriver driver;
	
	@Before
		
		
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
        
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	@Test
	public void WithMoreBooks() {
			
			WebElement shopMenu = driver.findElement(By.xpath("//*[@id='menu-item-40']/a"));
			
			shopMenu.click();
			
			WebElement siteLogoHomeMenu = driver.findElement(By.xpath("//*[@id='content']/nav/a"));
			siteLogoHomeMenu.click();
				
//				5) Test whether the Home page has Three Arrivals only
				List<WebElement> arrivals = driver.findElements(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
				
//				6) The Home page must contains only three Arrivals
				Assert.assertEquals(3, arrivals.size());

//				7) Now click the image in the Arrivals
				
				WebElement arrival3 = driver.findElement(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div[3]"));
				arrival3.click();

//				8) Test whether it is navigating to next page where the user can add that book into his basket.
				WebElement clickBook1 = driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[5]/ul/li[1]/a[1]"));
				clickBook1.click();
				

				
//				9) Image should be clickable and should navigate to next page where user can add that book to his basket
//				WebElement addToBasket1 = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/button"));
//				addToBasket1.click();

				
//				10) Click on the Add To Basket button which adds that book to your basket
				WebElement addToBasket1 = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/button"));
				addToBasket1.click();
				
//				11) User can view that Book in the Menu item with price.
				
				Boolean priceText = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/div[1]/p/span")).isDisplayed();
								        Assert.assertTrue(priceText);
								      //*[@id="product-170"]/div[2]/div[1]/p/span
				
//				12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket 
//				WebElement addToBasket2 = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/button"));
//				addToBasket2.click();
				
				// Functional Programming in Java Script
				//*[@id="product-170"]/div[2]/form/button
			
				
//				13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
//				WebElement addQuantity = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/div/input"));
				
				//add more books
				
//				String getMax = driver.findElement(By.xpath("//*[@class=\"quantity\"]/input ")).getAttribute("Max");
//				System.out.println(getMax);
//				int moreThanMax = Integer.valueOf(getMax)+1;
//				
//				driver.findElement(By.xpath("//form/div/input")).clear();
//				driver.findElement(By.xpath("//form/div/input")).sendKeys(String.valueOf(moreThanMax));
//				driver.findElement(By.xpath("//button[contains(text(), 'Add to basket')]")).click();
//				
//				//Check if there is an error message pop up (using javascript)
//				WebElement ele = driver.findElement(By.xpath("//form/div/input"));
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", ele);
//				System.out.println(isValidInput);
//				String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", ele);
//				System.out.println(validationMessage);
				
//				Assert.assertFalse(isValidInput);
//
//				String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(getMax));
//				
//				Assert.assertTrue(validationMessage.equals(alert));
				
				
				
				
				// enter quantity greater than what's allowed
//		          String getMax = BaseClass.driver.findElement(By.xpath("//*[@class=\"quantity\"]/input ")).getAttribute("Max"); // help from Leng's code
//		          int moreThanMax = Integer.valueOf(getMax)+1; // help from Leng's code
//		          
//		          Actions action = new Actions(BaseClass.driver);
//		          
//		          WebElement quantityBox = BaseClass.driver.findElement(By.xpath("//*[@class='quantity']/input"));
//		          action.moveToElement(quantityBox).click().perform();
//		          
//		          action.sendKeys(Integer.toString(moreThanMax));
//		          action.build().perform();
//		          
//		          JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
//		          String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", quantityBox);
//		        
//		          String expectedValue = "Value must be less than or equal to " + getMax + ".";
//		          String actualValue = validationMessage;
//		          
//		          Assert.assertEquals(actualValue, expectedValue);
//				
				
				
				
//				WebElement maxPlusOne = driver.findElement(By.max();
//				How can I find max + 1 ???
//				addQuantity.sendKeys(maxPlusOne());
				
//				7839 7840
				//*[@id="product-170"]/div[2]/form/div/input
//				<input type="number" step="1" min="1" max="7839" name="quantity" value="1" title="Qty" class="input-text qty text" size="4" pattern="[0-9]*" inputmode="numeric">
				
//				14) Click the add to basket button
//				WebElement addToBasket3 = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/button"));
//				addToBasket3.click();
				
//				15) Now it throws an error prompt like you must enter a value between 1 and 20
				


		}

		@After
		public void tearDown() {
			driver.close();
				
		}
}