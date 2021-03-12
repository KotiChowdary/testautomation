package com.test.koteswarakolluri.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/test/koteswarakolluri/features", tags = "@updatepersonalinformation", glue = {
		"com.test.koteswarakolluri.steps" })

public class UpdatePersonalInformation extends AbstractTestNGCucumberTests {

}
