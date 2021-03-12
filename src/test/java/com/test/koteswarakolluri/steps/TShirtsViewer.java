package com.test.koteswarakolluri.steps;

import com.test.koteswarakolluri.utils.ServiceFactory;

import cucumber.api.java.en.Then;

public class TShirtsViewer extends ServiceFactory {

	@Then("^User should navigate TShirt Viewer page$")
	public void user_should_navigate_TShirt_Viewer_page() {
		tshirtspagePO.launchTShirtsViewer();
	}

	@Then("^User should select TShirt with color \"([^\"]*)\"$")
	public void user_should_select_TShirt_with_color(String tshirtColor) {
		tshirtspagePO.selectTShirt(tshirtColor);
		tshirtspagePO.proceedtoCheckout();
	}

}
