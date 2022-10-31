package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/feature",
		glue= {"stepDefinitions"},	
		tags= "@test_1"
		)


public class TestRunner {
}
