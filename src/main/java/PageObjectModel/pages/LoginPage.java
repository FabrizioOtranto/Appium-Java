package PageObjectModel.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageBase{
    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "email_phone_edit_text")
    MobileElement username;

    @AndroidFindBy(id = "sign_in_button")
    MobileElement singInLogin;

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement password;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Sign in\"]")
    MobileElement singInPassword;

    public void sendUsername(String text) {
        sendText(username, text);
    }

    public void singInLogin(){
        click(singInLogin);
    }

    public void sendPassword(String text) {
       sendText(password, text);
    }

    public void singInPassword(){
        click(singInPassword);
    }

}
