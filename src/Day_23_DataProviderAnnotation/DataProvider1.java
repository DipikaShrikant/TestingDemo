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

public class DataProvider1 {

	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void URLLaunch() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
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

	@Test(dataProvider = "getData")
	public void DemoLogin(String user, String pass) {
		driver.findElement(By.name("userName")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("submit")).click();

		driver.navigate().back();
		driver.findElement(By.name("userName")).clear();

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
		return new Object[][] { new Object[] { "AAA", "aaa" }, 
			new Object[] { "BBB", "bbb" } };
	}
}