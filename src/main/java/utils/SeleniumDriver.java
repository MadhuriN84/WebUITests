package utils;

import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;

    private static WebDriver driver;
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public static String initialUrl = "http://automationpractice.com/index.php";

    private SeleniumDriver() throws Exception {
        driver = getWebDriver(initialUrl);
    }

	private WebDriver getWebDriver(String initialUrl) throws Exception {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		waitDriver = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		return driver;

	}

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWaitDriver() {
        return waitDriver;

    }

    public static void setUpDriver() throws Exception {
        if (seleniumDriver == null) {
            seleniumDriver = new SeleniumDriver();
        }
    }

    public static void tearDown() throws Exception {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }

}
