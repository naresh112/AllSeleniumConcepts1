package com.qa.applicationName.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.applicationName.pages.LandingPage;

public class BasePage {
	public WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public Properties prop;

	public WebDriver init_driver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "//src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "//src/main/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("internetExplorer")) {
			System.setProperty("", "");
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			System.setProperty("", "");
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("", "");
			driver = new EdgeDriver();
		} else {
			System.out.println("browser Name " + browserName + " is not found, please pass the correct browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		return driver;
	}

	public static void main(String[] args) {
//		System.out.println(projectPath);
//		new BasePage().init_driver("firefox");
	}

	public void init_properties() {
		prop = new Properties();
		String env = null;
		String path = null;
		try {
			if (env.equals("qa")) {
				path = ".//src/main/resources/properties/config.qa.properties";

			}
			if (env.equals("stg")) {
				path = ".//src/main/resources/properties/config.stg.properties";
			}
		} catch (Exception e) {
			path = ".//src/main/resources/properties/config.properties";
		}
		try {
			FileInputStream fis=new FileInputStream(path);
			prop.load(fis);
		}
		catch(FileNotFoundException e) {
			System.out.println("some issue with config properties....Please correct your config...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public LandingPage enterURL() {
		driver.get(prop.getProperty("url"));
		return new LandingPage(driver);
	}

}
