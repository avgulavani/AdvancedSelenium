package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

public class OpenbrowserDefinition {
	WebDriver driver;

	
	@Inject
	public OpenbrowserDefinition(WebDriver driver) {

		this.driver = driver;
	}

	public void enterTextForField(String inputValue, String fieldValue) throws Exception {
		driver.findElement(By.name(fieldValue)).clear();
		driver.findElement(By.name(fieldValue)).sendKeys(inputValue);
	}
	
	public void openHomePage() {
		driver.get("http://demo.guru99.com/v4");
		
		//driver.get("https://www.amazon.in/s?i=furniture&bbn=3591676031&rh=n%3A1380441031%2Cn%3A3591666031%2Cn%3A3591675031%2Cn%3A3591676031%2Cp_36%3A400000-&_encoding=UTF8&pf_rd_i=mobile&pf_rd_m=A1VBAL9TL5WCBF&pf_rd_p=dadfe156-3f7f-4288-a062-47f841f5195c&pf_rd_r=0NQZCGRQCYTKM0EKMAVR&pf_rd_s=merchandised-search-4&pf_rd_t=Gateway&ref=pc_mcnc_merchandised-search-4_");
	}
	
	public void clicResetButton() {
		driver.findElement(By.name("btnReset")).click();
	}
}
