package test;

import base.ProjectSpecifiedMethod;
import page.PaymentDetails;

public class TC005_PayementInfo extends ProjectSpecifiedMethod{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		PaymentDetails obj=new PaymentDetails(driver);
		obj.card_number("123456781234")
		.First_name("sangi")
		.Last_name("k s")
		.add_ress("286,kallakurichi")
		.ci_ty("chennai")
		.Sta_te()
		.Zip_code("606201")
		.place_order();
	}

}
