package Demo.Demo;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class DPTest {

	WebDriver driver;

	@DataProvider(name = "getLoginData")
	public Object[][] getData() {

		return new Object[][] { { "Admin", "admin123" }, { "Mahesh", "m123" } };
	}

	@Test(dataProvider = "getLoginData")
	public void loginTest(String un, String pwd) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(un);
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"),"Login Failed");

	}

	@BeforeMethod
	public void LuanchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
