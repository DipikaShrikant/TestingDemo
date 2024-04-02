package Day_22_PrioritiesInTestNG;

import org.testng.annotations.Test;

public class withPositiveAndNegativePriority {
	
	//first negative and then positive
	@Test(priority=-1)
	public void  Mango() {
		System.out.println("Mango");//2
	}

	@Test(priority=-2)
	public void  banana() {
		System.out.println("banana");//1

		
	}
	@Test(priority=3)
	public void  watermelon() {
		System.out.println("watermelon");//3

		
	}@Test(priority=4)
	public void  Apple() {
		System.out.println("Apple");//4

	}
}
