import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = ".",tags = {},dryRun = false,
        plugin = "com.cucumber.listener.ExtentCucumberFormatter:target/yt/yt.html")
public class Run {

}