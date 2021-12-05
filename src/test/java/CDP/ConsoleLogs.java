package CDP;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConsoleLogs {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://learn-automation.com/");
		
		System.out.println(driver.manage().logs().getAvailableLogTypes());
		
		LogEntries entries=driver.manage().logs().get(LogType.BROWSER);
		
		List<LogEntry> logs= entries.getAll();
		
		for(LogEntry e: logs)
		{
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
		driver.close();
		
	}

}
