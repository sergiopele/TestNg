package Annotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {
	@BeforeMethod
	public void BeforeMethod(){
		System.out.println("Bofere method");
	}
	@AfterMethod
	public void AfterMethod(){
		System.out.println("after Method");
	}
	@Test
	public void AFirstTest(){
		System.out.println("am test1");
	}
	@Test
	public void BSecondTest(){
		System.out.println("Second Test");
	}
}
