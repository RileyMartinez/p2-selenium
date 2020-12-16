package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import pages.AddNewCustomerPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestAddNewCustomerForm {
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	AddNewCustomerPage addNewCustomerPage;
	
	static final String BANK_URL = "http://demo.guru99.com/V4/";
	static final String USER_ID = "mngr299698";
	static final String PASSWORD = "epYpame";
	static final String HEADLESS_ARG = "--headless";
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// Headless browser option
		// ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments(HEADLESS_ARG); 
		// driver = new ChromeDriver(chromeOptions);
		
		driver.get(BANK_URL);
		
		loginPage = new LoginPage(driver);
		loginPage.loginToBank(USER_ID, PASSWORD);
		
		homePage = new HomePage(driver);
		homePage.clickNewCustomerButton();
		
		addNewCustomerPage = new AddNewCustomerPage(driver);
	}
		
	@Test
	public void test_labels_1() {
		String pageTitle = addNewCustomerPage.getPageTitle();
		String customerNameLabel = addNewCustomerPage.getCustomerNameLabel();
		String genderLabel = addNewCustomerPage.getGenderLabel();
		
		AssertJUnit.assertEquals(pageTitle, "Add New Customer");
		AssertJUnit.assertEquals(customerNameLabel, "Customer Name");
		AssertJUnit.assertEquals(genderLabel, "Gender");
		
		
	}
	
	@Test
	public void test_labels_2() {
		String dobLabel = addNewCustomerPage.getDOBLabel();
		String addressLabel = addNewCustomerPage.getAddressLabel();
		String cityLabel = addNewCustomerPage.getCityLabel();
		
		AssertJUnit.assertEquals(dobLabel, "Date of Birth");
		AssertJUnit.assertEquals(addressLabel, "Address");
		AssertJUnit.assertEquals(cityLabel, "City");
	}
	
	@Test
	public void test_labels_3() {
		String stateLabel = addNewCustomerPage.getStateLabel();
		String pinLabel = addNewCustomerPage.getPINLabel();
		String mobileNumberLabel = addNewCustomerPage.getMobileNumberLabel();
		
		AssertJUnit.assertEquals(stateLabel, "State");
		AssertJUnit.assertEquals(pinLabel, "PIN");
		AssertJUnit.assertEquals(mobileNumberLabel, "Mobile Number");
	}
	
	@Test
	public void test_labels_4() {
		String emailLabel = addNewCustomerPage.getEmailLabel();
		String passwordLabel = addNewCustomerPage.getPasswordLabel();
		
		AssertJUnit.assertEquals(emailLabel, "E-mail");
		AssertJUnit.assertEquals(passwordLabel, "Password");
	}
	
	@Test
	public void test_reset_button() {
		addNewCustomerPage.setCustomerNameField("John Doe");
		addNewCustomerPage.clickResetButton();
		
		AssertJUnit.assertTrue(addNewCustomerPage.customerNameFieldIsEmpty());
	}
	  
	
	
	@AfterTest
	public void tear_down() {
		driver.quit();
	}

}
