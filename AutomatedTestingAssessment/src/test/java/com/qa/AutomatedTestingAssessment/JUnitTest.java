package com.qa.AutomatedTestingAssessment;

import static org.junit.Assert.assertEquals;

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

import com.qa.AutomatedTestingAssessment.LandingPage;

public class JUnitTest {
	String url = Constants.url;

	ChromeDriver driver;

	WebElement web;

	@Before
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		// ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--headless");
		// driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void createItemTest() throws InterruptedException {
		driver.get(url);
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.logIn("admin", "admin"); 
		Thread.sleep(2000);
		landingPage.createItem("newitem");
		WebElement currentItem = driver.findElement(By.partialLinkText("newitem"));

		assertEquals("user not found", "newitem", currentItem.getText());
	}

}
