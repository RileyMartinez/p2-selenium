package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.HomePage;

public class TestSuccessfulLogin {
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	static final String BANK_URL = "http://demo.guru99.com/V4/";
	static final String USER_ID = "mngr299698";
	static final String PASSWORD = "epYpame";
	static final String DRIVER_PATH = "/usr/local/bin";
	static final String HEADLESS_ARG = "--headless";
	
	@BeforeTest
	public void set_up() {
		// Lightweight method to set up driver
		WebDriverManager.chromedriver().setup();
		
		// Legacy method to set up driver
		// System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		
		// Headless browser option
		// ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments(HEADLESS_ARG); 
		// driver = new ChromeDriver(chromeOptions);
	
		driver.get(BANK_URL);
	}
	
	@Test
	public void test_successful_login() {
		loginPage = new LoginPage(driver);
		loginPage.loginToBank(USER_ID, PASSWORD);
		
		homePage = new HomePage(driver);
		AssertJUnit.assertTrue(homePage.getDashboardUserID().toLowerCase().contains(USER_ID));
	}
  
	@AfterTest
	public void tear_down() {
		driver.quit();
	}

}





