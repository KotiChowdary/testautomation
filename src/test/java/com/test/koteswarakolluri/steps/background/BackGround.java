package com.test.koteswarakolluri.steps.background;

import com.test.koteswarakolluri.utils.ServiceFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BackGround extends ServiceFactory {
	
	@Given("^User launches the application \"([^\"]*)\" in Browser \"([^\"]*)\" for testcase \"([^\"]*)\"$")
	public void user_launches_the_application_in_Browser(String URL, String browserName,String testName) {
	   
		testcaseName = testName;
		
		ServiceFactory.getDriver(browserName.toUpperCase());
		
		capture.createFolder();

		driver.get(URL);
		
	}

	@Then("^User should login with the account details with Username \"([^\"]*)\" Password \"([^\"]*)\"$")
	public void user_should_login_with_the_account_details_with_Username_Password(String userName, String secretKey) {

		homepagePO.signintoApplication(userName, secretKey);
		
	}
	
	@Then("^User need to sigout of the application$")
	public void user_need_to_sigout_of_the_application(){
	    
		homepagePO.signOut();
		
	}


}
