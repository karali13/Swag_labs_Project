package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;

public class LoginPageTest extends BaseTest {
	@BeforeMethod
	public void openBrowser() {
		driver = Browser.chrome();
	}
	@Test
	public void loginWithValidStandardUserID() {
		LoginPage login = new LoginPage(driver);
		String LoginPageUrl= driver.getCurrentUrl();
		login.enterUserName("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		String ProductPageUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(LoginPageUrl, ProductPageUrl);
		
	}
	@Test
	public void loginWithInvalidStandardUserID() {
		LoginPage login = new LoginPage(driver);
		String LoginPageUrl= driver.getCurrentUrl();
		login.enterUserName("standard");
		login.enterPassword("secret");
		login.clickOnLoginButton();
		String ProductPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(LoginPageUrl, ProductPageUrl);
		
	}
	@Test
	public void loginWithValidLockedoutUserID() {
		LoginPage login = new LoginPage(driver);
		String LoginPageUrl= driver.getCurrentUrl();
		login.enterUserName("locked_out_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		String ProductPageUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(LoginPageUrl, ProductPageUrl);
		
	}
	@Test
	public void loginWithValidProblemUserID() {
		LoginPage login = new LoginPage(driver);
		String LoginPageUrl= driver.getCurrentUrl();
		login.enterUserName("problem_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		String ProductPageUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(LoginPageUrl, ProductPageUrl);
		
	}
	@Test
	public void loginWithInvalidProblemUserID() {
		LoginPage login = new LoginPage(driver);
		String LoginPageUrl= driver.getCurrentUrl();
		login.enterUserName("problem");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		String ProductPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(LoginPageUrl, ProductPageUrl);
		
	}
	@Test
	public void loginWithValidPerformacnceGlitchUserID() {
		LoginPage login = new LoginPage(driver);
		String LoginPageUrl= driver.getCurrentUrl();
		login.enterUserName("performance_glitch_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		String ProductPageUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(LoginPageUrl, ProductPageUrl);
		}
	@Test
	public void loginWithInvalidPerformacnceGlitchUserID() {
		LoginPage login = new LoginPage(driver);
		String LoginPageUrl= driver.getCurrentUrl();
		login.enterUserName("performance_glitch_user");
		login.enterPassword("secret");
		login.clickOnLoginButton();
		String ProductPageUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(LoginPageUrl, ProductPageUrl);
		}
	
}
