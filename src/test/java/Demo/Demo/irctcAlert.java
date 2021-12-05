package Demo.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class irctcAlert {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.irctc.co.in/");

		Thread.sleep(2000);
		
		if(driver.findElements(By.xpath("//button[text()='OK']")).size()>0)
		{
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		}

	}

}
