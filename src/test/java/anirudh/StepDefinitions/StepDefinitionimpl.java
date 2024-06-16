package anirudh.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import anirudh.Methods.ConfirmationPage;
import anirudh.Methods.Login;
import anirudh.Methods.cartPage;
import anirudh.Methods.checkoutPage;
import anirudh.Methods.productCatalogue;
import anirudhBase.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimpl extends BaseTest {
	
	public Login login;
	public productCatalogue prodcat;
	
	public ConfirmationPage confirmationpage;
	@Given("I landed on Ecommerce Website")
	public void I_landed_on_Ecommerce_Website() throws IOException {
		
		login = launchApplication();
	}
	
    @Given ("^Logged in with name(.+) and password(.+)$")
    public void logged_in_with_name_and_password(String name , String password) throws InterruptedException {
    	
    	prodcat=login.loginApplication(name,password);
    	
    }
    
    @When("^I add (.+) to cart$")
	public void i_add_product_to_cart(String productname) {
    	
    	List<WebElement> products=prodcat.getproductList();
		prodcat.addproducttoCart(productname);
		
    }
    
    @And("^Checkout (.+) and submit the order$")
    public void checkout_and_submit_order(String productname) throws InterruptedException {
    	cartPage cartpage=prodcat.gotoCart();
		Boolean Match = cartpage.matchItem(productname);
		Assert.assertTrue(Match);
		cartpage.CheckoutButton();
		checkoutPage cehckoutpage = new checkoutPage(driver);
		cehckoutpage.EnterText();
		confirmationpage=cehckoutpage.Submit();
    }
    
    @Then("{string} is displayed on ComfirmationPage")
    
    public void message_is_displayed(String string) {
    	String confirmMessage=confirmationpage.getConfirmMessage();
		System.out.println(confirmMessage);
		Assert.assertEquals(confirmMessage,string);
		
    }
    
}
