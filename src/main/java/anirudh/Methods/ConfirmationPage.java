package anirudh.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anirudh.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(css=".hero-primary")
	WebElement confirm;

	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String getConfirmMessage() {
		
		return confirm.getText();
	}

}
