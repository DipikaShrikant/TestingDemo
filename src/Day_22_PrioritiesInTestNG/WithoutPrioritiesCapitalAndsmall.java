package Day_22_PrioritiesInTestNG;

import org.testng.annotations.Test;

public class WithoutPrioritiesCapitalAndsmall {
	//in capita and small method name -capital will execute first
	@Test
	public void AAA() {
		System.out.println("AAA");//1
	}
	@Test
	public void BBB() {
		System.out.println("BBB");//2
	}@Test
	public void aaa() {
		System.out.println("aaa");//4
	}@Test
	public void bbb() {
		System.out.println("bbb");//5
	}@Test
	public void CCC() {
		System.out.println("CCC");//3
	}
}
