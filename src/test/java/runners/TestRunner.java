package runners;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/features/CategortDetails.feature"},
        glue = {"stepdefinitions"},
        dryRun = false,
        monochrome = true,
        plugin = {
                "pretty",
                "html:reports/cucumber-reports/cucumber.html",
                "json:reports/cucumber-reports/cucumber.json"
        },
        publish = true
        )

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}