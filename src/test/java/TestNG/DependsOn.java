package TestNG;

import org.testng.annotations.Test;

public class DependsOn {
	@Test
	public void test1(){
		System.out.println(4/0);
	}
	@Test(dependsOnMethods = "test1")
	public void test2(){
		System.out.println("test2");
	}
}
