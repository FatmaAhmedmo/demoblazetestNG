package Bouns;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginInvalidCredentials extends BaseSteps {
    @Test
    public void loginINValidPassword() throws InterruptedException {
        homePage.clickLogin();
        homePage.insertLoginName("FatmaAhmedMohamed");
        homePage.insertLoginPassword("worng");
        homePage.clickLoginBtn();
        String actualResult = homePage.CheckAlertMsg();
        String expectedResult ="Wrong";
        Assert.assertTrue(actualResult.contains(expectedResult));
        homePage.acceptAlert();
    }
    @Test
    public void loginINValidUserName() throws InterruptedException {
        homePage.clickLogin();
        homePage.insertLoginName("1213232");
        homePage.insertLoginPassword("worng");
        homePage.clickLoginBtn();
        String actualResult = homePage.CheckAlertMsg();
        String expectedResult ="User does not exist";
        Assert.assertTrue(actualResult.contains(expectedResult));
        homePage.acceptAlert();
    }

}
