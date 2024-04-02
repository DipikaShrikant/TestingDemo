package Day_26_SkipTestMethod;

import org.testng.annotations.Test;

public class SkipMethod {
	//by default enabled=true
	@Test
	public void m1() {
		System.out.println("m1 method");
	}
	@Test
	public void m2() {
		System.out.println("m2 method");
	}
	@Test(enabled = false)
	public void m3() {
		System.out.println("m3 method");//skip
	}
	@Test
	public void m4() {
		System.out.println("m4 method");
	}

}
