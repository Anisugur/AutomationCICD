package anirudh.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anirudh.Methods.Orderspage;
import anirudh.Methods.cartPage;


public class AbstractComponents {
	
	
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orders;
	
	public cartPage gotoCart() throws InterruptedException {
		
		Thread.sleep(3000);
		cartheader.click();
		cartPage cartpage = new cartPage(driver);
		return cartpage;
	}
	
	public Orderspage clickonOrders() throws InterruptedException {
		
		Thread.sleep(3000);
		orders.click();
		Orderspage orders = new Orderspage(driver);
		return orders;
	}
	
	public void waitforElementtoappear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
public void waittoappear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitforElementtoDisappear(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
