package firsttestcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MoveActions {


    AppiumDriver driver;

    public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("plataformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Emulator");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }
    private void scrollDown(){
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions  = new AndroidTouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release().perform();
    }
    @Test
    public void Scroll_test(){

        AndroidElement views =
                (AndroidElement) driver.findElementByAccessibilityId("Views");

        actions  = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();

        // scroll dowwn
        scrollDown();

        AndroidElement list = (AndroidElement) driver.findElementByAccessibilityId("Lists");
        actions.tap(ElementOption.element(list)).perform();

        AndroidElement photos = (AndroidElement) driver.findElementByAccessibilityId("08. Photos");
          String actualResult = photos.getText();
          String expectedResult = "08. Photos";
          Assert.assertEquals(actualResult,expectedResult);
          System.out.println(actualResult + expectedResult);
    }

//    @AfterTest
//    public void tearDown(){
//        if(null!= driver){
//            driver.quit();
//        }
//    }

}
