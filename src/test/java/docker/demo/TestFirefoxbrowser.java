package docker.demo;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestFirefoxbrowser {
	
	@Test
	public void openBrowser() throws Exception {
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.FIREFOX);
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"),capabilities);	
		driver.get("https://acloudguru.com/");
	}
}
