package Demo.Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIBiBoCal {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.goibibo.com/");

		Thread.sleep(2000);

		driver.findElement(By.id("departureCalendar")).click();

		By cal = By.cssSelector("div.calDate");
		List<WebElement> startDayList = driver.findElements(cal);

		for (WebElement e : startDayList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains("30")) {
				e.click();
				break;
			}

		}
	}
}
