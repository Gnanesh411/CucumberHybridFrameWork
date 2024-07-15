package stepDefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factoryDriver.AllDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {

	WebDriver driver;

	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
		driver = AllDriverFactory.getDriver();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters below details into the fields")
	public void user_enters_below_details_into_the_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataMap.get("Telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataMap.get("Password"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataMap.get("Password"));
	}
	
	@When("User enters below details into the fields with duplicate email")
	public void User_enters_below_details_into_the_fields_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(dataMap.get("emailaddress"));
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataMap.get("Telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataMap.get("Password"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataMap.get("Password"));
	}

	@When("Selects Privacy Policy field")
	public void selects_privacy_policy_field() {
		driver.findElement(By.xpath("//input[@name='agree']")).click();
	}

	@When("Clicks on Continue button")
	public void clicks_on_continue_button() {

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {

		Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
	}

	@When("Selects Yes for newsletter")
	public void selects_yes_for_newsletter() {
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
				.contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter details into any fields")
	public void user_dont_enter_details_into_any_fields() {

		// Intentionally kept blank
	}

	@Then("User should get a proper warning messages for every mandatory field")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {
		System.out.println(driver.findElement(By.xpath("//input[@id='input-firstname']")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
				.contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				"First Name must be between 1 and 32 characters!");
		Assert.assertEquals(
				"Last Name must be between 1 and 32 characters!","Last Name must be between 1 and 32 characters!");
		Assert.assertEquals("E-Mail Address does not appear to be valid!",
				"E-Mail Address does not appear to be valid!");
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				"Telephone must be between 3 and 32 characters!");
		Assert.assertEquals("Password must be between 4 and 20 characters!",
				"Password must be between 4 and 20 characters!");

	}

	private String getEmailWithTimeStamp() {
		Date date = new Date();
		return "gnanesh" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

}
