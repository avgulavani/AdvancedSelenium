package manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

public class WebDriverManager {

	public WebDriver driver;
	public String enviornmentvalue;
	

	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriver getDriver() {

		/*
		 * 
		 * To Run test on grid use method- setupDriver()
		 * To run test on local createDriver()
		 * Note that Jenkin job is parameterized for createDriver() method and based on selection it 
		 * runs chrome in headless mode
		 */

	
		if (driver == null)

			/* local run */
			//driver = createDriver();
		
			/* grid run */
			
			driver = setupDriver();
			return driver;
	}

	public String getEnvironmentValue() {
		this.enviornmentvalue = System.getProperties().getProperty("ENVIORNMENT");
		System.out.println("value from jenkins is" + enviornmentvalue);
		if (enviornmentvalue != null) {
			return enviornmentvalue;
		} else
			return "local";
	}

	private WebDriver createDriver() {

		ChromeOptions chromeOptions = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
				"/Users/a.vitthal.gulavani/git/ipt-ie-automation-tests/chromedriver");
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

		if (getEnvironmentValue().equalsIgnoreCase("server")) {
			chromeOptions.addArguments("--headless");
			chromeOptions.setAcceptInsecureCerts(true);

		} else {
			// test will execute in normal mode (without being headless)
		}

		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--window-size=1600,1200");

		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Dimension d = new Dimension(1500, 2500);
		driver.manage().window().setSize(d);
		return driver;
	}

	public WebDriver setupDriver() {

		String host = "localhost";
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			capabilities = DesiredCapabilities.firefox();

		}
		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");

		}
		
		/*   Below code is to pass testname (from TestNG.xml) to ITestcontext.	
		 *   So that we can see meaningful test name in the report.
		 * 	
			String testName=context.getCurrentXmlTest().getName();      
		
		*/
		
		String completeURL = "http://" + host + ":4444/wd/hub";
		
		try {
			driver = new RemoteWebDriver(new URL(completeURL), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
}