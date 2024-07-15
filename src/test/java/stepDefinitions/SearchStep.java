package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factoryDriver.AllDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep {

	WebDriver driver;

	@Given("User opens the Application")
	public void user_opens_the_application() {
		driver = AllDriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validPorduct) {
		driver.findElement(By.name("search")).sendKeys(validPorduct);
	}

	@When("User Click on Search button")
	public void user_click_on_search_button() {
		driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
	}

	@Then("User should get Valid Product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String InvalidProduct) {

		driver.findElement(By.name("search")).sendKeys(InvalidProduct);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText()); 
	}

	@When("User dont enter any product into search box field")
	public void user_dont_enter_any_product_into_search_box_field() {
		
		//Intentionally kept blank
	}

}
