package Demo.Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIboboTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.goibibo.com/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Delhi");
		
		Thread.sleep(2000);
		
		// Goibbo--Auto suggest-Stop in Debugging->Go to source Tab->source-Ctrl+\  or (F8)
		
		List<WebElement> fromList=driver.findElements(By.xpath("//div[@class='mainTxt clearfix']//span"));
		
		System.out.println(fromList.size());
		
		for(WebElement e: fromList)
		{
			System.out.println(e.getText());
			
		}
		
		

	}

}
