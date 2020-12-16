package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
	
	WebDriver driver;
	
	// Web elements
	@FindBy (xpath="//table//tr[@class='heading3']/td")
	WebElement userID;
	
	@FindBy (linkText="New Customer")
	WebElement newCustomerButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}
	
	public String getDashboardUserID() {
		return userID.getText();
	}
	
	public void clickNewCustomerButton() {
		newCustomerButton.click();
	}
}
