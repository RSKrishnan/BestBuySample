package test;

import base.ProjectSpecifiedMethod;
import page.CartPage;

public class TC003_CheckoutInfo extends ProjectSpecifiedMethod{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CartPage obj=new CartPage(driver);
		obj.check_out()
		.payment_info();
	}

}
