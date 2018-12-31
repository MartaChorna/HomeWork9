package practice2;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WebTestBase {
	
	
	protected ThreadLocal<RemoteWebDriver> threadDiver = new ThreadLocal<RemoteWebDriver>();

}
