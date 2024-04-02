package Day_23_DataProviderAnnotation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Magneto {
	WebDriver driver;

	@Test(dataProvider = "getData", priority = 1)
	public void Register(String fname, String lname, String email, String pass) {
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("password_confirmation")).sendKeys(pass);

		driver.findElement(By.xpath("//button[@class=\"action submit primary\"]//child::span")).click();

	}

	@Test(dataProvider = "getLoginData", priority = 2)
	public void Login(String email, String pass) {
		driver.findElement(By.cssSelector("button[class=\"action switch\"]")).click();
		driver.findElement(
				By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/customer/account/logout/\"]"))
				.click();

		driver.findElement(By.cssSelector(
				"a[href=\"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/\"]"))
				.click();

		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@class=\"action login primary\"]//child::span")).click();

	}

	@Test(priority = 3)
	public void AddTocart() throws InterruptedException {
		WebElement womens = driver.findElement(By.cssSelector("a[id=\"ui-id-4\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(womens);
		WebElement tops = driver.findElement(By.cssSelector("a[id=\"ui-id-9\"]"));
		act.moveToElement(tops);
		WebElement jackets = driver.findElement(By.cssSelector("a[id=\"ui-id-11\"]"));
		act.moveToElement(jackets).build().perform();
		jackets.click();
		WebElement pDetails = driver.findElement(By.cssSelector("div[class=\"product details product-item-details\"]"));
		act.moveToElement(pDetails);
		WebElement addtocart = driver.findElement(By.xpath("//button[@title=\"Add to Cart\"]//child::span"));
		act.moveToElement(addtocart).build().perform();
		Thread.sleep(2000);
		addtocart.click();
	}
	
	@Test(priority=4,dataProvider ="cart" )
	
	public void gotocart(String qunty) throws InterruptedException {
		
		driver.findElement(By.cssSelector("div[option-label=\"M\"]")).click();
		driver.findElement(By.cssSelector("div[option-label=\"Black\"]")).click();
		WebElement quntity = driver.findElement(By.id("qty"));
		quntity.clear();
		quntity.sendKeys(qunty);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title=\"Add to Cart\"]//child::span")).click();
		driver.findElement(By.xpath("//a[@class=\"action showcart\"]//child::span")).click();
		driver.findElement(By.cssSelector("button[class=\"action primary checkout\"]")).click();
		Thread.sleep(2000);
		
	}
@Test(priority=5)
public void Purchase() throws InterruptedException {
	
	
}
	@BeforeMethod
	public void maximizeWin() {
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void Sc() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\CJC -Classes\\TestNG Project CJC\\ScreenShot"));

	}

	@BeforeClass
	public void getCookies() {
		driver.manage().getCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void deleteCokkies() {
		driver.manage().deleteAllCookies();
	}

	@BeforeTest
	public void launchUrl() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
	}

	@AfterTest
	public void closeDB() {
		System.out.println("Db closed");
	}

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void closeResrce() {
		// driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { new Object[] { "Suryakumar", "Yadav", "SKV11900@gmail.com", "SKV@123456" }

		};

	}

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] { new Object[] { "SKV11900@gmail.com", "SKV@123456" },

		};
	}
	@DataProvider
	public Object[][]cart(){
		return new Object[][] { new Object[] { "5"},

		};
	}
}
