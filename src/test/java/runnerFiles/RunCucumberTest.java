package runnerFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(  
		  plugin = {"pretty"},   
		  features = {"src/test/resources/featureFiles"},  
		  glue = {"stepDefinations"}, 
		  tags="@browsertest",strict = true) 

public class RunCucumberTest extends AbstractTestNGCucumberTests {

}

