package Day_22_PrioritiesInTestNG;

import org.testng.annotations.Test;

public class withPAndNAndWithout {
	//first it will execute the negative no priority then without bcoz it is by default
	//zero and the positive
	@Test
	public void addition() {
		System.out.println("Addition");//2
	}
	@Test(priority=1)
	public void substraction() {
		System.out.println("substaraction ");//3
	}
	@Test(priority=3)
	public void multiplication() {
		System.out.println("multiplication");//4
	}
	@Test(priority=-4)
	public void division() {
		System.out.println("division");//1
	}
}
