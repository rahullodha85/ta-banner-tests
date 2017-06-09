package com.hbcd.banner.mobile.saks.overlays;

import com.hbcd.commonbanner.overlays.SmartSampleOverlay;
import com.hbcd.scripting.core.Find;
import com.hbcd.scripting.core.Report;

/**
 * Created by 461967 on 8/22/2016.
 */
public class mSmartSampleOverlay implements SmartSampleOverlay {
    @Override
    public void IsSmartSampleOverlay() throws Exception {
        if (Find.Object("smartSampleOverlay_RL").isPresent()) {
            Report.pass("Smart sample overlay is displayed");
        } else {
            Report.fail("Smart sample overlay is not displayed");
        }
    }

    @Override
    public void SelectSample(int index) throws Exception {
        if (Find.MultipleObjects("smartSampleChkbox_RL").select(index).isPresent()) {
            Find.MultipleObjects("smartSampleChkbox_RL").select(index).click();
        }
    }

    @Override
    public void ClickApply() throws Exception {
        if (Find.MultipleObjects("smartSampleCheckedChkbox_RL").size() > 0) {
            if (Find.Object("smartSampleApplyBtn_RL").isPresent()) {
                Report.pass("Apply selected promo button found and clicked");
                Find.Object("smartSampleApplyBtn_RL").click();
            } else {
                Report.fail("Apply selected promo button is not present on Smart Sample Overlay");
            }
        } else {
            Report.dataFail("No samples are selected, so Apply button cannot be clicked");
        }
    }

    @Override
    public void ValidateDisabledItemSelection() throws Exception {
        if (Find.MultipleObjects("smartSampleDisabledChkbox_RL").size() > 0) {
            Report.pass("After user selected 3 samples," +
                    " all other available sample selection was disabled");
        } else {
            Report.fail("After user selected 3 samples," +
                    " all other available sample selection was not disabled");
        }
    }

    @Override
    public void UnselectSample() throws Exception {
        if (Find.MultipleObjects("smartSampleCheckedChkbox_RL").select(1).isPresent()) {
            Find.MultipleObjects("smartSampleCheckedChkbox_RL").select(1).click();
            Report.pass("One of the selected items has been unselected");
        }
    }
}
