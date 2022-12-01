package Annotation;

import org.testng.annotations.*;

public class Annotations {
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("it's before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("am after class");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Bofere method");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("after Method");
	}
	
	@Test
	public void AFirstTest() {
		System.out.println("am test1");
	}
	
	@Test
	public void BSecondTest() {
		System.out.println("Second Test");
	}
}
