package Day_22_WebsitePrioritirs;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JPetDemo {
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void URLLaunch() {
		driver.get("https://public.aspectran.com/jpetstore/account/newAccountForm");
	}

	@BeforeClass
	public void maximize() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void getCookies() {
		driver.manage().getCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void accountInfo() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Demo1000@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Demo@123");
		driver.findElement(By.name("repeatedPassword")).sendKeys("Demo@123");
		driver.findElement(By.name("firstName")).sendKeys("Demo");
		driver.findElement(By.name("lastName")).sendKeys("Test");
		driver.findElement(By.name("email")).sendKeys("Demo@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("1234567891");
		driver.findElement(By.name("address1")).sendKeys("Akurdi");
		driver.findElement(By.name("address2")).sendKeys("Ravet");
		driver.findElement(By.name("city")).sendKeys("Pune");
		driver.findElement(By.name("state")).sendKeys("Maharashtra");
		driver.findElement(By.name("zip")).sendKeys("411044");
		driver.findElement(By.name("country")).sendKeys("India");

		WebElement launguage = driver.findElement(By.name("languagePreference"));
		Select sel = new Select(launguage);
		sel.selectByValue("english");

		WebElement category = driver.findElement(By.xpath("//select[@name=\"favouriteCategoryId\"]"));
		Select sel2 = new Select(category);
		sel2.selectByVisibleText("Dogs");

		driver.findElement(By.xpath("//input[@name=\"listOption\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"bannerOption\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/div/button")).click();

	}

	@Test(priority = 2)
	public void Login() {
		driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]")).click();
		WebElement username = driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys("Demo1000@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Demo@123.com");
		driver.findElement(By.xpath("//div[@class=\"button-bar\"]//child::button")).click();

	}

	@Test(priority = 3)
	public void AllDogsInfo() {

		driver.findElement(By.xpath("//div[@id=\"QuickLinks\"]//child::a[2]")).click();
		WebElement DogsInfo = driver.findElement(By.id("Catalog"));
		List<WebElement> DogsRow = DogsInfo.findElements(By.tagName("tr"));
		System.out.println("====Dogs product id and name=====");
		for (int i = 0; i < DogsRow.size(); i++) {
			String D = DogsInfo.findElements(By.tagName("tr")).get(i).getText();
			System.out.println(D);
		}

	}

	@Test(priority = 4)
	public void particularFishInfo() {
		System.out.println("====particular fish product no and name");
		driver.findElement(By.xpath("//div[@id=\"QuickLinks\"]//child::a")).click();
		String Fishinfo = driver.findElement(By.xpath("//div[@id=\"Catalog\"]//child::tr[4]")).getText();
		System.out.println(Fishinfo);
	}

	@Test(priority = 5)
	public void CatsSpecies() {
		driver.findElement(By.xpath("//div[@id=\"QuickLinks\"]//child::a[4]")).click();

		List<WebElement> catsSpecies = driver.findElements(By.xpath("//div[@id=\"Catalog\"]//child::tr//td[2]"));
		System.out.println("========cat names =========");
		for (WebElement catsnm : catsSpecies) {
			System.out.println(catsnm.getText());
		}
	}

	@Test(priority = 6)
	public void Birds() {
		System.out.println("====birds name ====");
		driver.findElement(By.xpath("//div[@id=\"QuickLinks\"]//child::a[5]")).click();
		List<WebElement> birds = driver.findElements(By.xpath("//div[@id=\"Catalog\"]//child::tr//td[2]"));
		for (WebElement bird : birds) {
			System.out.println(bird.getText());
		}

	}

	@AfterMethod
	public void ScreenShot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\CJC -Classes\\TestNG Project CJC\\ScreenShot"));
	}

	@AfterClass
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void closeDB() {
		System.out.println("DB closed");
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
