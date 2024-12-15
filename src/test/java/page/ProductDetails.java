package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.ProjectSpecifiedMethod;

public class ProductDetails extends ProjectSpecifiedMethod{
      
	
	//@FindBy(xpath="//*[@id=\"fulfillment-add-to-cart-button-2252063\"]/div/div/div[1]")
	//WebElement seedetails;
	
	@FindBy(xpath="//*[@id=\"fulfillment-add-to-cart-button-37535832\"]/div/div/div[1]/button")
	WebElement addtocart;
	
	//public ProductDetails see_details() {
		
	//	seedetails.click();
	//	return this;
	//}
	
	public CartPage add_cart() {
		
		addtocart.click();
		return new CartPage();
	}
}
