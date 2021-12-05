package Utitilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class TestUtilities {
	/**
	 * This method is used to check the Broken Limks
	 * @param urlVal
	 * @throws IOException
	 */

	public static void checkBrokenImages(String urlVal) throws IOException {
		URL url = new URL(urlVal);

		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.connect();

		int code = 0;
		
	
		try {
			code = http.getResponseCode();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (code == HttpURLConnection.HTTP_OK || code == HttpURLConnection.HTTP_MOVED_PERM
				|| code == HttpURLConnection.HTTP_MOVED_TEMP) {
			
			System.out.println("Log:PASS"+code);

		}
		else
		{
			System.out.println("Log:FAIL"+code);
		}

	}

}
