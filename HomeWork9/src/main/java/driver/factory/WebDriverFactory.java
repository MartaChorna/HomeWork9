package driver.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * A factory that returns a singleton of WebDriver object.
 */
public class WebDriverFactory {

	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";

	private static WebDriver webDriver;

	private WebDriverFactory() {
		
	}

	/**
	 * Gets the single instance of WebDriverFactory.
	 *
	 * @param browser the browser set in properties
	 * @return single instance of WebDriverFactory
	 */
	public static WebDriver getInstance(String browser) {
		if (webDriver == null) {
			if (CHROME.equals(browser)) {
				//setChromeDriver();
				WebDriverManager.chromedriver().setup();
				//ChromeOptions chromeOptions = new ChromeOptions();
				
				//Setting Chrome Profile
				//chromeOptions.addArguments("user-data-dir=C:/Users/user_name/AppData/Local/Google/Chrome/User Data");
				//chromeOptions.addExtensions(new File("path to extension"));
				
				//chromeOptions.setCapability("acceptSslCerts", true);
				//chromeOptions.setCapability("nativeEvents", true);
				//chromeOptions.addArguments("disable-infobars");

				webDriver = new ChromeDriver();
				
			} else if (FIREFOX.equals(browser)) {
				//setFFDriver();
				WebDriverManager.firefoxdriver().setup();
				
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				//firefoxOptions.setCapability("marionette", false);
				
				//Setting FF Profile
				/*ProfilesIni profile = new ProfilesIni();
				FirefoxProfile fp = profile.getProfile("/Users/bla bla path to profile");
				firefoxOptions.setCapability(FirefoxDriver.PROFILE, fp);*/
				
				//Example for extension
				//fp.addExtension(new File("path to extension"));
				//fp.addExtension(extensionToInstall)
				// new File(
				//	"C:\\Users\\Taras\\AppData\Local\Mozilla\Firefox\Profiles\o2l1s7ao.default-1422611077331"));
				
				webDriver = new FirefoxDriver();
				
			} else throw new IllegalArgumentException("Invalid browser property set in configuration file");
			
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		return webDriver;
	}

	/**
	 * Kill driver instance.
	 */
	public static void killDriverInstance() {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}

	/**
	 * Sets the chrome driver path for specific OS.
	 *
	 * @deprecated
	 */
	/*private static void setChromeDriver() {
		String osName = System.getProperty("os.name").toLowerCase();
		StringBuffer chromeBinaryPath = new StringBuffer(
				"src/main/resources/drivers/");

		if (osName.startsWith("win")) {
			chromeBinaryPath.append("chrome-win/chromedriver.exe");
		} else if (osName.startsWith("lin")) {
			chromeBinaryPath.append("chrome-lin/chromedriver");
		} else if (osName.startsWith("mac")) {
			chromeBinaryPath.append("chrome-mac/chromedriver");
		} else
			throw new IllegalStateException("Your OS is invalid for webdriver tests");

		System.setProperty("webdriver.chrome.driver",
				chromeBinaryPath.toString());
	}*/
	
	/**
	 * Sets the firefox driver path for specific OS.
	 *
	 * @deprecated
	 */
	/*private static void setFFDriver() {
		String osName = System.getProperty("os.name").toLowerCase();
		StringBuffer firefoxBinary = new StringBuffer(
				"src/main/resources/drivers/");

		if (osName.startsWith("win")) {
			firefoxBinary.append("ff-win/geckodriver.exe");
		} else if (osName.startsWith("lin")) {
			firefoxBinary.append("ff-lin/geckodriver");
		} else if (osName.startsWith("mac")) {
			firefoxBinary.append("ff-mac/geckodriver");
		} else
			throw new IllegalStateException("Your OS is invalid for webdriver tests");

		System.setProperty("webdriver.gecko.driver",
				firefoxBinary.toString());
	}*/

}