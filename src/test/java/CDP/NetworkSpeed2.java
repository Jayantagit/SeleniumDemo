package CDP;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.devtools.v94.network.model.Headers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		Map<String, Object> netWorkSpeed = new HashMap<String, Object>();
		netWorkSpeed.put("offline", false);
		netWorkSpeed.put("latency", 100);
		netWorkSpeed.put("downloadThroughput", 1024);
		netWorkSpeed.put("uploadThroughput", 1024);

		driver.executeCdpCommand("Network.emulateNetworkConditions", netWorkSpeed);

		driver.get("https://www.amazon.in/");

	}

}
