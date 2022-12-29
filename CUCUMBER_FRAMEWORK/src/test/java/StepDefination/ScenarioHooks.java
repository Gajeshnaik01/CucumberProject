package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ScenarioHooks {
	@Before(value="@scenario_spec",order=1)
	public void secSpcBefore() {
		System.out.println("Before specfic scenario");
	}
	
	@After(value="@scenario_spec",order=1)
	public void secSpcAfter() {
		System.out.println("After specfic scenario");
	}
	
}
