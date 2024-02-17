package awesomecucumber.stepdefinations;

import awesomecucumber.apis.CartApi;
import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {

    private final StorePage storePage;
    private final TestContext context;
    public StoreStepDefinitions(TestContext context){
       this.context=context;
        storePage= PageFactoryManager.getStorepage(context.driver);
    }
    @Given("I am on the Store page")
    public void i_am_on_the_store_page() {
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
        storePage.addToCart(product.getName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        //storePage.addToCart("Blue Shoes");
        CartApi cartApi=new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215,1);
        context.cookies.setCookies(cartApi.getCookie());
        context.cookies.injectCookiesToBrowser(context.driver);
    }

}
