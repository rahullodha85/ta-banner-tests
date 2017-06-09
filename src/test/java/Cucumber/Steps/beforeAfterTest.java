package Cucumber.Steps;

import Cucumber.common.ConfigTest;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Report;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by 461967 on 8/25/2016.
 */
public class beforeAfterTest {
    @Given("^Test Config parameters are set$")
    public void setTestParameters() throws Throwable {
        ConfigTest.SetTestParameters();
        ConfigTest.InitializeBroswer();
    }

    @Given("^Test resource files are loaded$")
    public void loadTestResources() throws Exception {
        ConfigTest.LoadObjectRepo();
    }

    @Then("^User closes browser$")
    public void testCleanup() throws Throwable {
        Report.end_script("SCRIPT IS COMPLETED - NO Screenshot", "");
        BrowserAction.close();
    }
}
