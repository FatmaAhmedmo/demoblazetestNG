package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogedUserHomePage {
    WebDriver driver;
    WebDriverWait wait;
    public LogedUserHomePage(WebDriver driver) {
        this.driver=driver;
    }
    // locators
    private By LogedUserInfo= By.cssSelector("#nameofuser"); //By.id("nameofuser");
            //By.xpath("//a[contains(text(),\"FatmaAhmedMohamed\")]");
    private By LapTopLocator =By.cssSelector("a[onclick=\"byCat('notebook')\"]");
    private By SonyVaioI5Locator =By.xpath("//a[contains(text(),'Sony vaio i5')]");
        //By.partialLinkText("Sony vaio i5");
    private By SonyVaioI7Locator =By.xpath("//a[contains(text(),'Sony vaio i7')]");
    private By CartLocator= By.partialLinkText("Cart");



    //actions
    public String checkUserData() throws InterruptedException {
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(LogedUserInfo)));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement userInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LogedUserInfo));
       // Thread.sleep(2000);
       //String logedUserName =driver.findElement(LogedUserInfo).getText();
        return driver.findElement(LogedUserInfo).getText();
    }

    public void lapTopsClick(){
        driver.findElement(LapTopLocator).click();
    }
    public  AddToCard sonyVaioI5Add() throws InterruptedException {
      //  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(SonyVaioI5Locator)));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement SonyVaioI5 = wait.until(ExpectedConditions.visibilityOfElementLocated(SonyVaioI5Locator));
        //Thread.sleep(3000);
        driver.findElement(SonyVaioI5Locator).click();
        return new AddToCard(driver);
    }
    public AddToCardGlobal  addItemToCard(By itemLocator) throws InterruptedException {
        // WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
         // wait.until(ExpectedConditions.visibilityOf(driver.findElement(SonyVaioI5Locator)));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement SonyVaioI5 = wait.until(ExpectedConditions.visibilityOfElementLocated(SonyVaioI5Locator));
        Thread.sleep(3000);
        driver.findElement(itemLocator).click();
        return new AddToCardGlobal(driver);
    }
    public CardDetails checkCard(){
        driver.findElement(CartLocator).click();
        return new CardDetails(driver);

    }


}
