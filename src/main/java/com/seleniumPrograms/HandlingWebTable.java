package com.seleniumPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWebTable {
	WebDriver driver;

	public void webtable() {
		System.setProperty("webdriver.chrome.driver",
				"G:/naresh practice/I Hub Selenium Manoj Sir/AutomationPractice/src/main/resources/LIB/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> table_rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

		System.out.println("table number of rows is :" + table_rows.size());
		for (int i = 2; i <= table_rows.size(); i++) {

			System.out.println(i - 1);
			List<WebElement> columns_eachrow = table_rows.get(i - 1).findElements(By.tagName("td"));
			for (int j = 1; j <= columns_eachrow.size(); j++) {
				System.out.print(
						driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]"))
								.getText() + "                     ");
			}
			System.out.println(" ");

		}
	}

	public void webtable2() {
		System.setProperty("webdriver.chrome.driver",
				"G:/naresh practice/I Hub Selenium Manoj Sir/AutomationPractice/src/main/resources/LIB/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> table_rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

		System.out.println("table number of rows is :" + table_rows.size());
		for (int i = 1; i <table_rows.size(); i++) {

			System.out.println(i);
			List<WebElement> columns_eachrow = table_rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < columns_eachrow.size(); j++) {
				System.out.print(columns_eachrow.get(j).getText() + "                        ");
				if(columns_eachrow.get(j).getText().equalsIgnoreCase("UK")) {
					System.out.println("UK");
				}
			}
			System.out.println("");

		}
	}

	public static void main(String[] args) throws InterruptedException {
		//new HandlingWebTable().webtable();
		new HandlingWebTable().webtable2();
	}

}
