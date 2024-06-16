package anirudh.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import anirudh.Methods.ConfirmationPage;
import anirudh.Methods.Login;
import anirudh.Methods.cartPage;
import anirudh.Methods.checkoutPage;
import anirudh.Methods.productCatalogue;
import anirudhBase.BaseTest;
import anirudhBase.Retry;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class errorValidation extends BaseTest {
		@Test(groups="Error",retryAnalyzer=Retry.class)
		public void Tstng() throws InterruptedException, IOException {
	
		String productname = "ZARA COAT 3";
		login.loginApplication("anisugurrr@gmail.com","23432isugur@1");
		Assert.assertEquals("Incorrect email password ",login.errorMessage());
		
	
}

}
