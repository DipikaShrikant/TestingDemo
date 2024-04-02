package Day_24_AsserionInTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertDemo {
	
	@Test
	public void Test01() {
		
		Assert.assertEquals(10, 10);
		System.out.println("1");
		Assert.assertEquals(200, 200);
		System.out.println("2");
		Assert.assertEquals("Dipika", "Dipika");
		System.out.println("3");
		Assert.assertEquals(10, 30);//exception
		System.out.println("4");
		Assert.assertEquals(1000, 1000);//skip
		System.out.println("5");
		Assert.assertEquals(60, 60);//skip
		System.out.println("6");//tC will get failed
	}
	
	@Test
	public void Test02() {
		Assert.assertEquals(10, 10);
		System.out.println("7");
		Assert.assertEquals(200, 200);
		System.out.println("8");
		Assert.assertEquals(40, 40);
		System.out.println("9");

	}

}
