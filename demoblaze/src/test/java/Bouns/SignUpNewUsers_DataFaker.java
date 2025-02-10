package Bouns;

import Pages.HomePage;
import base.BaseSteps;
import net.datafaker.Faker;
import org.testng.annotations.Test;

public class SignUpNewUsers_DataFaker extends BaseSteps {
    Faker faker = new Faker();



    @Test
    public void signUpUsers() throws InterruptedException {
        HomePage homePage= new HomePage(driver);
        homePage.clickSignUp();
        homePage.inserUserName( faker.name().username());
        homePage.inserPassword(faker.internet().password(8, 16, true, true, true));
        homePage.clickSignUpBtn();
        String actualAlertMsg= homePage.CheckAlertMsg();
        String expectedMsg="successful";
       // if (Assert.assertTrue(actualAlertMsg.contains(actualAlertMsg))
            homePage.acceptAlert();


    }


}
