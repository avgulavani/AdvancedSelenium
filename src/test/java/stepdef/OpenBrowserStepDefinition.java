package stepdef;

import java.util.List;

import common.util.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.OpenbrowserDefinition;

public class OpenBrowserStepDefinition {

	TestContext testContext;
	OpenbrowserDefinition openbrowserDefinition;

	/*
	 * @Inject public openbrowserStepDefinition(WebDriverManager webDriverManager,
	 * OpenbrowserDefinition openbrowserDefinition) { this.driver =
	 * webDriverManager.getDriver(); this.openbrowserDefinition =
	 * openbrowserDefinition; }
	 */
	public OpenBrowserStepDefinition(TestContext context) {
		testContext = context;
		openbrowserDefinition = testContext.getPageObjectManager().getopenbrowserDefinition();

	}

	@Given("^Open and launch the application$")
	public void open_and_launch_the_application() throws Throwable {
		openbrowserDefinition.openHomePage();

	}

	/*
	 * @When("^Enter the Username and Password$") public void
	 * enter_the_Username_and_Password() throws Throwable {
	 * driver.findElement(By.name("uid")).sendKeys("username12");
	 * driver.findElement(By.name("password")).sendKeys("password12"); }
	 */

	@When("^I enter <input> in <fieldValue>$")
	public void enterInputInField(List<List<String>> data) throws Exception {
		for (int i = 0; i < data.size(); i++) {
			enterInput(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2));
		}

	}

	@When("I enter \"([^\"]*)\" in \"([^\"]*)\"$")
	public void enterInput(String input, String fieldValue, String fieldType) throws Exception {
		switch (fieldType.trim().toLowerCase()) {
		case "text":
			openbrowserDefinition.enterTextForField(input, fieldValue);
			break;
		default:
		}
	}

	@Then("^Reset the credential$")
	public void Reset_the_credential() throws Throwable {
		openbrowserDefinition.clicResetButton();
	}

}
