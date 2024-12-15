package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethod;

public class CartPage extends ProjectSpecifiedMethod{

	@FindBy(xpath="//*[@id='cartApp']/div[2]/div/div[1]/div/div[2]/div[1]/section[2]/div/div/div[3]/div/div[1]")
	WebElement checkout;
	
	@FindBy(xpath="//*[@id=\"checkoutApp\"]/div[2]/div[1]/div[1]/main/div[3]/div[1]/section/div[3]/section/div/div/button")
	WebElement payment;
	
    public CartPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
    }
	public CartPage check_out() {
		
		checkout.click();
		return this;
	}
	
	public CartPage payment_info() {
		
		payment.click();
		return this;
	}
}
