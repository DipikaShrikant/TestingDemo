package Day_22_WebsitePrioritirs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class WebShopTest {
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void URLLaunch() {
		driver.get("https://demowebshop.tricentis.com/");
	}

	@BeforeClass
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void cookiesDetails() {
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Cookies count is=" + cookies.size());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void Register() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Albert");
		driver.findElement(By.id("LastName")).sendKeys("Einstine");
		driver.findElement(By.id("Email")).sendKeys("AE21292@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("AE@12345");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("AE@12345");
		driver.findElement(By.id("register-button")).click();
		driver.findElement(By.cssSelector("input[class=\"button-1 register-continue-button\"]")).click();
		driver.findElement(By.cssSelector("a[class=\"ico-logout\"]")).click();
		System.out.println("Registration successful");

	}

	@Test(priority = 2)
	public void LoginCheck() {
		driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click();
		driver.findElement(By.id("Email")).sendKeys("AE21292@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("AE@12345");
		driver.findElement(By.id("RememberMe")).click();

		driver.findElement(By.cssSelector("input[class=\"button-1 login-button\"]")).click();
		System.out.println("Login successful");

	}

	@Test(priority = 3)
	public void AddTocart() throws InterruptedException {
System.out.println("Add to cart");
		driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/div[3]/div[2]/input"))
				.click();

		driver.findElement(By.cssSelector("input[class=\"button-1 cart-button\"]"));
		Actions act = new Actions(driver);

		WebElement shoppingcart = driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));

		Thread.sleep(2000);
		act.moveToElement(shoppingcart).build().perform();
		driver.findElement(By.xpath("//input[@value=\"Go to cart\"]")).click();
	}

	@Test(dependsOnMethods = "AddTocart")
	public void PurchaseProduct() {
		System.out.println("purcahse product");
		WebElement country = driver.findElement(By.xpath("//select[@id=\"CountryId\"]"));
		Select sel = new Select(country);
		sel.selectByValue("41");

		WebElement state = driver.findElement(By.id("StateProvinceId"));
		Select sel1 = new Select(state);
		sel1.selectByValue("0");
		driver.findElement(By.id("ZipPostalCode")).click();
		driver.findElement(By.name("estimateshipping")).click();
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
	}

	@Test(dependsOnMethods = "PurchaseProduct")
	public void checkout() {
		System.out.println("checkout");
		driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Flipcart");
		WebElement country = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
		Select sel = new Select(country);
		sel.selectByValue("41");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Pune");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Punawale");
		driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("Punawale");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("234567");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9876543123");
		driver.findElement(By.xpath("//div[@id=\"billing-buttons-container\"]//child::input")).click();
	}

	@Test(dependsOnMethods = "checkout")
	public void shipping() throws InterruptedException {
		System.out.println("shipping");
		Thread.sleep(3000);
		driver.findElement(By.id("PickUpInStore")).click();
		driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("paymentmethod_0")).click();
		driver.findElement(By.cssSelector("input[class='button-1 payment-method-next-step-button']")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input[class=\"button-1 payment-info-next-step-button\"]")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input[class=\"button-1 confirm-order-next-step-button\"")).click();

		driver.findElement(By.cssSelector("input[class=\"button-2 order-completed-continue-button\"]")).click();
	}

	@AfterMethod
	public void captureSC() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\CJC -Classes\\TestNG Project CJC\\ScreenShot"));

	}

	@AfterClass
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void closeDb() {
		System.out.println("DB Closed");
	}

	@AfterSuite
	public void closeWindow() {
	 driver.quit();
	}

}
