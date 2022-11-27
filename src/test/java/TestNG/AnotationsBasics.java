package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnotationsBasics {
	@Test
	public void firsttestCase() {
		System.out.println("This is first test case");
	}
	
	@Test
	public void seconTestCase() {
		System.out.println("This is second test case");
	}
	
	@Test
	public void thirdTestCase() {
		System.out.println("This is third test case");
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("am before method");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("I am after method");
	}
}
