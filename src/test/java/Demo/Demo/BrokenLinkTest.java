package Demo.Demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utitilities.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkTest {

	@Test
	public void BrokenLinkTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.goibibo.com/");

		Thread.sleep(2000);

		List<String> imgList = new ArrayList<String>();

		List<WebElement> ele = driver.findElements(By.tagName("img"));

		for (WebElement e : ele) {
			String text = e.getAttribute("src");
			if (text != null) {
				imgList.add(text);
			}

		}

		for (String val : imgList) {
			System.out.println(val);
			try {
				TestUtilities.checkBrokenImages(val);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
