package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import page.HomePage;

public class TC005_ShoppingProduct extends ProjectSpecifiedMethod{
	@BeforeTest
	public void setup() throws IOException {
		testName="ShoppingTest";
		testDescription="Testing the Shopping functionality";
		testAuthor="Ram";
		testCategory="Regression Testing";
		sheetName="ShoppingTestData";
	}
	@Test(dataProvider="readData")
	public void shopping(String item) {
        
		HomePage obj=new HomePage(driver);
		obj.search_Product(item)
		.click_addToCart()
		.click_continueShopping();
	}

}
