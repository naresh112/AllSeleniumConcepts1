package days21bund;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	WebDriver driver;

	public void webtable2() {
		
		System.setProperty("webdriver.chrome.driver","G:\\naresh practice\\I Hub Selenium Manoj Sir\\AllSeleniumConcepts\\src\\main\\resources\\drivers83chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> tableHeaders_eleme = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		for (WebElement webElement : tableHeaders_eleme) {
			System.out.print(webElement.getText() + "       		  	                           ");
		}
		System.out.println("");
		List<WebElement> rowsInTable = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		for (WebElement rowElements : rowsInTable) {
			List<WebElement> rowData = rowElements.findElements(By.tagName("td"));
			for (WebElement rowsTdElements : rowData) {
				System.out.print(rowsTdElements.getText() + "        	                            ");
			}
			System.out.println("");
		}
		driver.quit();

	}

	public static void main(String[] args) {
		new WebTableHandle().webtable2();
		
	}

}
