package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;
import pom.ProductPage;

public class ProductPageTest extends BaseTest {
	@BeforeMethod
	public void openBrowser() {
		driver = Browser.chrome();
	}
	/*@BeforeClass
	public void login() {
		LoginPage login = new LoginPage(driver);
		//String LoginPageTitle= driver.getCurrentUrl();
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		//String ProductPageTitle = driver.getCurrentUrl();
		//Assert.assertNotEquals(LoginPageTitle, ProductPageTitle);
	}*/
	@Test
	public void verifyProductDisplayList() {
		ProductPage productPage = new ProductPage(driver);
		productPage.displayProductList(0);
		
	}
	@Test
	public void verifyProductNameText() {
		LoginPage login = new LoginPage(driver);
		//String LoginPageTitle= driver.getCurrentUrl();
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.moveOnProductName(driver);
		//Assert.assertTrue(text);
		
	}
	@Test
	public void verifyProductNameLink() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.moveOnProductName(driver);
		//Assert.assertTrue(text);
	}
	@Test
	public void verifyProductNameLinkIsClicked() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		String productUrl = driver.getCurrentUrl();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnProductName();
		String textUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(productUrl,textUrl);
		}
	@Test
	public void verifyImgLink() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		String productUrl = driver.getCurrentUrl();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnImg(1);
		String textUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(productUrl,textUrl);
		}
	@Test
	public void verifyFilterButton() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnFilter();
		}
	@Test
	public void verifyByclickOnATOZ() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnFilter();
		productPage.clickOnaToz();
		}
	@Test
	public void verifyByclickOnZTOA() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnFilter();
		productPage.clickOnzToa();
		}
	@Test
	public void verifyByclickOnLowToHigh() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		//productPage.clickOnFilter();
		productPage.clickOnlowToHigh();
		}
//using select
	@Test
	public void verifyByclickOnHighToLowselect() {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnhighToLow();
		}
	@Test
	public void verifyByclickOnAddToCart(){
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
	   }
	@Test
	public void varifyCartNumbers() throws InterruptedException{
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		for(int i=0;i<=2;i++) {
		productPage.clickOnAddToCcartButton(i);
		}
		productPage.varifyCartNumber();
		}
	@Test
	public void verifyByclickOnRemoveButton() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCcartButton(0);
		productPage.varifyCartNumber();
		Thread.sleep(2000);
		productPage.clickOnremoveButton(0);
		}
	@Test
	public void verifyByClickOnAbout() throws InterruptedException {
			LoginPage login = new LoginPage(driver);
			login.enterUserName("standard_user");
			login.enterPassword("secret_sauce");
			login.clickOnLoginButton();
			String ProductPageURL= driver.getCurrentUrl();
			ProductPage productPage = new ProductPage(driver);
			productPage.clickOnMenuButton();
			Thread.sleep(2000);
			productPage.clickOnAbout();
			String AboutPageURL= driver.getCurrentUrl();
			Assert.assertNotEquals(ProductPageURL, AboutPageURL);
	}
		
	}