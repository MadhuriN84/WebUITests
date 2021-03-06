package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}
        ,glue= "steps"
        ,plugin = {"html:target/cucumber-html-report",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        )

public class RunCucumberTest  {
	


}

