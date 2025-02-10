package stepdef.Bouns;

import io.cucumber.java.en.When;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import stepdef.Hooks;

import static stepdef.Hooks.driver;

public class SignUpNewUsers_DataFaker {
    Faker faker = new Faker();
    WebDriver drive= Hooks.getDriver();
    HomePage homePage=new HomePage(driver);


    @When("user enter Datafaker {string} and Datafaker {string} and press Signup")
    public void userEnterDatafakerAndDatafakerAndPressSignup(String username, String password) {
        homePage.inserUserName(faker.name().username());
        homePage.inserPassword(faker.internet().password(8, 16, true, true, true));
        homePage.clickSignUpBtn();
    }
}
