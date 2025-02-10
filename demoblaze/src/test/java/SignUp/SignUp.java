package SignUp;

import Pages.HomePage;
import base.BaseSteps;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp extends BaseSteps {
    @Test
    public void registerUser() throws InterruptedException {
        homePage.clickSignUp();
        // Thread.sleep(3000); // replaced by explicit wait
        homePage.inserUserName("test888888879");
        homePage.inserPassword("fatma");
        homePage.clickSignUpBtn();
        String actualResult = homePage.CheckAlertMsg();
        String expectedMsg = "";
        if (expectedMsg.equals("successful")) {
            Assert.assertTrue(actualResult.contains(expectedMsg));
        } else if (expectedMsg == "exist") {
            Assert.assertTrue(actualResult.contains(expectedMsg));


        }
    }
}

