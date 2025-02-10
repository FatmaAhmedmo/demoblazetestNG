package Bouns;

import base.BaseSteps;
import org.testng.annotations.Test;

public class SignUpByExistUser extends BaseSteps {

    @Test
    public void signingUpWithExistUser() throws InterruptedException {
        homePage.clickSignUp();
        homePage.inserUserName("FatmaAhmedMohamed");
        homePage.inserPassword("fatma");
        homePage.clickSignUpBtn();
        String actualAlertMsg= homePage.CheckAlertMsg();
        String expectedMsg="This user already exist";
        homePage.acceptAlert();
     }
}
