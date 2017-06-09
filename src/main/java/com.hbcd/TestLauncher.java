package com.hbcd;

import com.hbcd.execution.core.Automation;
import com.hbcd.utility.helper.Common;

public class TestLauncher {
    public static void main(String[] args) throws Exception {
    //This is a Test Launcher Class
        if (args.length > 0) {
            Common.DefaultParameterDirectory = args[0];
            System.out.println(Common.DefaultParameterDirectory);
        }
        Automation.start();
    }
}
