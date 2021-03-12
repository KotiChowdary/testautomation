package com.test.koteswarakolluri.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.koteswarakolluri.utils.ServiceFactory;

public class PersonalInformationPagePO extends ServiceFactory {

	@FindBy(css = "a[title='View my customer account']")
	WebElement customeraccount;

	@FindBy(css = "a[title='Information']")
	WebElement personalinformation;

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "old_passwd")
	WebElement oldpassword;

	@FindBy(id = "passwd")
	WebElement newpassword;

	@FindBy(id = "confirmation")
	WebElement confpassword;

	@FindBy(name = "submitIdentity")
	WebElement save;

	@FindBy(className = "alert")
	WebElement alert;

	public PersonalInformationPagePO() {
		PageFactory.initElements(driver, this);
	}

	public void launchPersonalDetails() {
		eventHandler.click(customeraccount);
		capture.takescreenShot("PersonalInformation");
		eventHandler.click(personalinformation);
	}

	public String updatefirstName(String newName, String curPassword) {
		eventHandler.sendText(firstname, newName);
		eventHandler.sendText(oldpassword, curPassword);
		eventHandler.sendText(newpassword, curPassword);
		eventHandler.sendText(confpassword, curPassword);
		capture.takescreenShot("PersonalInformation");
		eventHandler.click(save);
		capture.takescreenShot("SavePersonalInformation");
		return eventHandler.getText(alert);
	}
}
