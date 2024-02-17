package awesomecucumber.stepdefinations;

import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutStepDefinitions {
    private final CheckoutPage checkoutPage;
    private final TestContext context;

    public CheckoutStepDefinitions(TestContext context) {
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutpage(context.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() throws InterruptedException {
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.",
                checkoutPage.getNotice());
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
       checkoutPage.load(EndPoint.CHECKOUT.url);

    }

}
