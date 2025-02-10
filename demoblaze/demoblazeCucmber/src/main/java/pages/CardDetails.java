package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CardDetails {
    WebDriver driver;
    public CardDetails(WebDriver driver) {
        this.driver=driver;
    }
    // locators
    private By firstItemTilleLocator = By.xpath("//td[contains(text(),\"Sony vaio i5\")]");
    private By secItemTilleLocator = By.xpath("//td[contains(text(),\"Sony vaio i7\")]");
    // locate price by parent and child failed 6 items found .success :nth-child(1)
    private By totalPriceLocator = By.className("panel-title");
    private By placeOrderPriceLocator =By.cssSelector(".btn.btn-success");
    private By nameLocator = By.id("name");
    private By countryLocator = By.id("country");
    private By cityLocator = By.id("city");
    private By creditcardLocator = By.id("card");
    private By monthLocator = By.id("month");
    private By yearLocator = By.id("year");
    private By purchaseLocator = By.xpath("//button[contains(text(),'Purchase')]");
    private By sweetAlert = By.cssSelector(".sweet-alert.showSweetAlert.visible");
    private By sweetAlertConfirm =By.cssSelector(".confirm.btn.btn-lg.btn-primary") ;
    // actions
    public String firstitem() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement firstItemTille = wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemTilleLocator));
        //Thread.sleep(3000);
        return driver.findElement(firstItemTilleLocator).getText();
    }
    public List<String> checkItemTiltle() throws InterruptedException { Thread.sleep(3000);
        List<String> titles = new ArrayList<>();
        titles.add(driver.findElement(firstItemTilleLocator).getText());
        titles.add(driver.findElement(secItemTilleLocator).getText());
       return titles;

    }
    public String checkTotalPrice(){
       String totalPrice= driver.findElement(totalPriceLocator).getText();
        return totalPrice ;
    }
    public void placeorder(String name ,String country,String city ,int creditcard ,int month , int year) throws InterruptedException {
        driver.findElement(placeOrderPriceLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));

       // Thread.sleep(3000);
        driver.findElement(nameLocator).sendKeys(name);
        driver.findElement(countryLocator).sendKeys(country);
        driver.findElement(cityLocator).sendKeys(city);
        driver.findElement(creditcardLocator).sendKeys(Integer.toString(creditcard));
        driver.findElement(monthLocator).sendKeys(Integer.toString(month));
        driver.findElement(yearLocator).sendKeys(Integer.toString(year));
        driver.findElement(purchaseLocator).click();

    }
    public  String CheckSweetAlertMsg() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement sweetAlertappear  = wait.until(ExpectedConditions.visibilityOfElementLocated(sweetAlert));
        //Thread.sleep(3000);
        String alertMsg =driver.findElement(sweetAlert).getText();
        return  alertMsg ;


    }
    public  void acceptAlert(){
       driver.findElement(sweetAlertConfirm).click();

    }
//    public  int cartItems() throws InterruptedException {
//        Thread.sleep(2000);
//        List<WebElement> cartElements =  driver.findElements(By.cssSelector("tr[class=\"success\"]"));//driver.findElements(By.cssSelector("tbody[id=\"tbodyid\"]"));
//        return cartElements.size();
//
//    }



}
