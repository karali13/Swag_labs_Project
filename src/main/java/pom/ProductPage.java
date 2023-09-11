package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	@FindBy (xpath ="//button[text()='Add to cart'][1]")        private List<WebElement> addToCart;
	@FindBy (xpath="//select[@class='product_sort_container']") private WebElement filter;
	@FindBy (xpath="//option[@value='az']")  					private WebElement aToz;
	@FindBy (xpath="//option[@value='za']")  					private WebElement zToa;
	@FindBy (xpath="//option[@value='lohi']")                   private WebElement lowToHigh;
	@FindBy (xpath="//option[@value='hilo']")					private WebElement highToLow;
	@FindBy (xpath="//a[@class='shopping_cart_link']") 			private WebElement cart;
	@FindBy (xpath="//img[@class='inventory_item_img']") 	    private List<WebElement> img;
	@FindBy (xpath="(//div[@class='inventory_item_name'])[1]") 	private WebElement productName;
	@FindBy (xpath="(//div[@class='inventory_item'])[1]") 	    private List<WebElement> productList;
	@FindBy (xpath="(//button[@class='btn btn_secondary btn_small btn_inventory'])[1]")private List<WebElement> removeButton;

	//NavBar
	@FindBy (xpath="//button[@id='react-burger-menu-btn']") 	private WebElement menuButton;
	@FindBy (xpath="//a[@id='inventory_sidebar_link']") 		private WebElement allItems;
	@FindBy (xpath="//a[@id='about_sidebar_link']") 			private WebElement about;
	@FindBy (xpath="//a[@id='logout_sidebar_link']")			private WebElement logout;
	@FindBy (xpath="//span[@class='shopping_cart_badge']")		private WebElement cartNumbers;
	
	
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnAddToCcartButton(int i) {
		WebElement value = addToCart.get(i);
		value.click();
		//boolean add = removeButton.get(i).isDisplayed();
		//System.out.println(add);
	}
	public void clickOnFilter() {
		//Select se = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		//se.selectByIndex(0);
		filter.click();
		boolean list= aToz.isDisplayed();
		System.out.println(list);
	}
	public void clickOnaToz() {
		aToz.click();
	}
	public void clickOnzToa() {
		zToa.click();
	}
	public void clickOnlowToHigh() {
		lowToHigh.click();
	}
	public void clickOnhighToLow() {
		highToLow.click();
	}
	public void clickOnCart() {
		cart.click();
	}
	public void clickOnImg(int i) {
		WebElement value = img.get(i);
		value.click();
	} 
	public void moveOnProductName(WebDriver driver) {
		//WebElement value = productName.get(i);
		Actions actions = new Actions(driver);
		actions.moveToElement(productName);
		actions.perform();
		boolean text=productName.isEnabled();
		System.out.println(text);
	} 
	public void clickOnProductName() {
		productName.click();
	}
	public void displayProductList(int i) {
		WebElement value = productList.get(i);
		
		boolean result = value.isDisplayed();
		System.out.println(result);
	} 
	
	public void clickOnMenuButton() {
		menuButton.click();
	}
	public void clickOnAllItems() {
		allItems.click();
	}
	public void clickOnAbout() {
		about.click();
	}
	public void clickOnLogout() {
		logout.click();
	}
	public int varifyCartNumber() {
		String text= cartNumbers.getText();
		int num = Integer.parseInt(text);
		System.out.println(num);
		return num;
	}
	public void clickOnremoveButton(int i) {
		WebElement value = removeButton.get(i);
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfAllElements(removeButton);
		value.click();
	}
	
}
