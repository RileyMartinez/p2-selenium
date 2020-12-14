package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
	
	WebDriver driver;
	
	// Web elements
	@FindBy (className="barone")
	WebElement title;
	
	@FindBy (name="uid")
	WebElement userIDField;
	
	@FindBy (name="password")
	WebElement passwordField;
	
	@FindBy (name="btnLogin")
	WebElement loginButton;
	
	@FindBy (name="btnReset")
	WebElement resetButton;
	
	// Instantiate web driver and initialize all web elements
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}
	
	// Types text in the UserID field
	public void setUserID(String userID) {
		userIDField.sendKeys(userID);
	}
	
	// Types text in the Password field
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	// Clicks the Login button
	public void clickLoginButton() {
		loginButton.click();
	}
	
	// Clicks the reset button
	public void clickResetButton() {
		resetButton.click();
	}
	
	// Return the page title
	public String getLoginTitle() {
		return title.getText();
	}
	
	// Log into the bank portal
	public void loginToBank(String userID, String password) {
		setUserID(userID);
		setPassword(password);
		clickLoginButton();
	}
}
