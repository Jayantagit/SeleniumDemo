package Demo.Demo;

import java.net.URI;


import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFourTest extends BaseTest {

	// https://the-internet.herokuapp.com/basic_auth

	@Test
	public void authTest() 
	{
		
		
		Predicate<URI> uriPr = uri -> uri.getHost().contains("the-internet.herokuapp");

		((HasAuthentication) driver).register(uriPr, UsernameAndPassword.of("admin", "admin"));
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
	}
	
	@Test
	public void authTest3() 
	{
		
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}

}
