package hooksPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import factoryDriver.AllDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AllHooks {

	WebDriver driver;
	@Before
	public void setUp() {
		AllDriverFactory.initializeBrowser("chrome");
		driver=AllDriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
