package PageObjectModel.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateTaskPage extends PageBase {
    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "edit_text")
    MobileElement taskNameTxt;

    @AndroidFindBy(id ="theme_picker_view")
    MobileElement color;

    @AndroidFindBy(id ="photos_button")
    MobileElement photo;

    @AndroidFindBy(accessibility = "Dark purple")
    MobileElement purple;

    @AndroidFindBy(id = "android:id/button1")
    MobileElement create;

    public void sendTitle(String title){
        clear(taskNameTxt);
        sendText(taskNameTxt, title);
    }

    public void clickColor(){
        click(color);
    }

    public void clickPhoto(){
        click(photo);
    }

    public void colorPurple(){
        click(purple);
    }

    public void createTask(){
        click(create);
    }

}
