package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstNameField;
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephoneField;
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPasswordField;
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyOption;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement YesNewsLetterOption;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarnig;
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void enterTelephoneNumber(String telphoneText) {
		telephoneField.sendKeys(telphoneText);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String ConfirmpasswordText) {
		confirmPasswordField.sendKeys(ConfirmpasswordText);
	}

	public void selectPrivacyPolicy() {
		privacyPolicyOption.click();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}

	public void selectNewSLetterOption() {
		YesNewsLetterOption.click();
	}

	public String getWarningMessageText() {
		return warningMessage.getText();
	}

	public String getFirstNameWarning() {

		return firstNameWarning.getText();
	}

	public String getLastNameWarning() {

		return lastNameWarnig.getText();
	}

	public String getEmailWarning() {

		return emailWarning.getText();
	}

	public String getTelePhoneWarning() {

		return telephoneWarning.getText();
	}

	public String getPasswordWarning() {

		return passwordWarning.getText();
	}
}
