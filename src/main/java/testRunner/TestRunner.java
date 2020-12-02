package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/resources/features",
        tags = "@E2ETest",
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty","html:target/JSONReports"}
        )
public class TestRunner {
}
