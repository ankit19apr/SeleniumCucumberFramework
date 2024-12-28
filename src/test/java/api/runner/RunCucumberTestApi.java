package api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/api/features"}, // Path to your feature files
        glue = {"api/stepDefinitions"},      // Package containing step definitions
        plugin = {
                "pretty",                         // For readable console output
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json",  // JSON report
                "rerun:target/rerun.txt", // To rerun failed tests
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "",                // Tags to filter scenarios
        monochrome = true,        // Better console output formatting
        publish = true
)
public class RunCucumberTestApi extends AbstractTestNGCucumberTests {


}
