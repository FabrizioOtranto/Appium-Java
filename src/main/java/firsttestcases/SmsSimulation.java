package firsttestcases;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SmsSimulation {

    public AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("plataformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Emulator");
        caps.setCapability("appPackage","com.google.android.apps.messaging");
        caps.setCapability("appActivity",".ui.ConversationListActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }

    @Test
    public void SendSMS(){

        driver.sendSMS("555-123-4576", "Hello from test Autiomation University");

    }

}
