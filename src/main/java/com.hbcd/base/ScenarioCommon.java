package com.hbcd.base;

import com.hbcd.commonbanner.base.scenario.ScenarioRetailDomain;
import com.hbcd.utility.common.ApplicationSetup;
import com.hbcd.utility.common.Setting;
import com.hbcd.utility.testscriptdata.CheckoutDataRow;
import com.hbcd.utility.testscriptdata.JsonParser;

public class ScenarioCommon extends ScenarioRetailDomain {

    protected CheckoutDataRow dataObject;

    public void beforeExecuteScript() throws Exception {
        super.beforeExecuteScript();
        String banner = ApplicationSetup.get(Setting.SITE).toString();
    }

    @Override
    public void ini(long requestId, String... args) throws Exception {
        super.ini(requestId, args);
        if ((args.length > 0) && (args[0] != null) && (args[0].length() > 0)) {
            dataObject = (CheckoutDataRow) JsonParser.parseJson("com.hbcd.utility.testscriptdata.CheckoutDataRow", args[0]);

        }
    }
}
