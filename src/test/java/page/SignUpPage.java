package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethod;

public class SignUpPage extends ProjectSpecifiedMethod {

	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="fld-p1")
	WebElement psw1;
	
	@FindBy(id="reenterPassword")
	WebElement psw2;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(xpath="(//*[text()=\"Create an Account\"])[2]")
	WebElement submit;
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage enter_firstName(String firstname) {
		firstName.sendKeys(firstname);
		return this;
	}
	public SignUpPage enter_lastName(String last) {
		lastName.sendKeys(last);
		return this;
	}
	public SignUpPage enter_email(String emailId) {
		email.sendKeys(emailId);
		return this;
	}
	public SignUpPage enter_psw1(String psw11) {
		psw1.sendKeys(psw11);
		return this;
	}
	public SignUpPage enter_psw2(String psw22) {
		psw2.sendKeys(psw22);
		return this;
	}
	public SignUpPage enter_phone(String contact) {
		phone.sendKeys(contact);
		return this;
	}
	public HomePage click_submit() {
		submit.click();
		return new HomePage(driver);
	}
}
