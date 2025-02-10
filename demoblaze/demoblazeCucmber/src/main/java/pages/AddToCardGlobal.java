package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCardGlobal {
    WebDriver driver;

    public AddToCardGlobal(WebDriver driver) {
        this.driver=driver;
    }
    //Locators

    private By AddToCardLocator=By.xpath("//a[contains(@class ,'btn-lg')]");
    //By.cssSelector("btn.btn-success.btn-lg");
    private By HomePageLocator= By.partialLinkText("Home");


    // actions
    public void addToCard() throws InterruptedException {
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddToCardLocator)));
        Thread.sleep(3000);
        driver.findElement(AddToCardLocator).click();

    }
    public  String CheckAlertMsg() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        return  driver.switchTo().alert().getText();
    }
    public  void  acceptAlert(){
        driver.switchTo().alert().accept();

    }
    public void backToHomePage() throws InterruptedException {
        Thread.sleep(15);
        driver.findElement(HomePageLocator).click();

    }
}
