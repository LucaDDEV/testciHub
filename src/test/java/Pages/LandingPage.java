package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
    AppiumDriver driver;

    @FindBy(id = "Alert Views")
    private IOSElement alertViews;


    public LandingPage(AppiumDriver driver) throws Exception {
        super((IOSDriver) driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}