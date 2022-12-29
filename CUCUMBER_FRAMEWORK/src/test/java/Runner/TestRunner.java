package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="FeatureFiles",
		glue= {"StepDefination","Hooks.java"},
		monochrome=true,
		dryRun=false,
		tags= "@idfc",
		plugin= {"pretty","json:target/json-report/cucumber.json", "html:target/html-report/cucumber.html"}
		)


public class TestRunner {

}
