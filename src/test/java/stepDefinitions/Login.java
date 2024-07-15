package stepDefinitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factoryDriver.AllDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	WebDriver driver;
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver=AllDriverFactory.getDriver();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

	}

	@When("User enters valid email address {string} into email field")
	public void User_enters_valid_email_address_into_email_field(String emailText) {

		driver.findElement(By.id("input-email")).sendKeys(emailText);

	}

	@When("User has entered valid password {string} into password field")
	public void user_has_entered_valid_password_into_password_field(String pswdText) {
		driver.findElement(By.id("input-password")).sendKeys(pswdText);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed());
	}

	@When("User enters invalid email address into email field")
	public void User_enters_invalid_email_address_into_email_field() {
		driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	}

	@When("User has entered invalid password {string} into password field")
	public void User_has_entered_invalid_password_into_password_field(String Invalidpswd) {
		driver.findElement(By.id("input-password")).sendKeys(Invalidpswd);
	}

	@When("User dont enter email address into email field")
	public void User_dont_enter_email_address_into_email_field() {

		driver.findElement(By.id("input-email")).sendKeys("");
	}

	@When("User dont enter password into password field")
	public void User_dont_enter_password_into_password_field() {

		driver.findElement(By.id("input-password")).sendKeys("");
	}

	@Then("User should get a warning message about credentials mismatch")
	public void User_should_get_a_warning_message_about_credentials_mismatch() {

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
				.contains("Warning: No match for E-Mail Address and/or Password."));
	}
	private String getEmailWithTimeStamp() {
		Date date = new Date();
		return "gnanesh" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}


}
