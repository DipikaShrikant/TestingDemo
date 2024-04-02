package Day_22_PrioritiesInTestNG;

import org.testng.annotations.Test;

public class NegativePriorities {
	//as higher the negative priority that testcase will execute first
	@Test(priority=-1)
	public void apple() {
		System.out.println("apple");//4
	}
	@Test(priority=2)
	public void Banana() {
		System.out.println("Banana ");//3
	}
	@Test(priority=-3)
	public void pomgranate() {
		System.out.println("pomgranate");//2
	}
	@Test(priority=-4)
	public void pinapple() {
		System.out.println("pinapple");//1
	}

}
