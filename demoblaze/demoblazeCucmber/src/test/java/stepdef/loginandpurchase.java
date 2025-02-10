package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AddToCardGlobal;
import pages.CardDetails;
import pages.HomePage;
import pages.LogedUserHomePage;

import java.util.List;

public class loginandpurchase {
    WebDriver driver= Hooks.getDriver();
    WebDriverWait wait = Hooks.getWait();
    HomePage homePage= new HomePage(driver);
    LogedUserHomePage logedUserHomePage = new LogedUserHomePage(driver);
    private By SonyVaioI5Locator =By.xpath("//a[contains(text(),'Sony vaio i5')]");
    private By SonyVaioI7Locator =By.xpath("//a[contains(text(),'Sony vaio i7')]");


    @Given("user open homepage and click on login link")
    public void user_open_homepage_and_click_on_login_link() {
        HomePage homePage1 = homePage;
        homePage1.clickLogin();
    }
    @When("user enter {string} and  {string} and press Signup")
    public void user_enter_and_and_press_signup(String username, String password) {
       homePage.insertLoginName(username);
       homePage.insertLoginPassword(password);
       homePage.clickLoginBtn();
    }

    @Then("user move to logeduserhomepage")
    public void user_move_to_logeduserhomepage() throws InterruptedException {
        LogedUserHomePage logedUserHomePage= new LogedUserHomePage(driver);
        String actualResult= logedUserHomePage.checkUserData();
        String expectedResult ="FatmaAhmedMohamed";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @When("user pay two products")
    public void userPayTwoProducts() throws InterruptedException {
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
//    @And("user add products to cart")
//    public void useraddproductstocart() throws InterruptedException {
//
//    }
    @And("user check out cart details")
    public void usercheckoutcartdetails() throws InterruptedException {
        LogedUserHomePage logedUserHomePage = new LogedUserHomePage(driver);
        CardDetails cardDetails = logedUserHomePage.checkCard();
        // assert items name
        int i;
        List<String> titles = cardDetails.checkItemTiltle();
        for (i = 0; i < titles.size(); i++) {
            String actualResult = titles.get(i);
            System.out.println(actualResult);
            String expextedResult1 = "Sony vaio i5";
            String expextedResult2 = "Sony vaio i7";
            //Assert.assertTrue(actualResult.contains(expextedResult2 || expextedResult2));
            Assert.assertTrue(actualResult.contains(expextedResult1) || actualResult.contains(expextedResult2));


        }
    }

    @Then("place order")
    public void place_order()throws InterruptedException {
        CardDetails cardDetails = logedUserHomePage.checkCard();
        cardDetails.placeorder("Fatma", "Egypt","Giza",123456,01,2025);
        String palceorderMsg= cardDetails.CheckSweetAlertMsg();

        System.out.println(palceorderMsg);
        String expextedPalceorderMsg = "Thank you for your purchase!";
        Assert.assertTrue(palceorderMsg.contains(expextedPalceorderMsg));
    }
//    @And("And place order")
//    public void Andplaceorder() throws InterruptedException {
//        CardDetails cardDetails = logedUserHomePage.checkCard();
//
//        cardDetails.placeorder("Fatma", "Egypt","Giza",123456,01,2025);
//        String palceorderMsg= cardDetails.CheckSweetAlertMsg();
//
//        System.out.println(palceorderMsg);
//        String expextedPalceorderMsg = "Thank you for your purchase!";
//        Assert.assertTrue(palceorderMsg.contains(expextedPalceorderMsg));
//
//
//    }


}
