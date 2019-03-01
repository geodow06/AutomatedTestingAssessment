package com.qa.AutomatedTestingAssessment;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.AutomatedTestingAssessment.Constants;
import com.qa.AutomatedTestingAssessment.LandingPage;

@RunWith(Parameterized.class)
public class DDTTest {
	private String username;
	private String password;
	private String confirmPassword;
	private String fullname;
	private String email;
	private int rowNum;

	public DDTTest(String username, String fullname, String password, String confirmPassword, String email,
			int rowNum) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.rowNum = rowNum;

	}

	@Parameters
	public static Collection<Object[]> excelData() {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheetAt(0);

		Object[][] xld = new Object[sheet.getPhysicalNumberOfRows() - 1][sheet.getRow(1).getPhysicalNumberOfCells()
				+ 1];

		for (int row = 1; row < sheet.getPhysicalNumberOfRows(); row++) {
			int finalCol = 0;
			for (int column = 0; column < sheet.getRow(row).getPhysicalNumberOfCells(); column++) {
				finalCol++;
				xld[row - 1][column] = sheet.getRow(row).getCell(column).getStringCellValue();

			}
			xld[row - 1][5] = row;
		}
		return Arrays.asList(xld);
	}

	ChromeDriver driver;

	@Before
	public void setup() {
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
	public void addUserTest() throws IOException, InterruptedException {

		driver.get(Constants.url);
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.logIn("admin", "admin");
		System.out.println(username);
		System.out.println(fullname);
		System.out.println(password);
		System.out.println(confirmPassword);
		System.out.println(email);
		landingPage.createUser(username, fullname, password, confirmPassword, email);
		WebElement currentUser = driver.findElement(By.partialLinkText(username));

		assertEquals("user not found", username, currentUser.getText());

		String resp = currentUser.getText();

		FileInputStream file = new FileInputStream(Constants.excel);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String response = "Passed";
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(5);
		if (cell == null) {
			cell = row.createCell(5);
		}
		cell.setCellValue(resp);

		try {
			assertEquals("Failed", username, resp);

			row = sheet.getRow(rowNum);
			cell = row.getCell(5);
			if (cell == null) {
				cell = row.createCell(5);
			}
			cell.setCellValue(response);

			FileOutputStream fileOut = new FileOutputStream(Constants.excel);

			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			file.close();
		} catch (AssertionError e) {

			Assert.fail();
			response = "Failed";
			row = sheet.getRow(rowNum);
			cell = row.getCell(5);
			if (cell == null) {
				cell = row.createCell(5);
			}

			cell.setCellValue(response);

			FileOutputStream fileOut = new FileOutputStream(Constants.excel);

			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			file.close();
		}

	}
}
