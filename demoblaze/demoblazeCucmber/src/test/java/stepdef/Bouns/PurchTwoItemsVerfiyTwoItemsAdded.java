package stepdef.Bouns;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AddToCardGlobal;
import pages.CardDetails;
import pages.HomePage;
import pages.LogedUserHomePage;
import stepdef.Hooks;

import java.util.List;

public class PurchTwoItemsVerfiyTwoItemsAdded {
    WebDriver driver= Hooks.getDriver();
    WebDriverWait wait = Hooks.getWait();
    HomePage homePage= new HomePage(driver);
    LogedUserHomePage logedUserHomePage = new LogedUserHomePage(driver);
    AddToCardGlobal addToCardGlobal1 = new AddToCardGlobal(driver);
    private By SonyVaioI5Locator =By.xpath("//a[contains(text(),'Sony vaio i5')]");
    private By SonyVaioI7Locator =By.xpath("//a[contains(text(),'Sony vaio i7')]");

    @When("user pay two products VerfiyTwoItemsAdded")
    public void user_pay_two_products_verfiy_two_items_added() throws InterruptedException {
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
    }
}
