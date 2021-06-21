import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import functionLibrary.CommonFunctions;
import org.junit.AfterClass;

import java.io.File;

public class Hooks {

    CommonFunctions commonFunctions = new CommonFunctions();

    @Before
    public void beforeTest()
    {
        commonFunctions.openBrowser();
    }

    @After
    public void afterTest()
    {
        commonFunctions.quitBrowser();
    }

    private static String reportFilePath = new File("src/main/resources/reportConfig/extentReportConfig.xml").getAbsolutePath();
    @AfterClass
    public static void generateReport()
    {
        Reporter.loadXMLConfig(reportFilePath);
    }
}