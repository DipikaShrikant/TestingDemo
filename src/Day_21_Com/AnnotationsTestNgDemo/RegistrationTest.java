package Day_21_Com.AnnotationsTestNgDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class RegistrationTest {
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void url() {
		driver.get("https://demo.automationtesting.in/");
	}

	@BeforeClass
	public void maximize() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void waits() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Registration() {
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Smriti");
		driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Mandhana");
		driver.findElement(By.xpath("//textarea[@ng-model=\"Adress\"]")).sendKeys("Filmcity,Mumbai");
		driver.findElement(By.xpath("//input[@ng-model=\"EmailAdress\"]")).sendKeys("SM1@gmail.com");
		driver.findElement(By.xpath("//input[@ng-model=\"Phone\"]")).sendKeys("2345678987");
		driver.findElement(By.xpath("//input[@value=\"FeMale\"]")).click();
		driver.findElement(By.id("checkbox1")).click();
		driver.findElement(By.id("msdd")).click();
		Actions act = new Actions(driver);
		WebElement Laung = driver
				.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a"));
		act.moveToElement(Laung);
		Laung.click();

		driver.findElement(By.xpath("//div[@class='form-group'][8]//child::label")).click();
		WebElement skills = driver.findElement(By.id("Skills"));
		Select sel = new Select(skills);
		sel.selectByValue("Java");

		WebElement countries = driver.findElement(By.id("countries"));
		Select sel2 = new Select(countries);
		sel2.selectByVisibleText("Select Country");

		driver.findElement(By.xpath("//span[@class=\"select2-selection select2-selection--single\"]"))
				.sendKeys("India");

		WebElement year = driver.findElement(By.xpath("//select[@id=\"yearbox\"]"));
		Select sel3 = new Select(year);
		sel3.selectByValue("2015");
		WebElement month = driver.findElement(By.xpath("//select[@placeholder=\"Month\"]"));
		Select sel4 = new Select(month);
		sel4.selectByVisibleText("December");
		driver.findElement(By.id("daybox")).sendKeys("12");

		driver.findElement(By.xpath("//input[@id=\"firstpassword\"]")).sendKeys("Dk123");
		driver.findElement(By.xpath("//input[@id=\"secondpassword\"]")).sendKeys("Dk123");

		driver.findElement(By.name("signup")).click();
	}

//	@AfterMethod
//	public void SC() throws IOException {
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFileToDirectory(src, new File("C:\\CJC -Classes\\TestNG Project CJC\\ScreenShot"));
//	}

	@AfterClass
	public void afterClass() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("close Db");
	}

	@AfterSuite
	public void setUp() {
		// driver.quit();
	}

}
