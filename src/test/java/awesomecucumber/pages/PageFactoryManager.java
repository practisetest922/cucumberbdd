package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static StorePage storepage;
    private static CartPage cartpage;
    private static CheckoutPage checkoutpage;


    public static StorePage getStorepage(WebDriver driver){
        return storepage==null ? new StorePage(driver):storepage;
    }

    public static CartPage getCartpage(WebDriver driver){
        return cartpage==null ? new CartPage(driver):cartpage;
    }

    public static CheckoutPage getCheckoutpage(WebDriver driver){
        return checkoutpage==null ? new CheckoutPage(driver):checkoutpage;
    }

}
