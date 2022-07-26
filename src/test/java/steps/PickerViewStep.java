package steps;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PickerViewStep {
    private IOSDriver driver;

    @Given("I am in MainPage{int}")
    public void iAmInMainPage(int arg0) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 13 Pro");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("appium:platformVersion", "15.5");
        desiredCapabilities.setCapability("appium:usePrebuiltWDA", true);
        desiredCapabilities.setCapability("appium:app", "/Users/luca/Desktop/BDDtest/src/main/resources/UIKitCatalog-iphonesimulator.app");
        //desiredCapabilities.setCapability("bundleId", "");
        desiredCapabilities.setCapability("appium:includeSafariInWebviews", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 1000);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        // Per partire da un punto dell'app già aperta: true
        desiredCapabilities.setCapability("noReset", false);
        // Per reset totale
        //desiredCapabilities.setCapability("fullReset", true);
        desiredCapabilities.setCapability("useNewWDA", false);
        //
        //desiredCapabilities.setCapability("newCommandTimeout", 120);
        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new IOSDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Start Recording
        driver.startRecordingScreen();
    }

    @And("I tap PickerView")
    public void iTapPickerView() {
        driver.findElementByAccessibilityId("Picker View").click();
    }

    @And("I change RGB colous in {int} {int} {int}")
    public void iChangeRGBColousIn(int arg0, int arg1, int arg2) throws InterruptedException {
        List<WebElement> values = driver.findElementsByXPath("//XCUIElementTypePickerWheel");

        values.get(0).sendKeys(String.valueOf(arg0));
        values.get(1).sendKeys(String.valueOf(arg1));
        values.get(2).sendKeys(String.valueOf(arg2));

        Thread.sleep(5000);
    }

    @Then("Value are {int} {int} {int}")
    public void valueAre(int arg0, int arg1, int arg2) {
        List<WebElement> values = driver.findElementsByXPath("//XCUIElementTypePickerWheel");
        String value1 = values.get(0).getAttribute("value");
        String value2 = values.get(1).getAttribute("value");
        String value3 = values.get(2).getAttribute("value");

        Assertions.assertEquals(value1, String.valueOf(arg0));
        Assertions.assertEquals(value2, String.valueOf(arg1));
        Assertions.assertEquals(value3, String.valueOf(arg2));

        //Stop Recording
        String video = ((CanRecordScreen)driver).stopRecordingScreen();
        byte[] decodedVideo = Base64.getMimeDecoder().decode(video);

        try {
            Path testVideoDir = Paths.get(System.getProperty("user.dir") + "/videos");
            Files.createDirectories(testVideoDir);
            // test-date.mp4
            Path testVideoFileLocation = Paths.get(testVideoDir.toString(), String.format("%s-%d.%s", "test", System.currentTimeMillis(),"mp4"));
            Files.write(testVideoFileLocation, decodedVideo);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
