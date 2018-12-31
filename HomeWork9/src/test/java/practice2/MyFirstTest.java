package practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.factory.WebDriverFactory;

public class MyFirstTest {
	private WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void before(@Optional("chrome") String browser) {
		driver = WebDriverFactory.getInstance(browser);
		driver.get("https://mail.google.com/");

		driver.findElement(By.id("identifierId")).clear();
		driver.findElement(By.id("identifierId")).sendKeys("forlits.check@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		// Thread.sleep(2000);

		//driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty123@");
		driver.findElement(By.id("passwordNext")).click();
		// Thread.sleep(2000);

		System.out.println(driver.getTitle());
		// Thread.sleep(2000);
	}

	@Test
	public void NotEmpty() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Search mail']")).sendKeys("Hi for");

		driver.findElement(By.xpath("//button[@class='gb_yf gb_If']")).click();
		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//td[@class='TC']")).isEmpty()) {
			System.out.println("not success");
		} else {
			System.out.println("success");
		}
	}

	@Test
		 
        public void Empty() throws Exception {
		
		driver.findElement(By.xpath("//input[@placeholder='Search mail']")).sendKeys("Hi NoEmail");

		driver.findElement(By.xpath("//button[@class='gb_yf gb_If']")).click();
		Thread.sleep(2000);

		if (driver.findElements(By.xpath("//td[@class='TC']")).isEmpty()) {
			System.out.println("not success");
		} else {
			System.out.println("success");
		}
	}


	@AfterMethod
	public void after() {
		WebDriverFactory.killDriverInstance();
	}
}
