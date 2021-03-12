package com.test.koteswarakolluri.steps;

import com.test.koteswarakolluri.utils.ServiceFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class BaseClass extends ServiceFactory {

	@After
	public void afterScenario(Scenario scenario) {
		tearDown();
	}
}
