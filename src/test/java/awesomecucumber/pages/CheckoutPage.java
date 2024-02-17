package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    @FindBy(id="billing_first_name") public WebElement billingFirstnameFld;
    @FindBy(id="billing_last_name") public WebElement billingLastnameFld;
    @FindBy(id="billing_address_1")public WebElement billingAddressoneFld;
    @FindBy(id="billing_city") public WebElement billingCityFld;
    @FindBy(id="billing_state") public WebElement billingStateDropdown;

    @FindBy(id="select2-billing_state-container") public WebElement alternatebillingStateDropdown;
    @FindBy(id="billing_postcode") public WebElement billingZipFld;
    @FindBy(id="billing_email") public WebElement billingEmailFld;
    @FindBy(css=".woocommerce-notice") public WebElement noticeTxt;
    @FindBy(id="place_order") public WebElement placeOrderBtn;

    private final   By overlay=By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public CheckoutPage enterBillingFirstName(String billingFirstname) {
        WebElement ele=wait.until(ExpectedConditions.visibilityOf(billingFirstnameFld));
        ele.clear();
        ele.sendKeys(billingFirstname);
        return this;
    }
    public CheckoutPage enterBillingLastName(String billingLastname) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billingLastnameFld));
        ele.clear();
        ele.sendKeys(billingLastname);
        return this;
    }

    public CheckoutPage enterBillingAddressOne(String billingAddressOne) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billingAddressoneFld));
        ele.clear();
        ele.sendKeys(billingAddressOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        ele.clear();
        ele.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage enterBillingStateName(String billingStateName) {
        wait.until(ExpectedConditions.elementToBeClickable(alternatebillingStateDropdown)).click();
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+billingStateName+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
//        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropdown)));
//        select.selectByVisibleText(billingStateName);
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        ele.clear();
        ele.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        ele.clear();
        ele.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails){
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).enterBillingAddressOne(billingDetails.getBillingAddressOne())
                .enterBillingCity(billingDetails.getBillingCity()).enterBillingStateName(billingDetails.getBillingStateName())
                .enterBillingZip(billingDetails.getBillingZip()).enterBillingEmail(billingDetails.getBillingEmail());
    }

    public CheckoutPage placeOrder() {
        waitForOverlaysToDisapper(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNotice() {
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();

    }





}
