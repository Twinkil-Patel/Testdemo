package eMB.Test.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Reporter;

public class TestBase {
	// initilise webdriver and propertiesfile
	public static WebDriver driver;
	public static Properties prop;

	// Create method to initialize the browser
	public WebDriver initializer() throws IOException {
		// initialize object for properties
		prop = new Properties();
		// load the properties file
		FileInputStream fis = new FileInputStream(
				"E:\\Twinkil\\Test\\src\\main\\java\\eMB\\Test\\Resources\\TestProperties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equalsIgnoreCase("chrome")) {
			// execute in chrome browse
			// Accepting SSL certificates
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			// options.addArguments("headless");
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", "E:\\Twinkil\\SELENIUM\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		if (BrowserName.equalsIgnoreCase("firefox")) {
			// open Firefox
			driver = new FirefoxDriver();
			System.setProperty("webDriver.gecko.driver", "E:\\Drivers\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	// to take screen short for failed testcases
	public String getScrenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFile = "E:\\Twinkil\\Test\\Screenshots" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
	}
}
