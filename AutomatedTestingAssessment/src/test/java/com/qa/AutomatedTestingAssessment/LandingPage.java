package com.qa.AutomatedTestingAssessment;

public class LandingPage {
<<<<<<< HEAD
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
//	@FindBy(id = Constants.save)
//	private WebElement save;
	@FindBy(xpath = Constants.backToDash)
	private WebElement backToDash;
//	@FindBy(xpath = Constants.ok) 
	@FindBy(partialLinkText = "ok")
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
	@FindBy(partialLinkText = "Save") 
	private WebElement save;
	public void logIn(String user, String pass) {

		userName.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}

	public void createItem(String item) throws InterruptedException {
		newButton.click(); 
		Thread.sleep(1000);
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
=======
>>>>>>> parent of c1db82f... first and second task completed

}
