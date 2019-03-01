package com.qa.AutomatedTestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	@FindBy(xpath = Constants.newButton)
	private WebElement newButton;

	@FindBy(xpath = Constants.userName)
	private WebElement userName;
	@FindBy(xpath = Constants.password)
	private WebElement password;
	@FindBy(xpath = Constants.loginButton)
	private WebElement loginButton;
	@FindBy(xpath = Constants.itemName)
	private WebElement itemName;
	@FindBy(xpath = Constants.freestyle)
	private WebElement freestyle;
	@FindBy(id = Constants.save)
	private WebElement save;
	@FindBy(xpath = Constants.backToDash)
	private WebElement backToDash;
	@FindBy(xpath = Constants.ok)
	private WebElement ok;
	@FindBy(className = "model-link inside")
	private WebElement itemCheck;
	@FindBy(xpath = Constants.manJen)
	private WebElement manJen;
	@FindBy(xpath = Constants.manUser)
	private WebElement manUser;
	@FindBy(xpath = Constants.createUser)
	private WebElement createUser;
	@FindBy(xpath = Constants.newUsername)
	private WebElement newUsername;
	@FindBy(xpath = Constants.newPassword)
	private WebElement newPassword;
	@FindBy(xpath = Constants.passConfirm)
	private WebElement passConfirm;
	@FindBy(xpath = Constants.newFullname)
	private WebElement newFullname;
	@FindBy(xpath = Constants.newEmail)
	private WebElement newEmail;
	@FindBy(xpath = Constants.subNewUser)
	private WebElement subNewUser;

	public void logIn(String user, String pass) {

		userName.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}

	public void createItem(String item) throws InterruptedException {
		newButton.click();
		itemName.sendKeys(item);
		freestyle.click();
		ok.click(); 
		Thread.sleep(2000);
		save.click();
		backToDash.click();
	}

	public void createUser(String username, String fullname, String password, String confirmPassword, String email)
			throws InterruptedException {
		manJen.click();
		manUser.click();
		createUser.click();
		newUsername.sendKeys(username);
		newPassword.sendKeys(password);
		passConfirm.sendKeys(confirmPassword);
		newFullname.sendKeys(fullname);
		newEmail.sendKeys(email);
		subNewUser.click();
	}

	// public void input(String username, String password) {
	// demoUser.sendKeys(username);
	// demoPassword.sendKeys(password);
	// demoSubmit.click();
	// }
	//
	// public void login(String username, String password) {
	// loginUser.sendKeys(username);
	// loginPassword.sendKeys(password);
	// loginSubmit.click();
	// }
}
