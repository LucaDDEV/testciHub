package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs extends BaseSteps {
    @When("I launch UIKitCatalog app")
    public void iLaunchUIKitCatalogApp() throws Exception {
    }

    @Then("I tap on Alert Views")
    public void iTapOnAlertViews() {
        driver.findElementByAccessibilityId("Alert Views").click();
    }

    @Then("I tap on Text Entry")
    public void iTapOnTextEntry() {
        driver.findElementByAccessibilityId("Text Entry").click();
    }

    @And("I choose to enter {string}")
    public void iChooseToEnter(String arg0) {
        driver.findElementByXPath("//*[@type='XCUIElementTypeTextField']").sendKeys(arg0);
    }

    @Then("I should see {string}")
    public void iShouldSee(String arg0) {
        String result = driver.findElementByXPath("//*[@type='XCUIElementTypeTextField']").getText();
        Assertions.assertEquals(result, arg0);
    }
}
