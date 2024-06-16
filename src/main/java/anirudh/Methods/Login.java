package anirudh.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anirudh.AbstractComponents.AbstractComponents;

public class Login extends AbstractComponents {

	WebDriver driver; 
	public Login(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement Submit;
	
	@FindBy(css=".ng-tns-c4-3.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error")
	WebElement error;
	
	

	public productCatalogue loginApplication(String email, String password) throws InterruptedException {
		// TODO Auto-generated method stub
		
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		//Thread.sleep(1000);
		Submit.click();
		productCatalogue prodcat= new productCatalogue(driver);
		return prodcat;
		
	}
	
	public String errorMessage() throws InterruptedException {
		waittoappear(error);
		return error.getText();
	}
public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
}
