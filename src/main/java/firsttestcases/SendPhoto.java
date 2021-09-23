package firsttestcases;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SendPhoto {

    public AndroidDriver driver;

    private static By backupBtn = By.id("auto_backup_switch");
    private static By touchOutsideBtn = By.id("touch_outside");
    private static By keepOffBtn = By.xpath("//*[@text='KEEP OFF']");
    private static By photo  = By.xpath("//android.view.ViewGroup[contains(@content-desc,'Photo taken')]");

    File classPath , imageDirectory, img ;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("plataformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Emulator");
        caps.setCapability("appPackage","com.google.android.apps.photos");
        caps.setCapability("appActivity",".home.HomeActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }

    @Test
    public void SendPhoto() throws IOException {

        classPath =  new File(System.getProperty("user.dir"));
        imageDirectory = new File(classPath,"/resources/images");
        img = new File (imageDirectory.getCanonicalFile(),"iman.png");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(backupBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(touchOutsideBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(keepOffBtn)).click();

        String AndroidPhotoPath = "mnt/sdcard/Pictures";
        driver.pushFile(AndroidPhotoPath + "/" + img.getName(), img);
        ExpectedCondition condition  = ExpectedConditions.numberOfElementsToBe(photo,1);
        wait.until(condition);

    }

}
