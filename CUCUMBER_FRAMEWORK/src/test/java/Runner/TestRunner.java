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
		tags= "@smoke or @tc001",
		plugin= {"pretty","html:target/HtmlReports.html"}
		)


public class TestRunner {

}
