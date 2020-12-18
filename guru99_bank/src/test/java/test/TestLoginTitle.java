package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//Basic script using JUnit
public class TestLoginTitle {
	
	static final String URL = "http://demo.guru99.com/V4/";
	static final String EXPECTED_TITLE = "Guru99 Bank";
	static final String DRIVER_PATH = "/usr/local/bin/geckodriver";
	static final String HEADLESS_ARG = "-headless";
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		// Since I have geckodriver.exe installed in $PATH, I don't need to specify a the driver location.
		// System.setProperty("webdriver.gecko.driver", DRIVER_PATH);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		// Headless browser option
		// FirefoxOptions firefoxOptions = new FirefoxOptions();
		// firefoxOptions.addArguments(HEADLESS_ARG);
		// driver = new FirefoxDriver(firefoxOptions);
		
		driver.get(URL);
	}
	
	@Test
	public void test_correct_login_title() {
		WebElement loginTitle = driver.findElement(By.className("barone"));
		assertEquals(EXPECTED_TITLE, loginTitle.getText());
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}








