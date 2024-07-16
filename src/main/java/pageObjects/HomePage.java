package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginOption;
	@FindBy(linkText = "Register")
	private WebElement rigisterOption;
	@FindBy(name = "search")
	private WebElement searchOption;
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;

	public void clickOnMyaccount() {
		myAccountDropMenu.click();
	}

	public void loginOption() {
		loginOption.click();
	}

	public void SelectRigisterOption() {
		rigisterOption.click();
	}

	public void enterProductIntoSearchBox(String ProductText) {
		searchOption.sendKeys(ProductText);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}
}
