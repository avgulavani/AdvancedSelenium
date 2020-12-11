package runnerFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(  
		  plugin = {"pretty"},   
		  features = {"src/test/resources/featureFiles"},  
		  glue = {"src/main/java/stepDefinations"}, 
		  tags="@browsertest") 

public class RunCucumberTest extends AbstractTestNGCucumberTests {

}

