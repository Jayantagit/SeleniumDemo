package Demo.Demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripcal {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		driver.get("https://www.makemytrip.com/flights/?");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Thread.sleep(4000);

		/*
		 * Alert alert=driver.switchTo().alert(); alert.accept();
		 */
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("li[class$='userLoggedOut']")).click();
		
	
		//driver.switchTo().alert().dismiss();

		//driver.findElement(By.xpath("//label[@for='departure']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='departure']"))).click();

		By returnDate = By.xpath("(//div[@class='DayPicker-Month'])[2]//div[@role='gridcell']//p");

		String MonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[2]//div")).getText();

		String startDay = "September 2022";

		while (!MonthYear.contains(startDay)) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			MonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[2]//div")).getText();
			System.out.println(MonthYear);
		}

		List<WebElement> startDayList = driver.findElements(returnDate);

		for (WebElement e : startDayList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains("9")) {
				e.click();
				break;
			}

		}

	}

}
