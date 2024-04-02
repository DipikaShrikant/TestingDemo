package Day_22_PrioritiesInTestNG;

import org.testng.annotations.Test;

public class WithoutPriority {
	//without priorities the execution done alphabatically a-z
	
	@Test
	public void addition() {
		System.out.println("Addition");//1
	}
	@Test
	public void substraction() {
		System.out.println("substaraction ");//4
	}
	@Test
	public void multiplication() {
		System.out.println("multiplication");//3
	}
	@Test
	public void division() {
		System.out.println("division");//2
	}
	

}
