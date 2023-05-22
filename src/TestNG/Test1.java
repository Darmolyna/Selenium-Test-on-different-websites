package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void Demo() {
		// TODO Auto-generated method stub
		System.out.println("hello demo");

	}
	
	@BeforeTest
	public void Perequisite() {
		// TODO Auto-generated method stub
		System.out.println("I will Before tests");
	}
	
	@BeforeSuite
	public void ABeforeSuite() { //higher priority to before and after test
		// TODO Auto-generated method stub
		System.out.println("i will run before suite");
	}
	
	@AfterTest
	public void AfterTest() {
		// TODO Auto-generated method stub
		System.out.println("i will run after test");
	}
}

