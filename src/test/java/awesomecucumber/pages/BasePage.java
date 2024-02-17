package awesomecucumber.pages;

import awesomecucumber.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
            PageFactory.initElements(driver,this);
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl()+endPoint);
    }

    public void waitForOverlaysToDisapper(By overlay){
        List<WebElement> overlays=driver.findElements(overlay);
        System.out.println("Overlay Size"+overlays.size());
        if (overlays.size()>0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("Overlay Invisible");
        }else{
            System.out.println("Overlay not found");
        }

    }
    protected WebDriver driver;
    protected WebDriverWait wait;
}
