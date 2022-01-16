package Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserStackDemo {

	public static final String USERNAME = "jayantamandal_6UPl17";
	public static final String AUTOMATE_KEY = "XjFCyCAjzR48WrRfoQRP";
	public static final String HUBURL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	WebDriver driver;

	@Test

	public void startDriver() {

		WebDriverManager.chromedriver().setup();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "11");
		caps.setCapability("browser", "Edge");
		caps.setCapability("browser_version", "latest");

		try {
			driver = new RemoteWebDriver(new URL(HUBURL), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get("https://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("BrowserStack");
		element.submit();

		driver.quit();
	}

}
