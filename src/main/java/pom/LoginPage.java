package pom;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Parameterization;

public class LoginPage extends Parameterization{
	@FindBy(xpath ="//input[@placeholder='Username']")private WebElement userName;
	@FindBy(xpath ="//input[@placeholder='Password']")private WebElement password;
	@FindBy(xpath ="//input[@id='login-button']")     private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String name) {
		userName.sendKeys(name);
	}
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
}
