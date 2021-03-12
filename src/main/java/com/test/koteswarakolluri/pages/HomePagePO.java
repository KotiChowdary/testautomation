package com.test.koteswarakolluri.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.koteswarakolluri.utils.ServiceFactory;

public class HomePagePO extends ServiceFactory {

	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement submitsignin;

	@FindBy(css = "a[title='Log in to your customer account'")
	WebElement signin;
	
	@FindBy(css = "a[title='Log me out'")
	WebElement signout;

	public HomePagePO() {
		PageFactory.initElements(driver, this);
	}

	public void signintoApplication(String userName, String secretKey) {
		eventHandler.click(signin);
		eventHandler.sendText(username, userName);
		eventHandler.sendText(password, secretKey);
		capture.takescreenShot("HomePage");
		eventHandler.click(submitsignin);
	}
	
	public void signOut() {
		eventHandler.click(signout);
		capture.takescreenShot("SignOut");
	}
}
