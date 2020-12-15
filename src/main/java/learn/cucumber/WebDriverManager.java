package learn.cucumber;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {

	private WebDriver driver;
	protected  String enviornmentvalue;

	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	public String getEnvironmentValue() {
		this.enviornmentvalue= System.getProperties().getProperty("enviornment");
		
		if (this.enviornmentvalue!=null) {
			return enviornmentvalue;
		}
		else return "local";
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

		   if(getEnvironmentValue().equalsIgnoreCase("server")) {
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
}
