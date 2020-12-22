package stepdef;

import java.util.List;

import org.junit.Assert;

import common.util.TestContext;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pageObjects.OpenbrowserDefinition;
import pageObjects.ProductDisplayedPage;

public class ProductDisplayedStepDefination {
	TestContext testContext;
	ProductDisplayedPage productDisplayedPage;
	OpenbrowserDefinition openbrowserDefinition;

	public ProductDisplayedStepDefination(TestContext context) {
		testContext = context;

		productDisplayedPage = testContext.getPageObjectManager().getproductDisplayedPage();
	}

	@When("^I Should see following brands for product$")
	public void i_should_see_following_brand_for_products(DataTable table) {

		List<String> brands = table.asList(String.class);

		Assert.assertTrue("All brands are not listed from prodcut", productDisplayedPage.verifyBrandNames(brands));

	}
}
