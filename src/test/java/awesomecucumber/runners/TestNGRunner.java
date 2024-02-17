package awesomecucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        //dryRun=true,
        plugin={"html:target/cucumber/cucumber.html"},
        glue={"awesomecucumber"},   // to run from testng and hooks
        features = "src/test/resources/awesomecucumber"
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
