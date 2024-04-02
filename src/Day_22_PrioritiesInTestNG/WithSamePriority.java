package Day_22_PrioritiesInTestNG;

import org.testng.annotations.Test;

public class WithSamePriority {
	//if have same priority the it will execute according to alphabet
	//capital-first
	//small-after
	@Test(priority=1)
	public void  Mango() {
		System.out.println("Mango");//1
	}

	@Test(priority=1)
	public void  banana() {
		System.out.println("banana");//2

		
	}
	@Test(priority=2)
	public void  watermelon() {
		System.out.println("watermelon");//4

		
	}@Test(priority=2)
	public void  apple() {
		System.out.println("Apple");//3

	}

}
