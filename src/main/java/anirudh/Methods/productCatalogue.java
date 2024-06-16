package anirudh.Methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anirudh.AbstractComponents.AbstractComponents;

public class productCatalogue extends AbstractComponents{

	WebDriver driver; 
	public productCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;

	@FindBy(css=".ng-animating")
	WebElement spinner;
	

	
	
	By productBy=By.cssSelector(".mb-3");
	
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toast=By.cssSelector("#toast-container");
	
	public List<WebElement> getproductList(){
		
		waitforElementtoappear(productBy);
		return products;
	}
	
	
	public WebElement getProductsbyName(String productname) {
		
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		return prod;
	}
	
	
	public void addproducttoCart(String productname) {
		
		WebElement prod = getProductsbyName(productname);
		prod.findElement(addToCart).click();
		waitforElementtoappear(toast);
		waitforElementtoDisappear(spinner);
		//prod.findElement(cart).click(); 
		
	}
	

}