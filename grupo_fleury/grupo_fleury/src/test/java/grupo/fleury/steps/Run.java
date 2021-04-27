package grupo.fleury.steps;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class Run {

	// @RunWith(Cucumber.class)
	@RunWith(JUnitPlatform.class)
	@CucumberOptions(plugin = "pretty", monochrome = true, glue = { "stepDefinition" })
	public class RunCucumberTest {
	}
}
