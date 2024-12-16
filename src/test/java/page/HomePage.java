package page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import base.ProjectSpecifiedMethod;

public class HomePage extends ProjectSpecifiedMethod {

	

	@FindBy(xpath="//*[text()=\"Create Account\"]")
	WebElement createAccnt;
	//
	
	@FindBy(xpath = "//*[@id=\"account-menu-account-button\"]/span")
	WebElement account;

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	WebElement signin;

	@FindBy(id = "gh-search-input")
	WebElement search;

	@FindBy(xpath = "//*[text()='Add to Cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//*[text()=\"Menu\"]")
	WebElement menu;
	
	@FindBy(tagName="a")
	List<WebElement> menuOptions;
	
	@FindBy(xpath="//span[@class='header-search-icon']//*[name()='svg']")
	WebElement searchBox;
	
	@FindBy(xpath="//*[text()='Continue shopping']")
	WebElement continueShopping;

	@FindBy(xpath="//*[text()='An account with this email already exists.']")
	WebElement singupText;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage click_Account() throws IOException {
		takeScreenShot("HomePage");
		account.click();
		return this;
	}
	public void validate_login() throws IOException {
		String actual ="Best Buy | Official Online Store | Shop Now & Save";
		String expected=driver.getTitle();
		Assert.assertEquals(actual, expected);
		takeScreenShot("SignIn");
	}

	public SignInPage click_signin() {
		signin.click();
		return new SignInPage(driver);
	}
	
	public SignUpPage click_createAccnt() {
		createAccnt.click();
		return new SignUpPage(driver);
	}
	
	//Shopping Product
	public HomePage search_Product(String product) {
		search.sendKeys(product);
		searchBox.click();
		return this;
	}
	
	public HomePage click_continueShopping() {
		searchBox.click();
		return this;
	}

	public HomePage click_addToCart() {
		addToCart.click();
		return this;
	}

	//menu option selection
	public HomePage click_menu() {
		menu.click();
			return this;
	}
	//menu validation
	public void validate_menu() {
		List<WebElement> links = menuOptions;
		brokenLinkChecking(links);
	}

	public void validate_signUp() throws IOException {
		String actual ="An account with this email already exists.";
		String expected=singupText.getText();
		Assert.assertEquals(actual, expected);
		takeScreenShot("SignUp");
	}
}
