package com.test.module;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.module.Logon;

@SuppressWarnings("deprecation")
public class TestFoundation {
	private String system;
	private String path;
	private String baseURL;
	private String username;
	private String password;
	private String browser;
	protected DesiredCapabilities caps;
	protected WebDriverWait wait;
	protected WebDriver driver;
	protected Logon logon;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	protected final PrintStream P = System.out;
	public final String Inspector = ".sapUiUx3TVFacets .sapUiUx3TVFacetContent ";

	public TestFoundation(String system, String path, String username,
			String password, String browser) {
		this.system = system;
		this.path = path;
		this.username = username;
		this.password = password;
		this.browser = browser;
		this.initParameters();
	}

	public TestFoundation() {
		this.initParameters();
	}

	public void initParameters() {
		if (System.getProperty("system") != null) {
			this.system = System.getProperty("system");
		}
		if (System.getProperty("path") != null) {
			this.path = System.getProperty("path");
		}
		if (System.getProperty("username") != null) {
			this.username = System.getProperty("username");
		}
		if (System.getProperty("password") != null) {
			this.password = System.getProperty("password");
		}
		if (System.getProperty("browser") != null) {
			this.browser = System.getProperty("browser");
		}
		this.baseURL = this.system + this.path;
	}

	@Rule
	public ScreenshotRule screenshotTestRule = new ScreenshotRule();

	@Before
	protected void setUp() throws Exception {
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		if (this.browser.equals("firefox")) {
			caps = DesiredCapabilities.firefox();
			caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			driver = new FirefoxDriver(caps);
		} else if (this.browser.equals("chrome")) {
			
			if(caps == null) {
				caps = DesiredCapabilities.chrome();
			}
			//caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			System.setProperty("webdriver.chrome.driver", "E:\\Project\\java\\J2EE\\selenium_test_with_testng\\driver\\chromedriver.exe");
			//caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(caps);
		}		
		Thread.sleep(1000);
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1680, 1050));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(this.getBaseURL());
		this.wait = new WebDriverWait(driver, 20);
		//logon = new Logon(driver);
		//logon.logon(this.getUsername(), this.getPassword());
		Thread.sleep(3000);

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown");
		try {
			//LogHandler logHandler = new LogHandler(driver);
			//logHandler.analyzeLog();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
		} catch (Exception e) {
			throw e;
		}
		// This is done in the screenshot rule
		// finally {
		driver.close();
		driver.quit();
		// }
	}
	
	protected String getUsername() {
		return username;
	}

	protected String getPassword() {
		return password;
	}

	protected String getBrowser() {
		return browser;
	}

	protected String getBaseURL() {
		return baseURL;
	}
	
	class ScreenshotRule implements MethodRule {
		public Statement apply(final Statement statement,
				final FrameworkMethod frameworkMethod, final Object o) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					try {
						statement.evaluate();
					} catch (Throwable t) {
						captureScreenshot(frameworkMethod.getName(),
								frameworkMethod.getMethod().getDeclaringClass()
										.getName());
						throw t; // rethrow to allow the failure to be reported
									// to JUnit
					} finally {
						driver.close();
						driver.quit();
					}
				}

				public void captureScreenshot(String fileName, String className) {
					try {
						new File("target/surefire-reports/" + className)
								.mkdirs(); // Insure directory is there
						FileOutputStream out = new FileOutputStream(
								"target/surefire-reports/" + className
										+ "/screenshot-" + fileName + ".png");
						out.write(((TakesScreenshot) driver)
								.getScreenshotAs(OutputType.BYTES));
						out.close();
					} catch (Exception e) {
						// No need to crash the tests if the screenshot fails
					}
				}
			};
		}
	}
	
}
