package Demo.Demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SampleTest {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement userName=driver.findElement(By.id("txtUsername"));
		String path=System.getProperty("user.dir")+"/src/test/resources/Screesnhot/"+System.currentTimeMillis()+".png";
		File target=new File(path);
		File src=userName.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, target);
		System.out.println(userName.getAccessibleName());
		System.out.println(userName.getDomAttribute("id"));
		WebElement pwd=driver.findElement(with(By.tagName("input")).below(userName));
		pwd.sendKeys("admin");
		
		By linkdin=By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		
		driver.findElement(linkdin).click();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.selenium.dev/documentation/webdriver/locating_elements/");
		
		
		

	}

}
