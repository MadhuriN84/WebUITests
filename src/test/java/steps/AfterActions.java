package steps;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.*;

import utils.SeleniumDriver;

public class AfterActions {
    @After
    public static void tearDown(Scenario scenario) throws Exception {

        WebDriver driver=SeleniumDriver.getDriver();
		SeleniumDriver.tearDown();

    }

}

