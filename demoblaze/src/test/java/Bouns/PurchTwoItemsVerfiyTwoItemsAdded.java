package Bouns;

import Pages.AddToCardGlobal;
import Pages.CardDetails;
import Pages.LogedUserHomePage;
import base.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PurchTwoItemsVerfiyTwoItemsAdded extends BaseSteps {
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

    @Test(priority = 2)
    public void purchaseItem() throws InterruptedException {
        LogedUserHomePage logedUserHomePage= new LogedUserHomePage(driver);
        logedUserHomePage.lapTopsClick();
        AddToCardGlobal addToCardGlobal1 = logedUserHomePage.addItemToCard(SonyVaioI5Locator);
        addToCardGlobal1.addToCard();
        String actualMsg= addToCardGlobal1.CheckAlertMsg();
        String expectedMsg = "added";
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        addToCardGlobal1.acceptAlert();
        CardDetails cardDetails = logedUserHomePage.checkCard();
        Thread.sleep(2000);
        List<WebElement> cartElements =  driver.findElements(By.cssSelector("tr[class=\"success\"]"));//driver.findElements(By.cssSelector("tbody[id=\"tbodyid\"]"));
        int cartsize1= cartElements.size();
        System.out.println(cartsize1);
        addToCardGlobal1.backToHomePage();
        logedUserHomePage.lapTopsClick();
        AddToCardGlobal addToCardGlobal2 = logedUserHomePage.addItemToCard(SonyVaioI7Locator);
        addToCardGlobal2.addToCard();
        String actualMsg2= addToCardGlobal2.CheckAlertMsg();
        String expectedMsg2 = "added";
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        addToCardGlobal1.acceptAlert();
        logedUserHomePage.checkCard();
        Thread.sleep(2000);
        cartElements =  driver.findElements(By.cssSelector("tr[class=\"success\"]"));//driver.findElements(By.cssSelector("tbody[id=\"tbodyid\"]"));
        int cartsize2= cartElements.size();
        System.out.println(cartsize2);
        //Assert.assertTrue(cartsize2==cartsize1+1);
        Assert.assertEquals(cartsize2,cartsize1+1);
        cardDetails.placeorder("Fatma", "Egypt","Giza",123456,01,2025);
        String palceorderMsg= cardDetails.CheckSweetAlertMsg();

        System.out.println(palceorderMsg);
        String expextedPalceorderMsg = "Thank you for your purchase!";
        Assert.assertTrue(palceorderMsg.contains(expextedPalceorderMsg));

    }
}
