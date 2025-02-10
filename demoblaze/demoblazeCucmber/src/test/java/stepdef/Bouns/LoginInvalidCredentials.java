package stepdef.Bouns;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import stepdef.Hooks;

import static stepdef.Hooks.driver;

public class LoginInvalidCredentials {
    WebDriver drive= Hooks.getDriver();
    HomePage homePage=new HomePage(driver);
    @Then("error appear in alert msg appear")
    public void error_appear_in_alert_msg_appear() throws InterruptedException {
        String actualResult = homePage.CheckAlertMsg();
        String expectedResult = "";
        if (expectedResult == "Wrong" || expectedResult == "User does not exist") {
            Assert.assertTrue(actualResult.contains(expectedResult));
            homePage.acceptAlert();
        }
            

    }
}
