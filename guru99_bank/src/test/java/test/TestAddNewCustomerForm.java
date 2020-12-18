package test;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddNewCustomerPage;
import pages.HomePage;
import pages.LoginPage;
import resources.ReadExcel;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestAddNewCustomerForm {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private AddNewCustomerPage addNewCustomerPage;
	private String bankURL;
	private String password;
	private String username;
	private String expPageTitle;
	private String expCustomerNameLabel;
	private String expGenderLabel;
	private String expDOBLabel;
	private String expAddressLabel;
	private String expCityLabel;
	private String expStateLabel;
	private String expPINLabel;
	private String expMobileNumLabel;
	private String expEmailLabel;
	private String expPasswordLabel;
	private String customerName;
	private String gender;
	private String dob;
	private String address;
	private String city;
	private String state;
	private String pin;
	private String mobileNum;
	private String email;
	private String newPW;
	
	private static final String DATA_PATH = "test_data.xlsx";
	
	@BeforeTest
	@Parameters({"browser", "args"})
	public void setup(@Optional("Chrome") String browser, @Optional("") String args) throws Exception {
		// Initialize all test data from xlsx spreadsheet
		ReadExcel readTestData = new ReadExcel(DATA_PATH);
		username = readTestData.getCell(1, 0);
		password = readTestData.getCell(1, 1);
		bankURL = readTestData.getCell(1, 4);
		expPageTitle = readTestData.getCell(1, 2);
		expCustomerNameLabel = readTestData.getCell(2, 2);
		expGenderLabel = readTestData.getCell(3, 2);
		expDOBLabel = readTestData.getCell(4, 2);
		expAddressLabel = readTestData.getCell(5, 2);
		expCityLabel = readTestData.getCell(6, 2);
		expStateLabel = readTestData.getCell(7, 2);
		expPINLabel = readTestData.getCell(8, 2);
		expMobileNumLabel = readTestData.getCell(9, 2);
		expEmailLabel = readTestData.getCell(10, 2);
		expPasswordLabel = readTestData.getCell(11, 2);
		customerName = readTestData.getCell(2, 3);
		gender = readTestData.getCell(3, 3);
		dob = readTestData.getCell(4, 3);
		address = readTestData.getCell(5, 3);
		city = readTestData.getCell(6, 3);
		state = readTestData.getCell(7, 3);
		pin = readTestData.getCell(8, 3);
		mobileNum = readTestData.getCell(9, 3);
		email = readTestData.getCell(10, 3);
		newPW = readTestData.getCell(11, 3);
		
		switch(browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				if (!args.isEmpty()) {
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments(args);
					driver = new ChromeDriver(chromeOptions);
				} else {
					driver = new ChromeDriver();
				}
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				if (!args.isEmpty()) {
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					firefoxOptions.addArguments(args); 
					driver = new FirefoxDriver(firefoxOptions);
				} else {
					driver = new FirefoxDriver();
				}
				break;
			default:
				throw new Exception("Incorrect parameter for browser, check testng.xml");	
		}
	
		driver.get(bankURL);
		
		loginPage = new LoginPage(driver);
		loginPage.loginToBank(username, password);
		
		homePage = new HomePage(driver);
		homePage.clickNewCustomerButton();
		
		addNewCustomerPage = new AddNewCustomerPage(driver);
	}
		
	@Test
	public void test_labels_1() {
		String pageTitle = addNewCustomerPage.getPageTitle();
		String customerNameLabel = addNewCustomerPage.getCustomerNameLabel();
		String genderLabel = addNewCustomerPage.getGenderLabel();
		
		assertEquals(pageTitle, expPageTitle);
		assertEquals(customerNameLabel, expCustomerNameLabel);
		assertEquals(genderLabel, expGenderLabel);
		
		
	}
	
	@Test
	public void test_labels_2() {
		String dobLabel = addNewCustomerPage.getDOBLabel();
		String addressLabel = addNewCustomerPage.getAddressLabel();
		String cityLabel = addNewCustomerPage.getCityLabel();
		
		assertEquals(dobLabel, expDOBLabel);
		assertEquals(addressLabel, expAddressLabel);
		assertEquals(cityLabel, expCityLabel);
	}
	
	@Test
	public void test_labels_3() {
		String stateLabel = addNewCustomerPage.getStateLabel();
		String pinLabel = addNewCustomerPage.getPINLabel();
		String mobileNumberLabel = addNewCustomerPage.getMobileNumberLabel();
		
		assertEquals(stateLabel, expStateLabel);
		assertEquals(pinLabel, expPINLabel);
		assertEquals(mobileNumberLabel, expMobileNumLabel);
	}
	
	@Test
	public void test_labels_4() {
		String emailLabel = addNewCustomerPage.getEmailLabel();
		String passwordLabel = addNewCustomerPage.getPasswordLabel();
		
		assertEquals(emailLabel, expEmailLabel);
		assertEquals(passwordLabel, expPasswordLabel);
	}
	
	@Test
	public void test_fill_out_all_fields_and_press_reset_button() {
		addNewCustomerPage.setCustomerNameField(customerName);
		if (gender.equalsIgnoreCase("male")) {
			addNewCustomerPage.clickGenderMaleRadioBtn();
		} else {
			addNewCustomerPage.clickGenderFemaleRadioBtn();
		}
		addNewCustomerPage.setDOBField(dob);
		addNewCustomerPage.setAddressField(address);
		addNewCustomerPage.setCityField(city);
		addNewCustomerPage.setStateField(state);
		addNewCustomerPage.setPINField(pin);
		addNewCustomerPage.setMobileNumberField(mobileNum);
		addNewCustomerPage.setEmailField(email);
		addNewCustomerPage.setPasswordField(newPW);
		addNewCustomerPage.clickResetButton();
		
		assertTrue(addNewCustomerPage.getCustomerNameField().getAttribute("value").isEmpty());
		assertTrue(addNewCustomerPage.getGenderMaleRadioBtn().isSelected());
		assertTrue(addNewCustomerPage.getDOBField().getAttribute("value").isEmpty());
		assertTrue(addNewCustomerPage.getAddressField().getAttribute("value").isEmpty());
		assertTrue(addNewCustomerPage.getCityField().getAttribute("value").isEmpty());
		assertTrue(addNewCustomerPage.getStateField().getAttribute("value").isEmpty());
		assertTrue(addNewCustomerPage.getPINField().getAttribute("value").isEmpty());
		assertTrue(addNewCustomerPage.getMobileNumberField().getAttribute("value").isEmpty());
		assertTrue(addNewCustomerPage.getPasswordField().getAttribute("value").isEmpty());
		assertTrue(addNewCustomerPage.getPasswordField().getAttribute("value").isEmpty());
	}
	  
	
	
	@AfterTest
	public void tear_down() {
		driver.quit();
	}

}
