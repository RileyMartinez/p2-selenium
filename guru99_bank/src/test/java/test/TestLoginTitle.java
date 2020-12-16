package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Basic script using JUnit
public class TestLoginTitle {
	
	static final String URL = "http://demo.guru99.com/V4/";
	static final String EXPECTED_TITLE = "Guru99 Bank";
	static final String DRIVER_PATH = "/usr/local/bin/geckodriver";
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", DRIVER_PATH);
		driver = new FirefoxDriver();
		driver.get(URL);
	}
	
	@Test
	public void test_correct_login_title() {
		WebElement loginTitle = driver.findElement(By.className("barone"));
		assertEquals(EXPECTED_TITLE, loginTitle.getText());
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}








