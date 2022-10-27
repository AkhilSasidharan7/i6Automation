package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	features= "src/test/resources/Features",
glue = "StepDefinitions",
monochrome = true,
plugin = {"pretty","html:target/TestReport.html"}

// tags can be used for running specific group of scenarios
// @ContactUs - For running contact us scenario
// @Regression - For running all scenarios
// @EmailValidation - For running email validation scenario only

)
public class I6Runner {

}
