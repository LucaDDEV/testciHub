package Pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertViewPage extends BasePage {
    IOSDriver driver;

    @FindBy(id = "Text Entry")
    private IOSElement textEntryCell;

    @FindBy(id = "Text Entry")
    private IOSElement textEntry;

    @FindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    private IOSElement textField;


    public AlertViewPage(IOSDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTextEntryCell() {
        textEntry.click();
    }
    public void enterTexField() {
        textEntry.sendKeys("Hello Luca");
    }


}