package Cucumber.base;

import com.hbcd.banner.commomplatform.fullsite.overlays.*;
import com.hbcd.banner.commomplatform.fullsite.pages.*;
import com.hbcd.banner.commomplatform.fullsite.pages.AccountBillingAddressPage;
import com.hbcd.banner.commomplatform.fullsite.pages.AccountPaymentPage;
import com.hbcd.banner.commomplatform.fullsite.pages.AccountSettingsPage;
import com.hbcd.banner.commomplatform.fullsite.pages.AccountShippingAddressPage;
import com.hbcd.banner.commomplatform.fullsite.pages.AccountSummaryPage;
import com.hbcd.banner.commomplatform.fullsite.pages.BagPage;
import com.hbcd.banner.commomplatform.fullsite.pages.ConfirmationPage;
import com.hbcd.banner.commomplatform.fullsite.pages.ContactCenterPage;
import com.hbcd.banner.commomplatform.fullsite.pages.CreateAccountPage;
import com.hbcd.banner.commomplatform.fullsite.pages.ForgotPasswordPage;
import com.hbcd.banner.commomplatform.fullsite.pages.GiftCardsPage;
import com.hbcd.banner.commomplatform.fullsite.pages.Navigation;
import com.hbcd.banner.commomplatform.fullsite.pages.OrderDetailsPage;
import com.hbcd.banner.commomplatform.fullsite.pages.OrderHistoryPage;
import com.hbcd.banner.commomplatform.fullsite.pages.PaymentPage;
import com.hbcd.banner.commomplatform.fullsite.pages.PdpPage;
import com.hbcd.banner.commomplatform.fullsite.pages.ProductArrayPage;
import com.hbcd.banner.commomplatform.fullsite.pages.ReviewSubmitPage;
import com.hbcd.banner.commomplatform.fullsite.pages.SectionPage;
import com.hbcd.banner.commomplatform.fullsite.pages.ShippingPage;
import com.hbcd.banner.commomplatform.fullsite.pages.SignInPage;
import com.hbcd.banner.commomplatform.fullsite.pages.StoreLocatorPage;
import com.hbcd.commonbanner.base.scenario.ScenarioRetailDomain;
import com.hbcd.commonbanner.pages.*;
import com.hbcd.utility.common.ProjectSetup;
import com.hbcd.utility.common.Task;

/**
 * Created by 461967 on 7/18/2016.
 */
public class ScenarioSmokeTest extends ScenarioRetailDomain {

    public ScenarioSmokeTest() throws Exception {
        pdp = new PdpPage();
        bag = new BagPage();
        shp = new ShippingPage();
        pap = new PaymentPage();
        rsp = new ReviewSubmitPage();
        yap = new YourAccountPage_OLD();
        ccp = new ContactCenterPage();
        lno = new LoginOverlay();
        nav = new Navigation();
        sec = new SectionPage();
        prp = new ProductArrayPage();
        slp = new StoreLocatorPage();
        qlo = new QuickLookOverLay();
        fis = new FindInStore();
        shr= new ShopRunnerSigninOverlay();
        gcp = new GiftCardsPage();
        conf= new ConfirmationPage();
        sip = new SignInPage();
        cap = new CreateAccountPage();
        fpp = new ForgotPasswordPage();
        accSum = new AccountSummaryPage();
        accSet = new AccountSettingsPage();
        chngPwd = new ChangePasswordOverlay();
        editPro = new EditProfileOverlay();
        ordHis = new OrderHistoryPage();
        accPay = new AccountPaymentPage();
        accShp = new AccountShippingAddressPage();
        accBill = new AccountBillingAddressPage();
        ordDet = new OrderDetailsPage();
        editPay = new EditPaymentMethodOverlay();
        editShp = new EditShippingAddrOverlay();
        emailPref = new EditEmailPrefOverlay();
        
    }

    @Override
    public void beforeExecuteScript() throws Exception {
        pdp = new PdpPage();
        super.beforeExecuteScript();
    }
}
