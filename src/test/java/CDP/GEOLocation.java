package CDP;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GEOLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		
		Map<String,Object> geoMetrics=new HashMap<String,Object>();
		geoMetrics.put("latitude",40.712776);
		geoMetrics.put("longitude",-74.005974);
		geoMetrics.put("accuracy",100);
		
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", geoMetrics);
		
		driver.get("https://locations.dennys.com/search.html");
		
		driver.findElement(By.xpath("//*[name()='svg' and contains(@class,'icon-geolocate')]")).click();
		Thread.sleep(5000);
		
		driver.close();

	}

}
