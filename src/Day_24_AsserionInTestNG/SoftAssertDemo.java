package Day_24_AsserionInTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

	@Test
	public void test01() {
		SoftAssert soft = new SoftAssert();

		soft.assertEquals(10, 10);
		System.out.println("1");
		soft.assertEquals(100, 100);
		System.out.println("2");
		soft.assertEquals("D", "D");
		System.out.println("3");
		soft.assertEquals(10, 30);//exception
		System.out.println("4");//not skip
		soft.assertAll();//Tc will fail
	}

	@Test
	public void test02() {
		SoftAssert soft = new SoftAssert();
		soft.assertEquals('D', 'D');
		System.out.println("5");
		soft.assertEquals(10, 10);
		System.out.println("6");
		soft.assertEquals(10, 10);
		System.out.println("7");
		soft.assertAll();
	}

}
