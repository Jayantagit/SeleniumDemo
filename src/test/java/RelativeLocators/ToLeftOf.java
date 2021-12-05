package RelativeLocators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToLeftOf {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		WebElement searchIcon=driver.findElement(By.cssSelector("input#nav-search-submit-button"));
		
		//driver.findElement(with(By.tagName("input")).toLeftOf(searchIcon)).sendKeys("Laptop");
		
		driver.findElement(with(By.tagName("input")).near(searchIcon)).sendKeys("Laptop");

	}

}
