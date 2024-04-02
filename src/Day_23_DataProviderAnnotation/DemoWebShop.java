package Day_23_DataProviderAnnotation;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoWebShop {
	WebDriver driver;
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void URLLaunch() {
		driver.get("https://demowebshop.tricentis.com/register");
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

	@Test(dataProvider = "getData", priority = 1)
	public void register(String fname, String lname, String email, String pass) {
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.name("FirstName")).sendKeys(fname);
		driver.findElement(By.name("LastName")).sendKeys(lname);
		driver.findElement(By.name("Email")).sendKeys(email);
		driver.findElement(By.name("Password")).sendKeys(pass);
		driver.findElement(By.name("ConfirmPassword")).sendKeys(pass);
		driver.findElement(By.name("register-button")).click();
		driver.navigate().back();
		driver.navigate().refresh();

	}

	@Test(dataProvider = "getLoginData", priority = 2)
	public void login(String email, String pass) {
		driver.findElement(By.cssSelector("a[class=\"ico-logout\"]")).click();
		driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click();
		driver.findElement(By.name("Email")).sendKeys(email);
		driver.findElement(By.name("Password")).sendKeys(pass);
		driver.findElement(By.name("RememberMe")).click();
		driver.findElement(By.cssSelector("input[class=\"button-1 login-button\"]")).click();
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

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { 
			new Object[] { "Shreyanka", "Patil", "SP61000@gmail.com", "SP@123" } ,
			new Object[] { "Smiriti", "Mandhana", "SM91000@gmail.com", "Sm@123" } ,
			new Object[] { "Jimmy", "S", "J81000@gmail.com", "js@123" } };


	}

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] { 
			new Object[] { "SP3000@gmail.com", "SP@123" },
			new Object[] { "SP6000@gmail.com", "Sp@123" } };

	}
}
