package Demo.Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrap {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
		Thread.sleep(2000);
		
		 driver.findElement(By.id("menu1")).click();
		 
		 List<WebElement> ele = driver.findElements(By.xpath("//li[@role='presentation']//a"));
		 
		 for (WebElement e : ele) {
				String text = e.getText();
				System.out.println(text);

			}
			
			driver.close();
		
		

	}

}
