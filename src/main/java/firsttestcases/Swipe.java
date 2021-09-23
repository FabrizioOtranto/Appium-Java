package firsttestcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Swipe {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("plataformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Emulator");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/todo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }

//    @Test
//    public void swipe_test(){
//
//        AndroidElement views = (AndroidElement) driver.findElementByAccessibilityId("Views");
//        actions = new AndroidTouchAction(driver);
//        actions.tap(ElementOption.element(views)).perform();
//
//        AndroidElement gallery = (AndroidElement) driver.findElementByAccessibilityId("Gallery");
//        actions.tap(ElementOption.element(gallery)).perform();
//
//        AndroidElement photo = (AndroidElement) driver.findElementByAccessibilityId("1. Photos");
//        actions.tap(ElementOption.element(photo)).perform();
//
//        AndroidElement pict1 = (AndroidElement) driver.findElements(By.className("android.widget.ImageView")).get(0);
//        actions.press(ElementOption.element(pict1))
//                .waitAction()
//                .moveTo(PointOption.point(-1000,210))
//                .release()
//                .perform();
//    }
}
