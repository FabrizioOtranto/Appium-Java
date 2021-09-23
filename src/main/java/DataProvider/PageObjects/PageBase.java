package DataProvider.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    AppiumDriver driver;
    public static final long WAIT = 20;

    public PageBase(AppiumDriver appiumDriver){
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver  = appiumDriver;
    }
    public void waitForVisibility(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(WebElement element){
        waitForVisibility(element);
        element.clear();
    }

    public void click (WebElement element){
        waitForVisibility(element);
        element.click();
    }

    public void sendText(WebElement element, String text){
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public String getAttribute(MobileElement element, String attribute){
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public String getText(MobileElement element){
        waitForVisibility(element);
        return element.getText();
    }
}
