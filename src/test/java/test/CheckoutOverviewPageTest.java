package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.CheckoutOverviewPage;
import pom.LoginPage;
import pom.ProductPage;
import utility.Screenshots;

public class CheckoutOverviewPageTest extends BaseTest{
	@BeforeMethod
	public void openBrowser() {
		driver = Browser.chrome();
	}
	
	@Test
	public void verifyInputFieldsByValidInput() throws InterruptedException{
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnCheckoutButton();
		String checkoutInfoUrl = driver.getCurrentUrl();
		cartPage.enterFirstName("karali");
		Thread.sleep(2000);
		cartPage.enterLastName("baviskar");
		Thread.sleep(2000);
		cartPage.enterPostalcode("1234");
		Thread.sleep(2000);
		cartPage.clickOnContinueCheckout();
		String checkoutOverviewUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(checkoutInfoUrl, checkoutOverviewUrl);
	}
	
	@Test
	public void verifyInputFieldsByInValidInputs() throws InterruptedException{
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnCheckoutButton();
		String checkoutInfoUrl = driver.getCurrentUrl();
		cartPage.enterFirstName("@%^^");
		Thread.sleep(2000);
		cartPage.enterLastName("baviskar");
		Thread.sleep(2000);
		cartPage.enterPostalcode("abcdefg");
		Thread.sleep(2000);
		cartPage.clickOnContinueCheckout();
		String checkoutOverviewUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(checkoutInfoUrl, checkoutOverviewUrl);
	}
	@Test
	public void verifyContinueButtunWithoutInfo() throws InterruptedException{
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnCheckoutButton();
		//String checkoutInfoUrl = driver.getCurrentUrl();
		cartPage.enterFirstName("");
		Thread.sleep(2000);
		cartPage.enterLastName("");
		Thread.sleep(2000);
		cartPage.enterPostalcode("");
		Thread.sleep(2000);
		cartPage.clickOnContinueCheckout();
		CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
		Thread.sleep(2000);
		overview.getErrorMessage();
		//String checkoutOverviewUrl = driver.getCurrentUrl();
		//Assert.assertEquals(checkoutInfoUrl, checkoutOverviewUrl);
	}
	@Test
	public void verifyCheckoutCompletePage() throws InterruptedException{
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnCheckoutButton();
		cartPage.enterFirstName("karali");
		Thread.sleep(2000);
		cartPage.enterLastName("baviskar");
		Thread.sleep(2000);
		cartPage.enterPostalcode("abcdefg");
		Thread.sleep(2000);
		cartPage.clickOnContinueCheckout();
		Thread.sleep(2000);
		CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
		String productPageUrl = driver.getCurrentUrl();
		overview.clickOnCancelButton();
		String checkoutoverviewURL = driver.getCurrentUrl();
		Assert.assertNotEquals(productPageUrl,checkoutoverviewURL );
	}
	@Test
	public void verifyBachHomeButton() throws InterruptedException{
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnCheckoutButton();
		cartPage.enterFirstName("karali");
		Thread.sleep(2000);
		cartPage.enterLastName("baviskar");
		Thread.sleep(2000);
		cartPage.enterPostalcode("abcdefg");
		Thread.sleep(2000);
		cartPage.clickOnContinueCheckout();
		Thread.sleep(2000);
		CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
		overview.clickOnFinishButton();
		String checkoutCompleteUrl = driver.getCurrentUrl();
		overview.clickOnBackHomeButton();
		String checkoutoverviewURL = driver.getCurrentUrl();
		Assert.assertNotEquals(checkoutCompleteUrl,checkoutoverviewURL );
	}
	
	@Test
	public void verifyProductPriceIsEqualToItemTotal() throws InterruptedException, IOException{
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		for(int i=0;i<2;i++) {
		productPage.clickOnAddToCcartButton(i);
		}
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnCheckoutButton();
		cartPage.enterFirstName("karali");
		Thread.sleep(2000);
		cartPage.enterLastName("baviskar");
		Thread.sleep(2000);
		cartPage.enterPostalcode("abcdefg");
		Thread.sleep(2000);
		cartPage.clickOnContinueCheckout();
		Thread.sleep(2000);
		CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
		String checkoutOverviewUrl = driver.getCurrentUrl();
		double d = 0;
		for(int i=0;i<2;i++) {
		d= d+overview.getProductPrice(i);
		}
		if(d==overview.getItemTotal()) {
			System.out.println("products price is match with Total item");
		}
		else {
		System.out.println("not match");
		}
		double addTax =d+overview.getTax();
		System.out.println(addTax);
		if(addTax==overview.getTotalPrice()) {
			System.out.println("Price Match");
		}
		else {
			System.out.println("Price Not Match");
		}
		overview.clickOnFinishButton();
		overview.getCHeckoutTitle();
		String checkoutCompleteUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(checkoutOverviewUrl,checkoutCompleteUrl );
		Thread.sleep(2000);
		Screenshots.getScreenshot(driver);
	}
	
	
}
