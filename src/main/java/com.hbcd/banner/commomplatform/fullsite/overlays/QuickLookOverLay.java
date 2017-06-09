package com.hbcd.banner.commomplatform.fullsite.overlays;

import com.hbcd.commonbanner.base.overlays.QuickLookOverLayBase;
import com.hbcd.commonbanner.overlays.Overlay;
import com.hbcd.scripting.core.Find;

/**
 * Created by 461967 on 6/6/2016.
 */
public class QuickLookOverLay extends QuickLookOverLayBase {
    @Override
    public void ClickReadReviews() throws Exception {
        Find.Object("qoReadReviewBtn").click();
    }

    @Override
    public void AddToBag(String sizeOption) throws Exception {
        Find.Object("qlSizeDropDown").click();
        Find.Object("qlSizeOptionSelected_wk")
                .changeChildContainsText(sizeOption).click();
        Find.Object("qlAddToBagBtn_wk").click();
    }

    @Override
    public void UpdateQuantity(int quantity) throws Exception {
        Find.Object("pdpRedesignQty").clear();
        Find.Object("pdpRedesignQty").input(String.valueOf(quantity));

    }

    @Override
    public void AddToBag(int quantity) throws Exception{
        selectFirstSwatch();
        selectFirstSizeSwatch();
        selectFirstDropdownItem();
        updateQty(quantity);
        clickAddToBagButton();
    }

    @Override
    public void ClickViewFullDetails() {
    }

    @Override
    public Overlay ClickViewSizeGuide() {
        return null;
    }

    private void selectFirstSizeSwatch() throws Exception {
        if (Find.Object("pdpFirstSizeSwatch_wk").isPresent())
            Find.Object("pdpFirstSizeSwatch_wk").click();
    }

    private void selectFirstSwatch() throws Exception {
        boolean colorSelected = false;
        if (!colorSelected && Find.Object("pdpSwatchFirstSelection").isPresent()  ) {
            Find.Object("pdpSwatchFirstSelection").click();
            colorSelected = true;
        }
        if (!colorSelected && Find.Object("pdpRedesignColorSection").isPresent() ) {
            Find.Object("pdpSwatchFirstAvailableSelection").click();
            colorSelected= true;
        }
    }

    private void selectFirstDropdownItem() throws Exception {
        if (Find.Object("pdpRedesignPreOrderSize").isPresent()) {
            Find.Object("pdpRedesignPreOrderSize").click();
            Find.Object("pdpDropdownFirstSelection").click();

        }
    }

    private void updateQty(int qty) throws Exception {
        Find.Object("pdpRedesignQty").clear();
        Find.Object("pdpRedesignQty").input(new Integer(qty).toString());
    }

    private void clickAddToBagButton() throws Exception {
        Find.Object("qlAddToBagBtn_wk").click();
    }
}
