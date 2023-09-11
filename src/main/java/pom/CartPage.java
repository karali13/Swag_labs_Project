package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy (xpath ="//button[@id='continue-shopping']") 							   private WebElement continueButton;
	@FindBy (xpath ="//button[@id='checkout']") 									   private WebElement checkout;
	@FindBy (xpath ="(//button[@class='btn btn_secondary btn_small cart_button'])[1]") private List<WebElement> removeButton;
	@FindBy (xpath ="//div[@class='cart_item'][1]") 								   private List<WebElement> products;
	@FindBy (xpath ="(//div[@class='inventory_item_name'])[1]") 					   private List<WebElement> productsNameLink;

	//checkout page
	@FindBy (xpath ="//button[@id='cancel']") 										   private WebElement cancel;
	@FindBy (xpath ="//input[@id='continue']") 										   private WebElement continueChekout;
	@FindBy (xpath ="//input[@id='first-name']") 									   private WebElement firstName;
	@FindBy (xpath ="//input[@id='last-name']") 									   private WebElement lastName;
	@FindBy (xpath ="//input[@id='postal-code']") 									   private WebElement postalCode;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public void clickOnCheckoutButton() {
		checkout.click();
	}
	public void clickonRemoveButton(int i) {
		WebElement value = removeButton.get(i);
		value.click();
	}
	public void clickOncalcelButton() {
		cancel.click();
	}
	public void clickOnContinueCheckout() {
		continueChekout.click();
	}
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	public void enterPostalcode(String code) {
		postalCode.sendKeys(code);
	}
	public void getProductList(int i) {
		WebElement value = products.get(0);
		boolean result = value.isDisplayed();
		System.out.println(result);
	}
	public void clickOnProductNameLink(int i) {
		WebElement value = productsNameLink.get(0);
		value.click();
	}
	
}
