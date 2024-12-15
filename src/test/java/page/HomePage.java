package page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethod;

public class HomePage extends ProjectSpecifiedMethod {

	@FindBy(xpath = "//*[@id=\"account-menu-account-button\"]/span")
	WebElement account;

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	WebElement signin;

	@FindBy(id = "gh-search-input")
	WebElement search;

	@FindBy(xpath = "//*[@class='header-search-button ']")
	WebElement searchicon;
	
	@FindBy(xpath="//*[text()=\"Menu\"]")
	WebElement menu;
	
	@FindBy(tagName="a")
	List<WebElement> menuOptions;

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage click_Account() throws IOException {
		takeScreenShot("1.HomePage");
		account.click();
		return this;
	}
	public void validate_login() throws IOException {
		String actual ="Best Buy | Official Online Store | Shop Now & Save";
		String expected=driver.getTitle();
		takeScreenShot("2.SingIn");
		Assert.assertEquals(actual, expected);
		
	}

	public SignInPage click_signin() {
		signin.click();
		return new SignInPage(driver);
	}
	//

	public HomePage search(String searchid) {
		search.sendKeys(searchid);
		return this;
	}

	public ProductDetails searchicon() {
		searchicon.click();
		return new ProductDetails();
	}

	public HomePage click_menu() {
		menu.click();
			return this;
	}

	public void validate_menu() {
		List<WebElement> links = menuOptions;
		brokenLinkChecking(links);
	}
}
