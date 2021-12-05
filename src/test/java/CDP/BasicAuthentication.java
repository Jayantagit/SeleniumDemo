package CDP;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.devtools.v94.network.model.Headers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

				
		/**
		 * Encoding Credentials using Apache Base64
		 */

		String creds = new String(Base64.encode(String.format("%s:%s", "guest", "guest").getBytes()));
		Map<String,Object> header=new HashMap<String,Object>();
		header.put("Authorization", "Basic "+creds);

		System.out.println(creds);
		
		//Create a Session

		DevTools cdp = driver.getDevTools();
		cdp.createSession();
		
		//Executing Commands-Enable Network
		cdp.send(Network.enable(Optional.of(0), Optional.of(0), Optional.of(0)));
		
		//Add Header
		cdp.send(Network.setExtraHTTPHeaders(new Headers(header)));
		
		driver.get("https://jigsaw.w3.org/HTTP/Basic");
		
		Thread.sleep(5000);
		
		driver.close();

	}

}
