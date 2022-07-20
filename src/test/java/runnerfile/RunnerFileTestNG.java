package runnerfile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/resources/featuresFile", 
	glue = "stepdefs",
	plugin = {
			"pretty",
			"html:target/cucumber-reports",
			"json:target/cucumber-reports/cucumber2022.json"
	})
public class RunnerFileTestNG extends AbstractTestNGCucumberTests {

}
