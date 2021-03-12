package com.test.koteswarakolluri.steps;

import org.testng.Assert;

import com.test.koteswarakolluri.utils.ServiceFactory;

import cucumber.api.java.en.Then;

public class PersonalInformation extends ServiceFactory {

	@Then("^User should navigate to personal information page$")
	public void user_should_navigate_to_personal_information_page() {
		personalinformationpagePO.launchPersonalDetails();
	}

	@Then("^User should update firstname \"([^\"]*)\" Password \"([^\"]*)\"$")
	public void user_should_update_firstname_Password(String newName, String secretKey) {
		Assert.assertEquals(personalinformationpagePO.updatefirstName(newName, secretKey),
				"Your personal information has been successfully updated.", "Issue in Updating Personal Information");
	}

}
