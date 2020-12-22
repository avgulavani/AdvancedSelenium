package manager;

import org.openqa.selenium.WebDriver;

import pageObjects.OpenbrowserDefinition;
import pageObjects.ProductDisplayedPage;


public class PageObjectManager {

	private WebDriver driver;
	private OpenbrowserDefinition openbrowserdefinition;
	private ProductDisplayedPage productDisplayedPage;


	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public OpenbrowserDefinition getopenbrowserDefinition() {

		return (openbrowserdefinition == null) ? 
				openbrowserdefinition = new OpenbrowserDefinition(driver): openbrowserdefinition;

	}
	public ProductDisplayedPage getproductDisplayedPage() {

		return (productDisplayedPage == null) ? 
				productDisplayedPage = new ProductDisplayedPage(driver): productDisplayedPage;

	}
	

}
