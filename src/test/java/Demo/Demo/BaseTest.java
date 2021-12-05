package Demo.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@DataProvider(name="login")
	
	public static Object[][] loginData()
	{
		return new Object[][] {{"Jayanta","J123"},{"Mahesh","M123"}};
	}
	
	

}
