package day_26_DependsOnMethods;

import org.testng.annotations.Test;

public class DependsOnMethodDemo {
	
	
	@Test()
	public void m1() {
		System.out.println("m1 method");//2.depends on this
	}
	@Test(dependsOnMethods = "m1")
	public void m2() {
		System.out.println("m2 method");//1.output of this method- 
	}
	@Test(dependsOnMethods = "m2")
	public void m3() {
		System.out.println("m3 method");//1.output of this method- 
	}
	@Test(dependsOnMethods ="m3")
	public void m4() {
		System.out.println("m4 method");//1.output of this method- 
	}
}
