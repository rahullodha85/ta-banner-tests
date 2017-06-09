package Cucumber.common;

import com.hbcd.common.utility.Data;
import com.hbcd.common.utility.ServiceName;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.ProjectSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.common.Task;

/**
 * Created by 461967 on 7/22/2016.
 */
public class ConfigTest {
    public static void InitializeBroswer() throws Exception {
        if(!System.getProperty("BrowserType").equals("")) {
            BrowserAction.initializeDriver(System.getProperty("BrowserType"), System.getProperty("BrowserName"),"","",
                    System.getProperty("RemoteHub"),"","");
        } else {
            throw new Exception("Browser type not specified for test execution");
        }
    }

    public static void SetTestParameters() throws Exception {
        Task task = new Task();
        task.setBrowserType(System.getProperty("BrowserType"));
        task.setRemoteHub(System.getProperty("RemoteHub"));
        task.setDefaultDir(System.getProperty("user.dir"));
        task.setEnvironmentURL(System.getProperty("Url"));
        System.out.print("Running smoke test on Url: " + System.getProperty("Url"));
        task.setModuleName("SmokeTest");
        task.setSite("Test");
        com.hbcd.utility.helper.Common.DefaultParameterDirectory = System.getProperty("user.dir");
        ProjectSetup.Setup(task);
    }

    public static void LoadObjectRepo() throws Exception {
        if (!System.getProperty("ObjectRepo").equals("")) {
            Data.Load(ServiceName.OBJECT_REPOSITORY, "Test." + ServiceName.OBJECT_REPOSITORY, System.getProperty("ObjectRepo"));
        } else {
            throw new Exception("Object Repository file name not specified for test execution");
        }
    }
}
