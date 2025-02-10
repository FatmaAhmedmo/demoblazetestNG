package stepdef.Bouns;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import stepdef.Hooks;

import static stepdef.Hooks.driver;

public class SignUpByExistUser {
    WebDriver drive= Hooks.getDriver();
    HomePage homePage=new HomePage(driver);

    @When("user enter exist {string} and exist {string} and press Signup")
    public void user_enter_exist_and_exist_and_press_signup(String username, String password) {
        homePage.inserUserName("FatmaAhmedMohamed");
        homePage.inserPassword("fatma");
        homePage.clickSignUpBtn();
    }
    @Then("user already exist alert msg appear")
    public void user_already_exist_alert_msg_appear() throws InterruptedException {
        String actualAlertMsg= homePage.CheckAlertMsg();
        String expectedMsg="This user already exist";
        homePage.acceptAlert();
    }
}
