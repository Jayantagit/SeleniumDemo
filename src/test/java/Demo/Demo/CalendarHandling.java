package Demo.Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		Thread.sleep(2000);

		driver.findElement(By.id("datepicker")).click();

		By cal = By.xpath("//td[@data-handler='selectDay']//a");
		SelectDate(cal,"30");

	}

	public static void SelectDate(By Locator, String day) {
		List<WebElement> ele = driver.findElements(Locator);
		for (WebElement e : ele) {
			String text = e.getText();
			if(text.equals(day))
			{
				e.click();
				break;
			}

		}
	}

}
