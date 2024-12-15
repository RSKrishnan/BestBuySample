package test;

import base.ProjectSpecifiedMethod;
import page.HomePage;

public class TC002_SearchingProduct extends ProjectSpecifiedMethod{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		HomePage obj=new HomePage(driver);
		obj.search("Air Fryers & Deep Fryers")
		.searchicon()
		.add_cart();
	}

}
