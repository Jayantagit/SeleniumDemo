package Demo.Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentDemo {

	@Test
	public void Login() {

		System.out.println("Login");

		Assert.assertEquals(true, true);
	}

	@Test
	public void Search() {

		System.out.println("Search");

		Assert.assertEquals(true, true);
	}
	
	@Test(enabled=false)
	public void Payment() {

		System.out.println("Payment");

		Assert.assertEquals(true, false);
	}
}
