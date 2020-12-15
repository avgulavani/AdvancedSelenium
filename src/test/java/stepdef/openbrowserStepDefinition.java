package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import learn.cucumber.WebDriverManager;

public class openbrowserStepDefinition {

	WebDriverManager webDriverManager;
	WebDriver driver;

	@Given("^Open the Firefox and launch the application$")
	public void open_the_Firefox_and_launch_the_application() throws Throwable {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get("http://demo.guru99.com/v4");
	}

	@When("^Enter the Username and Password$")
	public void enter_the_Username_and_Password() throws Throwable {
		driver.findElement(By.name("uid")).sendKeys("username12");
		driver.findElement(By.name("password")).sendKeys("password12");
	}

	@Then("^Reset the credential$")
	public void Reset_the_credential() throws Throwable {
		driver.findElement(By.name("btnReset")).click();
	}

}
