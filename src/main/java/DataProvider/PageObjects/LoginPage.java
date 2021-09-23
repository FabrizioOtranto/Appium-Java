package DataProvider.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;


public class LoginPage extends PageBase{
    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(name = "user")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "/html/body/app-root/app-login/section/div/div[2]/div/div/form/div[3]/input")
    WebElement submit;

    public void sendUsername(String Username){
        sendText(username, Username);
    }

    public void sendPassword(String Password){
        sendText(password, Password);
    }

    public void clickLogin(){
        click(submit);
    }


}

