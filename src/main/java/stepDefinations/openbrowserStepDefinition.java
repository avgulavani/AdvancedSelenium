package stepDefinations;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class openbrowserStepDefinition {
	
	 private static Logger Log = Logger.getLogger(Log.class.getName());//

	 WebDriver driver;			
		
	    @Given("^Open the Firefox and launch the application$")					
	    public void open_the_Firefox_and_launch_the_application() throws Throwable							
	    {		
	    	 ChromeOptions chromeOptions=new ChromeOptions();
	       System.setProperty("webdriver.chrome.driver", "/Users/a.vitthal.gulavani/git/ipt-ie-automation-tests/chromedriver");					
	       DesiredCapabilities cap = DesiredCapabilities.chrome();
	        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	        chromeOptions.addArguments("start-maximized");
	        chromeOptions.addArguments("--always-authorize-plugins");
	        chromeOptions.setAcceptInsecureCerts(false);
	        chromeOptions.setExperimentalOption("useAutomationExtension", false);
	        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

	      
	       chromeOptions.addArguments("--disable-gpu");
	        chromeOptions.addArguments("--disable-extensions");
	        chromeOptions.addArguments("--no-sandbox");
	        chromeOptions.addArguments("--disable-dev-shm-usage");
	        
	        chromeOptions.addArguments("--headless");
	        chromeOptions.setAcceptInsecureCerts(true);
	        chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--window-size=1600,1200");
	     
	       
	       driver= new ChromeDriver	(chromeOptions);					
	       driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        Dimension d = new Dimension(1500,2500);
	        driver.manage().window().setSize(d);
	       
	       driver.get("http://demo.guru99.com/v4");					
	    }		

	    @When("^Enter the User	name and Password$")					
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
