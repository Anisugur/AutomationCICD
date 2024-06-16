package anirudh.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anirudh.AbstractComponents.AbstractComponents;

public class checkoutPage extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement serachbox;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By wait=By.cssSelector(".ta-results");
	
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	
	public void EnterText() {
		
		Actions a= new Actions(driver);
		a.sendKeys(serachbox,"india").build().perform();
		waitforElementtoappear(wait);
		country.click();
		
	}
	
	public ConfirmationPage Submit() {
		
		submit.click();
		return new ConfirmationPage(driver);
	}

	
	
}
