package com.seleniumPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","G:/naresh practice/I Hub Selenium Manoj Sir/AutomationPractice/src/main/resources/LIB/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.anaesthetist.com/mnm/javascript/calc.htm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//1. it executes scripts for get title
		String obj=js.executeScript("return document.title;").toString();
		System.out.println(obj);
		//2. it executes scripts for alert pop window
		js.executeScript("alert('how r you madhu');");
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		//3. refresh page current page
		Thread.sleep(6000);
		js.executeScript("history.go(0);");
		//4.scroll down untill element is display
		WebElement element=driver.findElement(By.xpath("//a[contains(text(), 'AddDigit')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		//5.highlight an element
		js.executeScript("arguments[0].style.boarder='red';", element);
		//6.click button
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", element);
		//7.navigate to specific page
		js.executeScript("window.location='https://www.google.com';");
		//8.enter text
		js.executeScript("document.getElementByXpath('//font[@face='Courier']/input').value='22';");
		js.executeScript("document.getElementById('').value='hello';");
		
	}

}
