package TestNG;

import org.testng.annotations.Test;

public class DependsOn {
	@Test(groups = "smoke")
	public void test1(){
		System.out.println(4/0);
	}
	@Test(dependsOnMethods = "test1",groups = "smoke")
	public void test2(){
		System.out.println("test2");
	}
}
