package com.qa.AutomatedTestingAssessment;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.AutomatedTestingAssessment.LandingPage;

public class JUnitTest {
	String url = Constants.url;

	ChromeDriver driver;

	WebElement web;

	@Before
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
//		 ChromeOptions chromeOptions = new ChromeOptions();
//		 chromeOptions.addArguments("--headless");
//		 driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver(); 
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void createItemTest() throws InterruptedException {
		driver.get(url); 
//		WebDriverWait wait=new WebDriverWait(driver, 1000);
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.logIn("admin", "admin");
		landingPage.createItem("newitem");
		WebElement currentItem = driver.findElement(By.partialLinkText("newitem"));
		assertEquals("user not found", "newitem", currentItem.getText());
	}

}
