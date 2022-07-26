package steps;

import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class iOSPageSteps {
    private IOSDriver driver;
    @When("^I launch iOS app$")
    public void iLaunchIOSApp() throws Throwable {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 13 Pro");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("appium:platformVersion", "15.5");
        desiredCapabilities.setCapability("appium:usePrebuiltWDA", true);
        desiredCapabilities.setCapability("appium:app", "/Users/luca/ios-test-app/build/Release-iphonesimulator/TestApp-iphonesimulator.app");
        desiredCapabilities.setCapability("appium:includeSafariInWebviews", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 60);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        // Per reset totale
        //desiredCapabilities.setCapability("noReset", true);
        //desiredCapabilities.setCapability("fullReset", true);
        desiredCapabilities.setCapability("useNewWDA", true);
        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new IOSDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @And("^I choose to enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iChooseToEnterAnd(String num1, String num2) throws Throwable {
        driver.findElementByAccessibilityId("IntegerA").sendKeys(num1);
        driver.findElementByAccessibilityId("IntegerB").sendKeys(num2);
    }

    @When("^I tap on Compute Sum$")
    public void iTapOnComputeSum() throws Throwable {
        //driver.findElementByAccessibilityId("ComputeSumButton").click();
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"ComputeSumButton\"]").click();
    }

    @Then("^I should see the result \"([^\"]*)\"$")
    public void iShouldSeeTheResult(String result) throws Throwable {
        Assertions.assertEquals(result, driver.findElementByAccessibilityId("Answer").getText());
    }
}
