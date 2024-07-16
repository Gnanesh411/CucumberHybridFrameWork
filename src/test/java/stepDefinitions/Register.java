package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factoryDriver.AllDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountSuccessPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage rp;

	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
		driver = AllDriverFactory.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickOnMyaccount();
		hp.SelectRigisterOption();
	}

	@When("User enters below details into the fields")
	public void user_enters_below_details_into_the_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		rp = new RegisterPage(driver);
		rp.enterFirstName(dataMap.get("firstname"));
		rp.enterLastName(dataMap.get("lastname"));
		rp.enterEmail(CommonUtils.getEmailWithTimeStamp());
		rp.enterTelephoneNumber(dataMap.get("Telephone"));
		rp.enterPassword(dataMap.get("Password"));
		rp.enterConfirmPassword(dataMap.get("Password"));
	}

	@When("User enters below details into the fields with duplicate email")
	public void User_enters_below_details_into_the_fields_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		rp = new RegisterPage(driver);
		rp.enterFirstName(dataMap.get("firstname"));
		rp.enterLastName(dataMap.get("lastname"));
		rp.enterEmail(dataMap.get("emailaddress"));
		rp.enterTelephoneNumber(dataMap.get("Telephone"));
		rp.enterPassword(dataMap.get("Password"));
		rp.enterConfirmPassword(dataMap.get("Password"));

	}

	@When("Selects Privacy Policy field")
	public void selects_privacy_policy_field() {
		rp.selectPrivacyPolicy();
	}

	@When("Clicks on Continue button")
	public void clicks_on_continue_button() {
		rp.clickOnContinueButton();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {

		AccountSuccessPage ap = new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", ap.getPageHeading());
	}

	@When("Selects Yes for newsletter")
	public void selects_yes_for_newsletter() {

		rp.selectNewSLetterOption();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {

		Assert.assertTrue(rp.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter details into any fields")
	public void user_dont_enter_details_into_any_fields() {

		rp = new RegisterPage(driver);

	}

	@Then("User should get a proper warning messages for every mandatory field")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {

		Assert.assertTrue(rp.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", rp.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", rp.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", rp.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", rp.getTelePhoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", rp.getPasswordWarning());

	}

}
