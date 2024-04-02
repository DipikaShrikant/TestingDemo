package Day_22_WebsitePrioritirs;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MagnetoDemo {

	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void URLLaunch() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
	}

	@BeforeClass
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void cookiesDetails() {
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Cookies count is=" + cookies.size());
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		// driver.findElement(By.partialLinkText("Create ")).click();
		driver.findElement(By.id("firstname")).sendKeys("Smriti");
		driver.findElement(By.id("lastname")).sendKeys("Mandana");
		driver.findElement(By.id("email_address")).sendKeys("Smriti.M199@gmail.com");
		driver.findElement(By.id("password")).sendKeys("SM1000@123");
//		String stengthmeter = driver.findElement(By.id("password-strength-meter")).getText();
//		System.out.println(stengthmeter);
		driver.findElement(By.id("password-confirmation")).sendKeys("SM1000@123");
		driver.findElement(By.xpath("//button[@class=\"action submit primary\"]//child::span")).click();
	}

	@Test(priority = 2)
	public void Login() throws InterruptedException {

		driver.findElement(By.cssSelector("button[class=\"action switch\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/customer/account/logout/\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("Smriti.M115@gmail.com");
		driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("SM1000@123");
		driver.findElement(By.cssSelector("button[class=\"action login primary\"]")).click();

	}
	@Test(priority = 3)
	public void AddTocart() throws InterruptedException {
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement women = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));
		act.moveToElement(women);
		WebElement tops = driver.findElement(By.cssSelector("//*[@id=\"ui-id-9\"]"));
		act.moveToElement(tops);
		WebElement tees = driver.findElement(By.cssSelector("//*[@id=\"ui-id-13\"]"));
		act.moveToElement(tees);
		tees.click();
		
		WebElement tshirt = driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[1]/div/div/strong/a"));
		act.moveToElement(tshirt);
		tshirt.click();

		driver.findElement(By.xpath("//div[@option-label=\"M\"]")).click();
		driver.findElement(By.xpath("//div[@option-label=\"Orange\"]")).click();
		WebElement quntity = driver.findElement(By.id("qty"));
		quntity.clear();
		quntity.sendKeys("5");

		driver.findElement(By.id("product-addtocart-button")).click();

	}

//	@Test(dependsOnMethods = "AddTocart")
//	public void Purchase() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.findElement(
//				By.xpath("//div[@data-block=\"minicart\"]//following-sibling::a[@class=\"action showcart\"]")).click();
//		String itmDetails = driver.findElement(By.xpath("//div[@class=\"product-item-details\"]")).getText();
//		System.out.println(itmDetails);
//		driver.findElement(By.id("top-cart-btn-checkout")).click();
//	}

	@AfterMethod
	public void Sc() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\CJC -Classes\\TestNG Project CJC\\ScreenShot"));
	}

	@AfterClass
	public void deletecookies() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void DbCose() {
	}

	@AfterSuite
	public void quit() {
		// driver.quit();
	}
}
