package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import page.HomePage;

public class TC004_MenuValidation extends ProjectSpecifiedMethod{
	@BeforeTest
	public void setup() throws IOException {
		testName="SignInTest";
		testDescription="Testing the Menu validation";
		testAuthor="Krish";
		testCategory="Smoke Testing";
	}
	
	@Test
	public void menuValidation() throws IOException {
        
		HomePage obj=new HomePage(driver);
		obj.click_menu()
		.validate_menu();
		
	}
}
