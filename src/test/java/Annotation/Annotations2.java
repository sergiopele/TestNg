package Annotation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Annotations2 {
	@BeforeTest
	public void BT(){
		System.out.println("am before test");
	}
	
	@AfterTest
	public void AT(){
		System.out.println("am after test");
	}
	@BeforeSuite
	public void beforeSuit(){
		System.out.println("i am before suit _");
	}
	@AfterSuite
	public void afterSuit(){
		System.out.println("i am after suit -_-");
	}
	
}
