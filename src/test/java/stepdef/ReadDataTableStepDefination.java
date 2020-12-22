package stepdef;

import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import common.util.ReadDataByTransform;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ReadDataTableStepDefination {

	ReadDataByTransform readdatabytransform;

	@Inject

	public ReadDataTableStepDefination(ReadDataByTransform readdatabytransform) {

		this.readdatabytransform = readdatabytransform;
	}

	@When("^I have the following books in the store by list$")
	public void readDataTableByList(DataTable table) {

		List<List<String>> rows = table.asLists(String.class);
		for (List<String> column : rows) {
			System.out.println("Book name is:" + column.get(0) + " and " + " author is: " + column.get(1));
		}

	}

	@When("^I have the following books in the store by map$")
	public void readDataTableByMap(DataTable table) {

		List<Map<String, String>> rows = table.asMaps(String.class, String.class);
		for (Map<String, String> column : rows) {
			System.out.println("Book name is:" + column.get("title") + " and " + " author is: " + column.get("author"));

		}
	}

	@When("^I have the following books in the store by Transform$")
	public void readDataTableByTransform() {

	}
}
