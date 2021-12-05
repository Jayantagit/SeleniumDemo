package CDP;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.devtools.v94.network.model.Headers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// Create a Session

		DevTools cdp = driver.getDevTools();
		cdp.createSession();

		// Executing Commands-Enable Network
		cdp.send(Network.enable(Optional.of(0), Optional.of(0), Optional.of(0)));

		// Add Header
		cdp.send(Network.emulateNetworkConditions(true, 100, 20, 20, null));

		driver.get("https://www.amazon.in/");

	}

}
