
package runnerFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions( 
		features = "src/test/resources/featureFiles/open_browser.feature", 
		glue = {"stepdef" }
		)

public class TestRunner extends AbstractTestNGCucumberTests  {

}