package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
				glue = {"stepDefinitions","hooksPackage"},
				plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"})
public class Testrunner {
	
}