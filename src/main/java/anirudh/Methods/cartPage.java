package anirudh.Methods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anirudh.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents {

	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProd;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	

	
	public Boolean matchItem( String productname) {
		
		Boolean Match= cartProd.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
		return Match;
	}
	
	public void CheckoutButton() {
		checkoutEle.click();
	}
	
	
}
