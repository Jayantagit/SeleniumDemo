package CDP;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulateDeviceMode {

	public static void main(String[] args) {
				
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		
		Map<String,Object> deviceMetrics=new HashMap<String,Object>();
		deviceMetrics.put("width",400);
		deviceMetrics.put("height",486);
		deviceMetrics.put("deviceScaleFactor",100);
		deviceMetrics.put("mobile",true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
		driver.get("https://chromedevtools.github.io/devtools-protocol/tot/Emulation/#method-setDeviceMetricsOverride");

	}

}
