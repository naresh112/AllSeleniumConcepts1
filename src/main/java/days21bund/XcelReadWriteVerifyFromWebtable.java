package days21bund;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XcelReadWriteVerifyFromWebtable {

	WebDriver driver;
	FileInputStream fis;
	Workbook wb;

	public void multipleOperations() {
		System.setProperty("webdriver.chrome.driver","G:/naresh practice/I Hub Selenium Manoj Sir/AutomationPractice/src/main/resources/LIB/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd112@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("nani6652");
		driver.findElement(By.xpath("//i[@class='icon-lock left']/..")).click();
		driver.findElement(By.xpath("//span[contains(text(),'My wishlists')]")).click();
		try {
			fis=new FileInputStream(".//New Microsoft Excel Worksheet.xlsx");
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet=wb.getSheetAt(0);
		int rows=sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();
		System.out.println("rows :"+rows);
		System.out.println("columns :"+columns);
		for (int i = 1; i <= rows; i++) {
//			for (int j = 0; j < columns; j++) {
//				if we want to print entair sheet at this time we use nested for loop here i want print only one column
////			}
			//*******************************************************//
//			WebDriverWait wait=new WebDriverWait(driver, 10);
//			By locator=By.id("");
//			i write expected condition using By class.....
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='name']"))));
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(sheet.getRow(i).getCell(0).toString());
			driver.findElement(By.id("submitWishlist")).click();
			
		}
		String name=sheet.getRow(0).getCell(0).toString();
		System.out.println("name is :"+name);
	}
	public static void main(String[] args) {
		new XcelReadWriteVerifyFromWebtable().multipleOperations();
	}

}
