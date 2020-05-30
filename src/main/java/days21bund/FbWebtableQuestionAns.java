package days21bund;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbWebtableQuestionAns {
	WebDriver driver;

	public void webtable2() {
		System.setProperty("webdriver.chrome.driver","G:/naresh practice/I Hub Selenium Manoj Sir/AutomationPractice/src/main/resources/LIB/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd112@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("nani6652");
		driver.findElement(By.xpath("//i[@class='icon-lock left']/..")).click();
		driver.findElement(By.xpath("//span[contains(text(),'My wishlists')]")).click();
		List<WebElement> tableHeaders_eleme = driver.findElements(By.xpath("//table[@class='table table-bordered']/thead/tr/th"));
		int headerLengh=tableHeaders_eleme.size();
		
		
		List<WebElement> rowsInTable = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
		for (WebElement rowElements : rowsInTable) {
			List<WebElement> rowData = rowElements.findElements(By.tagName("td"));
			for (WebElement rowsTdElements : rowData) {
				int temp=0;
				System.out.print(tableHeaders_eleme.get(temp).getText()+"          ");
				System.out.print(rowsTdElements.getText() + "                    ");
				++temp;
				if(temp==headerLengh) {
					temp=0;
				}
			}
			System.out.println("");
		}
		driver.quit();

	}

	public static void main(String[] args) {
		new HandleAutomationPracticeSiteWebtable().webtable2();
	}


}
