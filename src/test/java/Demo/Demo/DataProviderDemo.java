package Demo.Demo;

import org.testng.annotations.Test;

public class DataProviderDemo extends BaseTest {
	
	
	
	@Test(dataProvider="login")
	
	public void doLogin(String un,String pwd)
	{
		System.out.println("Username:"+un+"Password ="+pwd);
	}

}
