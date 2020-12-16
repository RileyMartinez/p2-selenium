package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewCustomerPage {

	WebDriver driver;
	
	//Web elements
	By pageTitle = By.xpath("//table[@class='layout']//p[@class='heading3'][contains(text(), 'Add New Customer')]");
	
	By customerNameLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'Customer Name')]");
	By customerNameField = By.name("name");
	
	By genderLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'Gender')]");
	By genderMaleRadioBtn = By.xpath("//input[@name='rad1' and @value='m']");
	By genderFemaleRadioBtn = By.xpath("//input[@name='rad1' and @value='f']");
	
	By dobLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'Date of Birth')]");
	By dobField = By.id("dob");
	
	By addressLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'Address')]");
	By addressField = By.name("addr");
	
	By cityLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'City')]");
	By cityField = By.name("city");
	
	By stateLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'State')]");
	By stateField = By.name("state");
	
	By pinLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'PIN')]");
	By pinField = By.name("pinno");
	
	By mobileNumberLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'Mobile')]");
	By mobileNumberField = By.name("telephoneno");
	
	By emailLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'E-mail')]");
	By emailField = By.name("emailid");
	
	By passwordLabel = By.xpath("//table[@class='layout']//td[contains(text(), 'Password')]");
	By passwordField = By.name("");
	
	By submitButton = By.name("sub");
	By resetButton = By.name("res");
	
	public AddNewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	
	public String getCustomerNameLabel() {
		return driver.findElement(customerNameLabel).getText();
	}
	
	public boolean customerNameFieldIsEmpty() {
		return driver.findElement(customerNameField).getAttribute("value").isEmpty();
	}
	
	public void setCustomerNameField(String name) {
		driver.findElement(customerNameField).sendKeys(name);
	}
	
	public String getGenderLabel() {
		return driver.findElement(genderLabel).getText();
	}
	
	public void clickGenderMaleRadioBtn() {
		driver.findElement(genderMaleRadioBtn).click();
	}
	
	public void clickGenderFemaleRadioBtn() {
		driver.findElement(genderFemaleRadioBtn).click();
	}
	
	public String getDOBLabel()	{
		return driver.findElement(dobLabel).getText();
	}
	
	public void setDOBField(String dob) {
		driver.findElement(dobField).sendKeys(dob);
	}
	
	public String getAddressLabel() {
		return driver.findElement(addressLabel).getText();
	}
	
	public void setAddressField(String address) {
		driver.findElement(addressField).sendKeys(address);
	}
	
	public String getCityLabel() {
		return driver.findElement(cityLabel).getText();
	}
	
	public void setCityField(String city) {
		driver.findElement(cityField).sendKeys(city);
	}
	
	public String getStateLabel() {
		return driver.findElement(stateLabel).getText();
	}
	
	public void setStateField(String state) {
		driver.findElement(stateField).sendKeys(state);
	}
	
	public String getPINLabel() {
		return driver.findElement(pinLabel).getText();
	}
	
	public void setPINField(String pin) {
		driver.findElement(pinField).sendKeys(pin);
	}
	
	public String getMobileNumberLabel() {
		return driver.findElement(mobileNumberLabel).getText();
	}
	
	public void setMobileNumberField(String mobileNumber) {
		driver.findElement(mobileNumberField).sendKeys(mobileNumber);
	}
	
	public String getEmailLabel() {
		return driver.findElement(emailLabel).getText();
	}
	
	public void setEmailField(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	
	public String getPasswordLabel() {
		return driver.findElement(passwordLabel).getText();
	}
	
	public void setPasswordField(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	
	public void clickResetButton() {
		driver.findElement(resetButton).click();
	}
}
