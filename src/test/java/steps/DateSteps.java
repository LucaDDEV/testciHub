package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DateSteps {
    // Inizializzo i driver
    private IOSDriver driver;
    @Given("I am in MainPage")
    public void iAmInMainPage() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 13 Pro");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("appium:platformVersion", "15.5");
        desiredCapabilities.setCapability("appium:usePrebuiltWDA", true);
        desiredCapabilities.setCapability("appium:app", "/Users/luca/Desktop/BDDtest/src/main/resources/UIKitCatalog-iphonesimulator.app");
        //desiredCapabilities.setCapability("bundleId", "");
        desiredCapabilities.setCapability("appium:includeSafariInWebviews", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
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
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @And("I tap on DatePicker cell")
    public void iTapOnDatePickerCell() {
        driver.findElementByAccessibilityId("Date Picker").click();
    }

    @And("I tap on DatePicke element")
    public void iTapOnDatePickeElement() {
        driver.findElementByAccessibilityId("Date and Time Picker").click();
    }


    @And("I tap on {string}")
    public void iTapOn(String arg0) {
        // driver.findElementByXPath("//XCUIElementTypeButton[@name="\arg0"]").click();
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"martedì 26 luglio\"]").click();
    }

    @Then("I tap out the datePicker")
    public void iTapOutTheDatePicker() {
        // Tap fuori
        IOSTouchAction touch = new IOSTouchAction(driver);
        MobileElement tap = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"UIKitCatalog\"]/XCUIElementTypeWindow");
        touch.tap(tapOptions().withElement(element(tap))).perform();
        //driver.findElementByIosNsPredicate("label == \"dismiss popup\"").click();
        //driver.findElementByXPath("").click();
        //driver.findElementByXPath("//XCUIElementTypeButton[@name=\"PopoverDismissRegion\"]").click();
        // driver.findElementByAccessibilityId("PopoverDismissRegion").click();
    }


    @Then("i should see {int}")
    public void iShouldSee(int arg0) {
        //String result = driver.findElementById("A5000000-0000-0000-6831-000000000000").getText();
        //Assertions.assertEquals(result, arg0);
    }


}
