package Demo.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeOptionsEg {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions();

		options.addArguments("--incognito");

		WebDriver driver = new EdgeDriver(options);

		driver.get("https://www.goibibo.com/");
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		driver.close();

	}

}
