package com.seleniumPrograms;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


/*
 * select tag look likes
 * <select class="usdhcfk" name="birtday_month" id="month" title="somthing" >
 * 		<options value=0>month</options>
 * 		<options value=1>January</options>		
 * 		<options value=2>feb</options>
 * 
 * etc....
 */

public class OperationsOnDownbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"G:/naresh practice/I Hub Selenium Manoj Sir/AutomationPractice/src/main/resources/LIB/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select month=new Select(driver.findElement(By.xpath("//select[@id='month']")));
		List<WebElement> dropdown=month.getOptions();
		//select all options from dropdown
		//using normal for loop
		for (int i = 0; i < dropdown.size(); i++) {
			String text_value=dropdown.get(i).getText();
			System.out.println("drop dpwn values are :"+text_value);
		}
		//******or
		//using forEach loop
		for (WebElement webElement : dropdown) {
			String text_value=webElement.getText();
			System.out.println("drop dpwn values are :"+text_value);
		}
		//  i want to print 1st selected option from dropdown
		//month.getFirstSelectedOption() it will return selected webelement
		System.out.println("********************");
		System.out.println(month.getFirstSelectedOption().getText());
		System.out.println("***********");
		month.selectByIndex(1);
		List<WebElement> selected_options=month.getAllSelectedOptions();
		for(WebElement elements:selected_options) {
			System.out.println(elements.getText());
		}
		//it de select by index
		month.deselectByIndex(1);
		
		month.deselectAll();
		//see notes 
		driver.quit();
	}

}
