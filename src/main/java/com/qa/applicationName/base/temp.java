package com.qa.applicationName.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class temp {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\naresh practice\\I Hub Selenium Manoj Sir\\AllSeleniumConcepts\\src\\main\\resources\\drivers2\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("t-shirts");
		driver.findElement(By.className("search_query form-control ac_input")).sendKeys("jeans");
		driver.findElement(By.name("search_query")).sendKeys("jeans");
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.partialLinkText("Us")).click();
		
		}

}
