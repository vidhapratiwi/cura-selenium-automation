package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDef",
        //tags = "@Login",
        plugin = {"pretty", "html:target/RegressionReport.html"}
)
public class runAll {
}
