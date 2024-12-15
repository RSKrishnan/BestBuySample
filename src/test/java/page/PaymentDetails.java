package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecifiedMethod;

public class PaymentDetails extends ProjectSpecifiedMethod{

	

	@FindBy(id="cc-number")
	WebElement cardnumber;
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="address-input")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="postalCode")
	WebElement zipcode;
	
	@FindBy(xpath="//*[@id=\"checkoutApp\"]/div[2]/div[1]/div[1]/main/div[3]/div[2]/div/section/div[2]/div/div[2]/div/button")
	WebElement placeorder;
	
    public PaymentDetails(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
    }
	public PaymentDetails card_number(String cardno) {
		
		cardnumber.sendKeys(cardno);
		return this;
	}
	
	public PaymentDetails First_name(String fname) {
		
		firstname.sendKeys(fname);
		return this;
	}
	
	public PaymentDetails Last_name(String lname) {
		
		 lastname.sendKeys(lname);
		 return this;
	}
	
	public PaymentDetails add_ress(String add) {
		
		address.sendKeys(add);
		return this;
	}
	
	public PaymentDetails ci_ty(String cityd) {
		
		city.sendKeys(cityd);
		return this;
	}
	
	public PaymentDetails Sta_te() {
		
		Select select=new Select(state);
		select.selectByValue("IN");
		return this;
	}
	
	public PaymentDetails Zip_code(String code) {
		
		zipcode.sendKeys(code);
		return this;
	}
	
	public PaymentDetails place_order() {
		
		placeorder.click();
		return this;
	}
}
