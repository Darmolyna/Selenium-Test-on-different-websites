package TestNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
	@Test
	public void Ploan() {
		// TODO Auto-generated method stub
		System.out.println("hello Ploan");

	}
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() {
		// TODO Auto-generated method stub
		System.out.println("I will Before executing any method in the class tests");
	}
	
	@BeforeTest
	public void Perequisite() {
		// TODO Auto-generated method stub
		System.out.println("I will Before tests");
	}
	
	@BeforeSuite
	public void BeforeSuite() { //higher priority to before and after test
		// TODO Auto-generated method stub
		System.out.println("i will run before suite");
	}
	
	@AfterSuite
	public void ABeforeSuite() { //higher priority to before and after test
		// TODO Auto-generated method stub
		System.out.println("i will run after suite");
	}
	
	@BeforeMethod
	public void BeforeMethod() { //higher priority to before and after test
		// TODO Auto-generated method stub
		System.out.println("i will run before every method in Test 3 file");
	}
	@AfterMethod
	public void AfterMethod() { //higher priority to before and after test
		// TODO Auto-generated method stub
		System.out.println("i will run after every method in Test 3 file");
	}
}
