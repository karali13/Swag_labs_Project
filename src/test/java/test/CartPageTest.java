package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.LoginPage;
import pom.ProductPage;

public class CartPageTest extends BaseTest{
	@BeforeMethod
	public void openBrowser() {
		driver = Browser.chrome();
	}
	
	@Test
	public void verifyByclickOnCartButton(){
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		}
	@Test
	public void verifyProductListInCart(){
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.getProductList(1);
		}
	@Test
	public void verifyRemoveProductButtonInCart(){
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickonRemoveButton(0);
		}
	@Test
	public void verifyProductNameLinkInCart(){
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		String cartUrl = driver.getCurrentUrl();
		cartPage.clickOnProductNameLink(0);
		String checkoutUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(cartUrl, checkoutUrl);
		}
	@Test
	public void verifyContinueShoppingButton(){
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		String cartUrl = driver.getCurrentUrl();
		cartPage.clickOnContinueButton();
		String checkoutUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(cartUrl, checkoutUrl);
		}
	@Test
	public void verifyCheckoutButton(){
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		String cartUrl = driver.getCurrentUrl();
		cartPage.clickOnCheckoutButton();
		String checkoutUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(cartUrl, checkoutUrl);
		}
	
}
