package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{

    @FindBy(css="a[title='View cart']") private WebElement viewCartLint;
    public StorePage(WebDriver driver) {
        super(driver);
    }
    public void addToCart(String productName){
        By addToCart = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLint)).click();
    }
}
