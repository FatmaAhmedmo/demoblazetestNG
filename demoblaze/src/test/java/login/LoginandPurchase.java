package login;

import Pages.AddToCardGlobal;
import Pages.CardDetails;
import Pages.LogedUserHomePage;
import base.BaseSteps;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginandPurchase extends BaseSteps {
    LogedUserHomePage logedUserHomePage= new LogedUserHomePage(driver);
    private By SonyVaioI5Locator =By.xpath("//a[contains(text(),'Sony vaio i5')]");
    private By SonyVaioI7Locator =By.xpath("//a[contains(text(),'Sony vaio i7')]");



    @Test(priority = 1)
    public void loginValidCredentials() throws InterruptedException {
        homePage.clickLogin();
        homePage.insertLoginName("FatmaAhmedMohamed");
        homePage.insertLoginPassword("fatma");
        homePage.clickLoginBtn();
        LogedUserHomePage logedUserHomePage= new LogedUserHomePage(driver);
        String actualResult= logedUserHomePage.checkUserData();
        String expectedResult ="FatmaAhmedMohamed";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
//    @Test
//    public void purchaseItem() throws InterruptedException {
//        LogedUserHomePage logedUserHomePage= new LogedUserHomePage(driver);
//        logedUserHomePage.lapTopsClick();
//        AddToCard addToCard= logedUserHomePage.sonyVaioI5Add();
//        //AddToCard addToCard= new LogedUserHomePage.sonyVaioI5Add();
//        addToCard.addToCard();
//        String actualMsg=addToCard.CheckSweetAlertMsg();
//        String expectedMsg = "added";
//        Assert.assertTrue(actualMsg.contains(expectedMsg));
//        addToCard.acceptAlert();
//    }
    @Test(priority = 2)
    public  void purchaseTwoitems() throws InterruptedException {
        LogedUserHomePage logedUserHomePage= new LogedUserHomePage(driver);
        logedUserHomePage.lapTopsClick();
        AddToCardGlobal addToCardGlobal1 = logedUserHomePage.addItemToCard(SonyVaioI5Locator);
        addToCardGlobal1.addToCard();
        String actualMsg= addToCardGlobal1.CheckAlertMsg();
        String expectedMsg = "added";
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        addToCardGlobal1.acceptAlert();
        addToCardGlobal1.backToHomePage();
        logedUserHomePage.lapTopsClick();
        AddToCardGlobal addToCardGlobal2 = logedUserHomePage.addItemToCard(SonyVaioI7Locator);
        addToCardGlobal2.addToCard();
        String actualMsg2= addToCardGlobal2.CheckAlertMsg();
        String expectedMsg2 = "added";
        Assert.assertTrue(actualMsg2.contains(expectedMsg2));
        addToCardGlobal2.acceptAlert();


    }
@Test(priority = 3)
    public void checkCardDetails() throws InterruptedException {
    LogedUserHomePage logedUserHomePage= new LogedUserHomePage(driver);
    CardDetails cardDetails= logedUserHomePage.checkCard();
    // assert items name
    int i;
    List<String> titles = cardDetails.checkItemTiltle();
    for (i=0;i<titles.size();i++){
        String actualResult= titles.get(i);
        System.out.println(actualResult);
        String expextedResult1 = "Sony vaio i5";
        String expextedResult2 = "Sony vaio i7";
        //Assert.assertTrue(actualResult.contains(expextedResult2 || expextedResult2));
        Assert.assertTrue(actualResult.contains(expextedResult1) || actualResult.contains(expextedResult2));
    }
    // assert total price
   String totalPrice =cardDetails.checkTotalPrice();
    String expectedtotalPrice = "1580";
    Assert.assertTrue(totalPrice.contains(expectedtotalPrice));

    cardDetails.placeorder("Fatma", "Egypt","Giza",123456,01,2025);
    String palceorderMsg= cardDetails.CheckSweetAlertMsg();

    System.out.println(palceorderMsg);
    String expextedPalceorderMsg = "Thank you for your purchase!";
    Assert.assertTrue(palceorderMsg.contains(expextedPalceorderMsg));












}
}

