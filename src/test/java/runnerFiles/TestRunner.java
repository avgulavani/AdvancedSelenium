
package runnerFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions( 
		features = "src/test/java/featureFiles/open_browser.feature", 
		glue = {"stepdef" }
		)

public class TestRunner extends AbstractTestNGCucumberTests  {

}