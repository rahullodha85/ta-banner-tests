package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.QASOverlayBase;
import com.hbcd.scripting.core.Find;

/**
 * Created by 461967 on 6/6/2016.
 */
public class QASOverlay extends QASOverlayBase {
    @Override
    public void confirmAddress() throws Exception{
        if(Find.Object("shAddressVerificationLayer").getText().value().toLowerCase().indexOf("have checked your address against")>=0)
        {
            Find.Object("rsUseAddressBtn").click();
        }

    }
}
