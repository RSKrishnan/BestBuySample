package page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethod;

public class SignInPage extends ProjectSpecifiedMethod{
     
	
	@FindBy(id="fld-e")
	WebElement email;
	
	@FindBy(id="fld-p1")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement signinbutton;
	
	@FindBy(id="password-radio")
	WebElement pWordRadioBtn;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement signIn;
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignInPage enter_email(String mailid) {
		email.sendKeys(mailid);
		return this;
	}
	
	public SignInPage enter_password(String pass) {
	//	visibilityOfElement(password);
		password.sendKeys(pass);
		return this;
	}
	
	public SignInPage click_pWordRadioBtn() {
		pWordRadioBtn.click();
		return this;
	}
	
	public SignInPage click_signin() {
		signinbutton.click();
		return this;
	}
	public HomePage click_sign() throws IOException {
		signIn.click();
		return new HomePage(driver);
	}
	
}
