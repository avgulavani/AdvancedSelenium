
package runnerFiles;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = "src/test/resources/featureFiles", 
		glue = {"stepdef" }
		)

public class TestRunner {

}