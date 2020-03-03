package com.seleniumPrograms;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InterviewPurposeJavaScriptExecuter {
	WebDriver driver;

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver",
				"G:\\\\naresh practice\\\\I Hub Selenium Manoj Sir\\\\AutomationPractice\\\\src\\\\main\\\\resources\\\\LIB\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@Test
	public void javaScriptExecu() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
	}

}
