package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDisplayedPage {
	WebDriver driver;

	public ProductDisplayedPage(WebDriver driver) {
		this.driver = driver;

	}

	public boolean verifyBrandNames(List<String> brnadnamestoverify) {
	
		List<String> expectedValues = brnadnamestoverify.stream().sorted().collect(Collectors.toList());

		//List<String> actualValues = driver.findElements(By.xpath("//*[@id=\"brandsRefinements\"]/ul")).stream()
		//		.map(WebElement::getText).map(String::trim).sorted().collect(Collectors.toList());

		List<WebElement> a =driver.findElements(By.xpath("//*[@id=\"brandsRefinements\"]/ul"));
		List<String> actualValues=a.stream().map(WebElement::getText).map(String::trim).sorted().collect(Collectors.toList());
		
		System.out.println("Passed List" + expectedValues);
		System.out.println("actual List" + actualValues);

		return expectedValues.equals(actualValues);

	}

}