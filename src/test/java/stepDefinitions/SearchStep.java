package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factoryDriver.AllDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;

public class SearchStep {

	WebDriver driver;
	private HomePage hp;
	private SearchResultPage sp;

	@Given("User opens the Application")
	public void user_opens_the_application() {

		driver = AllDriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validPorductText) {
		hp = new HomePage(driver);
		hp.enterProductIntoSearchBox(validPorductText);
	}

	@When("User Click on Search button")
	public void user_click_on_search_button() {
		hp.clickOnSearchButton();
	}

	@Then("User should get Valid Product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {

		sp = new SearchResultPage(driver);
		Assert.assertTrue(sp.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String InvalidProduct) {

		hp = new HomePage(driver);
		hp.enterProductIntoSearchBox(InvalidProduct);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		sp = new SearchResultPage(driver);

		Assert.assertEquals("There is no product that matches the search criteria.", sp.getMessageText());
	}

	@When("User dont enter any product into search box field")
	public void user_dont_enter_any_product_into_search_box_field() {

		hp = new HomePage(driver);

	}

}
