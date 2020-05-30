package com.qa.applicationName.testPages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.applicationName.base.BasePage;

public class CreateAccountPageTest extends BasePage {

	WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		driver=init_driver(browser);
		enterURL();
		System.out.println("before method executed :>>"+browser);
	}
	@Test
	public void validateTitle() {
		System.out.println("validate title test passed");
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("tearDown passed");
	}
}
