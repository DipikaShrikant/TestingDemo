package Day_22_PrioritiesInTestNG;

import org.testng.annotations.Test;

public class PositivePriority {
	//if we set priorities it will execute according to priority
	@Test(priority=1)
	public void addition() {
		System.out.println("Addition");//1
	}
	@Test(priority=2)
	public void substraction() {
		System.out.println("substaraction ");//2
	}
	@Test(priority=3)
	public void multiplication() {
		System.out.println("multiplication");//3
	}
	@Test(priority=4)
	public void division() {
		System.out.println("division");//4
	}
}
