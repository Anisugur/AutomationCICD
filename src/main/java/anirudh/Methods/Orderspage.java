package anirudh.Methods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anirudh.AbstractComponents.AbstractComponents;

public class Orderspage extends AbstractComponents {

	WebDriver driver;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductNames;
	
	/*@FindBy(css=".totalRow button")
	WebElement checkoutEle;*/
	
	public Orderspage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	

	
	public Boolean matchOrder( String productname) {
		
		Boolean Match= ProductNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
		return Match;
	}
	
	

	
}
