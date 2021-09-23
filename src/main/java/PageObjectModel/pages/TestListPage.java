package PageObjectModel.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TestListPage extends PageBase{
    public TestListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "create_list_text_view")
    MobileElement addTaskBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Mirar GOT\"]/android.view.View")
    MobileElement titleName;

    public void clickAddTaskBtn(){
        click(addTaskBtn);
    }

    public String getTitle(){
        return getText(titleName);
    }

}
