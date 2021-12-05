package Demo.Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestGoogle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		
		Thread.sleep(2000);
		
		 driver.findElement(By.name("q")).sendKeys("Mukesh");
		 
		 Thread.sleep(2000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//li[@role='presentation']//div[@role='option']//span"));
		
		for (WebElement e : ele) {
			String text = e.getText();
			System.out.println(text);

		}
		
		driver.close();
		
		
		
		

	}

}
