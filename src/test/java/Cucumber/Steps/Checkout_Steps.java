package Cucumber.Steps;

import Cucumber.base.ScenarioSmokeTest;
import Cucumber.common.ConfigTest;
import com.hbcd.banner.validations.s5a.ValidateConfirmation;
import com.hbcd.scripting.core.BrowserAction;
import com.hbcd.scripting.core.Navigate;
import com.hbcd.scripting.core.Report;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by 461967 on 7/18/2016.
 */
public class Checkout_Steps {
    protected ScenarioSmokeTest st;

    @Before
    public void TestSetup() throws Exception {
        ConfigTest.SetTestParameters();
        ConfigTest.InitializeBroswer();
        ConfigTest.LoadObjectRepo();
        st = new ScenarioSmokeTest();
    }

    @After
    public void Cleanup() throws Exception {
        Report.end_script("SCRIPT IS COMPLETED - NO Screenshot", "");
        BrowserAction.close();
    }


    public Checkout_Steps() throws Exception {

    }

    @Given("^user loads website$")
    public void user_loads_website() throws Throwable {
        Navigate.go(System.getProperty("Url"));
    }

    @When("^user searches for an item$")
    public void user_searches_for_an_item() throws Throwable {
        st.nav.SearchFor("0448863543546");
    }

    @When("^user checkout with that item$")
    public void user_checkout_with_that_item() throws Throwable {
        st.pdp.AddToBag(1);
        st.pdp.EnterBag();
    }

    @When("^user successfully logs in with credentials$")
    public void checkout_login() throws Throwable {
        st.bag.ClickCheckout().LoginWith("checkoutscen02@saks.com", "test123");
    }

    @When("^user places order$")
    public void placeOrder() throws Throwable {
        st.rsp.ClickPlaceOrder();
    }

    @When("^user proceeds to checkout as guest$")
    public void checkout_guest() throws Throwable {
        st.bag.ClickCheckout().ClickGuestCheckout();
    }

    @When("^user enters shipping address$")
    public void shippingAddress() throws Throwable {
        st.shp.AddShippingAddress(false, "250 vesey street", "New York", "New York", "10080", false);
    }

    @When("^user enters payment information$")
    public void paymentMethod() throws Throwable {
        st.pap.AddNewCreditCard(3);
        st.pap.ClickCheckout();
    }

    @Then("^Order should have been placed successfully$")
    public void order_should_have_been_placed_successfully() throws Throwable {
        ValidateConfirmation.isThankYouPage();
    }
}
