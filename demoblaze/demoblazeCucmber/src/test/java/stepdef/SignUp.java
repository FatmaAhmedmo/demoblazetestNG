package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LogedUserHomePage;
import static stepdef.Hooks.driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignUp {
    WebDriver driver= Hooks.getDriver();
    WebDriverWait wait = Hooks.getWait();
    HomePage homePage= new HomePage(driver);
    LogedUserHomePage logedUserHomePage = new LogedUserHomePage(driver);


    @Given("user open homepage and click on SignUp link")
    public void user_open_homepage_and_click_on_sign_up_link() throws InterruptedException {
        homePage.clickSignUp();


    }
    @When("user enter valid {string} and valid {string} and press Signup")
    public void user_enter_valid_and_valid_and_press_signup(String username, String password) {
        homePage.inserUserName(username);
        homePage.inserPassword(password);
        homePage.clickSignUpBtn();
    }

    @Then("alert msg appear")
    public void alert_msg_appear() throws InterruptedException {
        String actualResult = homePage.CheckAlertMsg();
        String expectedMsg = "";
        if (expectedMsg.equals("successful")) {
            Assert.assertTrue(actualResult.contains(expectedMsg));}
//        } else if (expectedMsg == "exist") {
//            Assert.assertTrue(actualResult.contains(expectedMsg));
//        } same used at datafaker
    }


}
