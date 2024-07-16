package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factoryDriver.AllDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage lp;

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver = AllDriverFactory.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickOnMyaccount();
		hp.loginOption();
	}

	@When("User enters valid email address {string} into email field")
	public void User_enters_valid_email_address_into_email_field(String emailText) {
		lp = new LoginPage(driver);
		lp.enterEmail(emailText);
	}

	@When("User has entered valid password {string} into password field")
	public void user_has_entered_valid_password_into_password_field(String pswdText) {
		lp = new LoginPage(driver);
		lp.enterPassword(pswdText);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		lp = new LoginPage(driver);
		lp.clickOnLoginBtn();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		AccountPage ap = new AccountPage(driver);
		Assert.assertTrue(ap.displayStatusOfMyAccountOption());
	}

	@When("User enters invalid email address into email field")
	public void User_enters_invalid_email_address_into_email_field() {
		lp = new LoginPage(driver);
		lp.enterEmail(CommonUtils.getEmailWithTimeStamp());
	}

	@When("User has entered invalid password {string} into password field")
	public void User_has_entered_invalid_password_into_password_field(String Invalidpswd) {
		lp.enterPassword(Invalidpswd);
	}

	@When("User dont enter email address into email field")
	public void User_dont_enter_email_address_into_email_field() {
		lp = new LoginPage(driver);
		lp.enterEmail("");

	}

	@When("User dont enter password into password field")
	public void User_dont_enter_password_into_password_field() {

		lp.enterPassword("");
	}

	@Then("User should get a warning message about credentials mismatch")
	public void User_should_get_a_warning_message_about_credentials_mismatch() {

		Assert.assertTrue(lp.getwarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

}
