package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
	@FindBy(xpath ="(//div[@class='inventory_item_name'])[1]") 				  private List<WebElement> productName;
	@FindBy(xpath ="(//div[@class='inventory_item_price'])") 			  private List<WebElement> productPrice;
	@FindBy(xpath ="(//div[@class='summary_info_label summary_total_label'])") private WebElement totalPrice;
	@FindBy(xpath ="(//div[@class='summary_subtotal_label'])") 				  private WebElement itemTotal;
	@FindBy(xpath ="(//div[@class='summary_tax_label'])") 					  private WebElement tax;
	@FindBy(xpath ="(//button[@id='cancel'])") 								  private WebElement cancelButton;
	@FindBy(xpath ="(//button[@id='finish'])") 								  private WebElement finishButton;
	@FindBy(xpath ="(//div[@class='error-message-container error'])") 		  private WebElement errorMessage;

	//chechout Complete
	@FindBy(xpath="//h2[@class='complete-header']") 						  private WebElement checkoutTitle;
	@FindBy(xpath="//button[@id='back-to-products']") 						  private WebElement backHomeButton;
	 
	public CheckoutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void getProductName(int i) {
		WebElement value1 = productName.get(i);
		
	}
	public Double getProductPrice(int i) {
		WebElement value1 = productPrice.get(i);
		String price = value1.getText();
		String rs = price.substring(1);
		Double p= Double.parseDouble(rs);
		return p;
	}
	public Double getItemTotal() {
		String a= itemTotal.getText();
		String b = a.substring(13);
		Double c = Double.parseDouble(b);
		//System.out.println(c);
		return c;
	}
	public Double getTax() {
		String d= tax.getText();
		String e = d.substring(6);
		Double f = Double.parseDouble(e);
		return f;
	}
	public Double getTotalPrice() {
		String g= totalPrice.getText();
		String h = g.substring(8);
		Double i = Double.parseDouble(h);
		return i;
	}
	public void clickOnCancelButton() {
		cancelButton.click();
	}
	public void clickOnFinishButton() {
		finishButton.click();
	}
	public void clickOnBackHomeButton() {
		backHomeButton.click();
	}
	public void getErrorMessage() {
		errorMessage.isDisplayed();
	}
	public void getCHeckoutTitle() {
		String thanku= checkoutTitle.getText();
		System.out.println(thanku);
	}
	
}
