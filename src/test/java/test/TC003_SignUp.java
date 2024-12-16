package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import page.CartPage;
import page.HomePage;

public class TC003_SignUp extends ProjectSpecifiedMethod{

	@BeforeTest
	public void setup() throws IOException {
		testName="SignUpTest";
		testDescription="Testing the SignUp functionality";
		testAuthor="Ram";
		testCategory="Regression Testing";
		sheetName="SignUpTestData";
	}
	
	@Test(dataProvider="readData")
	public void signUpTest(String firstname,String lastname,String emailId,String psw2,String psw1,String phone) throws IOException {
        
		HomePage obj=new HomePage(driver);
		obj.click_createAccnt()
		.enter_firstName(firstname)
		.enter_lastName(lastname)
		.enter_email(emailId)
		.enter_psw1(psw1)
		.enter_psw2(psw2)
		.enter_phone(phone)
		.click_submit()
		.validate_login();
	}

}
