package hooksPackage;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factoryDriver.AllDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class AllHooks {

	WebDriver driver;

	@Before
	public void setUp() {
		Properties prop = ConfigReader.intializeProperties();
		AllDriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver = AllDriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
