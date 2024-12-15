package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import page.HomePage;

public class TC001_SignIn extends ProjectSpecifiedMethod{
	@BeforeTest
	public void setup() throws IOException {
		testName="SignInTest";
		testDescription="Testing the SignUp functionality";
		testAuthor="Ram";
		testCategory="Regression Testing";
		sheetName="SignUpTestData";
	}
	
	@Test(dataProvider="readData")
	public void signUpTest(String email,String password) throws IOException {
        
		HomePage obj=new HomePage(driver);
		obj.click_Account()
		.click_signin()
		.enter_email(email)
		.click_signin()
		.click_pWordRadioBtn()
		.enter_password(password)
		.click_sign()
		.validate_login();
		
	}
}
