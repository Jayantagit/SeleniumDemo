package Demo.Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://api.jquery.com/dblclick/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(
				ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
		
	

		WebElement dblBlock = driver.findElement(By.xpath("//span[contains(text(),'Double click the block')]//preceding::div"));
		
		System.out.println(dblBlock.getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", dblBlock);
		
		wait.until(
				ExpectedConditions.elementToBeClickable(dblBlock));
		


		Actions act = new Actions(driver);
		act.pause(Duration.ofSeconds(3)).doubleClick(dblBlock).perform();
		System.out.println(dblBlock.getCssValue("background-color").toString());
		
		
		if (dblBlock.getCssValue("background-color").equals("yellow")) {
			System.out.println("Double Click successfully");
		}

	}

}
