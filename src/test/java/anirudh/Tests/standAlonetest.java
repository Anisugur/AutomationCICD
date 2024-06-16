package anirudh.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anirudh.Methods.ConfirmationPage;
import anirudh.Methods.Login;
import anirudh.Methods.Orderspage;
import anirudh.Methods.cartPage;
import anirudh.Methods.checkoutPage;
import anirudh.Methods.productCatalogue;
import anirudhBase.BaseTest;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class standAlonetest extends BaseTest {
	
		String productname = "ZARA COAT 3";
		@Test(dataProvider="getData")
		public void Testing(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("https://rahulshettyacademy.com/client");
		//Login login = new Login(driver);
		//login.goTo();
		//Login login=launchApplication();
		productCatalogue prodcat=login.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products=prodcat.getproductList();
		prodcat.addproducttoCart(input.get("productname"));
		Thread.sleep(2000);
		cartPage cartpage=prodcat.gotoCart();
		Boolean Match = cartpage.matchItem(input.get("productname"));
		Assert.assertTrue(Match);
		cartpage.CheckoutButton();
		checkoutPage cehckoutpage = new checkoutPage(driver);
		cehckoutpage.EnterText();
		ConfirmationPage confirmationpage=cehckoutpage.Submit();
		Thread.sleep(1000);
		String confirmMessage=confirmationpage.getConfirmMessage();
		System.out.println(confirmMessage);
		Assert.assertEquals(confirmMessage,"THANKYOU FOR THE ORDER.");
		/*driver.findElement(By.id("userEmail")).sendKeys("abc9696@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Aniket@123");
		driver.findElement(By.id("login")).click();*/
		//productCatalogue prodcat= new productCatalogue(driver);
		
		/*WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();*/
		
		//WebDriverWait wait1 = new WebDriverWait (driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSeelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//Thread.sleep(3000);
	
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click(); 
		/*List<WebElement> cartProd = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean Match= cartProd.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(Match);
		driver.findElement(By.cssSelector(".totalRow button")).click();*/
		
		//cartPage cartpage = new cartPage(driver);
		
		/*Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		Thread.sleep(3000);
	
		driver.findElement(By.xpath(("(//button[contains(@class,'ta-item')])[2]"))).click();
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//calling the method 
		//js.executeScript("window.scrollBy(0,100)");
		
		
		driver.findElement(By.cssSelector(".action__submit")).click();*/
		//Thread.sleep(1000);
		
		//String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		
		
	}
		
		@Test(dependsOnMethods={"Testing"})
		
		public void OrderHistory() throws InterruptedException {
			
			productCatalogue prodcat=login.loginApplication("anisugur@gmail.com","Anisugur@1");
			Orderspage orders=prodcat.clickonOrders();
			Assert.assertTrue(orders.matchOrder(productname));
		}
		
		
		
		@DataProvider
		public Object[][] getData() throws IOException {
		  
		  	List<HashMap<String,String>> data=getJsonDataToMap("C:\\Users\\Ani\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\test\\java\\anirudh\\data\\Purchaseorder.json");
			return new Object[] [] {{data.get(0)},{data.get(1)}};
		}
	
	
	
}

