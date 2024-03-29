package awesomecucumber.stepdefinations;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CustomerStepDefinitions {
    private final StorePage storePage;
     private final TestContext context;


    public CustomerStepDefinitions(TestContext context) {
        this.context=context;
        storePage= PageFactoryManager.getStorepage(context.driver);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }


    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        storePage.load(MyConstants.STORE);
    }

}
