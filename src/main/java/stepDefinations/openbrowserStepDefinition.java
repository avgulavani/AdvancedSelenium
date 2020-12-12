package stepDefinations;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class openbrowserStepDefinition {
	
	 private static Logger Log = Logger.getLogger(Log.class.getName());//

	 WebDriver driver;			
		
	    @Given("^Open the Firefox and launch the application$")					
	    public void open_the_Firefox_and_launch_the_application() throws Throwable							
	    {		
	       System.setProperty("webdriver.chrome.driver", "/Users/a.vitthal.gulavani/git/ipt-ie-automation-tests/chromedriver");					
	       ChromeOptions chromeOptions=new ChromeOptions();
	       chromeOptions.addArguments("--disable-gpu");
	        chromeOptions.addArguments("--disable-extensions");
	        chromeOptions.addArguments("--no-sandbox");
	        chromeOptions.addArguments("--disable-dev-shm-usage");
	        chromeOptions.addArguments("--headless");
	        chromeOptions.addArguments("--window-size=1580,1280");
	        chromeOptions.setHeadless(true);
	       
	       driver= new ChromeDriver	();					
	       driver.manage().window().maximize();			
	       Log.info("Opening browser");
	       driver.get("http://demo.guru99.com/v4");					
	    }		

	    @When("^Enter the Username and Password$")					
	    public void enter_the_Username_and_Password() throws Throwable 							
	    {		
	       driver.findElement(By.name("uid")).sendKeys("username12");							
	       driver.findElement(By.name("password")).sendKeys("password12");							
	    }		

	    @Then("^Reset the credential$")					
	    public void Reset_the_credential() throws Throwable 							
	    {		
	       driver.findElement(By.name("btnReset")).click();					
	    }	
	

}
