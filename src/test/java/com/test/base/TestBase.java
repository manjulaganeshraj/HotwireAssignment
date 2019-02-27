package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	public static WebDriver driver;
	public Properties prop;

	
	@BeforeMethod
	public WebDriver initializeDriver() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/main/java/com/hotwire/resources/data.properties");
		prop.load(fis);                           
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		else if(browserName.equals("firefox")){

		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;


		
	}
	
	
	public void getScreenshot(String result) throws IOException{
		
	}
	
	@AfterMethod
	public void tearDown() { 
		driver.close();
		driver=null;
	} 

}
