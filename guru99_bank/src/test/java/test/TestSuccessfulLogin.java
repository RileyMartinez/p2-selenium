package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.HomePage;

public class TestSuccessfulLogin {
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	static final String BANK_URL = "http://demo.guru99.com/V4/";
	static final String USER_ID = "mngr299698";
	static final String PASSWORD = "epYpame";
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(BANK_URL);
	}
	
	@Test
	public void testSuccessfullLogin() {
		loginPage = new LoginPage(driver);
		loginPage.loginToBank(USER_ID, PASSWORD);
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getDashboardUserID().toLowerCase().contains(USER_ID));
	}
  
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}





