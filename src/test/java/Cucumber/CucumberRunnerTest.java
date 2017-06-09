package Cucumber;

import Cucumber.common.ConfigTest;
import com.hbcd.common.utility.Data;
import com.hbcd.common.utility.ServiceName;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Report;
import com.hbcd.utility.common.ProjectSetup;
import com.hbcd.utility.common.Task;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by 461967 on 7/18/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/html/", "json:target/json/output.json"},
        features = {"src/test/resources/Features"}
)
public class CucumberRunnerTest {
//    @BeforeClass
//    public static void TestSetup() throws Exception {
//        ConfigTest.SetTestParameters();
//        ConfigTest.InitializeBroswer();
//        ConfigTest.LoadObjectRepo();
//    }
//    @AfterClass
//    public static void Cleanup() throws Exception {
//        Report.end_script("SCRIPT IS COMPLETED - NO Screenshot", "");
//        BrowserAction.close();
//    }
}
